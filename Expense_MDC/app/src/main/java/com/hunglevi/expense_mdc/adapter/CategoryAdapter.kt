package com.hunglevi.expense_mdc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hunglevi.expense_mdc.R
import com.hunglevi.expense_mdc.data.model.Category
import com.hunglevi.expense_mdc.databinding.ItemCategoryBinding

class CategoryAdapter(
    private var categories: List<Category>,
    private val onItemClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.categoryName.text = category.name
            binding.categoryIcon.setImageResource(getIconResource(category.icon)) // Example method to load icon
            binding.root.setOnClickListener {
                onItemClick(category)
            }
        }

        private fun getIconResource(icon: String): Int {
            // Map icon name to drawable resource (you'll need to implement this)
            return R.drawable.category // Replace with actual logic
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    fun updateData(newCategories: List<Category>) {
        categories = newCategories
        notifyDataSetChanged()
    }
}