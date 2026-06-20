#!/usr/bin/env python3
"""
DBNARY / FreeDict İspanyolca-Türkçe sözlük verisini SQLite veritabanına dönüştürür.

Kapsam hedefi: 50.000+ kelime (kullanıcı tercihi).

Kaynaklar:
  - DBNARY (Wiktionary): http://kaiko.getalp.org/about-dbnary/  (CC BY-SA)
  - FreeDict spa-tur:    https://freedict.org/downloads/        (GPL)
  - Tatoeba örnekleri:   https://tatoeba.org/downloads          (CC BY)

Üretilen şema, Room'un `WordEntity` / `WordFtsEntity` tablolarıyla birebir uyumludur.
Çıktı: app/src/main/assets/dictionary.db  (uygulamaya bundlelenir)

Kullanım:
    python3 build_db.py --input dbnary_spa_tur.tsv --output ../app/src/main/assets/dictionary.db

NOT: Bu betik veri hazırlama (geliştirici) adımıdır. APK içinde çalışmaz.
Geniş veri olmadan uygulama yine de DatabaseSeeder.kt içindeki yerleşik
çekirdek kelimelerle (~120 kelime) çalışır.
"""
import argparse
import csv
import json
import os
import sqlite3
import sys


def create_schema(conn: sqlite3.Connection) -> None:
    """Room ile uyumlu tabloları ve FTS4 sanal tablosunu oluşturur."""
    cur = conn.cursor()
    cur.executescript(
        """
        DROP TABLE IF EXISTS words;
        DROP TABLE IF EXISTS words_fts;
        DROP TABLE IF EXISTS favorites;

        CREATE TABLE words (
            id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
            es_word TEXT NOT NULL,
            tr_meaning TEXT NOT NULL,
            part_of_speech TEXT NOT NULL DEFAULT '',
            examples TEXT,
            pronunciation TEXT
        );
        CREATE INDEX index_words_es_word ON words(es_word);
        CREATE INDEX index_words_tr_meaning ON words(tr_meaning);

        CREATE VIRTUAL TABLE words_fts USING fts4(
            es_word, tr_meaning, content='words'
        );

        CREATE TABLE favorites (
            id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
            word_id INTEGER NOT NULL,
            added_at INTEGER NOT NULL,
            FOREIGN KEY(word_id) REFERENCES words(id) ON DELETE CASCADE
        );
        CREATE UNIQUE INDEX index_favorites_word_id ON favorites(word_id);
        """
    )
    conn.commit()


def normalize_pos(raw: str) -> str:
    """Wiktionary kelime türü etiketlerini Türkçeye çevirir."""
    mapping = {
        "noun": "isim",
        "verb": "fiil",
        "adjective": "sıfat",
        "adverb": "zarf",
        "pronoun": "zamir",
        "preposition": "edat",
        "conjunction": "bağlaç",
        "interjection": "ünlem",
        "numeral": "sayı",
        "phrase": "deyim",
    }
    return mapping.get(raw.strip().lower(), raw.strip().lower())


def load_tsv(path: str):
    """
    Beklenen TSV sütunları (DBNARY türevi):
        es_word \t part_of_speech \t tr_meaning \t [example_es] \t [example_tr]
    Aynı es_word için birden çok satır, anlamlar virgülle birleştirilerek toplanır.
    """
    aggregated: dict = {}
    with open(path, encoding="utf-8") as fh:
        reader = csv.reader(fh, delimiter="\t")
        for row in reader:
            if len(row) < 3:
                continue
            es = row[0].strip()
            pos = normalize_pos(row[1])
            tr = row[2].strip()
            if not es or not tr:
                continue
            key = (es, pos)
            entry = aggregated.setdefault(
                key, {"meanings": [], "examples": []}
            )
            if tr not in entry["meanings"]:
                entry["meanings"].append(tr)
            if len(row) >= 5 and row[3].strip() and row[4].strip():
                entry["examples"].append({"es": row[3].strip(), "tr": row[4].strip()})
    return aggregated


def populate(conn: sqlite3.Connection, aggregated: dict) -> int:
    cur = conn.cursor()
    count = 0
    for (es, pos), data in aggregated.items():
        tr_meaning = ", ".join(data["meanings"])
        examples = json.dumps(data["examples"], ensure_ascii=False) if data["examples"] else None
        cur.execute(
            "INSERT INTO words (es_word, tr_meaning, part_of_speech, examples, pronunciation) "
            "VALUES (?, ?, ?, ?, ?)",
            (es, tr_meaning, pos, examples, None),
        )
        count += 1
    # FTS içeriğini ana tablodan yeniden inşa et
    cur.execute("INSERT INTO words_fts(words_fts) VALUES('rebuild')")
    conn.commit()
    return count


def main() -> int:
    parser = argparse.ArgumentParser(description="TR-ES sözlük SQLite üretici")
    parser.add_argument("--input", required=True, help="DBNARY/FreeDict TSV dosyası")
    parser.add_argument(
        "--output",
        default="../app/src/main/assets/dictionary.db",
        help="Çıktı SQLite veritabanı yolu",
    )
    args = parser.parse_args()

    if not os.path.exists(args.input):
        print(f"HATA: girdi dosyası bulunamadı: {args.input}", file=sys.stderr)
        return 1

    os.makedirs(os.path.dirname(os.path.abspath(args.output)), exist_ok=True)
    if os.path.exists(args.output):
        os.remove(args.output)

    conn = sqlite3.connect(args.output)
    try:
        create_schema(conn)
        aggregated = load_tsv(args.input)
        total = populate(conn, aggregated)
        print(f"Tamamlandı: {total} kelime yazıldı -> {args.output}")
    finally:
        conn.close()
    return 0


if __name__ == "__main__":
    sys.exit(main())
