package com.example.foodapp.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.core.domain.model.Food
import com.example.core.domain.model.FoodDetail
import com.example.core.source.db.remote.Resource
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityDetailFoodBinding
import kotlinx.android.synthetic.main.activity_detail_food.collapsing_toolbar
import kotlinx.android.synthetic.main.activity_detail_food.favLoveDetailI
import kotlinx.android.synthetic.main.activity_detail_food.imgViewDetail
import kotlinx.android.synthetic.main.activity_detail_food.source
import kotlinx.android.synthetic.main.activity_detail_food.toolbar
import kotlinx.android.synthetic.main.activity_detail_food.tvCategory
import kotlinx.android.synthetic.main.activity_detail_food.tvCountry
import kotlinx.android.synthetic.main.activity_detail_food.tvIngredient
import kotlinx.android.synthetic.main.activity_detail_food.tvInstructions
import kotlinx.android.synthetic.main.activity_detail_food.tvMeasure
import kotlinx.android.synthetic.main.activity_detail_food.youtube
import org.koin.android.ext.android.inject


class DetailFoodActivity : AppCompatActivity() {
    private val detailVM: DetailFoodVM by inject()
    lateinit var foodId: String

    lateinit var binding: ActivityDetailFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar()


        val foodFav = intent.getParcelableExtra<FoodDetail>("IDCategoryFav")
        val food = intent.getParcelableExtra<Food>("IDCategory")


        if (food != null) {
            this.foodId = food.idMeal.toString()
            detailVM.getId(foodId)
//            detailVM.cekFav(foodId)
        } else {
            this.foodId = foodFav!!.idMeal.toString()
            detailVM.getId(foodId)
        }
        cekFav()
        vm()


    }


    private fun actionBar() {
        setSupportActionBar(toolbar)
        collapsing_toolbar.setContentScrimColor(resources.getColor(android.R.color.white))
        collapsing_toolbar.setCollapsedTitleTextColor(resources.getColor(R.color.colorPrimary))
        collapsing_toolbar.setExpandedTitleColor(resources.getColor(android.R.color.white))
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        }
    }


    private fun vm() {
        detailVM.set().observe(this, { detailFood ->
            if (detailFood != null) {
                when (detailFood) {
                    is Resource.Error -> Toast.makeText(this, "tes error", Toast.LENGTH_SHORT)
                        .show()
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> detailFood.data?.get(0).let {
                        binding.progressBar.visibility = View.GONE

                        setData(it)

                    }

                }
            }

        })

    }

    private fun cekFav() {
//        Log.d("terpanggil","jalan")
        detailVM.cekFav().observe(this, {
            if (it.size == 1) {
                Log.d("sesudah","jalan")
                favLoveDetailI.setBackgroundResource(R.drawable.ic_baseline_favorite)
            }
            else favLoveDetailI.setBackgroundResource(R.drawable.ic_favorite_border)
        })
    }

    private fun setData(foodDetail: FoodDetail?) {
        Glide.with(this@DetailFoodActivity)
            .load(foodDetail?.strMealThumb)
            .into(imgViewDetail)
        collapsing_toolbar.title = foodDetail?.strMeal
        tvCategory.text = foodDetail?.strCategory
        tvCountry.text = foodDetail?.strArea
        tvInstructions.text = foodDetail?.strInstructions

        for (i in 0..21) {
            if (foodDetail?.strIngredient1?.isNotEmpty() == true) {
                tvIngredient.append("\n \u2022 " + foodDetail.strIngredient1)
            }
        }

        if (foodDetail?.strIngredient1?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient1)
        }
        if (foodDetail?.strIngredient2?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient2)
        }
        if (foodDetail?.strIngredient3?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient3)
        }
        if (foodDetail?.strIngredient4?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient4)
        }
        if (foodDetail?.strIngredient5?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient5)
        }
        if (foodDetail?.strIngredient6?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient6)
        }
        if (foodDetail?.strIngredient7?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient7)
        }
        if (foodDetail?.strIngredient8?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient8)
        }
        if (foodDetail?.strIngredient9?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient9)
        }
        if (foodDetail?.strIngredient10?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient10)
        }
        if (foodDetail?.strIngredient11?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient11)
        }
        if (foodDetail?.strIngredient12?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient12)
        }
        if (foodDetail?.strIngredient13?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient13)
        }
        if (foodDetail?.strIngredient14?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient14)
        }
        if (foodDetail?.strIngredient15?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient15)
        }
        if (foodDetail?.strIngredient16?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient16)
        }
        if (foodDetail?.strIngredient17?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient17)
        }
        if (foodDetail?.strIngredient18?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient18)
        }
        if (foodDetail?.strIngredient19?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient19)
        }
        if (foodDetail?.strIngredient20?.isNotEmpty() == true) {
            tvIngredient.append("\n \u2022 " + foodDetail.strIngredient20)
        }

        if (foodDetail?.strMeasure1?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure1!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure1)
        }
        if (foodDetail?.strMeasure2?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure2!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure2)
        }
        if (foodDetail?.strMeasure3?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure3!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure3)
        }
        if (foodDetail?.strMeasure4?.isNotEmpty() == true && !Character.isWhitespace(
                foodDetail.strMeasure4?.get(
                    0
                )!!
            )
        ) {
            tvMeasure.append("\n : " + foodDetail.strMeasure4)
        }
        if (foodDetail?.strMeasure5?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure5!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure5)
        }
        if (foodDetail?.strMeasure6?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure6!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure6)
        }
        if (foodDetail?.strMeasure7?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure7!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure7)
        }
        if (foodDetail?.strMeasure8?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure8!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure8)
        }
        if (foodDetail?.strMeasure9?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure9!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure9)
        }
        if (foodDetail?.strMeasure10?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure10!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure10)
        }
        if (foodDetail?.strMeasure11?.isNotEmpty() == true && !Character.isWhitespace(
                foodDetail.strMeasure11?.get(
                    0
                )!!
            )
        ) {
            tvMeasure.append("\n : " + foodDetail.strMeasure11)
        }
        if (foodDetail?.strMeasure12?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure12!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure12)
        }
        if (foodDetail?.strMeasure13?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure13!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure13)
        }
        if (foodDetail?.strMeasure14?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure14!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure14)
        }
        if (foodDetail?.strMeasure15?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure15!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure15)
        }
        if (foodDetail?.strMeasure16?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure16!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure16)
        }
        if (foodDetail?.strMeasure17?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure17!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure17)
        }
        if (foodDetail?.strMeasure18?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure18!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure18)
        }
        if (foodDetail?.strMeasure19?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure19!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure19)
        }
        if (foodDetail?.strMeasure20?.isNotEmpty() == true && !Character.isWhitespace(foodDetail.strMeasure20!![0])) {
            tvMeasure.append("\n : " + foodDetail.strMeasure20)
        }

        youtube.setOnClickListener {
            val intentYoutube = Intent(Intent.ACTION_VIEW)
            intentYoutube.data = Uri.parse(foodDetail?.strYoutube)
            startActivity(intentYoutube)
        }

        source.setOnClickListener {
            val intentSource = Intent(Intent.ACTION_VIEW)
            intentSource.data = Uri.parse(foodDetail?.strSource)
            startActivity(intentSource)
        }




        favLoveDetailI.setOnClickListener {
            detailVM.cekFav().observe(this, {
                if (it.size != 1) {
                    detailVM.saveFav(foodDetail!!)
                    favLoveDetailI.setBackgroundResource(R.drawable.ic_baseline_favorite)
                    Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
                    this.recreate()

                } else {
                    detailVM.deleteFood(foodId)
                    favLoveDetailI.setBackgroundResource(R.drawable.ic_favorite_border)
                    Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show()
                    this.recreate()


                }
            }
            )
        }
    }
}