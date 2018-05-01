package com.surensth.letsblog.model

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