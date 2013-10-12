package opencv2_cookbook.android;

import opencv2_cookbook.android.chapter01.Ex1MyFirstOpenCVApp;
import opencv2_cookbook.android.chapter01.Ex2MyFirstGUIApp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button chapter1_Ex1MyFirstOpenCvApp = (Button) findViewById(R.id.chapter1_Ex1MyFirstOpenCvApp);
		chapter1_Ex1MyFirstOpenCvApp.setOnClickListener(this);
		Button chapter1_Ex2MyFirstGUIApp = (Button) findViewById(R.id.chapter1_Ex2MyFirstGUIApp);
		chapter1_Ex2MyFirstGUIApp.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.chapter1_Ex1MyFirstOpenCvApp:
			intent = new Intent(MainActivity.this, Ex1MyFirstOpenCVApp.class);
			break;
		case R.id.chapter1_Ex2MyFirstGUIApp:
			intent = new Intent(MainActivity.this, Ex2MyFirstGUIApp.class);
		default:
			break;
		}
		
		startActivity(intent);
	}

}
