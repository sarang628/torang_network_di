package com.sarang.torang.di.torang_network_di

import com.sarang.torang.api.ApiMenu
import com.sarang.torang.api.ApiRestaurant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ApiMenuModule {
    @Singleton
    @Provides
    fun provideRemoteFeedService(
        apiMenu: ProductApiMenu
//        apiRestaurant: LocalApiRestaurant
    ): ApiMenu {
        return apiMenu.create()
    }
}

@Singleton
class ProductApiMenu @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = ApiUrl.menu
    fun create(): ApiMenu {
        return retrofitModule
//            .getRetrofit(torangOkHttpClientImpl.getUnsafeOkHttpClient(), url)
            .getRetrofit(torangOkHttpClientImpl.getHttpClient(), url)
            .create(ApiMenu::class.java)
    }
}

@Singleton
class LocalApiMenu @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = ApiUrl.local
    fun create(): ApiMenu {
        return retrofitModule
//            .getRetrofit(torangOkHttpClientImpl.getUnsafeOkHttpClient(), url)
            .getRetrofit(torangOkHttpClientImpl.getHttpClient(), url)
            .create(ApiMenu::class.java)
    }
}