package com.example.cft_test.regestration

import com.example.cft_test.util.BasePresenter
import com.example.cft_test.util.User
import java.time.Period
import java.util.*

class RegistrationPresenter : BasePresenter<RegistrationActivity>() {
    fun setDate(){
        view?.setDate()
    }

    fun validateUser(user: User){
        //TODO: провести валидацию юзера
        //if(user.возраст < 18) view.exceptionAge() return
        val eighteenYearsInMilliseconds = 56799360000
        if(user.birthday.timeInMillis > Calendar.getInstance().timeInMillis - eighteenYearsInMilliseconds){
            view?.exceptionDate()
            return
        }
        if(user.password != user.confirmPassword){
            view?.exceptionPassword()
            return
        }
        view?.nextScreen(user)
    }
}