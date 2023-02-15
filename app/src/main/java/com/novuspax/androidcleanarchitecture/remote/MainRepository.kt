package com.novuspax.androidcleanarchitecture.remote

import com.novuspax.androidcleanarchitecture.remote.model.ApiResponse
import com.novuspax.androidcleanarchitecture.utils.ResponseEvent
import com.novuspax.androidcleanarchitecture.utils.RetrofitResponse
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiInterface: ApiInterface
) : Repository {
    override suspend fun getCharacterData(page: String): RetrofitResponse<ApiResponse> {
        return try {
            val response = apiInterface.getCharacterData(page)
            val data = response.body()
            if (response.isSuccessful) {
                RetrofitResponse.Success(data)
            } else {
                RetrofitResponse.Error("Api not called")
            }
        } catch (e: Exception) {
            RetrofitResponse.Error("getCharacterData catch block")
        }
    }

}