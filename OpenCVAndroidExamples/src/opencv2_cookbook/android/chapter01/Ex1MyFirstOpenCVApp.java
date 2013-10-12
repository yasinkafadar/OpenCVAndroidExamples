package opencv2_cookbook.android.chapter01;

import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import opencv2_cookbook.android.CommonUtilities;
import opencv2_cookbook.android.R;
import opencv2_cookbook.android.Util;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class Ex1MyFirstOpenCVApp extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ex1_my_first_open_cv_app);
		
		ImageView imageView = (ImageView) findViewById(R.id.image);
		IplImage image = cvLoadImage(CommonUtilities.BOLDT_IMAGE);
		Bitmap bitmap = Util.convertToBitmap(image);
		imageView.setImageBitmap(bitmap);
		
	}
}
