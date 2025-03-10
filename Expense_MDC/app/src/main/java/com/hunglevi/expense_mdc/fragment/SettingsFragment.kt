package com.hunglevi.expense_mdc.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.hunglevi.expense_mdc.LoginActivity
import com.hunglevi.expense_mdc.R
import com.hunglevi.expense_mdc.R.layout.fragment_settings

class SettingsFragment : Fragment() {

    private lateinit var tvUserName: TextView
    private lateinit var btnLogin: MaterialButton
    private lateinit var btnLogout: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvUserName = view.findViewById(R.id.tvUserName)
        btnLogin = view.findViewById(R.id.btnLogin)
        btnLogout = view.findViewById(R.id.btnLogout)

        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val userName = sharedPreferences.getString("userName", "Người dùng")
            tvUserName.text = userName
            btnLogin.visibility = View.GONE
            btnLogout.visibility = View.VISIBLE
        } else {
            btnLogin.visibility = View.VISIBLE
            btnLogout.visibility = View.GONE
        }

        btnLogin.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }

        btnLogout.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            Toast.makeText(requireContext(), "Đã đăng xuất", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }
}
