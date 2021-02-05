package example.show.kclock

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.show.example.R
import com.show.kclock.*
import java.util.*
import kotlin.time.hours


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hour = MonthOfYear.February.days(2020)



    }
}