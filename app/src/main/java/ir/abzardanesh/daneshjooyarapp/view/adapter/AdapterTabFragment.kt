package ir.abzardanesh.daneshjooyarapp.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ir.abzardanesh.daneshjooyarapp.view.fragment.EteelaatFragment
import ir.abzardanesh.daneshjooyarapp.view.fragment.HomeFragment
import ir.abzardanesh.daneshjooyarapp.view.fragment.MadrakFragment
import ir.abzardanesh.daneshjooyarapp.view.fragment.VideoFragment

class AdapterTabFragment(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> EteelaatFragment()
            1 -> VideoFragment()
            else -> EteelaatFragment()

        }
    }
}