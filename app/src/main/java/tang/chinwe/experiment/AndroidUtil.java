package tang.chinwe.experiment;

import android.content.Context;
public class AndroidUtil {


    public static int dpToPx(float dp, Context context) {
        return (int) (context.getResources().getDisplayMetrics().density * dp + 0.5f);
    }

    public static float spToPx(float sp, Context context) {
        return (context.getResources().getDisplayMetrics().density * sp + 0.5f);
    }

}
