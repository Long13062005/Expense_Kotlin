package com.hunglevi.expense_mdc.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.hunglevi.expense_mdc.data.model.Transaction
import com.hunglevi.expense_mdc.databinding.ItemTransactionBinding
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

class TransactionsAdapter(
    private var transactions: List<Transaction>,
    private val onEdit: (Transaction) -> Unit,
    private val onDelete: (Transaction) -> Unit,
    private val fetchCategoryName: (Int) -> String // Function to fetch category name dynamically
) : RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {


    // ViewHolder for binding transaction data
    inner class TransactionViewHolder(val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            // Fetch and set category name
            binding.transactionTitle.text = "Loading..." // Placeholder
            (binding.root.context as? LifecycleOwner)?.lifecycleScope?.launch {
                val categoryName = fetchCategoryName(transaction.categoryId)
                binding.transactionTitle.text = categoryName
            }
            // Set transaction details
            binding.transactionTime.text = transaction.date
            binding.transactionDescription.text = transaction.description ?: "No description"

            // Format amount as currency
            val formattedAmount = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(transaction.amount)
            binding.transactionAmount.text = formattedAmount

            // Change text color based on type
            val amountColor = if (transaction.type == "Income") Color.GREEN else Color.RED
            binding.transactionAmount.setTextColor(amountColor)

            // Set click listeners
            binding.editButton.setOnClickListener { onEdit(transaction) }
            binding.deleteButton.setOnClickListener { onDelete(transaction) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(transactions[position])
    }

    override fun getItemCount(): Int = transactions.size

    fun updateTransactions(newTransactions: List<Transaction>) {
        transactions = newTransactions
        notifyDataSetChanged()
    }
}