package ir.abzardanesh.daneshjooyarapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import ir.abzardanesh.daneshjooyarapp.databinding.ActivitySplashBinding
import ir.abzardanesh.daneshjooyarapp.databinding.BottomSheetInternetBinding


@SuppressLint("CustomSplashScreen")

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )



        if (!isNetworkState()){
            sheetDialog()
        }else {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)

                finish()
            }, 5000)

        }


    }

    private fun sheetDialog() {
        val dialog = BottomSheetDialog(this)

// فایل xml طراحی شده
        val view = BottomSheetInternetBinding.inflate(layoutInflater)

// دو دکمه موجود در فایل xml
        view.btnMobile.setOnClickListener {
            startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
            this.recreate()
        }
        view.btnWifi.setOnClickListener {
            startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
            this.recreate();
        }

// اضافه کردن view به رابط کاربری
        dialog.setContentView(view.root)

// کاربر نمی‌تواند با ضربه زدن به بیرون از پنجره آن را ببندد.
        dialog.setCancelable(false)
        dialog.show()
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun isNetworkState(): Boolean {
        var result = false

        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            val netInfo = connectivityManager.activeNetworkInfo

            result = when (netInfo?.type) {
                ConnectivityManager.TYPE_WIFI -> true
                ConnectivityManager.TYPE_MOBILE -> true
                ConnectivityManager.TYPE_ETHERNET -> true
                else -> false
            }

        }



        return result
    }









}