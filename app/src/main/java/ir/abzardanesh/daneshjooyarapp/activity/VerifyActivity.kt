package ir.abzardanesh.daneshjooyarapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.model.ModelLoginVerifyActivity
import ir.abzardanesh.daneshjooyarapp.peresenter.PresenterVerifyActivity
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewVerifyActivity

class VerifyActivity : AppCompatActivity(),Utils {

    private lateinit var presenter : PresenterVerifyActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewVerifyActivity(this,this)
        setContentView(view.binding.root)

        presenter = PresenterVerifyActivity(ModelLoginVerifyActivity(),view)

        presenter.onCreate()

    }

    override fun finished() {
        super.finished()
        finish()
    }


}