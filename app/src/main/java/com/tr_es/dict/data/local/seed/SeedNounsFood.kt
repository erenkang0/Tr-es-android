package com.tr_es.dict.data.local.seed

import com.tr_es.dict.data.local.entity.WordEntity

internal object SeedNounsFood {
    val items = listOf<WordEntity>(
        // Yiyecek ve içecek
        WordEntity(esWord = "carne", trMeaning = "et", partOfSpeech = "isim", pronunciation = "/ˈkaɾne/", examples = """[{"es":"No como carne.","tr":"Et yemiyorum."}]"""),
        WordEntity(esWord = "pescado", trMeaning = "balık (yemek)", partOfSpeech = "isim", pronunciation = "/pesˈkaðo/", examples = """[{"es":"El pescado está fresco.","tr":"Balık taze."}]"""),
        WordEntity(esWord = "pollo", trMeaning = "tavuk", partOfSpeech = "isim", pronunciation = "/ˈpoʎo/", examples = """[{"es":"Como pollo con arroz.","tr":"Pilavla tavuk yiyorum."}]"""),
        WordEntity(esWord = "arroz", trMeaning = "pirinç, pilav", partOfSpeech = "isim", pronunciation = "/aˈroθ/", examples = """[{"es":"El arroz está listo.","tr":"Pilav hazır."}]"""),
        WordEntity(esWord = "huevo", trMeaning = "yumurta", partOfSpeech = "isim", pronunciation = "/ˈweβo/", examples = """[{"es":"Quiero un huevo frito.","tr":"Bir sahanda yumurta istiyorum."}]"""),
        WordEntity(esWord = "queso", trMeaning = "peynir", partOfSpeech = "isim", pronunciation = "/ˈkeso/", examples = """[{"es":"El queso es delicioso.","tr":"Peynir lezzetli."}]"""),
        WordEntity(esWord = "fruta", trMeaning = "meyve", partOfSpeech = "isim", pronunciation = "/ˈfɾuta/", examples = """[{"es":"Como fruta cada día.","tr":"Her gün meyve yiyorum."}]"""),
        WordEntity(esWord = "manzana", trMeaning = "elma", partOfSpeech = "isim", pronunciation = "/manˈθana/", examples = """[{"es":"La manzana es roja.","tr":"Elma kırmızı."}]"""),
        WordEntity(esWord = "naranja", trMeaning = "portakal", partOfSpeech = "isim", pronunciation = "/naˈɾaŋxa/", examples = """[{"es":"Bebo zumo de naranja.","tr":"Portakal suyu içiyorum."}]"""),
        WordEntity(esWord = "plátano", trMeaning = "muz", partOfSpeech = "isim", pronunciation = "/ˈplatano/", examples = """[{"es":"El plátano es amarillo.","tr":"Muz sarı."}]"""),
        WordEntity(esWord = "uva", trMeaning = "üzüm", partOfSpeech = "isim", pronunciation = "/ˈuβa/", examples = """[{"es":"La uva es dulce.","tr":"Üzüm tatlı."}]"""),
        WordEntity(esWord = "tomate", trMeaning = "domates", partOfSpeech = "isim", pronunciation = "/toˈmate/", examples = """[{"es":"El tomate es rojo.","tr":"Domates kırmızı."}]"""),
        WordEntity(esWord = "patata", trMeaning = "patates", partOfSpeech = "isim", pronunciation = "/paˈtata/", examples = """[{"es":"Me gustan las patatas fritas.","tr":"Patates kızartmasını seviyorum."}]"""),
        WordEntity(esWord = "verdura", trMeaning = "sebze", partOfSpeech = "isim", pronunciation = "/beɾˈðuɾa/", examples = """[{"es":"Como mucha verdura.","tr":"Çok sebze yiyorum."}]"""),
        WordEntity(esWord = "ensalada", trMeaning = "salata", partOfSpeech = "isim", pronunciation = "/ensaˈlaða/", examples = """[{"es":"La ensalada está rica.","tr":"Salata güzel."}]"""),
        WordEntity(esWord = "sopa", trMeaning = "çorba", partOfSpeech = "isim", pronunciation = "/ˈsopa/", examples = """[{"es":"La sopa está caliente.","tr":"Çorba sıcak."}]"""),
        WordEntity(esWord = "azúcar", trMeaning = "şeker", partOfSpeech = "isim", pronunciation = "/aˈθukaɾ/", examples = """[{"es":"El café sin azúcar.","tr":"Şekersiz kahve."}]"""),
        WordEntity(esWord = "sal", trMeaning = "tuz", partOfSpeech = "isim", pronunciation = "/sal/", examples = """[{"es":"Pásame la sal.","tr":"Tuzu uzat."}]"""),
        WordEntity(esWord = "aceite", trMeaning = "yağ (sıvı)", partOfSpeech = "isim", pronunciation = "/aˈθejte/", examples = """[{"es":"Uso aceite de oliva.","tr":"Zeytinyağı kullanıyorum."}]"""),
        WordEntity(esWord = "café", trMeaning = "kahve", partOfSpeech = "isim", pronunciation = "/kaˈfe/", examples = """[{"es":"Quiero un café, por favor.","tr":"Bir kahve istiyorum, lütfen."}]"""),
        WordEntity(esWord = "té", trMeaning = "çay", partOfSpeech = "isim", pronunciation = "/te/", examples = """[{"es":"Bebo té por la tarde.","tr":"Öğleden sonra çay içiyorum."}]"""),
        WordEntity(esWord = "vino", trMeaning = "şarap", partOfSpeech = "isim", pronunciation = "/ˈbino/", examples = """[{"es":"El vino tinto es bueno.","tr":"Kırmızı şarap güzel."}]"""),
        WordEntity(esWord = "cerveza", trMeaning = "bira", partOfSpeech = "isim", pronunciation = "/θeɾˈβeθa/", examples = """[{"es":"Una cerveza fría, por favor.","tr":"Soğuk bir bira, lütfen."}]"""),
        WordEntity(esWord = "zumo", trMeaning = "meyve suyu", partOfSpeech = "isim", pronunciation = "/ˈθumo/", examples = """[{"es":"El zumo está fresco.","tr":"Meyve suyu taze."}]"""),
        WordEntity(esWord = "desayuno", trMeaning = "kahvaltı", partOfSpeech = "isim", pronunciation = "/desaˈʝuno/", examples = """[{"es":"El desayuno es importante.","tr":"Kahvaltı önemli."}]"""),
        WordEntity(esWord = "almuerzo", trMeaning = "öğle yemeği", partOfSpeech = "isim", pronunciation = "/alˈmweɾθo/", examples = """[{"es":"El almuerzo es a la una.","tr":"Öğle yemeği saat birde."}]"""),
        WordEntity(esWord = "cena", trMeaning = "akşam yemeği", partOfSpeech = "isim", pronunciation = "/ˈθena/", examples = """[{"es":"La cena está lista.","tr":"Akşam yemeği hazır."}]"""),
        WordEntity(esWord = "postre", trMeaning = "tatlı (yemek sonrası)", partOfSpeech = "isim", pronunciation = "/ˈpostɾe/", examples = """[{"es":"¿Qué hay de postre?","tr":"Tatlı olarak ne var?"}]"""),
        WordEntity(esWord = "chocolate", trMeaning = "çikolata", partOfSpeech = "isim", pronunciation = "/tʃokoˈlate/", examples = """[{"es":"Me encanta el chocolate.","tr":"Çikolataya bayılırım."}]"""),
        WordEntity(esWord = "miel", trMeaning = "bal", partOfSpeech = "isim", pronunciation = "/mjel/", examples = """[{"es":"Pongo miel en el té.","tr":"Çaya bal koyuyorum."}]"""),
        WordEntity(esWord = "mantequilla", trMeaning = "tereyağı", partOfSpeech = "isim", pronunciation = "/manteˈkiʎa/", examples = """[{"es":"Pan con mantequilla.","tr":"Tereyağlı ekmek."}]"""),
        WordEntity(esWord = "harina", trMeaning = "un", partOfSpeech = "isim", pronunciation = "/aˈɾina/", examples = """[{"es":"Necesito harina para el pan.","tr":"Ekmek için una ihtiyacım var."}]"""),
        WordEntity(esWord = "limón", trMeaning = "limon", partOfSpeech = "isim", pronunciation = "/liˈmon/", examples = """[{"es":"El limón es ácido.","tr":"Limon ekşi."}]"""),
        WordEntity(esWord = "cebolla", trMeaning = "soğan", partOfSpeech = "isim", pronunciation = "/θeˈβoʎa/", examples = """[{"es":"La cebolla me hace llorar.","tr":"Soğan beni ağlatıyor."}]"""),
        WordEntity(esWord = "ajo", trMeaning = "sarımsak", partOfSpeech = "isim", pronunciation = "/ˈaxo/", examples = """[{"es":"El ajo tiene un olor fuerte.","tr":"Sarımsağın kokusu kuvvetli."}]"""),
        WordEntity(esWord = "galleta", trMeaning = "bisküvi, kurabiye", partOfSpeech = "isim", pronunciation = "/ɡaˈʎeta/", examples = """[{"es":"Como una galleta con leche.","tr":"Sütle bir bisküvi yiyorum."}]"""),
        WordEntity(esWord = "helado", trMeaning = "dondurma", partOfSpeech = "isim", pronunciation = "/eˈlaðo/", examples = """[{"es":"En verano como helado.","tr":"Yazın dondurma yiyorum."}]"""),
        WordEntity(esWord = "pastel", trMeaning = "pasta, kek", partOfSpeech = "isim", pronunciation = "/pasˈtel/", examples = """[{"es":"El pastel de cumpleaños es grande.","tr":"Doğum günü pastası büyük."}]"""),
    )
}
