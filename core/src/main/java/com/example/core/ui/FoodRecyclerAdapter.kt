package com.example.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.databinding.ItemRecyclerBinding
import com.example.core.domain.model.Category
import com.example.core.domain.model.Food

class FoodRecyclerAdapter : RecyclerView.Adapter<FoodRecyclerAdapter.ListViewHolder>() {

    private var listData = ArrayList<Food>()
    var onItemClick: ((Food) -> Unit)? = null

    fun setData(newListData : List<Food>){
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent,false))


    override fun getItemCount() = listData.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRecyclerBinding.bind(itemView)
        fun bind(data: Food) {
            binding.categoryTitle.text = data.strMeal
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.strMealThumb)
                    .into(imgView)

            }
            }
        init {
            binding.root.setOnClickListener{
                onItemClick?.invoke(listData[adapterPosition])
        }
        }
    }



}