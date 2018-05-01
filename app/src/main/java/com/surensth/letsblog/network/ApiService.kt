package com.surensth.letsblog.network

import com.surensth.letsblog.model.FixturesResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by surensth on 5/1/18.
 */
interface ApiService {

    @GET("api/v1/fixtures/")
    fun getFixtures(): Observable<FixturesResponse>
}