package com.example.candyspaceapps.model.view.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.candyspaceapps.model.repository.SERepo
import com.example.candyspaceapps.util.ResponseStatus
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

// View Model - live data, coroutineScope
class UserModel (

    private val sERepo: SERepo,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    //private coroutine Scope - job and ioDispatcher
    private val corScope: CoroutineScope = CoroutineScope(SupervisorJob() + ioDispatcher)
) : CoroutineScope by corScope, ViewModel(){

    //live data
    private val usersLData: MutableLiveData<ResponseStatus> = MutableLiveData(ResponseStatus.LOADING())
    val usersLiveData: LiveData<ResponseStatus> get() = usersLData

    //get all users
    private fun gatherUsers() {
        //launch coroutine
        launch {
            sERepo.resFlow.collect{ responseStatus ->
                usersLData.postValue(responseStatus)
            }
        }
    }

    //sign up users by username
    fun signUpUsers(username:String="") {
        usersLData.postValue(ResponseStatus.LOADING())
        gatherUsers()
        //launch coroutine
        launch {
            sERepo.getUsers(username)
        }
    }
}