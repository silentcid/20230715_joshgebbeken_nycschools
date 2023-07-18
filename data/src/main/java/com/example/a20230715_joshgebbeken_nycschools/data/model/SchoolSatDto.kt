package com.example.a20230715_joshgebbeken_nycschools.data.model

import com.example.a20230715_joshgebbeken_nycschools.domain.models.SchoolSat
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SchoolSatDto(
    @Json(name = "dbn")
    val dbn: String?,
    @Json(name = "school_name")
    val schoolName: String,
    @Json(name = "num_of_sat_test_takers")
    val numOfSatTestTakers: String,
    @Json(name = "sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String,
    @Json(name = "sat_math_avg_score")
    val satMathAvgScore: String,
    @Json(name = "sat_writing_avg_score")
    val satWritingAvgScore: String,
)

fun SchoolSatDto.convertToSchoolSat() = SchoolSat (
    dbn = dbn,
    schoolName = schoolName,
    numOfSatTestTakers = numOfSatTestTakers,
    satCriticalReadingAvgScore = satCriticalReadingAvgScore,
    satMathAvgScore = satMathAvgScore,
    satWritingAvgScore = satWritingAvgScore,
)
