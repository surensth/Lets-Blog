package com.surensth.letsblog.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by surensth on 4/29/18.
 */
abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView, AppCompatActivity() {
    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    /**
     * instantiate the presenter, the activity is based on
     */
    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }

    /**
     * The onViewCreated() and onViewDestroyed() methods of the presenter
     * are not called here because as their names suggest,
     * they are supposed to be called at the end of view
     * creation and destruction. That is why we will call them in final classes.
     */
}