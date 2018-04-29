package com.surensth.letsblog.model

/**
 * Created by surensth on 4/29/18.
 */
data class Post(
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
)