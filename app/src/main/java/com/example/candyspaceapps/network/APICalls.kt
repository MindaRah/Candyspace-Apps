package com.example.candyspaceapps.network

import com.example.candyspaceapps.model.data.UserItem
import com.example.candyspaceapps.util.Constants.Companion.API_PATH_FUN_USER
import com.example.candyspaceapps.util.Constants.Companion.API_PATH_FUN_USERMAINTAGS
import com.example.candyspaceapps.util.Constants.Companion.API_PATH_ID
import com.example.candyspaceapps.util.Constants.Companion.INNAME
import com.example.candyspaceapps.util.Constants.Companion.ORDER
import com.example.candyspaceapps.util.Constants.Companion.PAGESIZE
import com.example.candyspaceapps.util.Constants.Companion.SITE
import com.example.candyspaceapps.util.Constants.Companion.SORT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APICalls {
    @GET(API_PATH_FUN_USER)
    suspend fun getUsers(
        @Query(INNAME)inname:String="",
        @Query(PAGESIZE)size:String="20",
        @Query(ORDER)order:String="asc",
        @Query(SORT)sort: String="name",
        @Query(SITE)site: String="stackoverflow"
    ): Response<UserItem>
}