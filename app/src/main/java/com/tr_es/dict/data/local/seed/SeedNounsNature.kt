package com.tr_es.dict.data.local.seed

import com.tr_es.dict.data.local.entity.WordEntity

internal object SeedNounsNature {
    val items = listOf<WordEntity>(
        // Hayvanlar
        WordEntity(esWord = "caballo", trMeaning = "at", partOfSpeech = "isim", pronunciation = "/kaˈβaʎo/", examples = """[{"es":"El caballo corre rápido.","tr":"At hızlı koşuyor."}]"""),
        WordEntity(esWord = "vaca", trMeaning = "inek", partOfSpeech = "isim", pronunciation = "/ˈbaka/", examples = """[{"es":"La vaca da leche.","tr":"İnek süt verir."}]"""),
        WordEntity(esWord = "pájaro", trMeaning = "kuş", partOfSpeech = "isim", pronunciation = "/ˈpaxaɾo/", examples = """[{"es":"El pájaro canta.","tr":"Kuş ötüyor."}]"""),
        WordEntity(esWord = "pez", trMeaning = "balık (canlı)", partOfSpeech = "isim", pronunciation = "/peθ/", examples = """[{"es":"El pez nada en el agua.","tr":"Balık suda yüzüyor."}]"""),
        WordEntity(esWord = "ratón", trMeaning = "fare", partOfSpeech = "isim", pronunciation = "/raˈton/", examples = """[{"es":"El gato persigue al ratón.","tr":"Kedi fareyi kovalıyor."}]"""),
        WordEntity(esWord = "oveja", trMeaning = "koyun", partOfSpeech = "isim", pronunciation = "/oˈβexa/", examples = """[{"es":"La oveja come hierba.","tr":"Koyun ot yiyor."}]"""),
        WordEntity(esWord = "cerdo", trMeaning = "domuz", partOfSpeech = "isim", pronunciation = "/ˈθeɾðo/", examples = """[{"es":"El cerdo está en la granja.","tr":"Domuz çiftlikte."}]"""),
        WordEntity(esWord = "gallina", trMeaning = "tavuk (canlı)", partOfSpeech = "isim", pronunciation = "/ɡaˈʎina/", examples = """[{"es":"La gallina pone huevos.","tr":"Tavuk yumurtluyor."}]"""),
        WordEntity(esWord = "león", trMeaning = "aslan", partOfSpeech = "isim", pronunciation = "/leˈon/", examples = """[{"es":"El león es fuerte.","tr":"Aslan güçlü."}]"""),
        WordEntity(esWord = "oso", trMeaning = "ayı", partOfSpeech = "isim", pronunciation = "/ˈoso/", examples = """[{"es":"El oso duerme en invierno.","tr":"Ayı kışın uyur."}]"""),
        WordEntity(esWord = "elefante", trMeaning = "fil", partOfSpeech = "isim", pronunciation = "/eleˈfante/", examples = """[{"es":"El elefante es enorme.","tr":"Fil kocaman."}]"""),
        WordEntity(esWord = "abeja", trMeaning = "arı", partOfSpeech = "isim", pronunciation = "/aˈβexa/", examples = """[{"es":"La abeja hace miel.","tr":"Arı bal yapar."}]"""),
        WordEntity(esWord = "mariposa", trMeaning = "kelebek", partOfSpeech = "isim", pronunciation = "/maɾiˈposa/", examples = """[{"es":"La mariposa es colorida.","tr":"Kelebek renkli."}]"""),
        WordEntity(esWord = "araña", trMeaning = "örümcek", partOfSpeech = "isim", pronunciation = "/aˈɾaɲa/", examples = """[{"es":"La araña teje su tela.","tr":"Örümcek ağını örüyor."}]"""),
        WordEntity(esWord = "serpiente", trMeaning = "yılan", partOfSpeech = "isim", pronunciation = "/seɾˈpjente/", examples = """[{"es":"La serpiente es peligrosa.","tr":"Yılan tehlikeli."}]"""),
        WordEntity(esWord = "conejo", trMeaning = "tavşan", partOfSpeech = "isim", pronunciation = "/koˈnexo/", examples = """[{"es":"El conejo come zanahorias.","tr":"Tavşan havuç yiyor."}]"""),
        WordEntity(esWord = "animal", trMeaning = "hayvan", partOfSpeech = "isim", pronunciation = "/aniˈmal/", examples = """[{"es":"El perro es un animal fiel.","tr":"Köpek sadık bir hayvan."}]"""),

        // Doğa ve hava
        WordEntity(esWord = "cielo", trMeaning = "gökyüzü, gök", partOfSpeech = "isim", pronunciation = "/ˈθjelo/", examples = """[{"es":"El cielo está despejado.","tr":"Gökyüzü açık."}]"""),
        WordEntity(esWord = "nube", trMeaning = "bulut", partOfSpeech = "isim", pronunciation = "/ˈnuβe/", examples = """[{"es":"Hay muchas nubes hoy.","tr":"Bugün çok bulut var."}]"""),
        WordEntity(esWord = "estrella", trMeaning = "yıldız", partOfSpeech = "isim", pronunciation = "/esˈtɾeʎa/", examples = """[{"es":"Las estrellas brillan.","tr":"Yıldızlar parlıyor."}]"""),
        WordEntity(esWord = "fuego", trMeaning = "ateş", partOfSpeech = "isim", pronunciation = "/ˈfweɣo/", examples = """[{"es":"El fuego es peligroso.","tr":"Ateş tehlikeli."}]"""),
        WordEntity(esWord = "tierra", trMeaning = "toprak, yer, dünya", partOfSpeech = "isim", pronunciation = "/ˈtjera/", examples = """[{"es":"La tierra es fértil.","tr":"Toprak verimli."}]"""),
        WordEntity(esWord = "piedra", trMeaning = "taş", partOfSpeech = "isim", pronunciation = "/ˈpjeðɾa/", examples = """[{"es":"La piedra es dura.","tr":"Taş sert."}]"""),
        WordEntity(esWord = "arena", trMeaning = "kum", partOfSpeech = "isim", pronunciation = "/aˈɾena/", examples = """[{"es":"La arena de la playa es fina.","tr":"Plajın kumu ince."}]"""),
        WordEntity(esWord = "hoja", trMeaning = "yaprak, kağıt", partOfSpeech = "isim", pronunciation = "/ˈoxa/", examples = """[{"es":"La hoja cae del árbol.","tr":"Yaprak ağaçtan düşüyor."}]"""),
        WordEntity(esWord = "hierba", trMeaning = "ot, çimen", partOfSpeech = "isim", pronunciation = "/ˈʝeɾβa/", examples = """[{"es":"La hierba está verde.","tr":"Çimen yeşil."}]"""),
        WordEntity(esWord = "bosque", trMeaning = "orman", partOfSpeech = "isim", pronunciation = "/ˈboske/", examples = """[{"es":"El bosque es tranquilo.","tr":"Orman sakin."}]"""),
        WordEntity(esWord = "playa", trMeaning = "plaj, kumsal", partOfSpeech = "isim", pronunciation = "/ˈplaʝa/", examples = """[{"es":"Vamos a la playa.","tr":"Plaja gidiyoruz."}]"""),
        WordEntity(esWord = "lago", trMeaning = "göl", partOfSpeech = "isim", pronunciation = "/ˈlaɣo/", examples = """[{"es":"El lago es muy profundo.","tr":"Göl çok derin."}]"""),
        WordEntity(esWord = "isla", trMeaning = "ada", partOfSpeech = "isim", pronunciation = "/ˈisla/", examples = """[{"es":"La isla es pequeña.","tr":"Ada küçük."}]"""),
        WordEntity(esWord = "tormenta", trMeaning = "fırtına", partOfSpeech = "isim", pronunciation = "/toɾˈmenta/", examples = """[{"es":"Viene una tormenta.","tr":"Bir fırtına geliyor."}]"""),
        WordEntity(esWord = "calor", trMeaning = "sıcaklık, sıcak", partOfSpeech = "isim", pronunciation = "/kaˈloɾ/", examples = """[{"es":"Hace mucho calor.","tr":"Çok sıcak."}]"""),
        WordEntity(esWord = "frío", trMeaning = "soğuk (hava)", partOfSpeech = "isim", pronunciation = "/ˈfɾio/", examples = """[{"es":"Hace frío en invierno.","tr":"Kışın hava soğuk."}]"""),
        WordEntity(esWord = "hielo", trMeaning = "buz", partOfSpeech = "isim", pronunciation = "/ˈʝelo/", examples = """[{"es":"El hielo es resbaladizo.","tr":"Buz kaygan."}]"""),

        // Şehir ve yerler
        WordEntity(esWord = "calle", trMeaning = "cadde, sokak", partOfSpeech = "isim", pronunciation = "/ˈkaʎe/", examples = """[{"es":"La calle está vacía.","tr":"Sokak boş."}]"""),
        WordEntity(esWord = "plaza", trMeaning = "meydan", partOfSpeech = "isim", pronunciation = "/ˈplaθa/", examples = """[{"es":"La plaza está llena de gente.","tr":"Meydan insanla dolu."}]"""),
        WordEntity(esWord = "tienda", trMeaning = "dükkan, mağaza", partOfSpeech = "isim", pronunciation = "/ˈtjenda/", examples = """[{"es":"La tienda abre a las nueve.","tr":"Dükkan dokuzda açılıyor."}]"""),
        WordEntity(esWord = "mercado", trMeaning = "pazar, çarşı", partOfSpeech = "isim", pronunciation = "/meɾˈkaðo/", examples = """[{"es":"Compro fruta en el mercado.","tr":"Pazardan meyve alıyorum."}]"""),
        WordEntity(esWord = "restaurante", trMeaning = "restoran, lokanta", partOfSpeech = "isim", pronunciation = "/restawˈɾante/", examples = """[{"es":"Cenamos en un restaurante.","tr":"Bir restoranda akşam yemeği yiyoruz."}]"""),
        WordEntity(esWord = "hospital", trMeaning = "hastane", partOfSpeech = "isim", pronunciation = "/ospiˈtal/", examples = """[{"es":"El hospital está cerca.","tr":"Hastane yakında."}]"""),
        WordEntity(esWord = "banco", trMeaning = "banka, bank (oturak)", partOfSpeech = "isim", pronunciation = "/ˈbaŋko/", examples = """[{"es":"Voy al banco.","tr":"Bankaya gidiyorum."}]"""),
        WordEntity(esWord = "iglesia", trMeaning = "kilise", partOfSpeech = "isim", pronunciation = "/iˈɣlesja/", examples = """[{"es":"La iglesia es antigua.","tr":"Kilise eski."}]"""),
        WordEntity(esWord = "parque", trMeaning = "park", partOfSpeech = "isim", pronunciation = "/ˈpaɾke/", examples = """[{"es":"Los niños juegan en el parque.","tr":"Çocuklar parkta oynuyor."}]"""),
        WordEntity(esWord = "museo", trMeaning = "müze", partOfSpeech = "isim", pronunciation = "/muˈseo/", examples = """[{"es":"El museo es interesante.","tr":"Müze ilginç."}]"""),
        WordEntity(esWord = "biblioteca", trMeaning = "kütüphane", partOfSpeech = "isim", pronunciation = "/biβljoˈteka/", examples = """[{"es":"Estudio en la biblioteca.","tr":"Kütüphanede ders çalışıyorum."}]"""),
        WordEntity(esWord = "universidad", trMeaning = "üniversite", partOfSpeech = "isim", pronunciation = "/uniβeɾsiˈðað/", examples = """[{"es":"Estudio en la universidad.","tr":"Üniversitede okuyorum."}]"""),
        WordEntity(esWord = "pueblo", trMeaning = "köy, kasaba, halk", partOfSpeech = "isim", pronunciation = "/ˈpweβlo/", examples = """[{"es":"Vivo en un pueblo pequeño.","tr":"Küçük bir köyde yaşıyorum."}]"""),
        WordEntity(esWord = "edificio", trMeaning = "bina", partOfSpeech = "isim", pronunciation = "/eðiˈfiθjo/", examples = """[{"es":"El edificio es muy alto.","tr":"Bina çok yüksek."}]"""),
        WordEntity(esWord = "puente", trMeaning = "köprü", partOfSpeech = "isim", pronunciation = "/ˈpwente/", examples = """[{"es":"Cruzamos el puente.","tr":"Köprüyü geçiyoruz."}]"""),
        WordEntity(esWord = "hotel", trMeaning = "otel", partOfSpeech = "isim", pronunciation = "/oˈtel/", examples = """[{"es":"El hotel está completo.","tr":"Otel dolu."}]"""),
        WordEntity(esWord = "aeropuerto", trMeaning = "havalimanı", partOfSpeech = "isim", pronunciation = "/aeɾoˈpweɾto/", examples = """[{"es":"Voy al aeropuerto en taxi.","tr":"Havalimanına taksiyle gidiyorum."}]"""),
        WordEntity(esWord = "estación", trMeaning = "istasyon, durak, mevsim", partOfSpeech = "isim", pronunciation = "/estaˈθjon/", examples = """[{"es":"Te espero en la estación.","tr":"Seni istasyonda bekliyorum."}]"""),
        WordEntity(esWord = "oficina", trMeaning = "ofis, büro", partOfSpeech = "isim", pronunciation = "/ofiˈθina/", examples = """[{"es":"Trabajo en una oficina.","tr":"Bir ofiste çalışıyorum."}]"""),
        WordEntity(esWord = "farmacia", trMeaning = "eczane", partOfSpeech = "isim", pronunciation = "/faɾˈmaθja/", examples = """[{"es":"Compro medicina en la farmacia.","tr":"Eczaneden ilaç alıyorum."}]"""),
    )
}
