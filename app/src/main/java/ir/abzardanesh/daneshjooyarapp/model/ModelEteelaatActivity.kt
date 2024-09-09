package ir.abzardanesh.daneshjooyarapp.model

import ir.abzardanesh.daneshjooyarapp.R

class ModelEteelaatActivity {


    val getLearn = arrayOf(
        ModelLearn(R.drawable.student,"تعداد دانشجو","۵۷,۷۰۳ نفر"),
        ModelLearn(R.drawable.score,"امتیاز دانشجویان","۴.۵ از ۵"),
        ModelLearn(R.drawable.course,"تعداد دوره ها","۲۶ عدد"),
        ModelLearn(R.drawable.timer,"ساعت آموزش","۶۹۷ ساعت"),
    )


    val getVideo = arrayOf(
        ModelGroupCourseVideoProperty("۱. المنتور چیست؟ چرا باید از آن استفاده کنیم؟",R.drawable.elimentor_small,1),
        ModelGroupCourseVideoProperty("۲.نصب و راه اندازی المنتور",R.drawable.elimentor_small,2),
        ModelGroupCourseVideoProperty("۳. افزایش محدوده حافظه Php در وردپرس",R.drawable.elimentor_small,3),
        ModelGroupCourseVideoProperty("۴. بررسی کامل المنتور رایگان و قابلیت های آن",R.drawable.elimentor_small,4),
        ModelGroupCourseVideoProperty("۵. نکات حیاتی در استفاده از افزونه های غیر رایگان",R.drawable.elimentor_small,6),
    )


}

data class ModelLearn(

    val imageUrl : Int,
    val title : String,
    val text : String
)

