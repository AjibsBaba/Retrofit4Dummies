package com.ajibsbaba.retrofit4dummies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajibsbaba.retrofit4dummies.adapter.MyAdapter
import com.ajibsbaba.retrofit4dummies.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel =  ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCustomPosts(2, "id", "desc")
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }

        })


    }


    private fun setupRecyclerView(){
        recyclerview.adapter = myAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}