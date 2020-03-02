package tang.chinwe.experiment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.ValueCallback
import android.webkit.WebView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONArray

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val view=HomeSiteGuidanceView(this,Pair(40f,40f))
        view_parent.addView(view)
        view_parent.postDelayed({view.startGuidance()},1000)
    }
}

class TestOb {

    @JavascriptInterface
    fun result(ob: Any?) {
        ob
    }
}
