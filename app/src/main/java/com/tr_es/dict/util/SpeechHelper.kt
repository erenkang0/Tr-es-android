package com.tr_es.dict.util

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

/**
 * Thin wrapper around [TextToSpeech] that speaks Spanish words aloud.
 *
 * The engine initializes asynchronously; [ready] guards every use so calls made
 * before initialization (or after a failed init) are simply ignored.
 */
class SpeechHelper(context: Context) : TextToSpeech.OnInitListener {

    private val tts = TextToSpeech(context.applicationContext, this)
    private var ready = false

    override fun onInit(status: Int) {
        if (status != TextToSpeech.SUCCESS) {
            ready = false
            return
        }
        val result = tts.setLanguage(Locale("es", "ES"))
        if (result == TextToSpeech.LANG_MISSING_DATA ||
            result == TextToSpeech.LANG_NOT_SUPPORTED
        ) {
            // Fall back to a generic Spanish locale when es-ES is unavailable.
            tts.setLanguage(Locale("es"))
        }
        ready = true
    }

    fun speak(text: String) {
        if (!ready || text.isBlank()) return
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "utt")
    }

    fun shutdown() {
        ready = false
        tts.stop()
        tts.shutdown()
    }
}
