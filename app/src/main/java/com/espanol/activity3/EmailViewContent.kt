package com.espanol.activity3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.espanol.activity3.databinding.ActivityEmailViewContentBinding
import com.espanol.activity3.databinding.ActivityMainBinding

class EmailViewContent : AppCompatActivity() {

    private lateinit var binding: ActivityEmailViewContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailViewContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.emailViewSender.text = MainActivity.name
        binding.emailViewSubject.text = MainActivity.subject
        binding.emailViewContent.text = MainActivity.content
    }
}