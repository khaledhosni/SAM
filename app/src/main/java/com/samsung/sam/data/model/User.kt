package com.samsung.sam.data.model

data class User(
    val avatar: String,
    val birthdate: String,
    val country: String,
    val createdAt: String,
    val id: String,
    val name: String,
    val phone: String,
    val photo: String
){

    constructor(name: String,phone: String) : this("","","","","",name,phone,"") {

    }
}