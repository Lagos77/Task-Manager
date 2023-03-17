package com.app.todoapp.presentation.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.todoapp.databinding.FragmentSettingsBinding
import com.app.todoapp.presentation.login.MainActivity

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.logutBtn.setOnClickListener {
            startActivity(Intent(this@SettingsFragment.context, MainActivity::class.java))
            activity?.finish()
        }
        return binding.root
    }

}