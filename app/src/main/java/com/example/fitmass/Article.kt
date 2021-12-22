package com.example.fitmass

class Article {
    var title : String = ""
    var content : String = ""
    var author : String = ""
    var id : Int = 0

    constructor(title: String, content: String, author: String) {
        this.title = title
        this.content = content
        this.author = author
    }
    constructor(){

    }
}