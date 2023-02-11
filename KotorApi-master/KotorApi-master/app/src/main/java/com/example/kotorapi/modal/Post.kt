package com.example.kotorapi.modal

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val activity: String,
    val type: String,
    val participants: Long,
    val price: Double,
    val link: String,
    val key: String,
    val accessibility: Double
)