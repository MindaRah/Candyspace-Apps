package com.example.candyspaceapps.util

//restricted class - success, error and loading state.
sealed class ResponseStatus {
    class SUCCESS(val success: Any): ResponseStatus()
    class ERROR(val error: Throwable): ResponseStatus()
    class LOADING(val isLoading: Boolean = true) : ResponseStatus()
}