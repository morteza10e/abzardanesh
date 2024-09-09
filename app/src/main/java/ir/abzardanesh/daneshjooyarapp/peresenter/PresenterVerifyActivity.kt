package ir.abzardanesh.daneshjooyarapp.peresenter

import ir.abzardanesh.daneshjooyarapp.model.ModelLoginVerifyActivity
import ir.abzardanesh.daneshjooyarapp.view.viewPM.ViewVerifyActivity

class PresenterVerifyActivity (
    val model: ModelLoginVerifyActivity,
    val view: ViewVerifyActivity
){
    fun onCreate(){
        view.onClickHandler(model.password)
        view.editNumber()

    }
}