package com.arif.quotesapi.repository

import com.arif.quotesapi.QuotesService
import com.arif.quotesapi.model.ModelQuotesItem
import retrofit2.Call


class QuotesRepository {

    suspend fun fetchQuotes(): ModelQuotesItem {
        val endUrl = "api/quotes"
        val response: ModelQuotesItem = QuotesService.quotesApiService.
        getQuotesList(endUrl)
        return response
    }
}