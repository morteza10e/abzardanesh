package ir.abzardanesh.daneshjooyarapp.peresenter

import ir.abzardanesh.daneshjooyarapp.model.ModelLoginVerifyActivity
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewLoginActivity

class PresenterLoginActivity(
    val model: ModelLoginVerifyActivity,
    val view: ViewLoginActivity
) {
    fun onCreate() {
        view.onClickHandler(model.numberAliReza)
    }
}