package com.example.cft_test.hello

import com.example.cft_test.regestration.RegistrationActivity
import com.example.cft_test.util.BasePresenter
import com.example.cft_test.util.User

class HelloPresenter: BasePresenter<HelloActivity>()  {
    fun printHello(user : User){
        view?.printHello(user)
    }
}