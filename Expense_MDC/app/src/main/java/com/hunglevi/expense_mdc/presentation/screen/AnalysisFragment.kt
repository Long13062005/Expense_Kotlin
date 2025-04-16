package com.hunglevi.expense_mdc.presentation.screen

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hunglevi.expense_mdc.R
import com.hunglevi.expense_mdc.adapter.TransactionsAdapter
import com.hunglevi.expense_mdc.data.dao.AppDatabase
import com.hunglevi.expense_mdc.data.repository.TransactionRepository
import com.hunglevi.expense_mdc.databinding.FragmentAnalysisBinding
import com.hunglevi.expense_mdc.presentation.viewmodel.TransactionViewModel
import com.hunglevi.expense_mdc.presentation.viewmodel.ViewModelFactory
import kotlinx.coroutines.launch
import kotlin.getValue

class AnalysisFragment : Fragment() {
    private var _binding: FragmentAnalysisBinding? = null
    private val binding get() = _binding!!
    private val transactionViewModel: TransactionViewModel by viewModels {
        ViewModelFactory(
            transactionRepository = TransactionRepository(
                AppDatabase.getInstance(requireContext()).transactionDao() // Use Activity context here
            )
        )
    }
    private lateinit var transactionAdapter: TransactionsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalysisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = context?.getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val userId = sharedPref?.getInt("USER_ID", -1)
        transactionViewModel.setUserId(userId ?: -1)
        // Initialize all sections
        setupFinancialSummary()
        setupTabs()
        setupBarChart()
        setupNavigation()
    }


    private fun setupFinancialSummary() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                transactionViewModel.transactions.collect { transactions ->
                    val totalIncome = transactions.filter { it.type == "Income" }.sumOf { it.amount }
                    val totalExpense = transactions.filter { it.type == "Expense" }.sumOf { it.amount }

                    // Update financial summary UI
                    binding.incomeValue.text = "$${String.format("%.2f", totalIncome)}"
                    binding.expenseValue.text = "$${String.format("%.2f", totalExpense)}"

                    // Update goal progress
                    val currentAmount = totalIncome - totalExpense
                    val goalAmount = 20000.0 // This can be dynamic based on user input
                    val progress = ((currentAmount / goalAmount) * 100).coerceIn(0.0, 100.0).toInt()

                    val currentProgress = calculateProgress(currentAmount, goalAmount)

                    binding.progressBar.max = 100
                    binding.progressBar.progress = currentProgress
                    binding.progressPercentage.text = String.format("%d%%", progress)
                    binding.progressGoal.text = "Goal: $${String.format("%.2f", goalAmount)}"
                }
            }
        }
    }
    fun calculateProgress(currentAmount: Double, goalAmount: Double): Int {
        if (goalAmount <= 0) {
            throw IllegalArgumentException("Goal amount must be greater than zero.")
        }
        val progress = ((currentAmount / goalAmount) * 100).coerceIn(0.0, 100.0) // Ensure between 0% and 100%
        return progress.toInt()
    }

    private fun setupNavigation() {
        // Navigate to CalendarFragment when graphIcon is clicked
        binding.graphIcon.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in_right, // Enter animation
                    R.anim.slide_out_left, // Exit animation
                    R.anim.slide_in_left,  // Pop enter animation
                    R.anim.slide_out_right // Pop exit animation
                )
                .replace(R.id.fragmentContainer, CalendarFragment())
                .addToBackStack(null)
                .commit()
        }

        // Navigate to SearchFragment when searchIcon is clicked
        binding.searchIcon.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in_right, // Enter animation
                    R.anim.slide_out_left, // Exit animation
                    R.anim.slide_in_left,  // Pop enter animation
                    R.anim.slide_out_right // Pop exit animation
                )
                .replace(R.id.fragmentContainer, SearchFragment())
                .addToBackStack(null)
                .commit()
        }
    }


    private fun setupTabs() {
        // Handle tab selection with dynamic updates
        binding.dayTab.setOnClickListener { selectTab("Day", binding.dayTab) }
        binding.weekTab.setOnClickListener { selectTab("Week", binding.weekTab) }
        binding.monthTab.setOnClickListener { selectTab("Month", binding.monthTab) }
        binding.yearTab.setOnClickListener { selectTab("Year", binding.yearTab) }
    }

    private fun selectTab(period: String, selectedTab: View) {
        updateBarChartData(period)
        updateTabFocus(selectedTab)
    }

    private fun updateBarChartData(period: String) {
        val incomeData: List<Float>
        val expenseData: List<Float>

        // Set data dynamically based on the selected period
        when (period) {
            "Day" -> {
                incomeData = listOf(500f, 1000f, 1500f, 2000f)
                expenseData = listOf(300f, 700f, 1100f, 1500f)
            }
            "Week" -> {
                incomeData = listOf(3000f, 4000f, 5000f, 6000f, 7000f, 8000f, 9000f)
                expenseData = listOf(1500f, 2500f, 3500f, 4000f, 5000f, 6000f, 7000f)
            }
            "Month" -> {
                incomeData = listOf(7000f, 8000f, 9000f, 10000f)
                expenseData = listOf(5000f, 6000f, 7000f, 8000f)
            }
            "Year" -> {
                incomeData = listOf(50000f, 60000f, 70000f)
                expenseData = listOf(25000f, 35000f, 45000f)
            }
            else -> return
        }

        // Update the bar chart with the new dataset
        binding.barChartView.setData(incomeData, expenseData, period)
    }

    private fun updateTabFocus(selectedTab: View) {
        // Reset all tabs to default focus effect
        binding.dayTab.setBackgroundResource(R.drawable.tab_focus_effect)
        binding.weekTab.setBackgroundResource(R.drawable.tab_focus_effect)
        binding.monthTab.setBackgroundResource(R.drawable.tab_focus_effect)
        binding.yearTab.setBackgroundResource(R.drawable.tab_focus_effect)

        // Highlight the selected tab
        selectedTab.setBackgroundResource(R.drawable.tab_selected_effect)
    }

    private fun setupBarChart() {
        // Initial dataset for the bar chart
        val incomeData = listOf(1000f, 3000f, 2000f, 5000f, 7000f, 8000f, 10000f)
        val expenseData = listOf(800f, 1500f, 1000f, 2500f, 4000f, 5000f, 6000f)

        // Configure bar chart with initial data
        binding.barChartView.setData(incomeData, expenseData, "Day")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}