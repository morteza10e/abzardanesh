package ir.abzardanesh.daneshjooyarapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.databinding.ActivityMainBinding
import ir.abzardanesh.daneshjooyarapp.databinding.DialogPoshtibanBinding
import ir.abzardanesh.daneshjooyarapp.databinding.FragmentHomeBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelMainActivity
import ir.abzardanesh.daneshjooyarapp.peresenter.PresenterMainActivity
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewMainActivity

class MainActivity : AppCompatActivity(),Utils {

    private lateinit var presenter :PresenterMainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val view = ViewMainActivity(this,this)
        setContentView(view.binding.root)

        presenter = PresenterMainActivity(ModelMainActivity(),view)
        presenter.onCreate()

    }

    override fun setFragment():NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment




    override fun finished() {
        super.finished()
    }




}