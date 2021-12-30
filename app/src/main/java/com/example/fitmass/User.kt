package com.example.fitmass

class User
{
    var username: String = ""
    var email: String = ""
    var password: String = ""
    var id: Int = 0

    constructor(username: String, email: String, password: String)
    {
        this.username = username
        this.email = email
        this.password = password
    }

    constructor()
}