package com.tr_es.dict.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.databinding.ItemWordBinding

class FavoriteAdapter(
    private val onItemClick: (WordEntity) -> Unit,
    private val onRemove: (WordEntity) -> Unit
) : ListAdapter<WordEntity, FavoriteAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(word: WordEntity) {
            binding.tvEsWord.text = word.esWord
            binding.tvTrMeaning.text = word.trMeaning
            binding.tvPartOfSpeech.text = word.partOfSpeech
            binding.root.setOnClickListener { onItemClick(word) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWordBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun removeItem(position: Int) {
        onRemove(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<WordEntity>() {
            override fun areItemsTheSame(a: WordEntity, b: WordEntity) = a.id == b.id
            override fun areContentsTheSame(a: WordEntity, b: WordEntity) = a == b
        }
    }
}
