package com.jg.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class BaseClient @Inject constructor(private val client : HttpClient){
    suspend fun get(
        url: String,
        parameters: Map<String, String>? = emptyMap(),
        token:String? = null
    ): HttpStatus {
        return try {
            val response = client.get(url) {
                contentType(ContentType.Application.Json)
                header(
                    "Authorization",
                    "Bearer $token"
                )
                parameters?.forEach { (key, value) ->
                    parameter(key, value) }
            }
            if(response.status.value in 200 ..299){
                return HttpStatus(response.body())
            }else
                return HttpStatus(errorMessage = response.status.description)
        } catch (e:Exception){
            return HttpStatus(errorMessage = e.message.toString())
        }
    }

    suspend fun post(
        url:String,
        value:Any?,
        token: String?
    ): HttpStatus {
        return try{
            val response = client.post(url){
                setBody(value)
                contentType(ContentType.Application.Json)
                header(
                    "Authorization",
                    "Bearer $token"
                )
            }
            if(response.status.value in 200 ..299){
                return HttpStatus(httpResponse = response)
            }else
                return HttpStatus(errorMessage = response.status.description.toString())
        } catch (e:Exception){
            return HttpStatus(errorMessage = e.message.toString())
        }
    }
}

data class HttpStatus(
    val httpResponse: HttpResponse? = null,
    val errorMessage: String = "",
)