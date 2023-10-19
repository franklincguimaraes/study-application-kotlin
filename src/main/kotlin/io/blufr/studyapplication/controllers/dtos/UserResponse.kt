package io.blufr.studyapplication.controllers.dtos

import io.blufr.studyapplication.models.User
import java.util.*

data class UserResponse(
        val id: UUID?
)

fun User.toResponse() = UserResponse(
        id = id
)
