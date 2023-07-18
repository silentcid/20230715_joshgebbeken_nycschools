package com.example.a20230715_joshgebbeken_nycschools.ui

import androidx.compose.runtime.State
import com.example.a20230715_joshgebbeken_nycschools.domain.models.School
import com.example.a20230715_joshgebbeken_nycschools.domain.models.SchoolSat
import com.example.a20230715_joshgebbeken_nycschools.domain.models.UserFacingError

data class SchoolScreenState(
    val schoolList: State<List<School>>,
    val schoolSat: State<SchoolSat>,
    val schoolError: State<UserFacingError>,
    val resetError: () -> Unit,
    val shouldNavigate: State<Boolean>,
    val shouldResetNavigate: () -> Unit,
    val onSchoolClicked: (dbn: String) -> Unit,
)
