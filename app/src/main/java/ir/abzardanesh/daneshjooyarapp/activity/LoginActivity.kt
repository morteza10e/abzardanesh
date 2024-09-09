package ir.abzardanesh.daneshjooyarapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import ir.abzardanesh.daneshjooyarapp.model.ModelLoginVerifyActivity
import ir.abzardanesh.daneshjooyarapp.peresenter.PresenterLoginActivity
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewLoginActivity

class LoginActivity : AppCompatActivity(){

    private lateinit var presenter : PresenterLoginActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val view = ViewLoginActivity(this)
        setContentView(view.binding.root)

        presenter = PresenterLoginActivity(ModelLoginVerifyActivity(),view)
        presenter.onCreate()
    }


}