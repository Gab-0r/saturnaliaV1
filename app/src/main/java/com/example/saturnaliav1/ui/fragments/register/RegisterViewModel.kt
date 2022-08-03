package com.example.saturnaliav1.ui.fragments.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    private var discoName: MutableLiveData<String> = MutableLiveData()
    var discoNameDone: LiveData<String> = discoName

    private var discoEmail: MutableLiveData<String> = MutableLiveData()
    var discoEmailDone: LiveData<String> = discoEmail

    private var discoPass: MutableLiveData<String> = MutableLiveData()
    var discoPassDone: LiveData<String> = discoPass

    private var discoPassConfirm: MutableLiveData<String> = MutableLiveData()
    var discoPassConfirmDonoe: LiveData<String> = discoPassConfirm

    private var isPassOk: MutableLiveData<Boolean> = MutableLiveData()
    var isPassOkDone: LiveData<Boolean> = isPassOk

    private var position = 0
    private var emptyFieldAt: MutableLiveData<Int> = MutableLiveData()
    val emptyFieldAtDone: LiveData<Int> = emptyFieldAt

    fun areEmptyFields(name_field: Boolean, lastname_field: Boolean,
                       email_field: Boolean,  pass_field: Boolean, confpass_field: Boolean){
        var fields = booleanArrayOf(name_field, lastname_field, email_field, pass_field, confpass_field)
        for (i in fields.indices) {
            Log.d("Verificando campo: ", i.toString() + fields.get(i).toString() )
            if (fields.get(i)) {
                position = i + 1
                Log.d("Campo vacío en: ", position.toString())
                emptyFieldAt.value = position
                break
            }
        }
    }

    fun storeFields(discoName_: String, discoEmail_: String, discoPass_: String){
        discoName.value = discoName_
        discoEmail.value = discoEmail_
        discoPass.value = discoPass_
    }
}