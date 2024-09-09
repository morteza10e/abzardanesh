package ir.abzardanesh.daneshjooyarapp.view.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.activity.EteelaatActivity
import ir.abzardanesh.daneshjooyarapp.activity.VideoActivity
import ir.abzardanesh.daneshjooyarapp.databinding.DialogPoshtibanBinding
import ir.abzardanesh.daneshjooyarapp.databinding.FragmentMadrakBinding
import ir.abzardanesh.daneshjooyarapp.remote.ApiRepository


class MadrakFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMadrakBinding.inflate(layoutInflater)
        setImageSupport(binding)
        setOnClick(binding)
        return binding.root
    }

    fun setImageSupport(binding:FragmentMadrakBinding) {
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
        binding.imageEtmam.visibility = View.INVISIBLE

    }

    fun setOnClick(binding: FragmentMadrakBinding){
        binding.btnSend.setOnClickListener {
            val intent = Intent(context,EteelaatActivity::class.java)
            startActivity(intent)
        }
    }


}