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


        Log.e("TestUtil"," now time : ${(System.currentTimeMillis() + 1603262409622).dateTime.format(yyyy_MM_dd_HHmmss)}")

    }
}