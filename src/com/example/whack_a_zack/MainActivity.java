package com.example.whack_a_zack;

import com.example.whack_a_zack.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	// private static final int SELECT_PICTURE = 1;
	// private String selectedImagePath;
	// private String filemanagerstring;
	private int score = 0;
	private int time;
	// private int lives=3;
	private ImageButton hole1, hole2, hole3, hole4, hole5, hole6, hole7, hole8,
			hole9;
	private ImageButton[] holes = new ImageButton[9];
	private TextView timeText, scoreText;
	private Button startButton;
	private Boolean started = false;

	// private ImageView selectedImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		timeText = (EditText) (findViewById(R.id.time_count));
		startButton = (Button) (findViewById(R.id.start));
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startGame();
				started=true;
			}

		});
		scoreText = (EditText) (findViewById(R.id.EditText01));
		hole1 = (ImageButton) (findViewById(R.id.hole1));
		holes[0] = hole1;
		hole2 = (ImageButton) (findViewById(R.id.hole2));
		holes[1] = hole2;
		hole3 = (ImageButton) (findViewById(R.id.hole3));
		holes[2] = hole3;
		hole4 = (ImageButton) (findViewById(R.id.hole4));
		holes[3] = hole4;
		hole5 = (ImageButton) (findViewById(R.id.hole5));
		holes[4] = hole5;
		hole6 = (ImageButton) (findViewById(R.id.hole6));
		holes[5] = hole6;
		hole7 = (ImageButton) (findViewById(R.id.hole7));
		holes[6] = hole7;
		hole8 = (ImageButton) (findViewById(R.id.hole8));
		holes[7] = hole8;
		hole9 = (ImageButton) (findViewById(R.id.hole9));
		holes[8] = hole9;

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

	@Override
	public void onClick(View v) {
		score += 10;
		scoreText.setText(score + "");

	}

	/*
	 * public void setToFriendly(ImageButton b){
	 * //b.setImageDrawable(R.drawable.whackzack); b.setOnClickListener(new
	 * OnClickListener(){
	 * 
	 * @Override public void onClick(View v) { score-=10;
	 * scoreText.setText(score+"");
	 * 
	 * }
	 * 
	 * }); }
	 */
	public void setToEnemy(ImageButton b) {
		b.setOnClickListener(this);
	}

	public void startGame() {
		for (int i = 0; i <= 8; i++) {
			holes[i].setImageDrawable(null);
			holes[i].setOnClickListener(null);
		}
		long endTime = System.currentTimeMillis() + 1000;
		long updateTime;
		while (System.currentTimeMillis() < endTime) {
			timeText.setText((int) ((endTime - System.currentTimeMillis()) / 1000)
					+ "");
			int enemyHole = (int) (Math.random() * 9);
			setToEnemy(holes[enemyHole]);
			updateTime = System.currentTimeMillis() + 1000;
			while (System.currentTimeMillis() < updateTime)
				;
		}
	}

	public void playGame() {
		

	}
}
