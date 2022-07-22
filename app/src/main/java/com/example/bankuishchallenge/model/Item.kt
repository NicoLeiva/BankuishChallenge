package com.example.bankuishchallenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Item(
    val created_at: String,
    val description: String,
    val html_url: String,
    val id: Int,
    val language: String?,
    val languages_url: String,
    val name: String,
    val node_id: String,
    val owner: Owner,
    val url: String,
    val updated_at: String,
    val visibility: String
): Parcelable