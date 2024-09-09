package ir.abzardanesh.daneshjooyarapp.view.viewPM

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.MediaController
import android.widget.Toast
import ir.abzardanesh.daneshjooyarapp.activity.EteelaatActivity
import ir.abzardanesh.daneshjooyarapp.databinding.ActivityVideoBinding
import ir.abzardanesh.daneshjooyarapp.databinding.DialogPoshtibanBinding
import ir.abzardanesh.daneshjooyarapp.model.ModelPref
import ir.abzardanesh.daneshjooyarapp.model.ModelVideo
import ir.abzardanesh.daneshjooyarapp.remote.ApiRepository
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.adapter.RecyclerViewVideo.*


@SuppressLint("ViewConstructor")
class ViewVideoActivity(
    contextInstance: Context,
    private val utils: Utils,
    listVideo: Array<ModelVideo>

) : FrameLayout(contextInstance) {
    val binding = ActivityVideoBinding.inflate(LayoutInflater.from(context))




    val arrayList = arrayListOf<ModelPref>()


    private lateinit var uri: Uri

    private val pref = context.getSharedPreferences("Pref", Context.MODE_PRIVATE)
    var postId = utils.postId()

    private var progress = pref.getLong("Progress", 0)
    private var idProgress = pref.getInt("id", -1)

    var array = arrayOf(0,0,0,0,0)

    var count = listVideo[postId].current.toInt()


    private val videoView = binding.videoViewActivity

    var isCheck: Int = 0


    @SuppressLint("SetTextI18n")
    fun getSecondsVideo() {

        val seconds = videoView.duration / 100
//        val seconds =listVideo[postId].duration.toLong() / 100
        isCheck = seconds * count.toInt()
        binding.tvTextProgress.text = "${count}" + " درصد "
        binding.progressBar?.setProgress(count.toInt())


        refresh(seconds.toLong())
        updateProgress()


    }

    private fun refresh(milliSeconds: Long) {
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                getSecondsVideo()
                if (videoView.isPlaying && isCheck <= videoView.currentPosition) {
                    count++
                }
            }
        }
        handler.postDelayed(runnable, milliSeconds)
    }


    @SuppressLint("SetTextI18n")
    private fun updateProgress() {

        binding.tvTextProgress.text = "$count درصد "
        binding.progressBar?.progress = count.toInt()


    }


    fun setTextVideoProgress(listVideo: Array<ModelVideo>) {
        postId = utils.postId()
        binding.tvTitleVideo.text = listVideo[postId].title





        binding.btnHelp.setOnClickListener {


        }






        if (idProgress == postId) {
            count += progress.toInt()
            progress += listVideo[postId].current.toInt()






        }

        val videoView = binding.videoViewActivity
        uri = Uri.parse("android.resource://" + context.packageName + "/" + listVideo[postId].video)
        val controller = MediaController(context)
        try {
            videoView.setMediaController(controller)
            videoView.setVideoURI(uri)
            videoView.requestFocus()
            videoView.start()
            videoView.setOnPreparedListener {
                it.setOnVideoSizeChangedListener { _, _, _ ->
                    controller.setAnchorView(binding.videoViewActivity)
                }
            }

            videoView.setOnCompletionListener {

            }


        } catch (e: Exception) {
            Log.i("video", e.toString())
        }

    }


    fun setClick(listVideo: Array<ModelVideo>) {

        binding.btnNext.setOnClickListener(object : OnClickListener {
            @SuppressLint("SetTextI18n")
            override fun onClick(v: View?) {
                if (postId == 5) {
                    Toast.makeText(context, "ویدیوی آخر هست", Toast.LENGTH_SHORT).show()
                } else {
                    val plus = postId++
                    binding.tvTitleVideo.text = listVideo[plus].title
                    binding.videoViewActivity.setVideoURI(
                        Uri.parse("android.resource://" + context.packageName + "/" + listVideo[plus].video)
                    )
                    binding.progressBar?.progress = listVideo[plus].current.toInt()
                    binding.tvTextProgress.text = "${listVideo[plus].current} درصد "
                }
            }

        })
        binding.btnPrevious.setOnClickListener(object : OnClickListener {
            @SuppressLint("SetTextI18n")
            override fun onClick(v: View?) {
                if (postId == 0) {
                    Toast.makeText(context, "ویدیوی اول هست", Toast.LENGTH_SHORT).show()
                } else {
                    val menha = --postId
                    binding.tvTitleVideo.text = listVideo[menha].title
                    binding.videoViewActivity.setVideoURI(
                        Uri.parse("android.resource://" + context.packageName + "/" + listVideo[menha].video)
                    )
                    binding.progressBar?.progress = listVideo[menha].current.toInt()
                    binding.tvTextProgress.text = "${listVideo[menha].current} درصد "

                }


            }

        })
    }

    fun setImageSupport() {
        binding.imageSupport.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            val view = DialogPoshtibanBinding.inflate(LayoutInflater.from(context))
            val btnSend: Button = view.btnSendPoshtiban
            val edtInput: EditText = view.edtInputText

            btnSend.setOnClickListener {
                ApiRepository.instance.sendText(
                    "ZLZIEanUWG0vgQUQb ff9MAgOy6DTBL9RAl942kjk",
                    "${edtInput.text}",
                    context
                )
            }
            dialog.setView(view.root)
            dialog.create()
            dialog.show()
        }
    }

    fun setOnBack() {
        binding.imageViewBack.setOnClickListener {
            context.startActivity(Intent(context, EteelaatActivity::class.java))
        }
    }






}




