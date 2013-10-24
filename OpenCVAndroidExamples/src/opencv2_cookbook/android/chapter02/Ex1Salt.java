package opencv2_cookbook.android.chapter02;

import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2RGB;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;

import java.util.Random;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

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

public class Ex1Salt extends Activity implements OnClickListener {

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
		imageView.setImageBitmap(Util.convertToBitmap(salt(2000)));
	}
	
	/**
     * Add 'salt' noise.
     * @param n number of 'salt' grains.
     */
	IplImage salt(int grainSize){
		// Place 'n' white spots at random locations
		int size = image.width() * image.height();
		int channels = image.nChannels();
		
		Random random = new Random();
		for (int i = 0; i < grainSize; i++) {
			// Create random index of a pixel
			int index = random.nextInt(size);
			int offset = index * channels;
			// Set it to white by setting each of the channels to max (255)
			for (int j = 0; j < channels; j++) {
				image.getByteBuffer().put(offset + j, (byte)255);
			}
		}
		
		return image;
	}
}
