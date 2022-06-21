package com.example.candyspaceapps.model.repository

import com.example.candyspaceapps.network.APICalls
import com.example.candyspaceapps.util.ResponseStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface SERepo {

    val mainTagResponseFlow: StateFlow<ResponseStatus>
    val resFlow: StateFlow<ResponseStatus>

    suspend fun getMainTag(userid:String)
    suspend fun getUsers(username:String="")

}

class SERepos(
    private val sEAPI: APICalls
) : SERepo {

    private val mainTagResFlow: MutableStateFlow<ResponseStatus> = MutableStateFlow(ResponseStatus.LOADING())

    override val mainTagResponseFlow: StateFlow<ResponseStatus> get() = mainTagResFlow

    private val userResFlow: MutableStateFlow<ResponseStatus> = MutableStateFlow(ResponseStatus.LOADING())

    override val resFlow: StateFlow<ResponseStatus> get() = userResFlow

    //get users by name
    override suspend fun getUsers(username:String) {
        try {
            val res = sEAPI.getUsers(username)

            if (res.isSuccessful) {
                res.body()?.let {
                    userResFlow.value = ResponseStatus.SUCCESS(it)
                } ?: run {
                    userResFlow.value = ResponseStatus.ERROR(IllegalStateException("User details are coming as null!"))
                }
            } else {
                userResFlow.value = ResponseStatus.ERROR(Exception(res.errorBody()?.string()))
            }
        } catch (e: Exception) {
            userResFlow.value = ResponseStatus.ERROR(e)
        }
    }

    override suspend fun getMainTag(userid: String) {

    }
}