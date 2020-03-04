package tang.chinwe.experiment

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.JavascriptInterface
import com.nemo.vidmate.ui.youtube.home.DefaultAnimatorListener
import com.nemo.vidmate.ui.youtube.home.HomeSiteGuidanceView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val view= HomeSiteGuidanceView(this, intArrayOf(600,400))
        view_parent.addView(view)
        view_parent.postDelayed({view.startGuidance(object :DefaultAnimatorListener(){
            override fun onAnimationEnd(animation: Animator?) {

            }
        }, View.OnClickListener {

        })},1000)
    }
}

class TestOb {

    @JavascriptInterface
    fun result(ob: Any?) {
        ob
    }
}
