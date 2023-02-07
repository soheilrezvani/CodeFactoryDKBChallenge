package com.srn.shortlyappchallenge.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName

/**
 * Created by SoheilR .
 */

@Parcelize
data class Api(
    val ok: Boolean,
    val result: ApiResult,
) : Parcelable

@Entity(tableName = "ApiResult")
@Parcelize
data class ApiResult(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @SerialName("code")
    @ColumnInfo(name = "apiCode")
    val code: String,

    @SerializedName("short_link")
    val shortLink: String,

    @SerializedName("full_short_link")
    val fullShortLink: String,

    @SerializedName("short_link2")
    val shortLink2: String,

    @SerializedName("full_short_link2")
    val fullShortLink2: String,

    @SerializedName("share_link")
    val shareLink: String,

    @SerializedName("full_share_link")
    val fullShareLink: String,

    @SerializedName("original_link")
    val originalLink: String,

) : Parcelable
