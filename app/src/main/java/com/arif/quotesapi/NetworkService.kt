package com.arif.quotesapi

import com.arif.quotesapi.model.ModelQuotesItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

const val base_url = "https://type.fit/"


val retrofit = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
interface QuotesApiService {
    @GET
    suspend fun getQuotesList(@Url endUrl: String): ModelQuotesItem

}
object QuotesService{
    val quotesApiService: QuotesApiService by lazy {
        retrofit.create(QuotesApiService::class.java)
    }
}
