package com.example.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.databinding.ItemRecyclerBinding
import com.example.core.domain.model.Food
import com.example.core.domain.model.FoodDetail

class FavoriteRecyclerAdapter: RecyclerView.Adapter<FavoriteRecyclerAdapter.ListViewHolder>() {

    private var list = ArrayList<FoodDetail>()
    var onItemClick: ((FoodDetail) -> Unit)? = null

    fun setData(data : List<FoodDetail>){
        if (data == null) return
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_fav, parent,false))


    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRecyclerBinding.bind(itemView)
        fun bind(data: FoodDetail) {
            binding.categoryTitle.text = data.strMeal
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.strMealThumb)
                    .into(imgView)

            }
        }
        init {
            binding.root.setOnClickListener{
                onItemClick?.invoke(list[adapterPosition])
            }
        }
    }
}