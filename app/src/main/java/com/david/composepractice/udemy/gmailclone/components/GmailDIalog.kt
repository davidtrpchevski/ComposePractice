package com.david.composepractice.udemy.gmailclone.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.AddLink
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.david.composepractice.R
import com.david.composepractice.udemy.gmailclone.mockAccountList
import com.david.composepractice.udemy.gmailclone.model.AccountDialogEntryModel

@Composable
fun GmailDialog(dialogOpenState: MutableState<Boolean>) {
    Dialog(
        onDismissRequest = { dialogOpenState.value = false },
        properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        AccountDialog(dialogOpenState)
    }
}

@Composable
fun AccountDialog(dialogOpenState: MutableState<Boolean>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(Color.White)) {
        TopAccountDialogRow(dialogOpenState = dialogOpenState, modifier = modifier)
        MainAccountEntry()
        Divider(modifier = modifier.padding(vertical = 4.dp))
        AccountsEntriesList()
        Divider(modifier = modifier.padding(vertical = 4.dp))
        ManageAccountOptions(Icons.Default.AddLink, "Add another account")
        ManageAccountOptions(Icons.Default.AddAPhoto, "Manage other accounts")
        Divider(modifier = modifier.padding(vertical = 4.dp))
        AboutRow()
    }
}

@Composable
fun AboutRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Privacy Policy")
        Box(
            Modifier
                .clip(CircleShape)
                .size(4.dp)
                .background(Color.Black)
        )
        Text(text = "Privacy Policy")
    }
}

@Composable
fun ManageAccountOptions(manageFieldIcon: ImageVector, manageFieldText: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Icon(
            imageVector = manageFieldIcon,
            contentDescription = manageFieldText,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(text = manageFieldText)
    }
}

@Composable
fun MainAccountEntry() {
    Column(modifier = Modifier) {
        AccountEntry(
            accountDialogEntryModel = AccountDialogEntryModel(
                R.drawable.android_logo, username = "Test Account", email = "test@mail.com", 11
            )
        )
        TextButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, Color.DarkGray),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Google Account", color = Color.Gray)
        }
    }

}

@Composable
fun AccountsEntriesList() {
    LazyColumn {
        items(mockAccountList) { accountItem ->
            AccountEntry(accountDialogEntryModel = accountItem)
        }
    }
}

@Composable
fun TopAccountDialogRow(dialogOpenState: MutableState<Boolean>, modifier: Modifier) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = { dialogOpenState.value = false }, modifier = modifier.padding(8.dp)) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }
        Text(text = "Google Mail", modifier = modifier.weight(2f), textAlign = TextAlign.Center)
    }
}

@Composable
fun AccountEntry(accountDialogEntryModel: AccountDialogEntryModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .requiredSize(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        ) {
            if (accountDialogEntryModel.profilePicture != null) {
                Image(
                    painter = painterResource(id = accountDialogEntryModel.profilePicture),
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Crop
                )
            } else {
                Text(text = accountDialogEntryModel.firstCharacterFromName)
            }
        }
        Spacer(modifier = Modifier.size(12.dp))
        Column {
            Text(text = accountDialogEntryModel.username, fontWeight = FontWeight.Bold)
            Text(text = accountDialogEntryModel.email, color = Color.Gray)
        }
        Spacer(Modifier.weight(1f))
        Text(text = accountDialogEntryModel.totalMailCount)
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun AccountDialogPreview() {
    AccountDialog(dialogOpenState = mutableStateOf(false))
}