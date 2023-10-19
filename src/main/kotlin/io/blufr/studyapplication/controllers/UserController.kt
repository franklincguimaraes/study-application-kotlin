package io.blufr.studyapplication.controllers

import io.blufr.studyapplication.controllers.dtos.UserRequest
import io.blufr.studyapplication.controllers.dtos.UserResponse
import io.blufr.studyapplication.controllers.dtos.toEntity
import io.blufr.studyapplication.controllers.dtos.toResponse
import io.blufr.studyapplication.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class UserController(
        private val userService: UserService
) {
    @PostMapping("/register")
    fun register(
            @RequestBody userRequest: UserRequest
    ): ResponseEntity<UserResponse> {
        val user = userService.save(userRequest.toEntity())
        return ResponseEntity.ok(user.toResponse())
    }
}