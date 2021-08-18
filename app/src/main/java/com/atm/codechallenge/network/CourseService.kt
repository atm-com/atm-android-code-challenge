package com.atm.codechallenge.network

import com.apollographql.apollo.coroutines.await
import com.atm.codechallenge.AvailableCoursesQuery
import com.atm.codechallenge.CourseByIdQuery
import com.atm.codechallenge.network.models.Course

object CourseService {

    suspend fun courses(): List<Course> {
        val response = API.apolloClient.query(
            AvailableCoursesQuery.builder()
                .first(1000)
                .build()
        ).await()

        return response.data?.availableCourses()?.edges()?.mapNotNull {
            it.node()?.fragments()?.courseFragment()
        }?.map {
            Course(it)
        } ?: emptyList()
    }

    suspend fun courseById(id: String): Course {
        val response = API.apolloClient.query(
            CourseByIdQuery.builder()
                .id(id)
                .build()
        ).await()

        response.data?.course()?.fragments()?.courseFragment()?.let {
            return Course(it)
        }

        throw Exception("Course Not Found, ID: $id")
    }
}