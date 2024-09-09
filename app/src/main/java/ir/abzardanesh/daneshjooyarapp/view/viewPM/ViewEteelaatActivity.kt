package ir.abzardanesh.daneshjooyarapp.view.viewPM

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import ir.abzardanesh.daneshjooyarapp.R
import ir.abzardanesh.daneshjooyarapp.activity.MainActivity
import ir.abzardanesh.daneshjooyarapp.databinding.ActivityEteelaatBinding
import ir.abzardanesh.daneshjooyarapp.databinding.DialogPoshtibanBinding
import ir.abzardanesh.daneshjooyarapp.databinding.FragmentEteelaatBinding
import ir.abzardanesh.daneshjooyarapp.databinding.FragmentHomeBinding
import ir.abzardanesh.daneshjooyarapp.remote.ApiRepository
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.adapter.AdapterTabFragment
import ir.abzardanesh.daneshjooyarapp.view.fragment.EteelaatFragment
import ir.abzardanesh.daneshjooyarapp.view.fragment.VideoFragment

@SuppressLint("ViewConstructor")
class ViewEteelaatActivity (
    private val contextInstance: Context,
    private val utils: Utils

)
    : FrameLayout(contextInstance) {
    val binding = ActivityEteelaatBinding.inflate(LayoutInflater.from(context))


    fun setTabLayout() {
        setFragment(EteelaatFragment())
        binding.tabLayout.addOnTabSelectedListener(
            object : OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when(tab?.position){
                        0 -> setFragment(EteelaatFragment())
                        1 -> setFragment(VideoFragment())
                        else -> setFragment(EteelaatFragment()) } }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}

            }
        )

    }


    fun setFragment(fragment: Fragment){
        utils.setFragment()
        utils.onReplaceFragment(fragment)
    }

    fun setVideoView(){
        val uri: Uri = Uri.parse("android.resource://" + context.packageName + "/" + R.raw.internet)
        val controller = MediaController(context)

        try {
            binding
            binding.videoView.setMediaController(controller)
            binding.videoView.setVideoURI(uri)
            binding.videoView.requestFocus()
            binding.videoView.start()
            binding.videoView.setOnPreparedListener {
                it.setOnVideoSizeChangedListener { _, _, _ ->
                    controller.setAnchorView(binding.videoView)
                } }



        } catch (e: Exception) {
            Log.i("video", e.toString())
        }

    }


   fun setImageSupport() {
        binding.imageSupport.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            val view = DialogPoshtibanBinding.inflate(LayoutInflater.from(context))
            val btnSend: Button = view.btnSendPoshtiban
            val edtInput: EditText= view.edtInputText

            btnSend.setOnClickListener {
                ApiRepository.instance.sendText(
                    "ZLZIEanUWG0vgQUQbff9MAgOy6DTBL9RAl942kjk",
                    "${edtInput.text}",
                    context
                )
            }

            dialog.setView(view.root)
            dialog.create()
            dialog.show()


        }
    }



    fun setOnBack(){
        binding.imageViewBack.setOnClickListener {
            context.startActivity(Intent(context,MainActivity::class.java))
        }
    }


}