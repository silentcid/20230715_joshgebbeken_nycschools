package com.example.a20230715_joshgebbeken_nycschools.data.network

import com.example.a20230715_joshgebbeken_nycschools.data.repositories.SchoolApiService

class SchoolServiceFactory: ServiceFactory() {
    override val baseUrl: String = "https://data.cityofnewyork.us/resource/"

    internal fun produce(): SchoolApiService = retrofit.create(SchoolApiService::class.java)
}