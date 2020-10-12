package example.show.kclock

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.show.example.R
import com.show.kclock.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val date1 = "2020-10-12 11:09:48".deFormat()


        Log.e("2222222","$date1")



    }
}