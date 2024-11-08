package com.example.firstex

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstex.databinding.ItemLayoutBinding

class RecyclerViewAdapter(private val context: Context, private val itemList: List<ItemData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        private val ITEM_KEY = "ITEM_DATA"
        lateinit var itemData: ItemData

        init {
            binding.root.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(ITEM_KEY, itemData)
                }
                context.startActivity(intent)
            }
        }

        fun bind(itemData: ItemData) {
            this.itemData = itemData
            binding.titleText.text = itemData.title
            binding.descriptionText.text = itemData.description

          
            Glide.with(context)
                .load(itemData.smallImageUrl)
                .into(binding."@+id/itemImageView") 
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}
