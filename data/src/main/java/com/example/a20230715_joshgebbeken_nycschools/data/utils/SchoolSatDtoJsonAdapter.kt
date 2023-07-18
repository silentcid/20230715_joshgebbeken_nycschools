package com.example.a20230715_joshgebbeken_nycschools.data.utils

import com.example.a20230715_joshgebbeken_nycschools.data.model.SchoolSatDto
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import java.lang.UnsupportedOperationException

class SchoolSatDtoJsonAdapter : JsonAdapter<SchoolSatDto>() {

    @FromJson
    override fun fromJson(reader: JsonReader): SchoolSatDto {
        var dbn = ""
        var schoolName = ""
        var numOfSatTestTakers = ""
        var satCriticalReadingAvgScore = ""
        var satMathAvgScore = ""
        var satWritingAvgScore = ""

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "dbn" -> dbn = reader.nextString()
                "school_name" -> schoolName = reader.nextString()
                "num_of_sat_test_takers" -> numOfSatTestTakers = reader.nextString()
                "sat_critical_reading_avg_score" -> satCriticalReadingAvgScore = reader.nextString()
                "sat_math_avg_score" -> satMathAvgScore = reader.nextString()
                "sat_writing_avg_score" -> satWritingAvgScore = reader.nextString()
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        return SchoolSatDto(
            dbn,
            schoolName,
            numOfSatTestTakers,
            satCriticalReadingAvgScore,
            satMathAvgScore,
            satWritingAvgScore,
        )
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: SchoolSatDto?) {
        throw UnsupportedOperationException("Serialization is not supported")
    }
}