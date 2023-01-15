package com.david.composepractice.udemy.gmailclone.model

data class AccountDialogEntryModel(
    val profilePicture: Int? = null, val username: String, val email: String, val mailCount: Int
) {
    val totalMailCount = if (mailCount > 99) {
        "99+"
    } else {
        "$mailCount"
    }

    val firstCharacterFromName = username.first().toString()
}
