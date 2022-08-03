package com.example.saturnaliav1.ui.fragments.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.saturnaliav1.R
import com.example.saturnaliav1.databinding.FragmentRegisterBinding

class registerFragment : Fragment() {

    companion object {
        fun newInstance() = registerFragment()
        private lateinit var viewModel: RegisterViewModel
        private lateinit var registerBinding: FragmentRegisterBinding
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerBinding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = registerBinding.root
        return view
    }
}