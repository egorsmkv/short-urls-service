package com.egorsmkv.short_urls_service.database.factories

import com.egorsmkv.short_urls_service.entities.User
import com.egorsmkv.short_urls_service.entities.Users
import dev.alpas.hashing.Hasher
import dev.alpas.ozone.EntityFactory
import dev.alpas.ozone.faker
import java.time.Instant

internal class UserFactory(private val hasher: Hasher) : EntityFactory<User>() {
    override val table = Users

    override fun entity(): User {
        return User {
            email = faker.internet().safeEmailAddress()
            password = hasher.hash("secret")
            name = faker.name().name()
            updatedAt = Instant.now()
            createdAt = Instant.now()
        }
    }

    override fun transform(name: String, value: Any?): Any? {
        return if (name == "password") {
            hasher.hash(value.toString())
        } else {
            value
        }
    }
}
