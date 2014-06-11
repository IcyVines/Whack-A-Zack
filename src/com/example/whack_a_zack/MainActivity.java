package com.example.whack_a_zack;

import com.example.whack_a_zack.R;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;
import android.provider.MediaStore;

public class MainActivity extends Activity implements OnClickListener{
	private static final int SELECT_PICTURE = 1;
	//private String selectedImagePath;
	//private String filemanagerstring;
	private ImageButton hole1,hole2,hole3,hole4,hole5,hole6,hole7,hole8,hole9;
	private ImageButton[] holes= new ImageButton[9];
	private Button start;
	private TextView timeText,scoreText;
	//private ImageView selectedImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		hole1= (ImageButton)(findViewById(R.id.hole1));
		holes[0]=hole1;
		hole2= (ImageButton)(findViewById(R.id.hole2));
		holes[1]=hole2;
		hole3= (ImageButton)(findViewById(R.id.hole3));
		holes[2]=hole3;
		hole4= (ImageButton)(findViewById(R.id.hole4));
		holes[3]=hole4;
		hole5= (ImageButton)(findViewById(R.id.hole5));
		holes[4]=hole5;
		hole6= (ImageButton)(findViewById(R.id.hole6));
		holes[5]=hole6;
		hole7= (ImageButton)(findViewById(R.id.hole7));
		holes[6]=hole7;
		hole8= (ImageButton)(findViewById(R.id.hole8));
		holes[7]=hole8;
		hole9= (ImageButton)(findViewById(R.id.hole9));
		holes[8]=hole9;
		for(ImageButton hole : holes){
			hole.setVisibility(2);
			hole.setClickable(false);
			hole.setOnClickListener(this);
		}
		timeText = (EditText)(findViewById(R.id.time_count));
		timeText.setText("" + 60);
		start = (Button)(findViewById(R.id.start));
		start.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.start){
			countDown();
		}
	}
	
	private void countDown(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timeText.setText(Integer.parseInt(timeText.getText().toString()) - 1 + "");
		if(!timeText.getText().toString().equals(0))
			countDown();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
