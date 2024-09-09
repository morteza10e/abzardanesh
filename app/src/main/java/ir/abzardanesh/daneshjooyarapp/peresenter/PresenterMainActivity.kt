package ir.abzardanesh.daneshjooyarapp.peresenter

import ir.abzardanesh.daneshjooyarapp.model.ModelMainActivity
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewMainActivity

class PresenterMainActivity(
    private val model : ModelMainActivity,
    private val view : ViewMainActivity
) {

    fun onCreate(){
        view.navHost()
    }

}