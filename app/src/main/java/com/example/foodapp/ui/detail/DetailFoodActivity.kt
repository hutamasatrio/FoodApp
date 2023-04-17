package com.example.foodapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.core.domain.model.Food
import com.example.core.domain.model.FoodDetail
import com.example.core.source.db.remote.Resource
import com.example.foodapp.databinding.ActivityDetailFoodBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFoodActivity : AppCompatActivity() {
    private val detailVM: DetailFoodVM by inject()
    lateinit var foodId: String

    lateinit var binding: ActivityDetailFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getParcelableExtra<Food>("IDCategory")

        if (food != null) {
            this.foodId = food.idMeal.toString()
            detailVM.getId(foodId)
        }
        vm()
//        setData()

    }

    private fun vm() {
        detailVM.set().observe(this,{ detailFood ->
            if(detailFood != null){
                when(detailFood){
                    is Resource.Error ->         Toast.makeText(this,"tes error",Toast.LENGTH_SHORT).show()

                    is Resource.Loading -> Toast.makeText(this,"tes loading",Toast.LENGTH_SHORT).show()
                    is Resource.Success -> detailFood.data?.get(0).let {
                        tesData(it)
                    }
//                    if (detailFood.data.get(0 != null))

                }
            }

        })
    }

    private fun tesData(foodDetail: FoodDetail?) {
        Toast.makeText(this,foodDetail?.strMeal,Toast.LENGTH_SHORT).show()
    }

}