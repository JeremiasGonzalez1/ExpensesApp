package com.jg.entities

sealed  class StatusResult <out T> {
    data class Success<out T>(val data: T) : StatusResult<T>()
    data class Error(val errorMessage: String) : StatusResult<Nothing>()
}