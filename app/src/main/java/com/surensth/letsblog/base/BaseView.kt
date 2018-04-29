package com.surensth.letsblog.base

import android.content.Context

/**
 * Created by surensth on 4/29/18.
 */

/**
 * base view must be implemented by any other views
 */
interface BaseView {
    /**
     *returns the context in which application is running
     * @return context of application currently running
     */
    fun getContext(): Context
}