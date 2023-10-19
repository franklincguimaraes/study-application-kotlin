package io.blufr.studyapplication.models

import io.blufr.studyapplication.utils.enums.UserRoleEnum
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType
import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import java.util.UUID

@Entity(name = "users")
@Getter
@Setter
@Convert(attributeName = "enum_type", converter = PostgreSQLEnumType::class)
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID? = null,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val email: String,

        @Column(nullable = false)
        val password: String,

        @Column(nullable = false)
        val role: UserRoleEnum
)