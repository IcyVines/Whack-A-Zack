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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.os.Build;
import android.provider.MediaStore;

public class MainActivity extends Activity implements OnClickListener{
	private static final int SELECT_PICTURE = 1;
	//private String selectedImagePath;
	//private String filemanagerstring;
	private ImageButton hole1,hole2,hole3,hole4,hole5,hole6,hole7,hole8,hole9;
	private ImageButton[] holes= new ImageButton[9];
	private EditText timeText,scoreText;
	//private ImageView selectedImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		hole1= (ImageButton)(findViewById(R.id.hole1));
		hole1.setOnClickListener(this);
		hole2= (ImageButton)(findViewById(R.id.hole2));
		hole2.setOnClickListener(this);
		hole3= (ImageButton)(findViewById(R.id.hole3));
		hole3.setOnClickListener(this);
		hole4= (ImageButton)(findViewById(R.id.hole4));
		hole4.setOnClickListener(this);
		hole5= (ImageButton)(findViewById(R.id.hole5));
		hole5.setOnClickListener(this);
		hole6= (ImageButton)(findViewById(R.id.hole6));
		hole6.setOnClickListener(this);
		hole7= (ImageButton)(findViewById(R.id.hole7));
		hole7.setOnClickListener(this);
		hole8= (ImageButton)(findViewById(R.id.hole8));
		hole8.setOnClickListener(this);
		hole9= (ImageButton)(findViewById(R.id.hole9));
		hole9.setOnClickListener(this);
	
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
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

	@Override
	public void onClick(View v) {
		
		
	}

}
