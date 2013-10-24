package opencv2_cookbook.android;

import opencv2_cookbook.android.chapter01.Ex1MyFirstOpenCVApp;
import opencv2_cookbook.android.chapter01.Ex2MyFirstGUIApp;
import opencv2_cookbook.android.chapter02.Ex1Salt;
import opencv2_cookbook.android.chapter02.Ex2ColorReduce;
import opencv2_cookbook.android.chapter02.Ex3Sharpen;
import opencv2_cookbook.android.chapter02.Ex4BlendImages;
import opencv2_cookbook.android.chapter02.Ex5ROILogo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.chapter1_Ex1MyFirstOpenCvApp:
			intent = new Intent(MainActivity.this, Ex1MyFirstOpenCVApp.class);
			break;
		case R.id.chapter1_Ex2MyFirstGUIApp:
			intent = new Intent(MainActivity.this, Ex2MyFirstGUIApp.class);
			break;
		case R.id.chapter2_Ex1Salt:
			intent = new Intent(MainActivity.this, Ex1Salt.class);
			break;
		case R.id.chapter2_Ex2ColorReduce:
			intent = new Intent(MainActivity.this, Ex2ColorReduce.class);
			break;
		case R.id.chapter2_Ex3Sharpen:
			intent = new Intent(MainActivity.this, Ex3Sharpen.class);
			break;
		case R.id.chapter2_Ex4BlendImages:
			intent = new Intent(MainActivity.this, Ex4BlendImages.class);
			break;
		case R.id.chapter2_Ex5ROILogo:
			intent = new Intent(MainActivity.this, Ex5ROILogo.class);
			break;
		default:
			break;
		}
		
		startActivity(intent);
	}

}
