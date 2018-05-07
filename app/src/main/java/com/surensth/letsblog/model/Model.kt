package com.surensth.letsblog.model

import com.chibatching.kotpref.KotprefModel
import java.util.*

/**
 * Created by surensth on 4/29/18.
 */
data class Fixtures(
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
)


data class FixturesResponse(
        val count: Int,
        val next: String,
        val previous: String,
        val results: ArrayList<Result>
)

data class Result(
        val resultId: Int,
        val is_today: Boolean,
        val is_home_game: Boolean,
        val datetime: String,
        val round: String,
        val venue: String,
        val broadcast_on: String,
        val mufc_score: String,
        val opponent_score: String,
        val remarks: String,
        val data: String
)


data class SignInSuccessData(
        var token: String? = null

)

data class SignInData(
        var username: String? = null,
        var password: String? = null
)


object UserInfo : KotprefModel() {
    var token by stringPref("")
}
