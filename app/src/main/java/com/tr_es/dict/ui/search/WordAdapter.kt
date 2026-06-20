package com.tr_es.dict.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.databinding.ItemWordBinding

class WordAdapter(
    private val onItemClick: (WordEntity) -> Unit
) : ListAdapter<WordEntity, WordAdapter.VH>(DIFF_CALLBACK) {

    inner class VH(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(word: WordEntity) {
            binding.tvWord.text = word.esWord
            binding.tvMeaning.text = word.trMeaning
            if (word.partOfSpeech.isBlank()) {
                binding.tvPos.visibility = View.GONE
            } else {
                binding.tvPos.visibility = View.VISIBLE
                binding.tvPos.text = word.partOfSpeech
            }
            binding.rootItem.setOnClickListener { onItemClick(word) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemWordBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<WordEntity>() {
            override fun areItemsTheSame(a: WordEntity, b: WordEntity) = a.id == b.id
            override fun areContentsTheSame(a: WordEntity, b: WordEntity) = a == b
        }
    }
}
