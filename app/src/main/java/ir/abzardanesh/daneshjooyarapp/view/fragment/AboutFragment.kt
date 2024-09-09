package ir.abzardanesh.daneshjooyarapp.view.fragment

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ir.abzardanesh.daneshjooyarapp.databinding.DialogPoshtibanBinding
import ir.abzardanesh.daneshjooyarapp.databinding.FragmentAboutBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelMainActivity
import ir.abzardanesh.daneshjooyarapp.remote.ApiRepository
import ir.abzardanesh.daneshjooyarapp.view.adapter.RecyclerViewLearn
import ir.abzardanesh.daneshjooyarapp.view.adapter.RecyclerViewProperty


class AboutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAboutBinding.inflate(layoutInflater)
        setRecyclerLearn(binding)
        setRecyclerProperty(binding)
        onClickLink(binding)
        setImageSupport(binding)
        return binding.root
    }


    private fun setRecyclerLearn(binding: FragmentAboutBinding) {

        binding.recyclerViewLearn.adapter = RecyclerViewLearn(ModelMainActivity().getLearnAbout)
        binding.recyclerViewLearn.layoutManager = GridLayoutManager(
            requireContext(), 2,
            GridLayoutManager.HORIZONTAL, false
        )
    }

    private fun setRecyclerProperty(binding: FragmentAboutBinding) {
        binding.recyclerViewProperty.adapter =
            RecyclerViewProperty(ModelMainActivity().getProperty)
        binding.recyclerViewProperty.layoutManager = GridLayoutManager(
            context,2,
            GridLayoutManager.HORIZONTAL,false


        )
    }

    private fun onClickLink(binding: FragmentAboutBinding){
        binding.btnYoutube.setOnClickListener {
            goLink("https://www.youtube.com/@alireza-ahmadi")
        }
        binding.btnInstagram.setOnClickListener {
            goLink("https://www.instagram.com/lrn.ir")
        }
    }

    private fun goLink(s:String){
        val uri : Uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW,uri))

    }

    fun setImageSupport(binding: FragmentAboutBinding) {
        binding.imageSupport.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            val view = DialogPoshtibanBinding.inflate(LayoutInflater.from(context))
            val btnSend: Button = view.btnSendPoshtiban
            val edtInput: EditText = view.edtInputText

            btnSend.setOnClickListener {
                ApiRepository.instance.sendText(
                    "ZLZIEanUWG0vgQUQbff9MAgOy6DTBL9RAl942kjk",
                    "${edtInput.text}",
                    requireContext()
                )
            }

            dialog.setView(view.root)
            dialog.create()
            dialog.show()


        }
    }

}


