package com.example.a20230715_joshgebbeken_nycschools.data.repositories

import com.example.a20230715_joshgebbeken_nycschools.data.model.SchoolDtoItem
import com.example.a20230715_joshgebbeken_nycschools.data.model.SchoolSatDto
import com.example.a20230715_joshgebbeken_nycschools.domain.models.SchoolSat
import retrofit2.http.GET

interface SchoolApiService {
    @GET("s3k6-pzi2.json")
    suspend fun getSchools(): Result<List<SchoolDtoItem>>

    @GET("f9bf-2cp4.json")
    suspend fun getSchoolSat(): Result<List<SchoolSatDto>>
}