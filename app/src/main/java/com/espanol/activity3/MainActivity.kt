package com.espanol.activity3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.espanol.activity3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        var name = ""
        var subject = ""
        var content = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)

        val emailList = ArrayList<ItemsViewModel>()

        for (i in 1..20) {
            emailList.add(ItemsViewModel(randomName(), randomSubject(), randomContent()))
        }

        val adapter = EmailAdapter(emailList, this@MainActivity)
        recyclerView.adapter = adapter
    }
    private fun randomName(): String {
        val name = arrayOf("Satoro Gojo", "Monkey D. Luffy")
        return name.random()
    }
    private fun randomSubject(): String {
        val subject = arrayOf("Inquiring for the HRIS Pricing", "Application for React Native Developer")
        return subject.random()
    }
    private fun randomContent(): String {
        val content = arrayOf("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "Hi, my name is Satoro Gojo, and I would like to introduce myself as a developer.", "Hi, my name is Monkey D. Luffy, and I would like to introduce myself as a developer.")
        return content.random()
    }
}