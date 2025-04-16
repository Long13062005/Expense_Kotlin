package com.hunglevi.expense_mdc.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.hunglevi.expense_mdc.R
import com.hunglevi.expense_mdc.databinding.FragmentEditProfileBinding
import com.hunglevi.expense_mdc.databinding.FragmentSettingsBinding

class EditSettingsFragment : Fragment() {
    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load Profile Image
        val profileImageUrl = "https://example.com/profile-image.jpg"
        Glide.with(requireContext())
            .load(profileImageUrl)
            .placeholder(R.drawable.profile)
            .into(binding.profileImage)


        // Handle Update Button Click
        binding.updateButton.setOnClickListener {
            val newUsername = binding.usernameInput.text.toString()
            val newEmail = binding.emailInput.text.toString()

            // Example: Perform API call or local storage update here
            Toast.makeText(
                requireContext(),
                "Updated: $newUsername, , $newEmail",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}