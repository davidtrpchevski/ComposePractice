package com.david.composepractice.udemy.gmailclone

import com.david.composepractice.R
import com.david.composepractice.udemy.gmailclone.model.AccountDialogEntryModel
import com.david.composepractice.udemy.gmailclone.model.MailItemModel

val mockMailList = listOf(
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
    MailItemModel("David", "Important Subject", "Some non important body", "21:20"),
)

val mockAccountList = listOf(
    AccountDialogEntryModel(
        username = "David",
        email = "david@mail.com",
        mailCount = 10
    ),
    AccountDialogEntryModel(
        profilePicture = R.drawable.androidparty,
        username = "David",
        email = "david@mail.com",
        mailCount = 900
    )
)