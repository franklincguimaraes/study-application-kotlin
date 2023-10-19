package io.blufr.studyapplication.controllers.dtos

import io.blufr.studyapplication.models.User
import io.blufr.studyapplication.utils.enums.UserRoleEnum


data class UserRequest (val name: String, val email: String, val password: String, val role: UserRoleEnum)

fun UserRequest.toEntity() = User(
        name = name, email = email, password = password, role = role
)

