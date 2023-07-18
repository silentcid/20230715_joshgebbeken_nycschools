package com.example.a20230715_joshgebbeken_nycschools.ui

import androidx.lifecycle.viewModelScope
import com.example.a20230715_joshgebbeken_nycschools.R
import com.example.a20230715_joshgebbeken_nycschools.data.repositories.SchoolRepository
import com.example.a20230715_joshgebbeken_nycschools.domain.models.School
import com.example.a20230715_joshgebbeken_nycschools.domain.models.SchoolSat
import com.example.a20230715_joshgebbeken_nycschools.domain.models.UserFacingError
import com.example.a20230715_joshgebbeken_nycschools.domain.models.schoolEmptySat
import com.example.a20230715_joshgebbeken_nycschools.utils.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class SchoolsViewModel: BaseViewModel() {

    // DI
    private val schoolRepository: SchoolRepository by inject()

    // UI
    val schoolDataState: MutableStateFlow<List<School>> = MutableStateFlow(emptyList())
    private val schoolSatListDataState: MutableStateFlow<List<SchoolSat>> = MutableStateFlow(emptyList())
    val schoolSatDataState: MutableStateFlow<SchoolSat> = MutableStateFlow(schoolEmptySat())
    val shouldNavigate = MutableStateFlow(false)

    init {
        fetchSchools()
        fetchSchoolSatScores()
    }

    private fun fetchSchools() {
        viewModelScope.launch(dispatcherProvider.IO) {
            schoolRepository.getSchoolsData().onSuccess { schoolList ->
                schoolDataState.value = schoolList
            }.handleFailure()
        }
    }
    private fun fetchSchoolSatScores() {
        viewModelScope.launch(dispatcherProvider.IO) {
            schoolRepository.getSchoolsSatData().onSuccess { schoolSat ->
                schoolSatListDataState.value = schoolSat
            }.handleFailure()
        }
    }

    fun onSchoolOnClicked(schoolId: String) {
        // Filter the list of schoolSats using the schoolId
        val filteredSats = schoolSatListDataState.value.filter { it.dbn == schoolId }

// If a matching Sat object is found, update the LiveData
        if (filteredSats.isNotEmpty()) {
            schoolSatDataState.value = filteredSats[FIRST_ITEM]
            shouldNavigate.value = true
        } else {
            errorStateFlow.value = UserFacingError
                .GeneralError(R.string.no_sat_scores_for_school_title,
                    R.string.no_sat_scores_description)
        }
    }

    fun resetShouldNavigate() {
        shouldNavigate.value = false
    }

    fun resetError() {
        errorStateFlow.value = UserFacingError.NoError
    }

    private companion object {
        const val FIRST_ITEM = 0
    }

}