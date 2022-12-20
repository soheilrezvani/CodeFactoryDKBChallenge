package com.srn.dkbcodechallenge.data

import com.srn.dkbcodechallenge.data.ServerResponse.ResponseStatus.*


/**
 * Created by SoheilR .
 */


data class ServerResponse<T>(
    val status: ResponseStatus,
    val data: T?,
    val message: String? = null,
    val title: String? = null,
) {
    enum class ResponseStatus() {
        SUCCESS, FAIL, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T?): ServerResponse<T> =
            ServerResponse(SUCCESS, data, null)

        fun <T> error(message: String?, title: String? = null, data: T? = null): ServerResponse<T> =
            ServerResponse(ERROR, data, message, title)

        fun <T> fail(message: String?, title: String? = null, data: T? = null): ServerResponse<T> =
            ServerResponse(FAIL, data, message, title)

        fun <T> loading(data: T? = null): ServerResponse<T> =
            ServerResponse(LOADING, data, null, null)
    }
    override fun toString(): String {
        return "Result(status=$status, data=$data, message=$message)"
    }
}
