package com.david.composepractice.udemy.gmailclone.model

data class MailItemModel(
    val username: String,
    val subject: String,
    val body: String,
    val timeStamp: String
) {
    val firstNameLetter = username[0].toString()
}
