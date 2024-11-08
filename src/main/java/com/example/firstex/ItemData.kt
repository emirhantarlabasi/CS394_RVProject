package com.example.firstex

import java.io.Serializable

data class ItemData(
    val id: Int,
    val title: String,
    val description: String,
    val smallImageUrl: String,
    val largeImageUrl: String
)
