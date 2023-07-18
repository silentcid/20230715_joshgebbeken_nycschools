package com.example.a20230715_joshgebbeken_nycschools.data.utils

import com.example.a20230715_joshgebbeken_nycschools.data.model.SchoolDtoItem
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import java.lang.UnsupportedOperationException

class SchoolDtoItemJsonAdapter : JsonAdapter<SchoolDtoItem>() {

    @FromJson
    override fun fromJson(reader: JsonReader): SchoolDtoItem {
        var dbn = ""
        var schoolName = ""
        var boro = ""
        var overviewParagraph = ""
        var school10thSeats = ""
        var academicOpportunities1 = ""
        var academicOpportunities2 = ""
        var ellPrograms = ""
        var neighborhood = ""
        var buildingCode = ""
        var location = ""
        var phoneNumber = ""
        var faxNumber = ""
        var schoolEmail = ""
        var website = ""
        var subway = ""
        var bus = ""
        var grades2018 = ""
        var finalGrades = ""
        var totalStudents = ""
        var extracurricularActivities = ""
        var schoolSports = ""
        var attendanceRate = ""
        var pctStuEnoughVariety = ""
        var pctStuSafe = ""
        var schoolAccessibilityDescription = ""
        var directions1 = ""
        var requirement1_1 = ""
        var requirement2_1 = ""
        var requirement3_1 = ""
        var requirement4_1 = ""
        var requirement5_1 = ""
        var offerRate1 = ""
        var program1 = ""
        var code1 = ""
        var interest1 = ""
        var method1 = ""
        var seats9ge1 = ""
        var grade9geFilledFlag1 = ""
        var grade9geApplicants1 = ""
        var seats9swd1 = ""
        var grade9swdFilledFlag1 = ""
        var grade9swdApplicants1 = ""
        var seats101 = ""
        var eligibility1 = ""
        var grade9geApplicantsPerSeat1 = ""
        var grade9swdApplicantsPerSeat1 = ""
        var primaryAddressLine1 = ""
        var city = ""
        var zip = ""
        var stateCode = ""
        var latitude = ""
        var longitude = ""
        var communityBoard = ""
        var councilDistrict = ""
        var censusTract = ""
        var bin = ""
        var bbl = ""
        var nta = ""
        var borough = ""

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "dbn" -> dbn = reader.nextString()
                "school_name" -> schoolName = reader.nextString()
                "boro" -> boro = reader.nextString()
                "overview_paragraph" -> overviewParagraph = reader.nextString()
                "school_10th_seats" -> school10thSeats = reader.nextString()
                "academicopportunities1" -> academicOpportunities1 = reader.nextString()
                "academicopportunities2" -> academicOpportunities2 = reader.nextString()
                "ell_programs" -> ellPrograms = reader.nextString()
                "neighborhood" -> neighborhood = reader.nextString()
                "building_code" -> buildingCode = reader.nextString()
                "location" -> location = reader.nextString()
                "phone_number" -> phoneNumber = reader.nextString()
                "fax_number" -> faxNumber = reader.nextString()
                "school_email" -> schoolEmail = reader.nextString()
                "website" -> website = reader.nextString()
                "subway" -> subway = reader.nextString()
                "bus" -> bus = reader.nextString()
                "grades2018" -> grades2018 = reader.nextString()
                "finalgrades" -> finalGrades = reader.nextString()
                "total_students" -> totalStudents = reader.nextString()
                "extracurricular_activities" -> extracurricularActivities = reader.nextString()
                "school_sports" -> schoolSports = reader.nextString()
                "attendance_rate" -> attendanceRate = reader.nextString()
                "pct_stu_enough_variety" -> pctStuEnoughVariety = reader.nextString()
                "pct_stu_safe" -> pctStuSafe = reader.nextString()
                "school_accessibility_description" -> schoolAccessibilityDescription = reader.nextString()
                "directions1" -> directions1 = reader.nextString()
                "requirement1_1" -> requirement1_1 = reader.nextString()
                "requirement2_1" -> requirement2_1 = reader.nextString()
                "requirement3_1" -> requirement3_1 = reader.nextString()
                "requirement4_1" -> requirement4_1 = reader.nextString()
                "requirement5_1" -> requirement5_1 = reader.nextString()
                "offer_rate1" -> offerRate1 = reader.nextString()
                "program1" -> program1 = reader.nextString()
                "code1" -> code1 = reader.nextString()
                "interest1" -> interest1 = reader.nextString()
                "method1" -> method1 = reader.nextString()
                "seats9ge1" -> seats9ge1 = reader.nextString()
                "grade9gefilledflag1" -> grade9geFilledFlag1 = reader.nextString()
                "grade9geapplicants1" -> grade9geApplicants1 = reader.nextString()
                "seats9swd1" -> seats9swd1 = reader.nextString()
                "grade9swdfilledflag1" -> grade9swdFilledFlag1 = reader.nextString()
                "grade9swdapplicants1" -> grade9swdApplicants1 = reader.nextString()
                "seats101" -> seats101 = reader.nextString()
                "eligibility1" -> eligibility1 = reader.nextString()
                "grade9geapplicantsperseat1" -> grade9geApplicantsPerSeat1 = reader.nextString()
                "grade9swdapplicantsperseat1" -> grade9swdApplicantsPerSeat1 = reader.nextString()
                "primary_address_line_1" -> primaryAddressLine1 = reader.nextString()
                "city" -> city = reader.nextString()
                "zip" -> zip = reader.nextString()
                "state_code" -> stateCode = reader.nextString()
                "latitude" -> latitude = reader.nextString()
                "longitude" -> longitude = reader.nextString()
                "community_board" -> communityBoard = reader.nextString()
                "council_district" -> councilDistrict = reader.nextString()
                "census_tract" -> censusTract = reader.nextString()
                "bin" -> bin = reader.nextString()
                "bbl" -> bbl = reader.nextString()
                "nta" -> nta = reader.nextString()
                "borough" -> borough = reader.nextString()
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        return SchoolDtoItem(
            dbn,
            schoolName,
            boro,
            overviewParagraph,
            school10thSeats,
            academicOpportunities1,
            academicOpportunities2,
            ellPrograms,
            neighborhood,
            buildingCode,
            location,
            phoneNumber,
            faxNumber,
            schoolEmail,
            website,
            subway,
            bus,
            grades2018,
            finalGrades,
            totalStudents,
            extracurricularActivities,
            schoolSports,
            attendanceRate,
            pctStuEnoughVariety,
            pctStuSafe,
            schoolAccessibilityDescription,
            directions1,
            requirement1_1,
            requirement2_1,
            requirement3_1,
            requirement4_1,
            requirement5_1,
            offerRate1,
            program1,
            code1,
            interest1,
            method1,
            seats9ge1,
            grade9geFilledFlag1,
            grade9geApplicants1,
            seats9swd1,
            grade9swdFilledFlag1,
            grade9swdApplicants1,
            seats101,
            eligibility1,
            grade9geApplicantsPerSeat1,
            grade9swdApplicantsPerSeat1,
            primaryAddressLine1,
            city,
            zip,
            stateCode,
            latitude,
            longitude,
            communityBoard,
            councilDistrict,
            censusTract,
            bin,
            bbl,
            nta,
            borough,
        )
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: SchoolDtoItem?) {
        // Implement this method if you need to serialize SchoolDtoItem to JSON
        throw UnsupportedOperationException("Serialization is not supported")
    }
}
