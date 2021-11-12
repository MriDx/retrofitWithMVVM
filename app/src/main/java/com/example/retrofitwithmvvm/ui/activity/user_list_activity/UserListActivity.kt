package com.example.retrofitwithmvvm.ui.activity.user_list_activity

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithmvvm.data.UserData
import com.example.retrofitwithmvvm.databinding.UserListActivityBinding
import com.example.retrofitwithmvvm.databinding.UserViewBinding
import com.example.retrofitwithmvvm.network.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListActivity : AppCompatActivity() {

    private lateinit var binding: UserListActivityBinding

    private var userList = arrayListOf<UserData>()

    private val viewModel by viewModels<UserListActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = UserListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /**
         * todo check diffutil
        val itemCallback = object :DiffUtil.ItemCallback<UserData>() {
        override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        TODO("Not yet implemented")
        }

        }
         */


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

        viewModel.response.observe(this) {
            when (it.status) {
                Status.ERROR -> {
                    Toast.makeText(this, "Some error !", Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    if (userList.size > 0) {
                        userList.addAll(it.data!!)
                        binding.userListHolder.addMoreItems(it.data.size)
                    } else {
                        userList.addAll(it.data!!)
                        binding.userListHolder.apply {
                            setItemCount(it.data.size)
                        }.render()
                    }

                }
                Status.LOADING -> {

                }
            }
        }


    }

}