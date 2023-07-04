package com.example.foodapp.ui.category

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.source.db.remote.Resource
import com.example.core.ui.MainRecyclerAdapter
import com.example.foodapp.databinding.ActivityMainBinding
import com.example.foodapp.ui.food.FoodActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mainVM: MainVM by viewModel()
    private val mainAdapter = MainRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        setRV()
        vm()

        fav_menu.setOnClickListener {
            val launchIntent = Intent()
            launchIntent.setClassName(this, "com.example.favorite.ui.FavoriteActivity")
            startActivity(launchIntent)

        }

    }

    private fun setRV() {
        val rvCategoryB = binding.rvCategory
        rvCategoryB.layoutManager = GridLayoutManager(this, 2)
        rvCategoryB.setHasFixedSize(true)
        rvCategoryB.adapter = mainAdapter

    }

    private fun vm() {
        mainVM.category.observe(this, Observer { category ->
            if (category != null) {
                when (category) {
                    is Resource.Loading -> binding.progressMain.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressMain.visibility = View.GONE
                        category.data?.let {
                            mainAdapter.setData(it)

                        }

                    }
                    else -> Log.e("error", "error")
                }
            }
        })

    }

    private fun setData() {
        mainAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@MainActivity, FoodActivity::class.java)
            intent.putExtra("IDCategory", selectedData)
            startActivity(intent)

        }
    }

}