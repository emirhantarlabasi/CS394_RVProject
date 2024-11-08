// Inside DetailActivity.kt
package com.example.firstex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.firstex.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val ITEM_KEY = "ITEM_DATA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the passed ItemData
        val itemData = intent.getSerializableExtra(ITEM_KEY) as? ItemData

        itemData?.let {
            binding.titleText.text = it.title
            binding.descriptionText.text = it.description

            
            Glide.with(this)
                .load(it.largeImageUrl)
                .into(binding."@+id/detailImageView") 
        }
    }
}
