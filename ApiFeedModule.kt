package com.sarang.torang.di.torang_network_di

import com.sarang.torang.api.feed.ApiFeed
import com.sarang.torang.api.feed.ApiFeedV1
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ApiFeedModule {
    @Singleton @Provides fun provideApiFeed(apiFeed: LocalApiFeed, ): ApiFeed { return apiFeed.create() }
    @Singleton @Provides fun provideApiFeedV1(apiFeed: LocalApiFeedV1 ): ApiFeedV1 { return apiFeed.create() }
}

@Singleton
class LocalApiFeed @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule,
) {
    private var url = ApiUrl.feed
    fun create(): ApiFeed {
        return retrofitModule.getRetrofit(torangOkHttpClientImpl.getHttpClient(), url).create(ApiFeed::class.java)
    }
}

@Singleton
class LocalApiFeedV1 @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule,
) {
    private var url = ApiUrl.feedv1
    fun create(): ApiFeedV1 {
        return retrofitModule.getRetrofit(torangOkHttpClientImpl.getHttpClient(), url).create(ApiFeedV1::class.java)
    }
}