package ir.abzardanesh.daneshjooyarapp.view.viewPM

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import com.wynsbin.vciv.VerificationCodeInputView.OnInputListener
import ir.abzardanesh.daneshjooyarapp.activity.LoginActivity
import ir.abzardanesh.daneshjooyarapp.activity.MainActivity
import ir.abzardanesh.daneshjooyarapp.databinding.ActivityVerifyBinding
import ir.abzardanesh.daneshjooyarapp.utils.Utils



@SuppressLint("ViewConstructor")
class ViewVerifyActivity(
    private val contextInstance: Context,
    private val utils: Utils
) : FrameLayout(contextInstance) {
    val binding = ActivityVerifyBinding.inflate(LayoutInflater.from(context))


    fun onClickHandler(password: String) {

        binding.verifyCode.setOnInputListener(
            object : OnInputListener {
                override fun onComplete(code: String?) {
                    if (code.toString() == password){
                        binding.btnSend.setOnClickListener {
                            context.startActivity(Intent(context, MainActivity::class.java))
                        }
                    }else{
                        binding.textInputPassword.error = "کد تایید وارد شده نامعتبر است."
                    }
                }

                override fun onInput() {
                }

            })






    }

    fun editNumber(){
        binding.tvEditMobile.setOnClickListener(){
            context.startActivity(Intent(context,LoginActivity::class.java)) }
    }


    private fun finish(){
        utils.finished()
    }

}
