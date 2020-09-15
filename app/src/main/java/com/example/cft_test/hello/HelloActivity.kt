package com.example.cft_test.hello

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cft_test.R
import com.example.cft_test.util.User
import com.example.cft_test.util.ViewContract
import kotlinx.android.synthetic.main.activity_hello.*
import org.w3c.dom.Text

class HelloActivity: AppCompatActivity(), ViewContract {

    private val presenter = HelloPresenter()
    var dialog : Dialog? = null
    var text : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        dialog = Dialog(this)

        dialog?.setTitle("Приветствие")

        dialog?.setContentView(R.layout.activity_dialog)

        text = dialog?.findViewById(R.id.dialogTextView) as TextView

        val user = intent.getSerializableExtra("User") as User

        presenter.attachView(this)

        this.button.setOnClickListener{
            presenter.printHello(user)
        }
    }
    fun printHello(user : User){
        text?.text = "Здравствуйте, " + user.name + " " + user.surname + "!"
        dialog?.show()
    }
}