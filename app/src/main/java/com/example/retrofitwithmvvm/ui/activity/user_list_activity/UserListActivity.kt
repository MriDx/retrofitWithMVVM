package com.example.retrofitwithmvvm.ui.activity.user_list_activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithmvvm.data.UserData
import com.example.retrofitwithmvvm.databinding.UserListActivityBinding
import com.example.retrofitwithmvvm.databinding.UserViewBinding

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: UserListActivityBinding

    private var userList = arrayListOf<UserData>()

    private lateinit var viewModel: UserListActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = UserListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.userListHolder.apply {
            itemBuilder = { parent, index ->
                UserViewBinding.inflate(
                    LayoutInflater.from(this@UserListActivity),
                    parent,
                    false
                ).root
            }
            itemBinding { holder, index ->
                UserViewBinding.bind(holder.itemView).apply {
                    userNameView.text = userList[index].name
                }
            }
            layoutManager = LinearLayoutManager(this@UserListActivity).apply {
                orientation = RecyclerView.VERTICAL
            }
        }


    }

}