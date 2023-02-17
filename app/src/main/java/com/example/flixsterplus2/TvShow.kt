package com.example.flixsterplus2

import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
class TvShow(
    @JvmField
    @SerializedName("name")
    var title: String? = null,

    @JvmField
    @SerializedName("backdrop_path")
    var imageBackdropPath: String? = null,

    @JvmField
    @SerializedName("poster_path")
    var imagePosterPath: String? = null,

    @JvmField
    @SerializedName("overview")
    var description: String? = null
) : java.io.Serializable
