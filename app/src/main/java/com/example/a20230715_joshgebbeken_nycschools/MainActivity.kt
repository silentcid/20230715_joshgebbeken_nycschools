package com.example.a20230715_joshgebbeken_nycschools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.a20230715_joshgebbeken_nycschools.theme.SchoolTheme
import com.example.a20230715_joshgebbeken_nycschools.ui.SchoolApp
import com.example.a20230715_joshgebbeken_nycschools.ui.SchoolListView
import com.example.a20230715_joshgebbeken_nycschools.ui.SchoolsViewModel
import com.example.a20230715_joshgebbeken_nycschools.ui.toState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val schoolViewModel: SchoolsViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            SchoolTheme {
                SchoolApp(modifier = Modifier.fillMaxSize(),
                    schoolScreenState = schoolViewModel.toState())
            }
        }
    }
}