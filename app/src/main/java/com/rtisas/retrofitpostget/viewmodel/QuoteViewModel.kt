package com.rtisas.retrofitpostget.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rtisas.retrofitpostget.data.model.Quote
import com.rtisas.retrofitpostget.data.model.QuotePriovider
import com.rtisas.retrofitpostget.domain.GetQuoteRandom
import com.rtisas.retrofitpostget.domain.GetQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    val quoteData = MutableLiveData<Quote>()
    val isLoading = MutableLiveData<Boolean>()

    //me genero una duda!!
    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuote = GetQuoteRandom()


    //para que inicie mostrando un cita
    fun onCreate(){
        isLoading.value = true
        //para crear un corrutina que se contrala automaticamente
        viewModelScope.launch {
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteData.postValue(result[0])
                isLoading.value = false
            }

        }
    }
    fun randomQuote(){
        isLoading.value = true
        val quote = getRandomQuote()
        if (quote != null){
            quoteData.postValue(quote!!)
        }
        isLoading.value = false
    }
}