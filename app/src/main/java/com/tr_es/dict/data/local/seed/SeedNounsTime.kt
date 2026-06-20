package com.tr_es.dict.data.local.seed

import com.tr_es.dict.data.local.entity.WordEntity

internal object SeedNounsTime {
    val items = listOf<WordEntity>(
        // Zaman ve takvim
        WordEntity(esWord = "hora", trMeaning = "saat, vakit", partOfSpeech = "isim", pronunciation = "/ˈoɾa/", examples = """[{"es":"¿Qué hora es?","tr":"Saat kaç?"}]"""),
        WordEntity(esWord = "minuto", trMeaning = "dakika", partOfSpeech = "isim", pronunciation = "/miˈnuto/", examples = """[{"es":"Espera un minuto.","tr":"Bir dakika bekle."}]"""),
        WordEntity(esWord = "segundo", trMeaning = "saniye", partOfSpeech = "isim", pronunciation = "/seˈɣundo/", examples = """[{"es":"Solo un segundo.","tr":"Sadece bir saniye."}]"""),
        WordEntity(esWord = "semana", trMeaning = "hafta", partOfSpeech = "isim", pronunciation = "/seˈmana/", examples = """[{"es":"La semana tiene siete días.","tr":"Hafta yedi gündür."}]"""),
        WordEntity(esWord = "mes", trMeaning = "ay (takvim)", partOfSpeech = "isim", pronunciation = "/mes/", examples = """[{"es":"El mes que viene viajo.","tr":"Gelecek ay seyahat ediyorum."}]"""),
        WordEntity(esWord = "año", trMeaning = "yıl, sene", partOfSpeech = "isim", pronunciation = "/ˈaɲo/", examples = """[{"es":"El año tiene doce meses.","tr":"Yıl on iki aydır."}]"""),
        WordEntity(esWord = "tarde", trMeaning = "öğleden sonra, akşamüstü", partOfSpeech = "isim", pronunciation = "/ˈtaɾðe/", examples = """[{"es":"Buenas tardes.","tr":"İyi günler."}]"""),
        WordEntity(esWord = "momento", trMeaning = "an, an, dakika", partOfSpeech = "isim", pronunciation = "/moˈmento/", examples = """[{"es":"Un momento, por favor.","tr":"Bir dakika, lütfen."}]"""),
        WordEntity(esWord = "fecha", trMeaning = "tarih (gün)", partOfSpeech = "isim", pronunciation = "/ˈfetʃa/", examples = """[{"es":"¿Qué fecha es hoy?","tr":"Bugün ayın kaçı?"}]"""),
        WordEntity(esWord = "calendario", trMeaning = "takvim", partOfSpeech = "isim", pronunciation = "/kalenˈdaɾjo/", examples = """[{"es":"Miro el calendario.","tr":"Takvime bakıyorum."}]"""),

        // Günler
        WordEntity(esWord = "lunes", trMeaning = "Pazartesi", partOfSpeech = "isim", pronunciation = "/ˈlunes/", examples = """[{"es":"El lunes empiezo a trabajar.","tr":"Pazartesi işe başlıyorum."}]"""),
        WordEntity(esWord = "martes", trMeaning = "Salı", partOfSpeech = "isim", pronunciation = "/ˈmaɾtes/", examples = """[{"es":"El martes tengo clase.","tr":"Salı dersim var."}]"""),
        WordEntity(esWord = "miércoles", trMeaning = "Çarşamba", partOfSpeech = "isim", pronunciation = "/ˈmjeɾkoles/", examples = """[{"es":"El miércoles voy al médico.","tr":"Çarşamba doktora gidiyorum."}]"""),
        WordEntity(esWord = "jueves", trMeaning = "Perşembe", partOfSpeech = "isim", pronunciation = "/ˈxweβes/", examples = """[{"es":"El jueves hay reunión.","tr":"Perşembe toplantı var."}]"""),
        WordEntity(esWord = "viernes", trMeaning = "Cuma", partOfSpeech = "isim", pronunciation = "/ˈbjeɾnes/", examples = """[{"es":"El viernes salgo con amigos.","tr":"Cuma arkadaşlarla çıkıyorum."}]"""),
        WordEntity(esWord = "sábado", trMeaning = "Cumartesi", partOfSpeech = "isim", pronunciation = "/ˈsaβaðo/", examples = """[{"es":"El sábado descanso.","tr":"Cumartesi dinleniyorum."}]"""),
        WordEntity(esWord = "domingo", trMeaning = "Pazar", partOfSpeech = "isim", pronunciation = "/doˈmiŋɡo/", examples = """[{"es":"El domingo voy a la playa.","tr":"Pazar plaja gidiyorum."}]"""),

        // Aylar
        WordEntity(esWord = "enero", trMeaning = "Ocak", partOfSpeech = "isim", pronunciation = "/eˈneɾo/", examples = """[{"es":"En enero hace frío.","tr":"Ocakta hava soğuk."}]"""),
        WordEntity(esWord = "febrero", trMeaning = "Şubat", partOfSpeech = "isim", pronunciation = "/feˈβɾeɾo/", examples = """[{"es":"Febrero es un mes corto.","tr":"Şubat kısa bir ay."}]"""),
        WordEntity(esWord = "marzo", trMeaning = "Mart", partOfSpeech = "isim", pronunciation = "/ˈmaɾθo/", examples = """[{"es":"En marzo llega la primavera.","tr":"Martta ilkbahar gelir."}]"""),
        WordEntity(esWord = "abril", trMeaning = "Nisan", partOfSpeech = "isim", pronunciation = "/aˈβɾil/", examples = """[{"es":"En abril llueve mucho.","tr":"Nisanda çok yağmur yağar."}]"""),
        WordEntity(esWord = "mayo", trMeaning = "Mayıs", partOfSpeech = "isim", pronunciation = "/ˈmaʝo/", examples = """[{"es":"En mayo hay flores.","tr":"Mayısta çiçekler olur."}]"""),
        WordEntity(esWord = "junio", trMeaning = "Haziran", partOfSpeech = "isim", pronunciation = "/ˈxunjo/", examples = """[{"es":"En junio empieza el verano.","tr":"Haziranda yaz başlar."}]"""),
        WordEntity(esWord = "julio", trMeaning = "Temmuz", partOfSpeech = "isim", pronunciation = "/ˈxuljo/", examples = """[{"es":"En julio hace calor.","tr":"Temmuzda hava sıcak."}]"""),
        WordEntity(esWord = "agosto", trMeaning = "Ağustos", partOfSpeech = "isim", pronunciation = "/aˈɣosto/", examples = """[{"es":"En agosto voy de vacaciones.","tr":"Ağustosta tatile gidiyorum."}]"""),
        WordEntity(esWord = "septiembre", trMeaning = "Eylül", partOfSpeech = "isim", pronunciation = "/sepˈtjembɾe/", examples = """[{"es":"En septiembre empieza la escuela.","tr":"Eylülde okul başlar."}]"""),
        WordEntity(esWord = "octubre", trMeaning = "Ekim", partOfSpeech = "isim", pronunciation = "/okˈtuβɾe/", examples = """[{"es":"En octubre caen las hojas.","tr":"Ekimde yapraklar dökülür."}]"""),
        WordEntity(esWord = "noviembre", trMeaning = "Kasım", partOfSpeech = "isim", pronunciation = "/noˈβjembɾe/", examples = """[{"es":"En noviembre hace viento.","tr":"Kasımda rüzgar olur."}]"""),
        WordEntity(esWord = "diciembre", trMeaning = "Aralık", partOfSpeech = "isim", pronunciation = "/diˈθjembɾe/", examples = """[{"es":"En diciembre nieva.","tr":"Aralıkta kar yağar."}]"""),

        // Mevsimler
        WordEntity(esWord = "primavera", trMeaning = "ilkbahar", partOfSpeech = "isim", pronunciation = "/pɾimaˈβeɾa/", examples = """[{"es":"La primavera es mi estación favorita.","tr":"İlkbahar en sevdiğim mevsim."}]"""),
        WordEntity(esWord = "verano", trMeaning = "yaz", partOfSpeech = "isim", pronunciation = "/beˈɾano/", examples = """[{"es":"En verano vamos a la playa.","tr":"Yazın plaja gidiyoruz."}]"""),
        WordEntity(esWord = "otoño", trMeaning = "sonbahar", partOfSpeech = "isim", pronunciation = "/oˈtoɲo/", examples = """[{"es":"En otoño hace fresco.","tr":"Sonbaharda hava serin."}]"""),
        WordEntity(esWord = "invierno", trMeaning = "kış", partOfSpeech = "isim", pronunciation = "/imˈbjeɾno/", examples = """[{"es":"El invierno es muy frío.","tr":"Kış çok soğuk."}]"""),

        // Soyut ve diğer isimler
        WordEntity(esWord = "idea", trMeaning = "fikir, düşünce", partOfSpeech = "isim", pronunciation = "/iˈðea/", examples = """[{"es":"Tengo una buena idea.","tr":"İyi bir fikrim var."}]"""),
        WordEntity(esWord = "palabra", trMeaning = "kelime, söz", partOfSpeech = "isim", pronunciation = "/paˈlaβɾa/", examples = """[{"es":"No entiendo esta palabra.","tr":"Bu kelimeyi anlamıyorum."}]"""),
        WordEntity(esWord = "pregunta", trMeaning = "soru", partOfSpeech = "isim", pronunciation = "/pɾeˈɣunta/", examples = """[{"es":"Tengo una pregunta.","tr":"Bir sorum var."}]"""),
        WordEntity(esWord = "respuesta", trMeaning = "cevap, yanıt", partOfSpeech = "isim", pronunciation = "/resˈpwesta/", examples = """[{"es":"No sé la respuesta.","tr":"Cevabı bilmiyorum."}]"""),
        WordEntity(esWord = "problema", trMeaning = "sorun, problem", partOfSpeech = "isim", pronunciation = "/pɾoˈβlema/", examples = """[{"es":"No hay ningún problema.","tr":"Hiçbir sorun yok."}]"""),
        WordEntity(esWord = "verdad", trMeaning = "gerçek, doğru", partOfSpeech = "isim", pronunciation = "/beɾˈðað/", examples = """[{"es":"Dime la verdad.","tr":"Bana gerçeği söyle."}]"""),
        WordEntity(esWord = "mentira", trMeaning = "yalan", partOfSpeech = "isim", pronunciation = "/menˈtiɾa/", examples = """[{"es":"Eso es una mentira.","tr":"Bu bir yalan."}]"""),
        WordEntity(esWord = "salud", trMeaning = "sağlık", partOfSpeech = "isim", pronunciation = "/saˈluð/", examples = """[{"es":"La salud es lo más importante.","tr":"Sağlık en önemli şey."}]"""),
        WordEntity(esWord = "guerra", trMeaning = "savaş", partOfSpeech = "isim", pronunciation = "/ˈɡera/", examples = """[{"es":"Nadie quiere la guerra.","tr":"Kimse savaş istemiyor."}]"""),
        WordEntity(esWord = "paz", trMeaning = "barış, huzur", partOfSpeech = "isim", pronunciation = "/paθ/", examples = """[{"es":"Todos queremos la paz.","tr":"Hepimiz barış istiyoruz."}]"""),
        WordEntity(esWord = "fuerza", trMeaning = "güç, kuvvet", partOfSpeech = "isim", pronunciation = "/ˈfweɾθa/", examples = """[{"es":"No tengo fuerza hoy.","tr":"Bugün gücüm yok."}]"""),
        WordEntity(esWord = "miedo", trMeaning = "korku", partOfSpeech = "isim", pronunciation = "/ˈmjeðo/", examples = """[{"es":"Tengo miedo a la oscuridad.","tr":"Karanlıktan korkuyorum."}]"""),
        WordEntity(esWord = "sueño", trMeaning = "rüya, uyku, hayal", partOfSpeech = "isim", pronunciation = "/ˈsweɲo/", examples = """[{"es":"Tengo mucho sueño.","tr":"Çok uykum var."}]"""),
        WordEntity(esWord = "suerte", trMeaning = "şans, talih", partOfSpeech = "isim", pronunciation = "/ˈsweɾte/", examples = """[{"es":"Buena suerte en el examen.","tr":"Sınavda bol şans."}]"""),
    )
}
