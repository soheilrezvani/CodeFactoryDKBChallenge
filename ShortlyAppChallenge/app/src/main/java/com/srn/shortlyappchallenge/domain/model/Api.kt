package com.srn.shortlyappchallenge.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName

/**
 * Created by SoheilR .
 */
@Parcelize
data class Api(
    @SerialName("code")
    private val code: String,

    @SerialName("short_link")
    private val shortLink: String,

    @SerialName("full_short_link")
    private val fullShortLink: String,

    @SerialName("short_link2")
    private val shortLink2: String,

    @SerialName("full_short_link2")
    private val fullShortLink2: String,

    @SerialName("share_link")
    private val shareLink: String,

    @SerialName("full_share_link")
    private val fullShareLink: String,

    @SerialName("original_link")
    private val originalLink: String,
) : Parcelable {}
