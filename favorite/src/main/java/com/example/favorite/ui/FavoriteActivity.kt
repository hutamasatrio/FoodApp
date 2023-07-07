package com.example.favorite.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.ui.FavoriteRecyclerAdapterDiffUtil
import com.example.favorite.databinding.ActivityFavoriteBinding
import com.example.favorite.di.favoriteModule
import com.example.foodapp.ui.detail.DetailFoodActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFavoriteBinding
    private val favoriteVM : FavoriteVM by viewModel()
    private lateinit var favoriteAdapter : FavoriteRecyclerAdapterDiffUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(favoriteModule)


        setData()
        setRV()
        vm()
    }

    private fun setData() {
        favoriteAdapter = FavoriteRecyclerAdapterDiffUtil{ selectedData ->
            val intent = Intent(this, DetailFoodActivity::class.java)
            intent.putExtra("IDCategoryFav", selectedData)
            startActivity(intent)

        }

    }

    private fun vm() {
        favoriteVM.getFavoriteMeals.observe(this,{
            favoriteAdapter.differ.submitList(it)
        })

    }

    private fun setRV() {
        val rvFavorite = binding.rvFavorite
        rvFavorite.layoutManager = GridLayoutManager(this, 2)
        rvFavorite.setHasFixedSize(true)
        rvFavorite.adapter = favoriteAdapter

    }
}