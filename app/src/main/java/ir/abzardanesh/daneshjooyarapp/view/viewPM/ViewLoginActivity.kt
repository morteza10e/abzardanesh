package ir.abzardanesh.daneshjooyarapp.view.viewPM

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.widget.FrameLayout
import ir.abzardanesh.daneshjooyarapp.activity.MainActivity
import ir.abzardanesh.daneshjooyarapp.activity.VerifyActivity
import ir.abzardanesh.daneshjooyarapp.databinding.ActivityLoginBinding
import ir.abzardanesh.daneshjooyarapp.databinding.ActivityMainBinding
import ir.abzardanesh.daneshjooyarapp.utils.Utils

@SuppressLint("ViewConstructor")
class ViewLoginActivity(
    private val contextInstance: Context,
)
    : FrameLayout(contextInstance) {
    val binding = ActivityLoginBinding.inflate(LayoutInflater.from(context))


    fun onClickHandler(number:String){


        binding.btnSend.setOnClickListener {

            if (binding.edtInputNumber.text.toString() == number){
                context.startActivity(Intent(context,VerifyActivity::class.java))

            }else
            {
                binding.textInputNumber.error = "شماره موبایل نامعتبر است"
            }


        }
    }
}