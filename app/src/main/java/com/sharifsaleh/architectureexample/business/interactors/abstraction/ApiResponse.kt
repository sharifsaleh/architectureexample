package com.sharifsaleh.architectureexample.business.interactors.abstraction

sealed class ApiResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ApiResponse<T>(data)
    class Loading<T>(data: T? = null) : ApiResponse<T>(data)
    class Error<T>(message: String, data: T? = null) : ApiResponse<T>(data, message)
}