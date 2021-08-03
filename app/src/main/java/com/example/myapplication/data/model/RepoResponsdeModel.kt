package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepoResponseModel(
    @SerializedName("count")val count: Int,
    @SerializedName("msg")val msg:String,
    @SerializedName("items")val repositoryData: ArrayList<RepositoryData>) :Serializable

data class RepositoryData(
    @SerializedName("repo")val repoName: String,
    @SerializedName("repo_link")val repo_link: String,
    @SerializedName("desc")val desc: String,
    @SerializedName("lang")val lang: String,
    @SerializedName("stars")val stars: String,
    @SerializedName("forks")val forks: String,
    @SerializedName("added_stars")val added_stars: String,
    @SerializedName("avatars")val avatars: ArrayList<String>
) : Serializable
