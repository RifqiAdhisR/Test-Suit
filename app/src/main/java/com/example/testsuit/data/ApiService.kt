package com.example.testsuit.data

import com.example.testsuit.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int? = null,
        @Query("per_page") per_page: Int? = null,
    ): UserResponse
}