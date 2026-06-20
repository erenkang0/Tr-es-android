package com.tr_es.dict.data.local.seed

import com.tr_es.dict.data.local.entity.WordEntity

internal object SeedNounsPeople {
    val items = listOf<WordEntity>(
        // Aile ve insanlar
        WordEntity(esWord = "hermano", trMeaning = "erkek kardeş, abi", partOfSpeech = "isim", pronunciation = "/eɾˈmano/", examples = """[{"es":"Mi hermano es mayor.","tr":"Erkek kardeşim büyük."}]"""),
        WordEntity(esWord = "hermana", trMeaning = "kız kardeş, abla", partOfSpeech = "isim", pronunciation = "/eɾˈmana/", examples = """[{"es":"Mi hermana es médica.","tr":"Kız kardeşim doktor."}]"""),
        WordEntity(esWord = "abuelo", trMeaning = "dede, büyükbaba", partOfSpeech = "isim", pronunciation = "/aˈβwelo/", examples = """[{"es":"Mi abuelo tiene ochenta años.","tr":"Dedem seksen yaşında."}]"""),
        WordEntity(esWord = "abuela", trMeaning = "nine, büyükanne", partOfSpeech = "isim", pronunciation = "/aˈβwela/", examples = """[{"es":"Mi abuela cocina muy bien.","tr":"Ninem çok iyi yemek yapar."}]"""),
        WordEntity(esWord = "tío", trMeaning = "amca, dayı", partOfSpeech = "isim", pronunciation = "/ˈtio/", examples = """[{"es":"Mi tío vive en España.","tr":"Amcam İspanya'da yaşıyor."}]"""),
        WordEntity(esWord = "tía", trMeaning = "hala, teyze", partOfSpeech = "isim", pronunciation = "/ˈtia/", examples = """[{"es":"Mi tía es profesora.","tr":"Teyzem öğretmen."}]"""),
        WordEntity(esWord = "primo", trMeaning = "kuzen (erkek)", partOfSpeech = "isim", pronunciation = "/ˈpɾimo/", examples = """[{"es":"Mi primo es muy alto.","tr":"Kuzenim çok uzun."}]"""),
        WordEntity(esWord = "prima", trMeaning = "kuzen (kız)", partOfSpeech = "isim", pronunciation = "/ˈpɾima/", examples = """[{"es":"Mi prima estudia arte.","tr":"Kuzenim sanat okuyor."}]"""),
        WordEntity(esWord = "esposo", trMeaning = "koca, eş", partOfSpeech = "isim", pronunciation = "/esˈposo/", examples = """[{"es":"Su esposo trabaja mucho.","tr":"Kocası çok çalışıyor."}]"""),
        WordEntity(esWord = "esposa", trMeaning = "karı, eş", partOfSpeech = "isim", pronunciation = "/esˈposa/", examples = """[{"es":"Mi esposa es enfermera.","tr":"Eşim hemşire."}]"""),
        WordEntity(esWord = "marido", trMeaning = "koca, eş", partOfSpeech = "isim", pronunciation = "/maˈɾiðo/", examples = """[{"es":"Mi marido cocina los domingos.","tr":"Kocam pazarları yemek yapar."}]"""),
        WordEntity(esWord = "novio", trMeaning = "erkek arkadaş, nişanlı", partOfSpeech = "isim", pronunciation = "/ˈnoβjo/", examples = """[{"es":"Su novio es simpático.","tr":"Erkek arkadaşı sempatik."}]"""),
        WordEntity(esWord = "novia", trMeaning = "kız arkadaş, nişanlı", partOfSpeech = "isim", pronunciation = "/ˈnoβja/", examples = """[{"es":"Mi novia vive cerca.","tr":"Kız arkadaşım yakında oturuyor."}]"""),
        WordEntity(esWord = "bebé", trMeaning = "bebek", partOfSpeech = "isim", pronunciation = "/beˈβe/", examples = """[{"es":"El bebé duerme.","tr":"Bebek uyuyor."}]"""),
        WordEntity(esWord = "persona", trMeaning = "kişi, insan", partOfSpeech = "isim", pronunciation = "/peɾˈsona/", examples = """[{"es":"Es una persona amable.","tr":"Nazik bir kişi."}]"""),
        WordEntity(esWord = "gente", trMeaning = "insanlar, halk", partOfSpeech = "isim", pronunciation = "/ˈxente/", examples = """[{"es":"Hay mucha gente aquí.","tr":"Burada çok insan var."}]"""),
        WordEntity(esWord = "vecino", trMeaning = "komşu", partOfSpeech = "isim", pronunciation = "/beˈθino/", examples = """[{"es":"Mi vecino es amable.","tr":"Komşum nazik."}]"""),
        WordEntity(esWord = "nombre", trMeaning = "isim, ad", partOfSpeech = "isim", pronunciation = "/ˈnombɾe/", examples = """[{"es":"¿Cuál es tu nombre?","tr":"Adın ne?"}]"""),

        // Vücut
        WordEntity(esWord = "cabeza", trMeaning = "baş, kafa", partOfSpeech = "isim", pronunciation = "/kaˈβeθa/", examples = """[{"es":"Me duele la cabeza.","tr":"Başım ağrıyor."}]"""),
        WordEntity(esWord = "cara", trMeaning = "yüz", partOfSpeech = "isim", pronunciation = "/ˈkaɾa/", examples = """[{"es":"Tiene una cara amable.","tr":"Nazik bir yüzü var."}]"""),
        WordEntity(esWord = "ojo", trMeaning = "göz", partOfSpeech = "isim", pronunciation = "/ˈoxo/", examples = """[{"es":"Tiene los ojos azules.","tr":"Mavi gözleri var."}]"""),
        WordEntity(esWord = "nariz", trMeaning = "burun", partOfSpeech = "isim", pronunciation = "/naˈɾiθ/", examples = """[{"es":"Me duele la nariz.","tr":"Burnum ağrıyor."}]"""),
        WordEntity(esWord = "boca", trMeaning = "ağız", partOfSpeech = "isim", pronunciation = "/ˈboka/", examples = """[{"es":"Abre la boca.","tr":"Ağzını aç."}]"""),
        WordEntity(esWord = "oreja", trMeaning = "kulak", partOfSpeech = "isim", pronunciation = "/oˈɾexa/", examples = """[{"es":"Me duele la oreja.","tr":"Kulağım ağrıyor."}]"""),
        WordEntity(esWord = "diente", trMeaning = "diş", partOfSpeech = "isim", pronunciation = "/ˈdjente/", examples = """[{"es":"Me lavo los dientes.","tr":"Dişlerimi fırçalıyorum."}]"""),
        WordEntity(esWord = "mano", trMeaning = "el", partOfSpeech = "isim", pronunciation = "/ˈmano/", examples = """[{"es":"Lávate las manos.","tr":"Ellerini yıka."}]"""),
        WordEntity(esWord = "dedo", trMeaning = "parmak", partOfSpeech = "isim", pronunciation = "/ˈdeðo/", examples = """[{"es":"Me corté el dedo.","tr":"Parmağımı kestim."}]"""),
        WordEntity(esWord = "brazo", trMeaning = "kol", partOfSpeech = "isim", pronunciation = "/ˈbɾaθo/", examples = """[{"es":"Me duele el brazo.","tr":"Kolum ağrıyor."}]"""),
        WordEntity(esWord = "pierna", trMeaning = "bacak", partOfSpeech = "isim", pronunciation = "/ˈpjeɾna/", examples = """[{"es":"Tengo las piernas cansadas.","tr":"Bacaklarım yorgun."}]"""),
        WordEntity(esWord = "pie", trMeaning = "ayak", partOfSpeech = "isim", pronunciation = "/pje/", examples = """[{"es":"Me duele el pie.","tr":"Ayağım ağrıyor."}]"""),
        WordEntity(esWord = "corazón", trMeaning = "kalp, yürek", partOfSpeech = "isim", pronunciation = "/koɾaˈθon/", examples = """[{"es":"Su corazón late rápido.","tr":"Kalbi hızlı atıyor."}]"""),
        WordEntity(esWord = "pelo", trMeaning = "saç", partOfSpeech = "isim", pronunciation = "/ˈpelo/", examples = """[{"es":"Tiene el pelo largo.","tr":"Uzun saçı var."}]"""),
        WordEntity(esWord = "espalda", trMeaning = "sırt", partOfSpeech = "isim", pronunciation = "/esˈpalda/", examples = """[{"es":"Me duele la espalda.","tr":"Sırtım ağrıyor."}]"""),
        WordEntity(esWord = "estómago", trMeaning = "mide, karın", partOfSpeech = "isim", pronunciation = "/esˈtomaɣo/", examples = """[{"es":"Me duele el estómago.","tr":"Midem ağrıyor."}]"""),
        WordEntity(esWord = "cuello", trMeaning = "boyun", partOfSpeech = "isim", pronunciation = "/ˈkweʎo/", examples = """[{"es":"Tengo dolor de cuello.","tr":"Boyun ağrım var."}]"""),

        // Meslekler
        WordEntity(esWord = "médico", trMeaning = "doktor, hekim", partOfSpeech = "isim", pronunciation = "/ˈmeðiko/", examples = """[{"es":"El médico es muy bueno.","tr":"Doktor çok iyi."}]"""),
        WordEntity(esWord = "profesor", trMeaning = "öğretmen, profesör", partOfSpeech = "isim", pronunciation = "/pɾofeˈsoɾ/", examples = """[{"es":"El profesor explica bien.","tr":"Öğretmen iyi anlatıyor."}]"""),
        WordEntity(esWord = "maestro", trMeaning = "öğretmen, usta", partOfSpeech = "isim", pronunciation = "/maˈestɾo/", examples = """[{"es":"El maestro es paciente.","tr":"Öğretmen sabırlı."}]"""),
        WordEntity(esWord = "estudiante", trMeaning = "öğrenci", partOfSpeech = "isim", pronunciation = "/estuˈðjante/", examples = """[{"es":"Soy estudiante de medicina.","tr":"Tıp öğrencisiyim."}]"""),
        WordEntity(esWord = "enfermero", trMeaning = "hemşire (erkek)", partOfSpeech = "isim", pronunciation = "/enfeɾˈmeɾo/", examples = """[{"es":"El enfermero ayuda al médico.","tr":"Hemşire doktora yardım ediyor."}]"""),
        WordEntity(esWord = "abogado", trMeaning = "avukat", partOfSpeech = "isim", pronunciation = "/aβoˈɣaðo/", examples = """[{"es":"Necesito un abogado.","tr":"Bir avukata ihtiyacım var."}]"""),
        WordEntity(esWord = "ingeniero", trMeaning = "mühendis", partOfSpeech = "isim", pronunciation = "/iŋxeˈnjeɾo/", examples = """[{"es":"Mi padre es ingeniero.","tr":"Babam mühendis."}]"""),
        WordEntity(esWord = "policía", trMeaning = "polis", partOfSpeech = "isim", pronunciation = "/poliˈθia/", examples = """[{"es":"El policía dirige el tráfico.","tr":"Polis trafiği yönetiyor."}]"""),
        WordEntity(esWord = "cocinero", trMeaning = "aşçı", partOfSpeech = "isim", pronunciation = "/kosiˈneɾo/", examples = """[{"es":"El cocinero prepara la cena.","tr":"Aşçı akşam yemeğini hazırlıyor."}]"""),
        WordEntity(esWord = "camarero", trMeaning = "garson", partOfSpeech = "isim", pronunciation = "/kamaˈɾeɾo/", examples = """[{"es":"El camarero trae la cuenta.","tr":"Garson hesabı getiriyor."}]"""),
        WordEntity(esWord = "conductor", trMeaning = "sürücü, şoför", partOfSpeech = "isim", pronunciation = "/kondukˈtoɾ/", examples = """[{"es":"El conductor es cuidadoso.","tr":"Sürücü dikkatli."}]"""),
        WordEntity(esWord = "agricultor", trMeaning = "çiftçi", partOfSpeech = "isim", pronunciation = "/aɣɾikulˈtoɾ/", examples = """[{"es":"El agricultor trabaja en el campo.","tr":"Çiftçi tarlada çalışıyor."}]"""),
        WordEntity(esWord = "vendedor", trMeaning = "satıcı", partOfSpeech = "isim", pronunciation = "/bendeˈðoɾ/", examples = """[{"es":"El vendedor es amable.","tr":"Satıcı nazik."}]"""),
        WordEntity(esWord = "artista", trMeaning = "sanatçı", partOfSpeech = "isim", pronunciation = "/aɾˈtista/", examples = """[{"es":"Ella es una gran artista.","tr":"O büyük bir sanatçı."}]"""),
        WordEntity(esWord = "escritor", trMeaning = "yazar", partOfSpeech = "isim", pronunciation = "/eskɾiˈtoɾ/", examples = """[{"es":"El escritor publica un libro.","tr":"Yazar bir kitap yayımlıyor."}]"""),
        WordEntity(esWord = "jefe", trMeaning = "patron, şef, amir", partOfSpeech = "isim", pronunciation = "/ˈxefe/", examples = """[{"es":"Mi jefe es exigente.","tr":"Patronum titiz."}]"""),
    )
}
