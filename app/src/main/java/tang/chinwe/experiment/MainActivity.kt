package tang.chinwe.experiment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View

fun log(str: String) {
    Log.d(MainActivity::class.java.name, str)
}


class MainActivity : AppCompatActivity() {

    private fun getInternalDimensionSize(context: Context, key: String): Int {
        val result = 0
        try {
            val resourceId = Resources.getSystem().getIdentifier(key, "dimen", "android")
            if (resourceId > 0) {
                val sizeOne = context.resources.getDimensionPixelSize(resourceId)
                val sizeTwo = Resources.getSystem().getDimensionPixelSize(resourceId)

                if (sizeTwo >= sizeOne) {
                    return sizeTwo
                } else {
                    val densityOne = context.resources.displayMetrics.density
                    val densityTwo = Resources.getSystem().displayMetrics.density
                    return Math.round(sizeOne * densityTwo / densityOne)
                }
            }
        } catch (ignored: Resources.NotFoundException) {
            return 0
        }

        return result
    }

    val IMMERSION_STATUS_BAR_HEIGHT = "status_bar_height"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskId
        log("onCreate")

//        mStatusBarHeight = getInternalDimensionSize(this, IMMERSION_STATUS_BAR_HEIGHT)

        log("状态栏高度" + getInternalDimensionSize(this, "status_bar_height"))

        // 通过WindowManager获取
        val dm = DisplayMetrics()
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        System.out.println("width-display :" + dm.widthPixels);
        System.out.println("heigth-display :" + dm.heightPixels);


        log("通过WindowManager获取" + "width-display :" + dm.widthPixels + "heigth-display :" + dm.heightPixels)

// 通过Resources获取
        val dm2 = getResources ().getDisplayMetrics();
        System.out.println("width-display :" + dm2.widthPixels);
        System.out.println("heigth-display :" + dm2.heightPixels);


        log("通过Resources获取" + "width-display :" + dm2.widthPixels + "heigth-display :" + dm2.heightPixels)

// 获取屏幕的默认分辨率
        val display = getWindowManager ().getDefaultDisplay();
        System.out.println("width-display :" + display.getWidth());
        System.out.println("heigth-display :" + display.getHeight());


        log("获取屏幕的默认分辨率" + "width-display :" + display.width + "heigth-display :" + display.height)


    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        log("onConfigurationChanged${resources.displayMetrics.density}")
    }

    @SuppressLint("MissingSuperCall")
    override fun onNewIntent(intent: Intent?) {
        log("onNewIntent")
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    override fun onStart() {
        super.onStart()
        log("onStart")
    }

    override fun onPause() {
        super.onPause()
        log("onPause")
    }

    override fun onStop() {
        super.onStop()
        log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        taskId
        log("onDestroy")
    }

    fun clickTop(v: View) {
        Log.d("test", "clickTop")
    }

    fun clickBottom(v: View) {
        Log.d("test", "clickBottom")
    }

    fun clickNext(v: View) {
        startActivity(Intent(this, Main3Activity::class.java))
    }


}
