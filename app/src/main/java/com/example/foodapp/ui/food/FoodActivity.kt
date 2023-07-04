package com.example.foodapp.ui.food

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.domain.model.Category
import com.example.core.source.db.remote.Resource
import com.example.core.ui.FoodRecyclerAdapter
import com.example.foodapp.databinding.ActivityFoodBinding
import com.example.foodapp.ui.detail.DetailFoodActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class FoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodBinding
    private val foodVM: FoodVM by viewModel()
    lateinit var categoryName: String
    private val foodAdapter = FoodRecyclerAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getParcelableExtra<Category>("IDCategory")

        if (category != null) {
            this.categoryName = category.strCategory
            foodVM.getId(categoryName)

        }

        setRV()
        vm()
        setData()


    }

    private fun vm() {
        foodVM.set().observe(this, { food ->
            if (food != null) {
                when (food) {
                    is Resource.Error -> Log.e("error", "error")
                    is Resource.Loading -> binding.progressFood.visibility = View.VISIBLE
                    is Resource.Success -> food.data?.let {
                        binding.progressFood.visibility = View.GONE
                        foodAdapter.setData(it)

                    }
                }
            }

        })
    }

    private fun setRV() {
        val rvFood = binding.rvFood
        rvFood.layoutManager = GridLayoutManager(this, 2)
        rvFood.setHasFixedSize(true)
        rvFood.adapter = foodAdapter

    }

    private fun setData() {
        foodAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@FoodActivity, DetailFoodActivity::class.java)
            intent.putExtra("IDCategory", selectedData)
            startActivity(intent)

        }
    }


}
