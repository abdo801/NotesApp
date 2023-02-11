package com.example.kotorapi.modal

interface PostsApi {
    suspend fun getPosts(): List<Post>
}