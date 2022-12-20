package com.srn.dkbcodechallenge.data.base

import com.srn.dkbcodechallenge.data.ServerResponse
import org.json.JSONObject
import retrofit2.Response

/**
 * Created by SoheilR .
 */
suspend fun <T> getResult(call: suspend () -> Response<out T>): ServerResponse<T> {
    try {
        val response = call()
        if (response.isSuccessful) {
            val body = response.body()
            return if (body != null) ServerResponse.success(body)
            else return ServerResponse.error(response.message())
        } else {
            val json = JSONObject(response.errorBody()?.string()!!)
            return ServerResponse.error(json.get("Message") as String, null)
        }
    } catch (e: Exception) {
        return ServerResponse.fail(e.message ?: e.toString())
    }
}
