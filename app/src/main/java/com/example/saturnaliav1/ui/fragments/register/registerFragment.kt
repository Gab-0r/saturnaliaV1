package com.example.saturnaliav1.ui.fragments.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.saturnaliav1.databinding.FragmentRegisterBinding

class registerFragment : Fragment() {



    private lateinit var registerviewModel: RegisterViewModel
    private lateinit var registerBinding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        registerBinding = FragmentRegisterBinding.inflate(inflater, container, false)
        registerviewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        return registerBinding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.hide()

        registerviewModel.emptyFieldAtDone.observe(viewLifecycleOwner){
            when(it){
                1 -> Toast.makeText(getActivity(),"Digite su nombre", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(getActivity(), "Digite su e-mail", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(getActivity(), "Digite su contraseña", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(getActivity(), "Confirme la contraseña", Toast.LENGTH_SHORT).show()
            }
        }

        registerviewModel.arePassOkDone.observe(viewLifecycleOwner){
            if(!it)Toast.makeText(activity, "Las contraseñas son diferentes", Toast.LENGTH_SHORT).show()
        }

        registerviewModel.regSuccess.observe(viewLifecycleOwner){
            if(it)Toast.makeText(getActivity(), "Registro satisfactorio", Toast.LENGTH_SHORT).show()
            else Toast.makeText(getActivity(), "Registro fallido", Toast.LENGTH_SHORT).show()
        }

        with(registerBinding){
            registerButton.setOnClickListener{
                registerviewModel.areEmptyFields(
                    nameTextInputLayout.text.toString().isEmpty(),
                    emailTextEmailAddress2.text.toString().isEmpty(),
                    passwordTextTextPassword.text.toString().isEmpty(),
                    confirmPasswordTextPassword2.text.toString().isEmpty()
                )

                registerviewModel.passComp(passwordTextTextPassword.text.toString(), confirmPasswordTextPassword2.text.toString())
                registerviewModel.isRegOk()
                registerviewModel.storeFields(nameTextInputLayout.text.toString(), emailTextEmailAddress2.text.toString(), passwordTextTextPassword.text.toString())

            }
        }

    }

}