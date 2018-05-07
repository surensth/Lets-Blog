package com.surensth.letsblog.ui.post

import android.util.Log.v
import com.surensth.letsblog.R
import com.surensth.letsblog.base.BasePresenter
import com.surensth.letsblog.model.SignInData
import com.surensth.letsblog.model.UserInfo
import com.surensth.letsblog.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by surensth on 5/6/18.
 */
class PostPresenter(postView: PostView) : BasePresenter<PostView>(postView) {
    @Inject
    lateinit var mApiService: ApiService

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        doLogin()
    }

    private fun doLogin() {
        view.showLoading()
        val signInData = SignInData("roshanshrestha01@gmail.com", "password")
        subscription = mApiService
                .doLogin(signInData)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { response ->
                            UserInfo.token = response.token.toString()
                            fetchFixtureData()
                        },
                        {
                            v("test", it.localizedMessage)
                            view.showError(R.string.unknown_error)
                        }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun fetchFixtureData() {
        view.showLoading()
        subscription = mApiService
                .getFixtures()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { response ->
                            view.updateFixtures(response)
                        },
                        {
                            view.showError(R.string.unknown_error)
                        }
                )
    }
}