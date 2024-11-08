package com.example.firstex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList = generateSampleData()
        val adapter = RecyclerViewAdapter(this, itemList)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun generateSampleData(): List<ItemData> {
        val names = listOf("Dr", "Rev", "Ms", "Mrs", "Mr")
        val descriptions = listOf(
            "Curabitur in libero ut massa volutpat convallis.",
            "Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.",
            "Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor.",
            "Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris.",
            "Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia."
        )
        val imageUrls = listOf(
            "http://example.com/image1.jpg",
            "https://example.com/image2.jpg",
            "http://example.com/image3.jpg",
            "http://example.com/image4.jpg",
            "https://example.com/image5.jpg"
        )

        val itemList = mutableListOf<ItemData>()
        for (i in names.indices) {
            val item = ItemData(names[i], descriptions[i], imageUrls[i], i)
            itemList.add(item)
        }
        return itemList
    }
}
