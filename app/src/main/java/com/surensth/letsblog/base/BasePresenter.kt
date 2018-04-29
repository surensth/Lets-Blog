package com.surensth.letsblog.base

/**
 * Created by surensth on 4/29/18.
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    init {
        inject()
    }

    /**
     * called when presenter view is created
     */
    open fun onViewCreated() {

    }

    /**
     * called when presenter view is destroyed
     */
    open fun onViewDestroyed() {

    }

    /**
     * injects required dependencies
     */
    private fun inject() {

    }
}