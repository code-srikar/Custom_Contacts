package com.srikar.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.srikar.contacts.databinding.ActivityMainBinding
import com.srikar.contacts.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        val country = intent.getStringExtra("country")
        val image = intent.getIntExtra("image",R.drawable.profile)

        binding.name.text = name
        binding.number.text = number
        binding.country.text = country
        binding.image.setImageResource(image)

    }
}