package io.blufr.studyapplication.services

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import io.blufr.studyapplication.models.User
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenService {

    private val secret: String = "secret"

    fun genenerateToken(user: User): String {
        try {
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            return JWT.create()
                    .withIssuer("study")
                    .withSubject(user.email)
                    .withExpiresAt(expireToken())
                    .sign(algorithm)
        } catch (e : JWTCreationException) {
            throw RuntimeException("Error to generate token", e)
        }
    }

    fun validateToken(token: String): Boolean {
        try {
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            val verifier = JWT.require(algorithm)
                    .withIssuer("study")
                    .build()
            verifier.verify(token)
            return true
        } catch (e : JWTCreationException) {
            throw RuntimeException("Error to validate token", e)
        }
    }

    fun expireToken() : Instant {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"))
    }
}