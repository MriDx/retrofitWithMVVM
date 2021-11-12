package com.example.retrofitwithmvvm.ui.activity.posts_activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithmvvm.data.PostData
import com.example.retrofitwithmvvm.databinding.UserListActivityBinding
import com.example.retrofitwithmvvm.databinding.UserViewBinding
import com.example.retrofitwithmvvm.network.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Error

@AndroidEntryPoint
class PostsActivity : AppCompatActivity() {

    private lateinit var binding: UserListActivityBinding

    private val viewModel by viewModels<PostsActivityViewModel>()

    private var postsList = arrayListOf<PostData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.response.observe(this) {
            when (it.status) {
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
                Status.SUCCESS -> {
                    if (postsList.size > 0) {
                        postsList.addAll(it.data!!)
                        binding.userListHolder.addMoreItems(it.data.size)
                        return@observe
                    }
                    postsList.addAll(it.data!!)
                    binding.userListHolder.apply {
                        setItemCount(it.data.size)
                    }.render()
                }
            }
        }

        binding.userListHolder.apply {
            itemBuilder = { parent, index ->
                UserViewBinding.inflate(
                    LayoutInflater.from(this@PostsActivity),
                    parent,
                    false
                ).root
            }
            itemBinding { holder, index ->
                UserViewBinding.bind(holder.itemView).apply {
                    userNameView.text = postsList[index].title
                }
            }
            layoutManager = LinearLayoutManager(this@PostsActivity).apply {
                orientation = RecyclerView.VERTICAL
            }
        }


    }

}