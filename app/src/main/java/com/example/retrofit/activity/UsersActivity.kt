package com.example.retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.databinding.ActivityUsersBinding

class UsersActivity : AppCompatActivity() {
    lateinit var  binding : ActivityUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}