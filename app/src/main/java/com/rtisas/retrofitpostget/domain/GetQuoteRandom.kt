package com.rtisas.retrofitpostget.domain

import com.rtisas.retrofitpostget.data.model.Quote
import com.rtisas.retrofitpostget.data.model.QuotePriovider
import com.rtisas.retrofitpostget.data.repository.QuoteRepository

class GetQuoteRandom {

    private val repository = QuoteRepository()

    operator fun invoke():Quote?{
        val quotes = QuotePriovider.quotes

        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}