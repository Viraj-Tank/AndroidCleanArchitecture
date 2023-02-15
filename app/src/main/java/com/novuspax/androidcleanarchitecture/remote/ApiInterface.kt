package com.novuspax.androidcleanarchitecture.remote

import com.novuspax.androidcleanarchitecture.remote.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("character")
    suspend fun getCharacterData(
        @Query("page") page: String
    ) : Response<ApiResponse>
}