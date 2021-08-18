package com.atm.codechallenge.network.models

import com.atm.codechallenge.fragment.CourseFragment
import com.atm.codechallenge.type.AvailabilityStatusEnum
import com.atm.codechallenge.type.RewardTypeEnum

data class Course(
    val id: String,
    val title: String?,
    val description: String?,
    val bannerImageUrl: String?,
    val previewImageUrl: String?,
    val rewardAmount: String,
    val rewardType: RewardTypeEnum,
    val status: AvailabilityStatusEnum
) {
    constructor(data: CourseFragment) : this(
        data.id(),
        data.title(),
        data.description(),
        data.bannerImageUrl(),
        data.previewImageUrl(),
        data.rewardAmount() ?: "0",
        data.rewardType() ?: RewardTypeEnum.USD,
        data.status()
    )

    override fun toString(): String {
        return "Course(id='$id', title=$title, description=$description, bannerImageUrl=$bannerImageUrl, previewImageUrl=$previewImageUrl, rewardAmount='$rewardAmount', rewardType=$rewardType, status=$status)"
    }


}