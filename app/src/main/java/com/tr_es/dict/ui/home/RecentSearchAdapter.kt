package com.tr_es.dict.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.databinding.ItemRecentSearchBinding

class RecentSearchAdapter(
    private val onClick: (WordEntity) -> Unit
) : ListAdapter<WordEntity, RecentSearchAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(private val binding: ItemRecentSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(word: WordEntity) {
            binding.tvPillWord.text = word.esWord
            binding.tvPillMeaning.text = word.trMeaning
            binding.rootPill.setOnClickListener { onClick(word) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecentSearchBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<WordEntity>() {
            override fun areItemsTheSame(a: WordEntity, b: WordEntity) = a.id == b.id
            override fun areContentsTheSame(a: WordEntity, b: WordEntity) = a == b
        }
    }
}
