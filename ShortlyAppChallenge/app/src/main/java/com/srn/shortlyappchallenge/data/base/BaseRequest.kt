package com.srn.shortlyappchallenge.data.base

import com.srn.shortlyappchallenge.data.ServerResponse
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
            else return ServerResponse.error(response.code(), response.message())
        } else {
            val json = JSONObject(response.errorBody()?.string()!!)
            return ServerResponse.error(response.code() , json.get("Message") as String)
        }
    } catch (e: Exception) {
        return ServerResponse.fail(0 , e.message ?: e.toString())
    }
}