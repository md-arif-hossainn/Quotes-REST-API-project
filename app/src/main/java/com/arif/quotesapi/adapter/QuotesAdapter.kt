package com.arif.quotesapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arif.quotesapi.databinding.DesignRowBinding
import com.arif.quotesapi.model.ModelQuotesItem

class QuotesAdapter(val callback:(ModelQuotesItem.ModelQuotesItemItem) ->Unit) : ListAdapter<ModelQuotesItem.ModelQuotesItemItem,QuotesAdapter.QuotesViewHolder>(QuotesDiffUtil()) {

    class QuotesViewHolder(val binding: DesignRowBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(item: ModelQuotesItem.ModelQuotesItemItem){
                binding.item = item
            }
        }
    class QuotesDiffUtil:DiffUtil.ItemCallback<ModelQuotesItem.ModelQuotesItemItem>() {
        override fun areItemsTheSame(
            oldItem: ModelQuotesItem.ModelQuotesItemItem,
            newItem: ModelQuotesItem.ModelQuotesItemItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ModelQuotesItem.ModelQuotesItemItem,
            newItem: ModelQuotesItem.ModelQuotesItemItem
        ): Boolean {
            return oldItem == newItem
        }
    }
//view holder creat kore
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
       val binding = DesignRowBinding.inflate(
           LayoutInflater.from(parent.context),parent,false
       )
        return QuotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item) //layout passing //data set kore
        holder.itemView.setOnClickListener {
            callback(item)
        }
    }
}