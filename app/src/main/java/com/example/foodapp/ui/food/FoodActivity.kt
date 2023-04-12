package com.example.foodapp.ui.food

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.domain.model.Category
import com.example.core.domain.model.Food
import com.example.core.source.db.remote.Resource
import com.example.core.ui.FoodRecyclerAdapter
import com.example.foodapp.databinding.ActivityFoodBinding
import kotlinx.android.synthetic.main.activity_food.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class FoodActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFoodBinding
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
        foodVM.set().observe(this,{food ->
            if (food != null){
                when(food){
                    is Resource.Error -> tesData(food.data)
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
        rvFood.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvFood.setHasFixedSize(true)
        rvFood.adapter = foodAdapter

    }

    private fun setData() {
        foodAdapter.onItemClick = {selectedData ->
            val intent = Intent(this@FoodActivity, FoodActivity::class.java)
            intent.putExtra("IDCategory", selectedData)
            startActivity(intent)

        }
    }

    private fun tesData(food: List<Food>?) {
        if (food != null) {
            for (i in food)
                Toast.makeText(this,i.strMeal,Toast.LENGTH_SHORT).show()
        }
    }
}
