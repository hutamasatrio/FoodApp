package com.example.foodapp.ui.Category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ui.RecyclerAdapter
import com.example.foodapp.R
import com.example.foodapp.ui.food.FoodActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainVM: MainVM by inject()
    private val mainAdapter = RecyclerAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRV()
        mainVM.getCategory()
        setData()
        vm()

    }

    private fun setRV() {
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvCategory.setHasFixedSize(true)
        rvCategory.adapter = mainAdapter
    }

    private fun vm() {
        mainVM.postData.observe(this, Observer {
            with(mainVM){
                postData.observe(this@MainActivity, Observer {
                    mainAdapter.setData(it)
                })
                messageData.observe(this@MainActivity, Observer {
                    Toast.makeText(this@MainActivity,it,Toast.LENGTH_SHORT).show()
                })

                progressbar.observe(this@MainActivity, Observer {

                })
            }
        })

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