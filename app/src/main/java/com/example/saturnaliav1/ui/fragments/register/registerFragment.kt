package com.example.saturnaliav1.ui.fragments.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
    ): View{
        registerBinding = FragmentRegisterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        val view = registerBinding.root
        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity)!!.supportActionBar!!.hide()

        viewModel.emptyFieldAtDone.observe(viewLifecycleOwner){
            when(it){
                1 -> Toast.makeText(getActivity(),"Digite su nombre", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(getActivity(), "Digite su e-mail", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(getActivity(), "Digite su contraseña", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(getActivity(), "Confirme la contraseña", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.arePassOkDone.observe(viewLifecycleOwner){
            if(!it)Toast.makeText(getActivity(), "Las contraseñas son diferentes", Toast.LENGTH_SHORT).show()
        }

        viewModel.regSuccess.observe(viewLifecycleOwner){
            if(it)Toast.makeText(getActivity(), "Registro satisfactorio", Toast.LENGTH_SHORT).show()
            else Toast.makeText(getActivity(), "Registro fallido", Toast.LENGTH_SHORT).show()
        }

        with(registerBinding){
            registerButton.setOnClickListener{
                viewModel.areEmptyFields(
                    nameTextInputLayout.text.toString().isEmpty(),
                    emailTextEmailAddress2.text.toString().isEmpty(),
                    passwordTextTextPassword.text.toString().isEmpty(),
                    confirmPasswordTextPassword2.text.toString().isEmpty()
                )

                viewModel.passComp(passwordTextTextPassword.text.toString(), confirmPasswordTextPassword2.text.toString())
                viewModel.isRegOk()
                viewModel.storeFields(nameTextInputLayout.text.toString(), emailTextEmailAddress2.text.toString(), passwordTextTextPassword.text.toString())

            }
        }
    }

}