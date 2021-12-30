package com.example.fitmass

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class ArticleData(
    var title: String? = "",
    var author: String? = "",
    var content: String? = ""
)
