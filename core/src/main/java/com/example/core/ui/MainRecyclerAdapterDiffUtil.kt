package com.example.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.databinding.ItemRecyclerBinding
import com.example.core.domain.model.Category

class MainRecyclerAdapterDiffUtil(private val onItemClick: ((Category) -> Unit)) : RecyclerView.Adapter<MainRecyclerAdapterDiffUtil.ListViewHolder>() {

    private lateinit var binding: ItemRecyclerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MainRecyclerAdapterDiffUtil.ListViewHolder{
        binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder()
    }


    override fun getItemCount() = differ.currentList.size


    override fun onBindViewHolder(holder: MainRecyclerAdapterDiffUtil.ListViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    inner class ListViewHolder(): RecyclerView.ViewHolder(binding.root) {
        fun setData(data: Category) {
            itemView.setOnClickListener { onItemClick(data) }
            binding.categoryTitle.text = data.strCategory
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.strCategoryThumb)
                    .into(imgView)
            }
        }

    }

    private val differCallback = object : DiffUtil.ItemCallback<Category>(){
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return  oldItem.idCategory == newItem.idCategory
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)




}





