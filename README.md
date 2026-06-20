# İspanyolca Sözlük (Türkçe)

Türkçe konuşan kullanıcılar için tamamen **çevrimdışı** çalışan bir İspanyolca–Türkçe
sözlük Android uygulaması.

## Özellikler

- 🔍 **Çift yönlü arama** — İspanyolca → Türkçe veya Türkçe → İspanyolca (tek dokunuşla yön değiştirme)
- ⭐ **Favoriler** — kelimeleri kaydetme, kaydırarak silme
- 📅 **Günün Kelimesi** — her gün otomatik yenilenen yeni kelime
- 💬 **Örnek cümleler** — her kelime için İspanyolca + Türkçe örnekler
- 🌙 **Açık/Koyu tema** — Material Design 3, İspanya esinli renk paleti
- 📴 **İnternet gerektirmez** — tüm veri cihazda (Room/SQLite)

## Mimari

| Katman | Teknoloji |
|--------|-----------|
| UI | Fragment + ViewBinding + Material 3 |
| Sunum | MVVM (ViewModel + StateFlow) |
| Bağımlılık enjeksiyonu | Hilt |
| Yerel veri | Room + FTS4 tam metin arama |
| Navigasyon | Navigation Component + Safe Args |
| Eşzamansızlık | Kotlin Coroutines / Flow |

```
ui/ (Fragment + ViewModel)
  └── data/repository/DictionaryRepository
        └── data/local (Room: WordDao, FavoriteDao, FTS4)
```

## Sözlük Verisi

Uygulama, `DatabaseSeeder.kt` içindeki **yerleşik çekirdek kelime setiyle** (yaklaşık
120 yüksek frekanslı kelime) kutudan çıktığı gibi çalışır.

Tam **50.000+ kelimelik** veri tabanı için `scripts/build_db.py` betiği açık lisanslı
kaynaklardan SQLite üretir:

| Kaynak | Lisans |
|--------|--------|
| [DBNARY (Wiktionary)](http://kaiko.getalp.org/about-dbnary/) | CC BY-SA |
| [FreeDict spa-tur](https://freedict.org/downloads/) | GPL |
| [Tatoeba](https://tatoeba.org/downloads) (örnek cümleler) | CC BY |

```bash
cd scripts
python3 build_db.py --input dbnary_spa_tur.tsv \
    --output ../app/src/main/assets/dictionary.db
```

Üretilen şema, Room'un `WordEntity` / `words_fts` tablolarıyla birebir uyumludur;
böylece bundlelenmiş `.db` ilk açılışta doğrudan kullanılabilir.

## Derleme

```bash
./gradlew assembleDebug
```

> Android SDK gereklidir (compileSdk 34, minSdk 26). `local.properties` içinde
> `sdk.dir` ayarlı olmalıdır.

## Lisans

Kod MIT. Sözlük verisi ilgili kaynakların lisanslarına tabidir (yukarıdaki tablo).
