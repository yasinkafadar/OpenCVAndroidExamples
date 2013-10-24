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

public class Ex4BlendImages extends Activity implements OnClickListener {

	private static final int div = 8;
	
	private IplImage image = null;
	private IplImage image2 = null;
	private ImageView imageView = null;
	private ImageView imageView2 = null;
	private ImageView resultImageView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ex4_blend_images);

		Button processImage = (Button) findViewById(R.id.process_image);
		processImage.setOnClickListener(this);

		imageView = (ImageView) findViewById(R.id.image);
		image = cvLoadImage(CommonUtilities.BOLDT_IMAGE);
		imageView.setImageBitmap(Util.convertToBitmap(image));
		
		imageView2 = (ImageView) findViewById(R.id.image2);
		image2 = cvLoadImage(CommonUtilities.RAIN_IMAGE);
		imageView2.setImageBitmap(Util.convertToBitmap(image2));
		
		resultImageView = (ImageView) findViewById(R.id.result_image);
	}
	
	@Override
	public void onClick(View v) {
		resultImageView.setImageBitmap(Util.convertToBitmap(sharpening()));
	}
	
	IplImage sharpening(){

		// Define output image
		IplImage result = cvCreateImage(cvGetSize(image), image.depth(), 3);
		
		// Create blended image
		cvAddWeighted(image, 0.7, image2, 0.9, 0.0, result);
		
		return result;
	}
}
