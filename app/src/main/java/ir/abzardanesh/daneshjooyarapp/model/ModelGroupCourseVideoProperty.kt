package ir.abzardanesh.daneshjooyarapp.model

/*
  Group -> طراحی سایت و برنامه نویسی موبایل وهوش مصنوعی در صفحه اول هست
  Course -> دوره  هایی که در صفحه اول هست
  Video -> بعد از اینکه دوره رو میزنیم اطلاعات و بعدش ویدیو بالا میاد

 */
data class ModelGroupCourseVideoProperty(
    val title: String,
    val imageUrl: Int,
    val id: Int

)