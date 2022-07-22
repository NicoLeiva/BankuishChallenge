package com.example.bankuishchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankuishchallenge.databinding.ActivityMainBinding
import com.example.bankuishchallenge.ui.RecyclerViewAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //createView()
        //initViewModel()
        setContentView(binding.root)
    }

    /*private fun createView(){
        recyclerViewAdapter = RecyclerViewAdapter { data -> showCharacterDetails() }
        binding.recyclerView.apply {
            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }
    }

    private fun initViewModel() {
        lifecycleScope.launchWhenCreated {
            viewModel.getAllRepositoriesByLanguage().collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    private fun showCharacterDetails() {

    }

     */
}