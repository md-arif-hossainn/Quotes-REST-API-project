package com.arif.quotesapi.model
import com.google.gson.annotations.SerializedName

class ModelQuotesItem : ArrayList<ModelQuotesItem.ModelQuotesItemItem>(){

    data class ModelQuotesItemItem(
        @SerializedName("author")
        val author: String,
        @SerializedName("text")
        val text: String
    )
}

