package ir.abzardanesh.daneshjooyarapp.remote

import android.content.Context
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.abzardanesh.daneshjooyarapp.model.HelpModel
import ir.abzardanesh.daneshjooyarapp.model.ModelPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class ApiRepository private constructor() {

    companion object {
        private var apiRepository: ApiRepository? = null

        val instance: ApiRepository
            get() {
                if (apiRepository == null) apiRepository = ApiRepository()
                return apiRepository!!
            }
    }

    fun sendText(to: String, text: String, context: Context) {
        RetrofitService.apiService.sendTextToTelegram(to, text).enqueue(
            object : Callback<HelpModel> {
                override fun onResponse(call: Call<HelpModel>, response: Response<HelpModel>) {
                    val data = response.body() as HelpModel
                    if (text.isEmpty()) {
                        Toast.makeText(
                            context,
                            "لطفا دوباره تلاش کن",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "ارسال شد ... ممنون به زودی چک میشه",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }

                override fun onFailure(call: Call<HelpModel>, t: Throwable) {
                    Toast.makeText(
                        context,
                        "لطفا دوباره تلاش کن",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
        )

    }

    object SharedPreferences{
        fun savePreferences(context:Context,number: Long,id: Int) {
            val pref = context.getSharedPreferences("Pref", Context.MODE_PRIVATE)
            val edit = pref.edit()
            edit.putLong("Progress", number)
            edit.putInt("id", id)
            edit.apply()
        }



    }


}