package com.srikar.contacts

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context: Activity,private val arrayList:ArrayList<User>) : ArrayAdapter<User>(context,android.R.layout.simple_list_item_1,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.listitem,null)

        val imageView: ImageView = view.findViewById(R.id.profilePic)
        val profileName: TextView = view.findViewById(R.id.profileName)
        val lastMsg: TextView = view.findViewById(R.id.lastMsg)
        val lastTime: TextView = view.findViewById(R.id.lastTime)

        imageView.setImageResource(arrayList[position].image)
        profileName.text = arrayList[position].name
        lastMsg.text = arrayList[position].lastMsg
        lastTime.text = arrayList[position].lastTime

        return view
    }

}