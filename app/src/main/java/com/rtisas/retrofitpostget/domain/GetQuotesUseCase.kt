package com.rtisas.retrofitpostget.domain

import com.rtisas.retrofitpostget.data.model.Quote
import com.rtisas.retrofitpostget.data.repository.QuoteRepository

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    //para haga referencia directamente a este metodo
    suspend operator fun invoke (): List<Quote>?{
        return repository.getAllQuotes()
    }
}