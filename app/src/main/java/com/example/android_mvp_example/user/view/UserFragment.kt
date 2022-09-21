package com.example.android_mvp_example.user.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_mvp_example.databinding.FragmentUserBinding
import com.example.android_mvp_example.user.model.User
import com.example.android_mvp_example.user.presenter.UserContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserFragment : Fragment(), UserContract.View {
    private lateinit var binding: FragmentUserBinding

    @Inject lateinit var presenter: UserContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUserBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addUser.setOnClickListener {
            presenter.addUser()
        }
    }

    override fun showAllUsers(allUsers: List<User>) {
        binding.userList.text = buildString {
            allUsers.forEach {
                append("${it}\n")
            }
        }
    }
}
