package com.surensth.letsblog.ui.post

import com.surensth.letsblog.R
import com.surensth.letsblog.base.BasePresenter
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
        fetchFixtureData()

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