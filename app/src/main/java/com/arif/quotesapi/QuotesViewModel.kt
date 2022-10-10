package com.arif.quotesapi


import android.telecom.Call
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.arif.quotesapi.model.ModelQuotesItem

import com.arif.quotesapi.repository.QuotesRepository
import kotlinx.coroutines.launch


class QuotesViewModel : ViewModel() {
    val repository = QuotesRepository()
    val quotesLiveData: MutableLiveData<ModelQuotesItem> = MutableLiveData()

    fun fetchQuotes(){
       viewModelScope.launch {
           try {
               quotesLiveData.value = repository.fetchQuotes()

           }catch (e: Exception){
               Log.d("QuotesViewModel", e.localizedMessage)
           }
       }

    }

}