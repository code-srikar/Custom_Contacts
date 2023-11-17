package com.srikar.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.srikar.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(R.drawable.profile,R.drawable.genprofile,R.drawable.genprofile,R.drawable.genprofile,R.drawable.genprofile,R.drawable.genprofile,R.drawable.genprofile,R.drawable.genprofile,R.drawable.genprofile)
        val names = arrayOf("Srikar","Sathvik","Dharahas","Namruth","Srujan","Aditya","Avinash","Ajay","Nobita")
        val numbers = arrayOf("9999999999","9999999999","9999999999","9999999999","9999999999","9999999999","9999999999","9999999999","9999999999")
        val country = arrayOf("India","India","India","India","India","India","India","India","India")
        val lastMsg = arrayOf("Hi, How are you?","I'm good","Super","Nice","Hello","Good Night","See ya later","All the Best","MorninG")
        val lastTime = arrayOf("00.00 A.M.","07.00 A.M.","08.00 A.M.","00.45 A.M.","00.30 A.M.","00.01 A.M.","01.30 A.M.","02.00 A.M.","00.30 A.M.",)

        userArrayList = ArrayList()

        for(i in names.indices){

            val user = User(names[i],numbers[i],lastMsg[i],lastTime[i],country[i],imageId[i])
            userArrayList.add(user)

        }

        binding.list.isClickable = true
        binding.list.setOnItemClickListener { parent, view, position, id ->

            val name = names[position]
            val number = numbers[position]
            val country = country[position]
            val image = imageId[position]

            val intent = Intent(this,UserActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("number",number)
            intent.putExtra("country",country)
            intent.putExtra("image",image)
            startActivity(intent)

        }

        binding.list.adapter = MyAdapter(this,userArrayList)

    }
}