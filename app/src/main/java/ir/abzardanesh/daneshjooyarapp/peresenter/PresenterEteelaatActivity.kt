package ir.abzardanesh.daneshjooyarapp.peresenter

import ir.abzardanesh.daneshjooyarapp.model.ModelEteelaatActivity
import ir.abzardanesh.daneshjooyarapp.model.ModelLoginVerifyActivity
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewEteelaatActivity
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewLoginActivity

class PresenterEteelaatActivity (
    val model: ModelEteelaatActivity,
    val view: ViewEteelaatActivity
) {
    fun onCreate() {
        view.setTabLayout()
        view.setVideoView()
        view.setImageSupport()
        view.setOnBack()
    }
}