package ir.abzardanesh.daneshjooyarapp.model

import ir.abzardanesh.daneshjooyarapp.R


class ModelMainActivity() {

    val getGroup = arrayOf(
        ModelGroupCourseVideoProperty("طراحی سایت",R.drawable.site_vector,0),
        ModelGroupCourseVideoProperty("برنامه نویسی موبایل",R.drawable.mobile_img,1),
        ModelGroupCourseVideoProperty("هوش مصنوعی",R.drawable.ai_image,2),
        ModelGroupCourseVideoProperty("بازی سازی",R.drawable.ic_games,3),
        ModelGroupCourseVideoProperty("پایگاه داده",R.drawable.ic_and,4),
    )


    val getCourse = arrayOf(
        ModelGroupCourseVideoProperty("آموزش راه اندازی کسب و کار اینترنتی (رایگان و کاربردی)",R.drawable.elementorplus,0),
        ModelGroupCourseVideoProperty("دوره آموزش المنتور رایگان به همراه ۲ پروژه عملی",R.drawable.elementor,1),
        ModelGroupCourseVideoProperty("دوره جامع آموزش لینکدین",R.drawable.linkdin,2),
        ModelGroupCourseVideoProperty("دوره جامع مستر کدر پایتون",R.drawable.python,3),
    )


    val getLearnAbout = arrayOf(
        ModelLearn(R.drawable.count_user,"تعداد کاربران","+۴۰۰,۰۰۰"),
        ModelLearn(R.drawable.student,"تعداد مدرسین","+۵۰۰"),
        ModelLearn(R.drawable.count_view,"بازدید روزانه","+۲۵,۰۰۰"),
        ModelLearn(R.drawable.count_course,"تعداد دوره ها","+۲۰۰۰"),
    )

    val getProperty = arrayOf(
        ModelGroupCourseVideoProperty("مدرک دو زبانه",R.drawable.zaban,0),
        ModelGroupCourseVideoProperty("مدرسین مجرب",R.drawable.teacher,1),
        ModelGroupCourseVideoProperty("دورههای تخصص محور",R.drawable.course_master,2),
        ModelGroupCourseVideoProperty("خیریه آموزشی",R.drawable.khereh,3),
    )


}