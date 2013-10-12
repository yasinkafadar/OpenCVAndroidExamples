package opencv2_cookbook.android;

import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2RGBA;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;

import com.googlecode.javacv.cpp.opencv_core.IplImage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;

public class Util {

	private static final String TAG = "Util";
	
	public static Bitmap convertToBitmap(IplImage image){
		Log.i(TAG, "convertToBitmap");
		IplImage newImage = IplImage.create(image.width(), image.height(), IPL_DEPTH_8U, 4);
		cvCvtColor(image, newImage, CV_BGR2RGBA);
		Bitmap b = Bitmap.createBitmap(newImage.width(), newImage.height(), Config.ARGB_8888);
		b.copyPixelsFromBuffer(newImage.getByteBuffer());
		return b;
	}
}
