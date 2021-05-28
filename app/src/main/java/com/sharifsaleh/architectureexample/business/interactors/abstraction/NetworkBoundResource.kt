package com.sharifsaleh.architectureexample.business.interactors.abstraction

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

abstract class NetworkBoundResource<ResultType, RequestType> {

    // Called to save the result of the API response into the database
    @WorkerThread
    protected abstract suspend fun saveCallResult(item: RequestType)

    // Called with the data in the database to decide whether to fetch
    // potentially updated data from the network.
    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    // Called to get the cached data from the database.
    @MainThread
    protected abstract suspend fun loadFromDb(): Flow<ResultType>

    // Called to create the API call.
    @MainThread
    protected abstract fun createCall(): Flow<ApiResponse<RequestType>>

    // Called when the fetch fails. The child class may want to reset components
    // like rate limiter.
    protected open fun onFetchFailed() {}
}