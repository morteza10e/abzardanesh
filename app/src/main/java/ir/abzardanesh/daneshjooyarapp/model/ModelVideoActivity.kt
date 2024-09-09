package ir.abzardanesh.daneshjooyarapp.model

import android.content.Context
import ir.abzardanesh.daneshjooyarapp.R


class ModelVideoActivity(

) {







    var getVideo = arrayOf(
        ModelVideo(
            "۱. المنتور چیست؟ چرا باید از آن استفاده کنیم؟",

            R.raw.carton,
            0,

"0"
        ),
        ModelVideo(
            "۲.نصب و راه اندازی المنتور",
            R.raw.carton,
            1,
       "0"
        ),
        ModelVideo(
            "۳. افزایش محدوده حافظه Php در وردپرس",

            R.raw.php,
            2,
           "0"
        ),
        ModelVideo(
            "۴. بررسی کامل المنتور رایگان و قابلیت های آن",
            R.raw.site,
            3,
          "0"

        ),
        ModelVideo(
            "۵. نکات حیاتی در استفاده از افزونه های غیر رایگان",

            R.raw.insta,
            4,

            "0"
        ),


        )


}

data class ModelVideo(
    val title: String,
    val video: Int,
    val id: Int,
//    val duration: Int,  // کل زمان ویدیو
    var current: String

)





