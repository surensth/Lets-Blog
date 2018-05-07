package com.surensth.letsblog.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.surensth.letsblog.R
import com.surensth.letsblog.databinding.FixturesRecyclerRowBinding
import com.surensth.letsblog.model.Result

/**
 * Created by surensth on 5/6/18.
 */
class FixtureAdapter(private val context: Context) : RecyclerView.Adapter<FixtureAdapter.FixtureViewHolder>() {
    private var fixtureList: List<Result> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: FixturesRecyclerRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fixtures_recycler_row, parent, false)
        return FixtureViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fixtureList.size
    }

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        holder.bind(fixtureList[position])
    }

    /**
     * Updates the list of posts of the adapter
     * @param posts the new list of posts of the adapter
     */
    fun updatePosts(result: List<Result>) {
        this.fixtureList = result
        notifyDataSetChanged()
    }

    class FixtureViewHolder(private val binding: FixturesRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a post into the view
         */
        fun bind(fixture: Result) {
            binding.fixture = fixture
            binding.executePendingBindings()
        }
    }
}