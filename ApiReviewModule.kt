package com.sarang.torang.di.torang_network_di

import com.sarang.torang.api.ApiReview
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ApiReviewModule {
    @Singleton
    @Provides
    fun provideApiReview(
        service: ReviewServiceProductImpl,
//        service: ReviewServiceLocalImpl
    ): ApiReview {
        return service.create()
    }
}


/**
 * 리뷰 서비스 Product
 */
@Singleton
class ReviewServiceLocalImpl @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
)
{
    private var url = ApiUrl.local
    fun create(): ApiReview
    {
        return retrofitModule
            //            .getRetrofit(torangOkHttpClientImpl.getUnsafeOkHttpClient(), url)
            .getRetrofit(torangOkHttpClientImpl.getHttpClient(), url).create(ApiReview::class.java)
    }
}

@Singleton
class ReviewServiceProductImpl @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
)
{
    private var url = ApiUrl.prod
    fun create(): ApiReview
    {
        return retrofitModule //            .getRetrofit(torangOkHttpClientImpl.getUnsafeOkHttpClient(), url)
            .getRetrofit(torangOkHttpClientImpl.getHttpClient(), url).create(ApiReview::class.java)
    }
}