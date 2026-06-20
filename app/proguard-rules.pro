# Room
-keep class * extends androidx.room.RoomDatabase
-dontwarn androidx.room.paging.**

# Gson - örnek cümle modelleri
-keep class com.tr_es.dict.ui.detail.Example { *; }
-keepattributes Signature
-keepattributes *Annotation*

# Hilt tarafından üretilen sınıflar zaten korunur (eklenti yönetir)
