package ir.abzardanesh.daneshjooyarapp.view.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.databinding.FragmentHomeBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelMainActivity
import ir.abzardanesh.daneshjooyarapp.remote.ApiRepository
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.adapter.RecyclerViewCourse
import ir.abzardanesh.daneshjooyarapp.view.adapter.RecyclerViewGroup


class HomeFragment : Fragment(), Utils {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(layoutInflater)
        setInitRecycler(binding)
        setInitRecyclerCourse(binding)
        setImageSupport(binding)
        return binding.root

    }


    private fun setInitRecycler(binding: FragmentHomeBinding) {

        binding.recyclerViewGroup.adapter = RecyclerViewGroup(ModelMainActivity().getGroup)
        binding.recyclerViewGroup.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.HORIZONTAL,
            false
        )



    }


    private fun setInitRecyclerCourse(binding: FragmentHomeBinding) {
        binding.recViewCourse.adapter =
            RecyclerViewCourse(requireContext(), ModelMainActivity().getCourse)
        binding.recViewCourse.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
    }

    private fun setImageSupport(binding: FragmentHomeBinding) {
        binding.imageSupport.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            val view = getLayoutInflater().inflate(R.layout.dialog_poshtiban, null)
            val btnSend: Button = view.findViewById(R.id.btn_sendPoshtiban)
            val edtInput: EditText = view.findViewById(R.id.edt_input_text)

            btnSend.setOnClickListener {
                ApiRepository.instance.sendText(
                    "ZLZIEanUWG0vgQUQbff9MAgOy6DTBL9RAl942kjk",
                    "${edtInput.text}",
                    requireContext()
                )
            }

            dialog.setView(view)
            dialog.create()
            dialog.show()


        }
    }


}