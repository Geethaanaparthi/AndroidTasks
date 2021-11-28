package com.example.designtask.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Rating {
    @SerializedName("rate")
    @Expose
    var rate: Double? = null

    @SerializedName("count")
    @Expose
    var count: Int? = null
}