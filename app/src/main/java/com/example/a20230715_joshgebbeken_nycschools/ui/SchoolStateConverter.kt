package com.example.a20230715_joshgebbeken_nycschools.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.a20230715_joshgebbeken_nycschools.domain.models.UserFacingError
import com.example.a20230715_joshgebbeken_nycschools.domain.models.schoolEmptySat

@Composable
fun SchoolsViewModel.toState() = SchoolScreenState(
    schoolList = schoolDataState.collectAsState(emptyList()),
    schoolSat = schoolSatDataState.collectAsState(schoolEmptySat()),
    schoolError = errorStateFlow.collectAsState(UserFacingError.NoError),
    resetError = ::resetError,
    shouldNavigate = shouldNavigate.collectAsState(initial = false),
    shouldResetNavigate = ::resetShouldNavigate,
    onSchoolClicked = ::onSchoolOnClicked
)