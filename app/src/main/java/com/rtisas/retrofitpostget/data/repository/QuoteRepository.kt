package com.rtisas.retrofitpostget.data.repository

import com.rtisas.retrofitpostget.data.model.Quote
import com.rtisas.retrofitpostget.data.model.QuotePriovider
import com.rtisas.retrofitpostget.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes():List<Quote>{
        val response = api.getQuotes()
        QuotePriovider.quotes = response
        return response
    }
}