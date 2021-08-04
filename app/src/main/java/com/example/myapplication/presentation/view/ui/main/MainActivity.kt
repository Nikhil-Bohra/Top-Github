package com.example.myapplication.presentation.view.ui.main

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.BaseApplication
import com.example.myapplication.data.model.RepositoryData
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentation.view.base.BaseActivity
import com.example.myapplication.presentation.view.ui.detail.RepositoryDetailActivity
import com.example.myapplication.presentation.view.ui.main.adapter.RepoListAdapter
import javax.inject.Inject
import androidx.core.app.ActivityCompat
import com.example.myapplication.R


class MainActivity : BaseActivity(), MainCallback, RepoListAdapter.ListItemClickCallback  {

    @Inject
    lateinit var mainViewModel: MainViewModel
    private lateinit var repoListAdapter: RepoListAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as BaseApplication).appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainViewModel.callback = this
        repoListAdapter = RepoListAdapter(arrayListOf(), this)

        binding.repolist.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
            adapter = repoListAdapter
        }

        binding.progressBar.visibility = View.VISIBLE
        mainViewModel.getRepositoryDetails()
    }

    override fun onReceiveSuccess(repositoryDataList: ArrayList<RepositoryData>) {
        binding.progressBar.visibility = View.GONE
        repoListAdapter.updateRepoList(repositoryDataList)
    }

    override fun onReceiveError(error: Throwable) {
        binding.progressBar.visibility = View.GONE
        Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_LONG).show()
    }

    override fun onListItemClick(item: RepositoryData, view: View) {
        navigateToDetailActivity(item, view)
    }

    private fun navigateToDetailActivity(item: RepositoryData, view: View) {
        val intent = Intent( this, RepositoryDetailActivity::class.java)
        intent.putExtra("data", item)

        val activityOptions: ActivityOptionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(
                this@MainActivity,
                androidx.core.util.Pair<View,String>(view, "VIEW_NAME_HEADER_IMAGE"))

        // Now we can start the Activity, providing the activity options as a bundle
        ActivityCompat.startActivity(this@MainActivity, intent, activityOptions.toBundle())
        // END_INCLUDE(start_activity)
    }
}