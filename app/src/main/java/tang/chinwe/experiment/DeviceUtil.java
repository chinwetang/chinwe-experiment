package tang.chinwe.experiment;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;


/**
 * Created by KevenFong on 2015/6/10.
 */
public class DeviceUtil {

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics outMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(outMetrics);
            return outMetrics.widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics outMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(outMetrics);
            return outMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
