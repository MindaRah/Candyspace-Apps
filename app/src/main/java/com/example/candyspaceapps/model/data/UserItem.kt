package com.example.candyspaceapps.model.data


import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("items")
    val userDetails: MutableList<UserDetails>,
    @SerializedName("quota_max")
    val quotaMax: Int,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int
)