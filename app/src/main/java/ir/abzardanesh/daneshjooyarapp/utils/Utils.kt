package ir.abzardanesh.daneshjooyarapp.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import ir.abzardanesh.daneshjooyarapp.activity.VideoActivity
import ir.abzardanesh.daneshjooyarapp.databinding.ActivityVideoBinding
import ir.abzardanesh.daneshjooyarapp.databinding.ItemVideoBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelVideo
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewVideoActivity

public interface Utils {

    fun setFragment():NavHostFragment {
        return NavHostFragment()
    }

    fun finished(){}


    fun onReplaceFragment(fragment: Fragment){}



    fun postId():Int{
        return 0
    }









}
