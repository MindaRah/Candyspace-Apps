package com.example.candyspaceapps.model.data


import com.google.gson.annotations.SerializedName

data class CollectiveX(
    @SerializedName("description")
    val description: String,
    @SerializedName("external_links")
    val externalLinks: List<ExternalLink>,
    @SerializedName("link")
    val link: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("tags")
    val tags: List<String>
)