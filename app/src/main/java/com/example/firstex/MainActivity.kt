package com.example.firstex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstex.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val itemList = loadMockDataFromAssets()

        val adapter = RecyclerViewAdapter(this, itemList)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

   private fun loadMockDataFromAssets(): List<ItemData> {
    val inputStream = assets.open("MOCK_DATA.json")
    val reader = InputStreamReader(inputStream)
    val itemType = object : TypeToken<List<ItemData>>() {}.type
    return Gson().fromJson(reader, itemType)
}
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
