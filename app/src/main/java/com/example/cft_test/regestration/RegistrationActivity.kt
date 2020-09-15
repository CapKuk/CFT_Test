package com.example.cft_test.regestration

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.format.DateUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cft_test.R
import com.example.cft_test.hello.HelloActivity
import com.example.cft_test.util.User
import com.example.cft_test.util.ViewContract
import kotlinx.android.synthetic.main.activity_registration.*
import java.util.*


class RegistrationActivity : AppCompatActivity(), ViewContract {

    private var currentDateTime: TextView? = null
    private var dateAndTime = Calendar.getInstance()
    private val presenter = RegistrationPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        currentDateTime = this.dateTextView

        presenter.attachView(this)

        setInitialDateTime()

        this.dateButton.setOnClickListener {
            presenter.setDate()
        }

        this.completeButton.setOnClickListener{
            presenter.validateUser(User(this.nameText.text.toString(), this.surnameText.text.toString(), dateAndTime,
                this.password.text.toString(), this.confirmPassword.text.toString()))
        }
    }

    fun nextScreen(user: User){
        val intent = Intent(this, HelloActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)
    }

    fun exceptionPassword(){
        this.exceptionText.text = getString(R.string.exception_password)
    }
    fun exceptionDate(){
        this.exceptionText.text = getString(R.string.exception_age)
    }

    // отображаем диалоговое окно для выбора даты
    fun setDate() {
        DatePickerDialog(this@RegistrationActivity, d,
            dateAndTime.get(Calendar.YEAR),
            dateAndTime.get(Calendar.MONTH),
            dateAndTime.get(Calendar.DAY_OF_MONTH))
            .show()
    }

    // установка начальных даты и времени
    private fun setInitialDateTime() {
        currentDateTime?.text = DateUtils.formatDateTime(this,
            dateAndTime.timeInMillis,
            DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
                    or DateUtils.FORMAT_SHOW_TIME
        )
    }

    // установка обработчика выбора даты
     private var d:DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            dateAndTime.set(Calendar.YEAR, year)
            dateAndTime.set(Calendar.MONTH, monthOfYear)
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            setInitialDateTime()
        }
}
