package com.example.favorite.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ui.FavoriteRecyclerAdapter
import com.example.favorite.R
import com.example.favorite.databinding.ActivityFavoriteBinding
import com.example.foodapp.ui.detail.DetailFoodActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFavoriteBinding
    private val favoriteVM : FavoriteVM by viewModel()
    private lateinit var favoriteAdapter : FavoriteRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRV()
        vm()
        setData()
    }

    private fun setData() {
        favoriteAdapter.onItemClick = {selectedData ->
            val intent = Intent(this, DetailFoodActivity::class.java)
            intent.putExtra("IDCategory", selectedData)
            startActivity(intent)

        }

    }

    private fun vm() {
        favoriteVM.getFavoriteMeals.observe(this, Observer {
            favoriteAdapter.setData(it)
        })
    }

    private fun setRV() {
        val rvFavorite = binding.rvFavorite
        rvFavorite.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvFavorite.setHasFixedSize(true)
        rvFavorite.adapter = favoriteAdapter

    }
}