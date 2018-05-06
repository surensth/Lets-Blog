package com.surensth.letsblog.ui.post

import android.support.annotation.StringRes
import com.surensth.letsblog.base.BaseView
import com.surensth.letsblog.model.FixturesResponse

/**
 * Created by surensth on 5/6/18.
 */
interface PostView : BaseView {
    /**
     * updates the fixtures to the view
     */
    fun updateFixtures(fixtureList: FixturesResponse)

    /**
     * shows error string
     */
    fun showError(error: String)

    /**
     * shows error
     * @param errorResId the resource id of error to display in view
     */
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    /**
     * display loading in view
     */
    fun showLoading()

    /**
     * hide loading from view
     */
    fun hideLoading()
}