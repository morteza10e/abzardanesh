package ir.abzardanesh.daneshjooyarapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import ir.abzardanesh.daneshjooyarapp.model.ModelPref
import ir.abzardanesh.daneshjooyarapp.model.ModelVideoActivity
import ir.abzardanesh.daneshjooyarapp.peresenter.PresenterVideoActivity
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewVideoActivity


class VideoActivity : AppCompatActivity(), Utils {
    private lateinit var presenter: PresenterVideoActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val view = ViewVideoActivity(this, this, ModelVideoActivity().getVideo)
        setContentView(view.binding.root)
        presenter = PresenterVideoActivity(ModelVideoActivity(), view, this, this)
        presenter.onCreate()
    }


    override fun postId(): Int {
        return intent.getIntExtra("pos", 0)
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()

    }


}





