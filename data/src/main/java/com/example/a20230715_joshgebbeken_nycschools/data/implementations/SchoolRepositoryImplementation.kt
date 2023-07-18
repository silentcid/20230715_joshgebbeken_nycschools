package com.example.a20230715_joshgebbeken_nycschools.data.implementations

import com.example.a20230715_joshgebbeken_nycschools.data.model.SchoolSatDto
import com.example.a20230715_joshgebbeken_nycschools.data.model.convertToSchool
import com.example.a20230715_joshgebbeken_nycschools.data.model.convertToSchoolSat
import com.example.a20230715_joshgebbeken_nycschools.data.repositories.SchoolApiService
import com.example.a20230715_joshgebbeken_nycschools.data.repositories.SchoolRepository
import com.example.a20230715_joshgebbeken_nycschools.data.utils.mapErrors
import com.example.a20230715_joshgebbeken_nycschools.domain.models.School
import com.example.a20230715_joshgebbeken_nycschools.domain.models.SchoolSat
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class SchoolRepositoryImplementation: SchoolRepository, KoinComponent {
    // DI
    private val schoolApiService: SchoolApiService by inject()

    override suspend fun getSchoolsData(): Result<List<School>> =
        schoolApiService.getSchools().map { schoolDtos ->
            schoolDtos.map { schoolDtoItem -> schoolDtoItem.convertToSchool() }
        }.mapErrors()


    override suspend fun getSchoolsSatData(): Result<List<SchoolSat>>  =
        schoolApiService.getSchoolSat().map { schoolSatDtos ->
            schoolSatDtos.map { schoolSatDto -> schoolSatDto.convertToSchoolSat() }
        }

}