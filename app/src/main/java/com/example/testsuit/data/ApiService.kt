package com.example.testsuit.data

import com.example.testsuit.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("users/{id}")
    fun getUser(
        @Path("id") id: String
    ): Call<UserResponse>
}