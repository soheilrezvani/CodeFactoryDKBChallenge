package com.srn.shortlyappchallenge.data

import com.srn.shortlyappchallenge.data.ServerResponse.ResponseStatus.*

/**
 * Created by SoheilR .
 */
data class ServerResponse<T>(
    val status: ResponseStatus,
    val ok: Boolean,
    val result: T?,
    val error_code: Int? = null,
    val error: String? = null,
) {
    enum class ResponseStatus() {
        LOADING, SUCCESS, ERROR , FAIL
    }

    companion object {

        fun <T> success(data: T?): ServerResponse<T> =
            ServerResponse(SUCCESS, true, data)

        fun <T> error(errorCode: Int? , errorMessage: String?): ServerResponse<T> =
            ServerResponse(ERROR, false, null, errorCode, errorMessage)

        fun <T> loading(): ServerResponse<T> =
            ServerResponse(LOADING, true, null)

        fun <T> fail(errorCode: Int? , errorMessage: String?): ServerResponse<T> =
            ServerResponse(FAIL, false , null , errorCode , errorMessage)

    }

}