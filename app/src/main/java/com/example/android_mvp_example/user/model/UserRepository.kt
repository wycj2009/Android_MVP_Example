package com.example.android_mvp_example.user.model

import javax.inject.Inject
import kotlin.random.Random

class UserRepository @Inject constructor() {
    private val allUsers: MutableList<User> = mutableListOf()

    fun addNewUser(callback: (users: List<User>) -> Unit) {
        allUsers.add(
            User(id = allUsers.size, name = generateRandomName())
        )

        callback(allUsers)
    }

    private fun generateRandomName(): String {
        return buildString {
            repeat(3) {
                append(Random.nextInt('a'.code, 'z'.code + 1).toChar())
            }
        }
    }
}
