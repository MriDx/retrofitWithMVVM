package com.example.retrofitwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithmvvm.data.UserData
import com.example.retrofitwithmvvm.databinding.ActivityMainBinding
import com.example.retrofitwithmvvm.databinding.UserViewBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var userList = arrayListOf<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.userListHolder.apply {
            itemBuilder = { parent, index ->
                UserViewBinding.inflate(LayoutInflater.from(this@MainActivity), parent, false).root
            }
            itemBinding { holder, index ->
                UserViewBinding.bind(holder.itemView).apply {
                    userList[index]
                }
            }
            layoutManager = LinearLayoutManager(this@MainActivity).apply {
                orientation = RecyclerView.VERTICAL
            }
        }




    }
}