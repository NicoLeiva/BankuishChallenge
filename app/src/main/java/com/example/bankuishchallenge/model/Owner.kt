package com.example.bankuishchallenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    val avatar_url: String,
    val html_url: String,
    val id: Int,
    val url: String
): Parcelable