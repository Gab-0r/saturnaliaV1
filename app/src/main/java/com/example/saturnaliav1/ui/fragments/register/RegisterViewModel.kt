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
    var emptyFieldAtDone: LiveData<Int> = emptyFieldAt

    private var areFieldsOk = false

    private var passOk_ = false
    private var arePassOk: MutableLiveData<Boolean> = MutableLiveData()
    var arePassOkDone: LiveData<Boolean> = arePassOk

    private var regsuccess_ = false
    var regSuccess: MutableLiveData<Boolean> = MutableLiveData()
    var regSuccessDone: LiveData<Boolean> = regSuccess

    fun areEmptyFields(name_field: Boolean, email_field: Boolean,  pass_field: Boolean, confpass_field: Boolean){
        var fields = booleanArrayOf(name_field, email_field, pass_field, confpass_field)
        for (i in fields.indices) {
            Log.d("Verificando campo: ", i.toString() + fields.get(i).toString() )
            if (fields.get(i)) {
                position = i + 1
                Log.d("Campo vacío en: ", position.toString())
                emptyFieldAt.value = position
                break
            }
        }
        areFieldsOk = true
    }

    fun storeFields(discoName_: String, discoEmail_: String, discoPass_: String){
        if(regsuccess_) {
            discoName.value = discoName_
            discoEmail.value = discoEmail_
            discoPass.value = discoPass_
            regSuccess.value = true //Avisar a la vista que se completó el registro(Logica inversa)
        }
    }

    fun passComp(pass_: String, confPass_: String){
        if(pass_ != confPass_){
            passOk_ = false
            arePassOk.value = false
        }
    }

    fun isRegOk(){
        if(areFieldsOk && passOk_){
            regsuccess_ = true
        }
    }
}