package com.ajibsbaba.retrofit4dummies.repository

import com.ajibsbaba.retrofit4dummies.api.RetrofitInstance
import com.ajibsbaba.retrofit4dummies.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(auth: String, number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(auth, number)
    }

    suspend fun getCustomPost(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId, sort, order)
    }

    suspend fun getCustomPost2(userId: Int, options: Map<String, String>) : Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost2(userId, options)
    }

    suspend fun pushPost(post: Post) : Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPostFormType(userId: Int, id: Int, title: String, body: String) : Response<Post> {
        return RetrofitInstance.api.pushPostFormType(userId, id, title, body)
    }
}