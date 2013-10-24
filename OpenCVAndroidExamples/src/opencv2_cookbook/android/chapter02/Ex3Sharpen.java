package opencv2_cookbook.android.chapter02;

import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_legacy.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;

import opencv2_cookbook.android.CommonUtilities;
import opencv2_cookbook.android.R;
import opencv2_cookbook.android.Util;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Ex3Sharpen extends Activity implements OnClickListener {

	private static final int div = 8;
	
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
		imageView.setImageBitmap(Util.convertToBitmap(sharpening()));
	}
	
	IplImage sharpening(){

		IplImage dest = cvCreateImage(cvGetSize(image), image.depth(), 3);
		CvMat kernel = CvMat.create(3, 3, CV_32F);
		kernel.put(1, 1, 5);
	    kernel.put(0, 1, -1);
	    kernel.put(2, 1, -1);
	    kernel.put(1, 0, -1);
	    kernel.put(1, 2, -1);

	 	// Filter the image
	    filter2D(image, dest, -1, kernel, new CvPoint(-1, -1), 0, BORDER_DEFAULT);
		
		return dest;
	}
}
