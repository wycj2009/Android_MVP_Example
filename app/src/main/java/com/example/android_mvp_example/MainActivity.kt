package com.example.android_mvp_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_mvp_example.databinding.ActivityMainBinding
import com.example.android_mvp_example.user.view.UserFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(binding.frame.id, UserFragment()).commit()
    }
}
