package tang.chinwe.experiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import tang.chinwe.mylibrary.R
import kotlin.concurrent.thread

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        thread {
//
//        }
//        runBlocking {
//        }
        val jsonArray = JSONArray()
        jsonArray.put("https://v.starhalo.mobi/user/avatar/30/88/89713088.jpg")
        println(jsonArray.toString())
    }
}
