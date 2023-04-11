package com.example.foodapp.ui.Category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.source.db.remote.Resource
import com.example.core.ui.RecyclerAdapter
import com.example.foodapp.databinding.ActivityMainBinding
import com.example.foodapp.ui.food.FoodActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainVM: MainVM by viewModel()
    private val mainAdapter = RecyclerAdapter()

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRV()
        vm()
        setData()


    }

    private fun setRV() {
        val rvCategoryB = binding.rvCategory
        rvCategoryB.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvCategoryB.setHasFixedSize(true)
        rvCategoryB.adapter = mainAdapter
    }

    private fun vm() {
        mainVM.category.observe(this, Observer{ category ->
            if (category != null){
                when(category){
                    is Resource.Loading -> binding.progressMain.visibility = View.VISIBLE
                    is Resource.Success -> {
                    binding.progressMain.visibility = View.GONE
                    category.data?.let { mainAdapter.setData(it) }
                }
                    else -> Log.e("error","error")
                }
            }
        })


//        val listData = mainVM.category.observe()
//        mainVM.category.observe(this, Observer {
//            mainAdapter.setData(listData)

//            with(mainVM){
//                val listData = it.data
////                mainAdapter.setData(listData!!)
//                if(listData == null){
//                    Toast.makeText(this@MainActivity,"null",Toast.LENGTH_SHORT).show()
//                }
//                else mainAdapter.setData(listData!!)
////                postData.observe(this@MainActivity, Observer {
////                    mainAdapter.setData(it)
////                })
//////                messageData.observe(this@MainActivity, Observer {
////                    Toast.makeText(this@MainActivity,it,Toast.LENGTH_SHORT).show()
////                })
////
//////                progressbar.observe(this@MainActivity, Observer {
////
////                })
//            }

    }

    private fun setData() {
        val mainAdapter = RecyclerAdapter()
        mainAdapter.onItemClick = {selectedData ->
            startActivity(Intent(this@MainActivity, FoodActivity::class.java))
        }
//        mainVM.postData.observe(this, Observer {
//            with(mainVM){
//                postData.observe(this@MainActivity, Observer {
//                    mainAdapter
//                })
//            }
//        })
    }

}