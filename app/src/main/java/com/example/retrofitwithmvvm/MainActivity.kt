package com.example.retrofitwithmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithmvvm.data.UserData
import com.example.retrofitwithmvvm.databinding.ActivityMainBinding
import com.example.retrofitwithmvvm.databinding.UserViewBinding
import com.example.retrofitwithmvvm.ui.activity.posts_activity.PostsActivity
import com.example.retrofitwithmvvm.ui.activity.user_list_activity.UserListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var userList = arrayListOf<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userListBtn.setOnClickListener {
            startActivity(Intent(this, UserListActivity::class.java))
        }
        binding.postListBtn.setOnClickListener {
            startActivity(Intent(this, PostsActivity::class.java))
        }


    }
}