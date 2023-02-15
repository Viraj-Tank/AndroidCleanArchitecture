package com.novuspax.androidcleanarchitecture.remote.model

data class ApiResponse(
    val info: Info,
    val results: List<Result>
)