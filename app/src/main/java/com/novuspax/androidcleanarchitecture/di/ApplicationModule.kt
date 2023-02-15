package com.novuspax.androidcleanarchitecture.di

import com.novuspax.androidcleanarchitecture.remote.ApiInterface
import com.novuspax.androidcleanarchitecture.remote.MainRepository
import com.novuspax.androidcleanarchitecture.remote.Repository
import com.novuspax.androidcleanarchitecture.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun providesRetrofit(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun providesMainRepo(api: ApiInterface): Repository = MainRepository(api)

    @Provides
    @Singleton
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {

        override val main: CoroutineDispatcher
            get() = Dispatchers.Main

        override val io: CoroutineDispatcher
            get() = Dispatchers.IO

        override val default: CoroutineDispatcher
            get() = Dispatchers.Default

        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined

    }
}