package ir.abzardanesh.daneshjooyarapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.databinding.FragmentEteelaatBinding
import ir.abzardanesh.daneshjooyarapp.databinding.FragmentVideoBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelEteelaatActivity
import ir.abzardanesh.daneshjooyarapp.model.ModelVideo
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.adapter.RecyclerViewLearn
import ir.abzardanesh.daneshjooyarapp.view.adapter.RecyclerViewVideo
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewVideoActivity

class VideoFragment : Fragment(),Utils {

    private lateinit var  listVideo: Array<ModelVideo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val binding = FragmentVideoBinding.inflate(inflater)
        setRecyclerVideo(binding)
        return  binding.root
    }

    private fun setRecyclerVideo(binding: FragmentVideoBinding){

        binding.recyclerVideo.adapter = RecyclerViewVideo(requireContext(),
            ModelEteelaatActivity().getVideo)

        binding.recyclerVideo.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL
            ,false
        )
        binding.imageTabrik.visibility = View.GONE
    }

}