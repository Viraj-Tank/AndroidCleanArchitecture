package com.novuspax.androidcleanarchitecture.remote

import com.novuspax.androidcleanarchitecture.remote.model.ApiResponse
import com.novuspax.androidcleanarchitecture.utils.RetrofitResponse

interface Repository {

    suspend fun getCharacterData(
        page: String
    ) : RetrofitResponse<ApiResponse>
}