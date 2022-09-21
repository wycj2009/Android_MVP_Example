package com.example.android_mvp_example.user.presenter

import com.example.android_mvp_example.user.model.User
import com.example.android_mvp_example.user.model.UserRepository
import javax.inject.Inject

class UserContract {

    interface View {
        fun showAllUsers(allUsers: List<User>)
    }

    interface Presenter {
        fun addUser()
    }

    class PresenterImpl @Inject constructor(
        private val userRepository: UserRepository,
        private val view: View
    ) : Presenter {

        override fun addUser() {
            userRepository.addNewUser(callback = { users -> view.showAllUsers(users) })
        }
    }
}
