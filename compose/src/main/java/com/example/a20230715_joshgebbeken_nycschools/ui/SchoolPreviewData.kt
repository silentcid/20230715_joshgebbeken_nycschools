package com.example.a20230715_joshgebbeken_nycschools.ui

import androidx.compose.runtime.mutableStateOf
import com.example.a20230715_joshgebbeken_nycschools.domain.models.School
import com.example.a20230715_joshgebbeken_nycschools.domain.models.SchoolSat
import com.example.a20230715_joshgebbeken_nycschools.domain.models.UserFacingError

object SchoolPreviewData {
    fun getFakeSchoolList() = listOf(getFakeSchool())
    
    private fun getFakeSchool() = School(
        dbn = "DBN1",
        schoolName = "School 1",
        boro = "Boro 1",
        overviewParagraph = "This is a school",
        academicOpportunities1 = "Academic Opportunity 1",
        academicOpportunities2 = "Academic Opportunity 2",
        ellPrograms = "ELL Programs",
        neighborhood = "Neighborhood",
        buildingCode = "Building Code",
        location = "Location",
        phoneNumber = "1234567890",
        faxNumber = "0987654321",
        schoolEmail = "school1@test.com",
        website = "www.test.com",
        subway = "Subway",
        bus = "Bus",
        grades2018 = "Grades 2018",
        finalGrades = "Final Grades",
        totalStudents = "1000",
        extracurricularActivities = "Extracurricular Activities",
        schoolSports = "School Sports",
        attendanceRate = "90%",
        primary_address_line_1 = "Primary Address Line 1",
        city = "City",
        zip = "Zip",
        latitude = "Latitude",
        longitude = "Longitude",
        bin = "Bin",
        bbl = "BBL",
        nta = "NTA",
        borough = "Borough",
        stateCode = "stateCode",
        communityBoard = "CommunityBoard",
        councilDistrict = "CouncilDistrict",
        censusTract = "censusTract",
    )
    private val fakeSchoolSat = SchoolSat(
        dbn = "MSM2S",
        schoolName = "school name",
        numOfSatTestTakers = "22",
        satCriticalReadingAvgScore = "88",
        satMathAvgScore = "86",
        satWritingAvgScore = "90"
    )

    val schoolPreviewState = SchoolScreenState(
        schoolList = mutableStateOf(getFakeSchoolList()),
        schoolSat = mutableStateOf(fakeSchoolSat),
        schoolError = mutableStateOf(UserFacingError.NoError),
        resetError = {},
        shouldNavigate = mutableStateOf(false),
        shouldResetNavigate = { },
        onSchoolClicked = { },

    )
}

object SchoolSatScoresPreviewData {
    fun satScorePreviewData() =
        SchoolSat(
            dbn = "sdasd11",
            schoolName = "schoolName",
            numOfSatTestTakers = "22",
            satCriticalReadingAvgScore = "88",
            satMathAvgScore = "87",
            satWritingAvgScore = "88",
            )
}