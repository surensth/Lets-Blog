package com.surensth.letsblog.base

import com.surensth.letsblog.injection.component.DaggerPresenterInjector
import com.surensth.letsblog.injection.component.PresenterInjector
import com.surensth.letsblog.injection.module.ContextModule
import com.surensth.letsblog.injection.module.NetworkModule
import com.surensth.letsblog.ui.post.PostPresenter

/**
 * Created by surensth on 4/29/18.
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()
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
        when (this) {
            is PostPresenter -> injector.inject(this)
        }
    }
}