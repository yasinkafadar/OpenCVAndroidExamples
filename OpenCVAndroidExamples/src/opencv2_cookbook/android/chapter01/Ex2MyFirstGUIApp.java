package opencv2_cookbook.android.chapter01;

import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import opencv2_cookbook.android.CommonUtilities;
import opencv2_cookbook.android.R;
import opencv2_cookbook.android.Util;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2RGB;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;

public class Ex2MyFirstGUIApp extends Activity implements OnClickListener {

	private IplImage image = null;
	private ImageView imageView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ex2_my_first_gui_app);

		Button processImage = (Button) findViewById(R.id.process_image);
		processImage.setOnClickListener(this);

		imageView = (ImageView) findViewById(R.id.image);
		image = cvLoadImage(CommonUtilities.BOLDT_IMAGE);
		imageView.setImageBitmap(Util.convertToBitmap(image));
	}

	@Override
	public void onClick(View v) {
		// Flip upside down
		cvFlip(image, image, 0);
		// Swap red and blue channels
		cvCvtColor(image, image, CV_BGR2RGB);
		
		imageView.setImageBitmap(Util.convertToBitmap(image));
	}
}
