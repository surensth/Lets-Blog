package com.surensth.letsblog.injection.module

import com.surensth.letsblog.model.UserInfo
import com.surensth.letsblog.network.ApiService
import com.surensth.letsblog.utils.Constants
import com.surensth.letsblog.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 * Created by surensth on 5/2/18.
 */

@Module
object NetworkModule {

    /**
     * api service
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    /**
     * retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(OkHttpClient.Builder().addInterceptor(MyInterceptor()).build())
                .build()

    }

    private class MyInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val requestBuilder: Request.Builder
            requestBuilder = original.newBuilder()
                    .header("key", Constants.DISTRIBUTION_KEY)

            if (!UserInfo.token.isNullOrEmpty())
                requestBuilder.header("Authorization", "token " + UserInfo.token)

            val request = requestBuilder.build()
            return chain.proceed(request)
        }
    }

}