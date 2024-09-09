package ir.abzardanesh.daneshjooyarapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.model.ModelEteelaatActivity
import ir.abzardanesh.daneshjooyarapp.peresenter.PresenterEteelaatActivity
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewEteelaatActivity


class EteelaatActivity : AppCompatActivity(),Utils {
    private lateinit var presenter: PresenterEteelaatActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewEteelaatActivity(this,this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(view.binding.root)


        presenter = PresenterEteelaatActivity(ModelEteelaatActivity(), view)
        presenter.onCreate()
    }

    override fun onReplaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment).commit()
    }













}