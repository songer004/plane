package song.tiaofeiji.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Common {
	private static int Sw = 0; // 屏幕宽度
	private static int Sh = 0; // 屏幕高度
	private static float Sd = 0; // 屏幕分辨率

	// 获取屏幕宽度
	public static int GetW(Context context) {
		if (Sw == 0) {
			DisplayMetrics dm = new DisplayMetrics();
			WindowManager wMgr = (WindowManager) context
					.getSystemService(Context.WINDOW_SERVICE);
			wMgr.getDefaultDisplay().getMetrics(dm);
			Sw = dm.widthPixels;
		}
		return Sw;
	}

	// 获取屏幕高度
	public static int GetH(Context context) {
		if (Sh == 0) {
			DisplayMetrics dm = new DisplayMetrics();
			WindowManager wMgr = (WindowManager) context
					.getSystemService(Context.WINDOW_SERVICE);
			wMgr.getDefaultDisplay().getMetrics(dm);
			Sh = dm.heightPixels;
		}
		return Sh;
	}

	// 获取屏幕分辨率
	public static float GetD(Context context) {
		if (Sd == 0) {
			DisplayMetrics dm = new DisplayMetrics();
			WindowManager wMgr = (WindowManager) context
					.getSystemService(Context.WINDOW_SERVICE);
			wMgr.getDefaultDisplay().getMetrics(dm);
			Sd = dm.density;
		}
		return Sd;
	}
}
