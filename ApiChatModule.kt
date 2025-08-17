package com.sarang.torang.di.torang_network_di

import com.sarang.torang.api.ApiChat
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ApiChatModule {
    @Singleton
    @Provides
    fun provideRemoteFeedService(
        apiChat: LocalApiChat,
    ): ApiChat {
        return apiChat.create()
    }
}

@Singleton
class LocalApiChat @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule,
) {
    fun create(): ApiChat {
        return retrofitModule.getRetrofit(torangOkHttpClientImpl.getHttpClient(), ApiUrl.chat)
            .create(
                ApiChat::class.java
            )
    }
}