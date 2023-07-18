package com.example.a20230715_joshgebbeken_nycschools.domain.models

data class SchoolSat(
    val dbn: String?,
    val schoolName: String?,
    val numOfSatTestTakers: String?,
    val satCriticalReadingAvgScore: String?,
    val satMathAvgScore: String?,
    val satWritingAvgScore: String?,
)

fun schoolEmptySat() = SchoolSat(
    dbn = "", schoolName = "", numOfSatTestTakers = "",
    satCriticalReadingAvgScore = "", satMathAvgScore = "", satWritingAvgScore = ""
)
