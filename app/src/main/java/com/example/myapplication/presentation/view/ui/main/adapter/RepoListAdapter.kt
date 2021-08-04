package com.example.myapplication.presentation.view.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.model.RepositoryData
import com.example.myapplication.databinding.ItemRepositoryListBinding
import androidx.core.content.ContextCompat.startActivity

import androidx.core.view.ViewCompat

import androidx.core.app.ActivityOptionsCompat

import android.content.Intent
import androidx.core.content.ContextCompat
import com.example.myapplication.presentation.view.ui.detail.RepositoryDetailActivity


class RepoListAdapter(
    private var repositoryList: ArrayList<RepositoryData>,
    val itemCallback: ListItemClickCallback
) : RecyclerView.Adapter<RepoListAdapter.RepositoryViewHolder>() {

    fun updateRepoList(repoList: ArrayList<RepositoryData>) {
        this.repositoryList = repoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = ItemRepositoryListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(repositoryList[position])
    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }

    inner class RepositoryViewHolder(private val binding: ItemRepositoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repoItem: RepositoryData) {
            Glide.with(binding.root).load(repoItem.avatars[0]).into(binding.imageView1)
            binding.tvRepoName.text = repoItem.repoName
            binding.tvUserName.text = repoItem.stars

            binding.root.setOnClickListener {
                itemCallback.onListItemClick(repoItem, binding.imageView1)
            }
        }
    }

    interface ListItemClickCallback {
        fun onListItemClick(item: RepositoryData, view: View)
    }
}