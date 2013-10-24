package opencv2_cookbook.android.chapter02;

import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_legacy.*;

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

public class Ex2ColorReduce extends Activity implements OnClickListener {

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
		imageView.setImageBitmap(Util.convertToBitmap(colorReduce()));
	}
	
	IplImage colorReduce(){
		int nbElements = image.width() * image.height() * image.nChannels() / 2;
		Log.i("nbElement size", "" + nbElements);
		for (int i = 0; i < nbElements - 4; i++) {
			int v = image.getByteBuffer(i).getInt();
			Log.i("byte value", "i:" + i + " value:"  + v);
			int newV = v / div * div + div / 2;
			Log.i("new byte value", "i:" + i + " value:" + newV);
			image.getByteBuffer().put(i, (byte)newV);
		}
		return image;
	}
}
