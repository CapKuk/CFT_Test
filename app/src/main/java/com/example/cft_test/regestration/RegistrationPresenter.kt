package com.example.cft_test.regestration

import com.example.cft_test.util.BasePresenter

class RegistrationPresenter : BasePresenter<RegistrationActivity>() {
    fun setDate(){
        view?.setDate()
    }
}