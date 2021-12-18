package com.rtisas.retrofitpostget.data.network

import com.rtisas.retrofitpostget.data.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteAPIService {
    @GET(".json")
    suspend fun getAllQuotes(): Response<List<Quote>>
}