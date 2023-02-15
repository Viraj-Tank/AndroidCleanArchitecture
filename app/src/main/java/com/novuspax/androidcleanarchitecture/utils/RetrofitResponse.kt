package com.novuspax.androidcleanarchitecture.utils


sealed class RetrofitResponse<T>(val data: T?, val error: String?) {
    class Success<T>(data: T?) : RetrofitResponse<T>(data, null)
    class Error<T>(error: String?) : RetrofitResponse<T>(null, error)
}


///////////////////////////////////////////////////////////////////////////
// Below we can use in viewModel with LiveData
// we add empty because we need to provide initial value to state flow
///////////////////////////////////////////////////////////////////////////
sealed class ResponseEvent {
    class Success(val resultText: String?) : ResponseEvent()
    class Failure(val errorText: String?) : ResponseEvent()
    object Loading : ResponseEvent()
    object Empty : ResponseEvent()
}



///////////////////////////////////////////////////////////////////////////
// Below both we can use in viewModel with LiveData
///////////////////////////////////////////////////////////////////////////
class Resource<T>(val status: Status, val data: T? = null, var errorString: String? = null) {
    fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)
    fun <T> fail(data: String?): Resource<T> = Resource(Status.SUCCESS, null, data)
    fun <T> loading(): Resource<T> = Resource(Status.LOADING, null, null)
}

enum class Status {
    SUCCESS,
    FAIL,
    LOADING
}