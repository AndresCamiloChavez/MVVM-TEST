package com.rtisas.retrofitpostget.data.network

import com.rtisas.retrofitpostget.core.RetrofitHelper
import com.rtisas.retrofitpostget.data.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<Quote>{
        // en caso de que sea null retorna un lista vacía

        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteAPIService::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}