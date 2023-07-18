package com.example.a20230715_joshgebbeken_nycschools.ui

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.a20230715_joshgebbeken_nycschools.R
import com.example.a20230715_joshgebbeken_nycschools.domain.models.School
import com.example.a20230715_joshgebbeken_nycschools.domain.models.SchoolSat
import com.example.a20230715_joshgebbeken_nycschools.domain.models.UserFacingError

/**
 * enum values that represent the screens in the app
 */
enum class SchoolScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    SatScores(title = R.string.satScores),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolAppBar(
    currentScreen: SchoolScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolApp(
    modifier: Modifier,
    schoolScreenState: SchoolScreenState,
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = SchoolScreen.valueOf(
        backStackEntry?.destination?.route ?: SchoolScreen.Start.name
    )

    Scaffold(
        topBar = {
            SchoolAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = SchoolScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = SchoolScreen.Start.name) {
                SchoolListView(
                    schoolScreenState = schoolScreenState,
                    modifier = Modifier
                        .fillMaxSize(),
                    onNavigation = {
                        navController.navigate(SchoolScreen.SatScores.name)
                    }
                )
            }
            composable(route = SchoolScreen.SatScores.name) {
                ShowSchoolSatScores(
                    modifier = Modifier.fillMaxHeight(),
                    schoolSat = schoolScreenState.schoolSat.value,

                )
            }
        }
    }
}

@Composable
fun SchoolListView(modifier: Modifier, schoolScreenState: SchoolScreenState,
                   onNavigation: (SchoolSat) -> Unit) {
    val dialogVisibility = remember {
        mutableStateOf(value = false)
    }

    dialogVisibility.value = schoolScreenState.schoolError.value != UserFacingError.NoError
    val shouldNavigate by schoolScreenState.shouldNavigate


    if (shouldNavigate) {
        onNavigation(schoolScreenState.schoolSat.value)
        schoolScreenState.shouldResetNavigate()
    }

    AnimatedVisibility(dialogVisibility.value) {
        ShowErrorDialog(
            schoolError = schoolScreenState.schoolError.value,
            onDismiss = {
                schoolScreenState.resetError()
            }
        )
    }

    LazyColumn {
        items(schoolScreenState.schoolList.value) {schoolList ->
            SchoolListItem(modifier = Modifier, school = schoolList,
                onClick = schoolScreenState.onSchoolClicked )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolListItem(modifier: Modifier, school: School, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = {
            school.dbn?.let { schoolId -> onClick(schoolId) }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "${school.schoolName}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "${school.primary_address_line_1}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "${school.city}, ${school.stateCode} ${school.zip}")
        }
    }
}

@Composable
fun ShowSchoolSatScores(modifier: Modifier, schoolSat: SchoolSat) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Text(text = "${schoolSat.schoolName}",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.num_of_sat_takers,
            schoolSat.numOfSatTestTakers.toString() ))

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.math_header,
            schoolSat.satMathAvgScore.toString() ))

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.writing_header,
            schoolSat.satWritingAvgScore.toString() ))

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.reading_header,
            schoolSat.satCriticalReadingAvgScore.toString() ))
    }

}

@Composable
fun ShowErrorDialog(schoolError: UserFacingError, onDismiss: () -> Unit) {
    when (schoolError) {
        is UserFacingError.ApiError -> CustomAlertDialog(
            title = schoolError.title,
            message = schoolError.description,
            onDismiss = onDismiss
        )
        is UserFacingError.GeneralError -> CustomAlertDialog(
            title = schoolError.title,
            message = schoolError.description,
            onDismiss = onDismiss
        )
        else -> {
            onDismiss()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SchoolListPreview() {
    SchoolListView(Modifier.fillMaxSize(), SchoolPreviewData.schoolPreviewState, onNavigation = {})
}

@Preview(showBackground = true)
@Composable
fun SchoolSatPreview() {
    ShowSchoolSatScores(modifier = Modifier.fillMaxSize(),
        schoolSat = SchoolSatScoresPreviewData.satScorePreviewData() )
}