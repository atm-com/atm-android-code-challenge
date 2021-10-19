package com.antmoney.kmm_services.network.models

import fragment.CourseFragment
import type.AvailabilityStatusEnum
import type.RewardTypeEnum

data class Course(
    val id: String,
    val title: String?,
    val description: String?,
    val bannerImageUrl: String?,
    val previewImageUrl: String?,
    val rewardAmount: String
) {
    constructor(data: CourseFragment) : this(
        data.id,
        data.title,
        data.description,
        data.bannerImageUrl,
        data.previewImageUrl,
        data.rewardAmount ?: "0"
    )

    override fun toString(): String {
        return "Course(id='$id', title=$title, description=$description, bannerImageUrl=$bannerImageUrl, previewImageUrl=$previewImageUrl, rewardAmount='$rewardAmount')"
    }
}
