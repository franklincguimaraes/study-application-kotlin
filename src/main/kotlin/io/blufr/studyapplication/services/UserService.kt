package io.blufr.studyapplication.services

import io.blufr.studyapplication.models.User
import io.blufr.studyapplication.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun deleteUserById(id: UUID) {
        userRepository.deleteById(id)
    }
}