package com.example.candyspaceapps.util

class Constants {
    //https://api.stackexchange.com/2.3/answers?order=desc&sort=activity&site=stackoverflow

    //Static variables
    companion object {
        const val BASE_URL = "https://api.stackexchange.com/2.3/"
        const val ORDER = "order"
        const val SORT = "sort"
        const val SITE = "site"
        const val PAGESIZE = "pagesize"
        const val INNAME = "inname"

        const val API_PATH_FUN_USERMAINTAGS = "users/{id}/top-tags"
        const val API_PATH_FUN_USER = "users"
        const val API_PATH_ID = "id"
    }

}