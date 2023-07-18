package com.example.a20230715_joshgebbeken_nycschools.data.repositories

import com.example.a20230715_joshgebbeken_nycschools.domain.models.School
import com.example.a20230715_joshgebbeken_nycschools.domain.models.SchoolSat

interface SchoolRepository {
    suspend fun getSchoolsData(): Result<List<School>>
    suspend fun getSchoolsSatData(): Result<List<SchoolSat>>
}