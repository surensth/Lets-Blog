package com.surensth.letsblog.injection.module

import com.surensth.letsblog.network.ApiService
import com.surensth.letsblog.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

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
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()

    }

}