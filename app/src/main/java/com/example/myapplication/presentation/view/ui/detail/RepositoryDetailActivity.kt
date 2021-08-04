package com.example.myapplication.presentation.view.ui.detail

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.transition.Transition
import android.view.View
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.model.RepositoryData
import com.example.myapplication.databinding.ActivityRepositoryDetailBinding
import com.example.myapplication.presentation.view.base.BaseActivity

class RepositoryDetailActivity : BaseActivity() {

    lateinit var binding: ActivityRepositoryDetailBinding
    lateinit var data: RepositoryData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        this.actionBar.apply {
            title = getString(R.string.repo_detail_header)
        }
        data = intent.extras?.get("data") as RepositoryData

        ViewCompat.setTransitionName(binding.imageView, "VIEW_NAME_HEADER_IMAGE");

        data?.let {
            binding.repoName.text = it.repoName

            if (TextUtils.isEmpty(it.desc)) {
                binding.tvDesc.visibility = View.GONE
                binding.tvDescVal.visibility = View.GONE
            } else {
                binding.tvDescVal.text = it.desc
            }

            if (TextUtils.isEmpty(it.forks)) {
                binding.tvForks.visibility = View.GONE
                binding.tvForksVal.visibility = View.GONE
            } else {
                binding.tvForksVal.text = it.forks
            }

            if (TextUtils.isEmpty(it.lang)) {
                binding.tvLanguage.visibility = View.GONE
                binding.tvLanguageVal.visibility = View.GONE
            } else {
                binding.tvLanguageVal.text = it.lang
            }

            if (TextUtils.isEmpty(it.stars)) {
                binding.tvStars.visibility = View.GONE
                binding.tvStarsVal.visibility = View.GONE
            } else {
                binding.tvStarsVal.text = it.stars
            }

            if (TextUtils.isEmpty(it.added_stars)) {
                binding.tvAddStar.visibility = View.GONE
                binding.tvAddStarVal.visibility = View.GONE
            } else {
                binding.tvAddStarVal.text = it.added_stars
            }

            if (TextUtils.isEmpty(it.repo_link)) {
                binding.tvLinkVal.visibility = View.GONE
                binding.tvLink.visibility = View.GONE
            } else {
                binding.tvLinkVal.text = it.repo_link
            }
        }
        loadItem()
    }

    private fun loadItem() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && addTransitionListener()) {
            // If we're running on Lollipop and we have added a listener to the shared element
            // transition, load the thumbnail. The listener will load the full-size image when
            // the transition is complete.

        } else {
            loadImageView()
        }
    }

    fun loadImageView(){
        Glide.with(this).load(data.avatars[0]).into(binding.imageView)
    }

    private fun addTransitionListener(): Boolean {
        val transition: Transition? = window.sharedElementEnterTransition
        transition?.addListener(object : Transition.TransitionListener{
            override fun onTransitionStart(p0: Transition?) {
                loadImageView()
            }

            override fun onTransitionEnd(p0: Transition?) {
            }

            override fun onTransitionCancel(p0: Transition?) {
                transition.removeListener(this)
            }

            override fun onTransitionPause(p0: Transition?) {
            }

            override fun onTransitionResume(p0: Transition?) {
            }

        })
        return false
    }
}