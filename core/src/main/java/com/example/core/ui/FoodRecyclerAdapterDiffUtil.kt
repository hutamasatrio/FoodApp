package com.example.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.databinding.ItemRecyclerBinding
import com.example.core.domain.model.Food

class FoodRecyclerAdapterDiffUtil(private val onItemClick: ((Food) -> Unit)) : RecyclerView.Adapter<FoodRecyclerAdapterDiffUtil.ListViewHolder>() {

    private lateinit var binding: ItemRecyclerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : FoodRecyclerAdapterDiffUtil.ListViewHolder{
        binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder()
    }


    override fun getItemCount() = differ.currentList.size


    override fun onBindViewHolder(holder: FoodRecyclerAdapterDiffUtil.ListViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    inner class ListViewHolder(): RecyclerView.ViewHolder(binding.root) {
        fun setData(data: Food) {
            itemView.setOnClickListener { onItemClick(data) }
            binding.categoryTitle.text = data.strMeal
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.strMealThumb)
                    .into(imgView)
            }
            }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Food>(){
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return  oldItem.idMeal == newItem.idMeal
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)



}