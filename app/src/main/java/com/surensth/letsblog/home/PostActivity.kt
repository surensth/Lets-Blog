package com.surensth.letsblog.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.surensth.letsblog.R
import com.surensth.letsblog.adapter.FixtureAdapter
import com.surensth.letsblog.base.BaseActivity
import com.surensth.letsblog.model.FixturesResponse
import com.surensth.letsblog.ui.post.PostPresenter
import com.surensth.letsblog.ui.post.PostView
import com.surensth.letsblog.databinding.ActivityPostsBinding


class PostActivity : BaseActivity<PostPresenter>(), PostView {


    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityPostsBinding

    /**
     * The adapter for the list of posts
     */
    private val postsAdapter = FixtureAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_posts)
        binding.adapter = postsAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }


    override fun updateFixtures(fixtureList: FixturesResponse) {
        postsAdapter.updatePosts(fixtureList.results)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun instantiatePresenter(): PostPresenter {
        return PostPresenter(this)
    }
}