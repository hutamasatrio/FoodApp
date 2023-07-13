package com.example.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.databinding.ItemRecyclerBinding
import com.example.core.databinding.ItemRecyclerFavBinding
import com.example.core.domain.model.FoodDetail

class FavoriteRecyclerAdapterDiffUtil(private val onItemClick: ((FoodDetail) -> Unit)) : RecyclerView.Adapter<FavoriteRecyclerAdapterDiffUtil.ListViewHolder>() {

    private lateinit var binding: ItemRecyclerFavBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : FavoriteRecyclerAdapterDiffUtil.ListViewHolder{
        binding = ItemRecyclerFavBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder()
    }


    override fun getItemCount() = differ.currentList.size


    override fun onBindViewHolder(holder: FavoriteRecyclerAdapterDiffUtil.ListViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    inner class ListViewHolder(): RecyclerView.ViewHolder(binding.root) {
        fun setData(data: FoodDetail) {
            itemView.setOnClickListener { onItemClick(data) }
            binding.categoryTitle.text = data.strMeal
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.strMealThumb)
                    .into(imgView)
            }
            }

    }

    private val differCallback = object : DiffUtil.ItemCallback<FoodDetail>(){
        override fun areItemsTheSame(oldItem: FoodDetail, newItem: FoodDetail): Boolean {
            return  oldItem.idMeal == newItem.idMeal
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: FoodDetail, newItem: FoodDetail): Boolean {
            val result = oldItem.idMeal == newItem.idMeal

            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)


}