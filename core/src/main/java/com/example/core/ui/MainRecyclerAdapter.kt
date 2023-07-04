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

    private var list = ArrayList<Category>()
    var onItemClick: ((Category) -> Unit)? = null

    fun setData(data : List<Category>){
        if (data == null) return
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent,false))


    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]
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
                onItemClick?.invoke(list[adapterPosition])
        }
        }
    }



}