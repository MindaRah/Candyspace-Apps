package com.example.candyspaceapps.di

import com.example.candyspaceapps.model.repository.SERepo
import com.example.candyspaceapps.model.repository.SERepos
import com.example.candyspaceapps.network.APICalls

import com.example.candyspaceapps.model.view.ui.users.UserModel
import com.example.candyspaceapps.util.Constants.Companion.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// initialising and setting up network module
val networkModule = module {
    // Gives google Gson object
    fun giveGson() = GsonBuilder().create()

    // Gives repository
    fun giveStExRepository(stExAPI: APICalls): SERepo = SERepos(stExAPI)

    // Gives okhttp
    fun giveOkHttpClient(logInt: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(logInt)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    // Gives Http logging
    fun giveLoggingInt() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    // Method for the retrofit
    fun giveStExAPI(okHttpClient: OkHttpClient, gson: Gson): APICalls =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(APICalls::class.java)

    single { giveGson() }
    single { giveOkHttpClient(get()) }
    single { giveLoggingInt() }
    single { giveStExRepository(get()) }
    single { giveStExAPI(get(), get()) }
}

// initialising and setting up view model
val vModelMod = module {
    viewModel {
        UserModel(get())
    }
}

