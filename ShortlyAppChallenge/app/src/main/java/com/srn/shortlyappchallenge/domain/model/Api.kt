package com.srn.shortlyappchallenge.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName

/**
 * Created by SoheilR .
 */
@Parcelize
data class Api(
    private val ok: Boolean,
    private val result: ApiResult,
): Parcelable

@Parcelize
data class ApiResult(
    @SerialName("code")
    private val code: String,

    @SerializedName("short_link")
    private val shortLink: String,

    @SerializedName("full_short_link")
    private val fullShortLink: String,

    @SerializedName("short_link2")
    private val shortLink2: String,

    @SerializedName("full_short_link2")
    private val fullShortLink2: String,

    @SerializedName("share_link")
    private val shareLink: String,

    @SerializedName("full_share_link")
    private val fullShareLink: String,

    @SerializedName("original_link")
    private val originalLink: String,
) : Parcelable
