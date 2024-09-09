package ir.abzardanesh.daneshjooyarapp.view.viewPM

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.databinding.ActivityMainBinding
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.fragment.AboutFragment
import ir.abzardanesh.daneshjooyarapp.view.fragment.HomeFragment
import ir.abzardanesh.daneshjooyarapp.view.fragment.MadrakFragment

@SuppressLint("ViewConstructor")
class ViewMainActivity(
    private val contextInstance: Context,
    private val utils: Utils
) : FrameLayout(contextInstance) {
    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun navHost(){
        val navHost = utils.setFragment()
        binding.bottomNav.setupWithNavController(navHost.findNavController())
        binding.bottomNav.itemIconTintList = null
    }



}