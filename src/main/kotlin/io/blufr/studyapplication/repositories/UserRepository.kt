package io.blufr.studyapplication.repositories

import io.blufr.studyapplication.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<User, UUID> {
    fun findByEmail(email: String): User?

    fun save(user: User): User

    fun deleteUserById(id: UUID)
}