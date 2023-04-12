package com.example.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.databinding.ItemRecyclerBinding
import com.example.core.domain.model.Category

class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ListViewHolder>() {

    private var listData = ArrayList<Category>()
    var onItemClick: ((Category) -> Unit)? = null

    fun setData(newListData : List<Category>){
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
        fun bind(data: Category) {
            binding.categoryTitle.text = data.strCategory
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.strCategoryThumb)
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