package com.tr_es.dict.ui.flashcards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tr_es.dict.R
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.databinding.FragmentFlashcardsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FlashcardsFragment : Fragment() {

    private var _binding: FragmentFlashcardsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FlashcardsViewModel by viewModels()

    private val gson = Gson()

    private data class Ex(val es: String = "", val tr: String = "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlashcardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardFlip.setOnClickListener { animateFlip() }
        binding.btnKnow.setOnClickListener { viewModel.answer(true) }
        binding.btnDontKnow.setOnClickListener { viewModel.answer(false) }
        binding.btnRestart.setOnClickListener { viewModel.restart() }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state -> render(state) }
            }
        }
    }

    private fun render(state: FlashState) {
        val b = _binding ?: return

        // Still loading the deck: keep the screen quiet for the brief moment.
        if (state.loading) {
            b.cardFlip.isVisible = false
            b.btnKnow.isVisible = false
            b.btnDontKnow.isVisible = false
            b.tvProgress.isVisible = false
            b.tvDone.isVisible = false
            b.btnRestart.isVisible = false
            b.tvEmpty.isVisible = false
            return
        }

        // Nothing to study.
        if (state.deck.isEmpty()) {
            b.tvEmpty.isVisible = true
            b.cardFlip.isVisible = false
            b.btnKnow.isVisible = false
            b.btnDontKnow.isVisible = false
            b.tvProgress.isVisible = false
            b.tvDone.isVisible = false
            b.btnRestart.isVisible = false
            return
        }

        b.tvEmpty.isVisible = false

        // Finished the whole deck.
        if (state.finished) {
            b.tvDone.isVisible = true
            b.btnRestart.isVisible = true
            b.cardFlip.isVisible = false
            b.btnKnow.isVisible = false
            b.btnDontKnow.isVisible = false
            b.tvProgress.isVisible = false
            return
        }

        // Active study state.
        b.tvDone.isVisible = false
        b.btnRestart.isVisible = false
        b.cardFlip.isVisible = true
        b.btnKnow.isVisible = true
        b.btnDontKnow.isVisible = true
        b.tvProgress.isVisible = true

        val current = state.deck.getOrNull(state.index) ?: return

        b.tvProgress.text = getString(R.string.flashcards_progress, state.index + 1, state.deck.size)
        b.tvCardPrimary.text = current.esWord

        applyCardFace(current, state.showBack)
    }

    /** Show either the front (word + hint) or the back (meaning + example) of [word]. */
    private fun applyCardFace(word: WordEntity, showBack: Boolean) {
        val b = _binding ?: return
        if (showBack) {
            b.tvCardMeaning.text = word.trMeaning
            b.tvCardMeaning.isVisible = true

            val example = firstExample(word)
            if (example != null) {
                b.tvCardExample.text = example
                b.tvCardExample.isVisible = true
            } else {
                b.tvCardExample.isVisible = false
            }

            b.tvTapHint.isVisible = false
        } else {
            b.tvCardMeaning.isVisible = false
            b.tvCardExample.isVisible = false
            b.tvTapHint.isVisible = true
        }
    }

    /** First parsed example formatted as "es — tr", or null when there is none. */
    private fun firstExample(word: WordEntity): String? {
        val examples = parseExamples(word.examples)
        val first = examples.firstOrNull() ?: return null
        if (first.es.isBlank() && first.tr.isBlank()) return null
        return "${first.es} — ${first.tr}"
    }

    private fun parseExamples(json: String?): List<Ex> {
        if (json.isNullOrBlank()) return emptyList()
        return try {
            val type = object : TypeToken<List<Ex>>() {}.type
            gson.fromJson<List<Ex>>(json, type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    /**
     * Half-rotation flip: spin to the edge, flip the model + swap the visible face at the
     * mid-point, then spin back in. Guards against the view going away mid-animation.
     */
    private fun animateFlip() {
        val card = _binding?.cardFlip ?: return
        card.animate()
            .rotationY(90f)
            .setDuration(120)
            .withEndAction {
                val b = _binding ?: return@withEndAction
                viewModel.flip()
                b.cardFlip.rotationY = -90f
                b.cardFlip.animate()
                    .rotationY(0f)
                    .setDuration(120)
                    .start()
            }
            .start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
