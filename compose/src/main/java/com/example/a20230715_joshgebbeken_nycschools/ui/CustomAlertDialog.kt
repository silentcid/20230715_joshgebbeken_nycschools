package com.example.a20230715_joshgebbeken_nycschools.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.example.a20230715_joshgebbeken_nycschools.R

@Composable
fun CustomAlertDialog(@StringRes title: Int, @StringRes message: Int, onDismiss: () -> Unit) {
    MaterialTheme {
        Column {

            AlertDialog(
                onDismissRequest = onDismiss,
                title = {
                    Text(text = stringResource(id = title))
                }, text = {
                    Text(text = stringResource(id = message))
                },
                confirmButton = {
                    CustomAlertDialogConfirmButton(onDismiss = onDismiss)
                },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true,
                )
            )
        }
    }
}

@Composable
@Preview
fun PreviewCustomAlertDialog() {
    CustomAlertDialog(
        title = R.string.test_general_error_title,
        message = R.string.test_api_error_description,
        onDismiss = {}
    )

}

@Composable
fun CustomAlertDialogConfirmButton(onDismiss: () -> Unit) {
    Button(
        onClick = onDismiss
    ) {
        Text("OK")
    }
}