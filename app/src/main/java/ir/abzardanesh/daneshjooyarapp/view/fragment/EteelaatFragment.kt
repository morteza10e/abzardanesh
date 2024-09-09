package ir.abzardanesh.daneshjooyarapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.databinding.FragmentEteelaatBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelEteelaatActivity
import ir.abzardanesh.daneshjooyarapp.view.adapter.RecyclerViewLearn


class EteelaatFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEteelaatBinding.inflate(inflater)
        setRecyclerLearn(binding)
        return binding.root
    }


    private fun setRecyclerLearn(binding: FragmentEteelaatBinding){

        binding.recLearn.adapter = RecyclerViewLearn(ModelEteelaatActivity().getLearn)
        binding.recLearn.layoutManager = GridLayoutManager(
            requireContext(),2,
            GridLayoutManager.HORIZONTAL
            ,false
        )
    }

}