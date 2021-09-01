package com.antmoney.kmm_services.network

import AvailableCoursesQuery
import CourseByIdQuery
import com.antmoney.kmm_services.network.models.Course


object CourseService {

    suspend fun courses(): List<Course> {
        val data = API.apolloClient.query(
            AvailableCoursesQuery(null, null, 1000)
        ).dataOrThrow

        return data.availableCourses?.edges?.mapNotNull {
            it?.node?.fragments?.courseFragment
        }?.map {
            Course(it)
        } ?: emptyList()
    }

    suspend fun courseById(id: String): Course {
        val data = API.apolloClient.query(
            CourseByIdQuery(id)
        ).dataOrThrow

        data.course?.fragments?.courseFragment?.let {
            return Course(it)
        }

        throw Exception("Course Not Found, ID: $id")
    }
}
