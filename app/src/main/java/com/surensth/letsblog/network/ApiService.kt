package com.surensth.letsblog.network

import com.surensth.letsblog.model.FixturesResponse
import com.surensth.letsblog.model.SignInData
import com.surensth.letsblog.model.SignInSuccessData
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by surensth on 5/1/18.
 */
interface ApiService {

    @GET("api/v1/fixtures/")
    fun getFixtures(): Observable<FixturesResponse>


    @POST("api/v1/obtain_auth_token/")
    fun doLogin(@Body signInData: SignInData): Observable<SignInSuccessData>
}