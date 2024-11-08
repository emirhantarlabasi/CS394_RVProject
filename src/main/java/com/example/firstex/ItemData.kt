package com.example.firstex

import java.io.Serializable

data class ItemData(
    val title: String,
    val description: String,
    val imageUrl: String,
    val id: Int
) : Serializable
