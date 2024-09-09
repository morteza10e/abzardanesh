package ir.abzardanesh.daneshjooyarapp.peresenter

import android.content.Context
import ir.abzardanesh.daneshjooyarapp.model.ModelPref
import ir.abzardanesh.daneshjooyarapp.model.ModelVideoActivity
import ir.abzardanesh.daneshjooyarapp.remote.ApiRepository
import ir.abzardanesh.daneshjooyarapp.utils.Utils
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewVideoActivity

class PresenterVideoActivity(
    val model: ModelVideoActivity,
    val view: ViewVideoActivity,
    val utils: Utils,
    val context: Context


) {



    fun onCreate() {
        view.setTextVideoProgress(ModelVideoActivity().getVideo)
        view.setClick(ModelVideoActivity().getVideo)
        view.setImageSupport()
        view.setOnBack()
        view.getSecondsVideo()

    }

    fun onPause() {
        ApiRepository.SharedPreferences.savePreferences(context,view.count.toLong(),
            view.postId)






    }
}