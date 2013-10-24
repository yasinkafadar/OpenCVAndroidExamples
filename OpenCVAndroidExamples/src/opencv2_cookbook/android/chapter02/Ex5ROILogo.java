package opencv2_cookbook.android.chapter02;

import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_LOAD_IMAGE_GRAYSCALE;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_LOAD_IMAGE_COLOR;

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

public class Ex5ROILogo extends Activity implements OnClickListener {

	private static final int div = 8;
	
	private IplImage image = null;
	private IplImage logo = null;
	private IplImage mask = null;
	private ImageView imageView = null;
	private ImageView imageView2 = null;
	private ImageView resultImageView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ex4_blend_images);

		Button processImage = (Button) findViewById(R.id.process_image);
		processImage.setOnClickListener(this);
		processImage.setText("Watermark");

		imageView = (ImageView) findViewById(R.id.image);
		image = cvLoadImage(CommonUtilities.BOLDT_IMAGE, CV_LOAD_IMAGE_COLOR);
		imageView.setImageBitmap(Util.convertToBitmap(image));
		
		imageView2 = (ImageView) findViewById(R.id.image2);
		logo = cvLoadImage(CommonUtilities.LOGO_IMAGE, CV_LOAD_IMAGE_COLOR);
		imageView2.setImageBitmap(Util.convertToBitmap(logo));
		
		mask = cvLoadImage(CommonUtilities.LOGO_IMAGE, CV_LOAD_IMAGE_GRAYSCALE);
		
		resultImageView = (ImageView) findViewById(R.id.result_image);
	}
	
	@Override
	public void onClick(View v) {
		resultImageView.setImageBitmap(Util.convertToBitmap(watermarking()));
	}
	
	IplImage watermarking(){

		// Define region of interest that matches the size of the logo
		IplROI roi = new IplROI();
		roi.xOffset(385);
		roi.yOffset(270);
		roi.width(logo.width());
		roi.height(logo.height());
		
		IplImage imageROI = image.roi(roi);
		
		// Combine input image with the logo. Mask is used to control blending.
		cvCopy(logo, imageROI, mask);
		
		// Clear ROI after processing is done.
	    // If ROI is not cleared further operations would apply to ROI only.
	    // For instance, if saving the image, only part within the ROI would be saved.
	    image.roi(null);
		
		return image;
	}
}
