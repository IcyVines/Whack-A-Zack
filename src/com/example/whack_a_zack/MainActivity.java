package com.example.whack_a_zack;

import com.example.whack_a_zack.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;




//import android.widget.ImageView;
import android.widget.TextView;
//import android.os.Build;
//import android.provider.MediaStore;
//import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	// private static final int SELECT_PICTURE = 1;
	// private String selectedImagePath;
	// private String filemanagerstring;
	private int score = 0;
	private int time = 30;
	private int wait = 500, disappear = 5000, limit = 0;
	private Boolean clicked = false;
	private int lives = 2;
	private ImageButton hole1, hole2, hole3, hole4, hole5, hole6, hole7, hole8, hole9;
	private ImageButton[] holes = new ImageButton[9];
	private TextView timeText, scoreText, lifeText;
	private Button startButton;
	Timer timer, newEnemy;
	private int enemyHole = 0;
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
			}

		});

		scoreText = (EditText)(findViewById(R.id.EditText01));
		timeText = (EditText)(findViewById(R.id.time_count));
		lifeText = (EditText)(findViewById(R.id.life_count));
		
		holes[0] = hole1 = (ImageButton)(findViewById(R.id.hole1));
		holes[1] = hole2 = (ImageButton)(findViewById(R.id.hole2));
		holes[2] = hole3 = (ImageButton)(findViewById(R.id.hole3));
		holes[3] = hole4 = (ImageButton)(findViewById(R.id.hole4));
		holes[4] = hole5 = (ImageButton)(findViewById(R.id.hole5));
		holes[5] = hole6 = (ImageButton)(findViewById(R.id.hole6));
		holes[6] = hole7 = (ImageButton)(findViewById(R.id.hole7));
		holes[7] = hole8 = (ImageButton)(findViewById(R.id.hole8));
		holes[8] = hole9 = (ImageButton)(findViewById(R.id.hole9));

		for (int i = 0; i <= 8; i++) {
			holes[i].setImageDrawable(null);
			holes[i].setOnClickListener(null);
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
	
	@Override
	public void onClick(View v) {
		this.clicked = true;
		score += 10;
		scoreText.setText(score + "");
		removeEnemy();		
	}
	
	public void removeEnemy(){
		holes[enemyHole].setOnClickListener(null);
		holes[enemyHole].setImageDrawable(null);
	}
	
	public void waitFor(){
		newEnemy.cancel();
		newEnemy.purge();
		newEnemy = new Timer();
		newEnemy.schedule(new TimerTask() {
		 @Override
		 public void run(){
			 MainActivity.this.runOnUiThread(new Runnable(){
				 public void run(){
					 wait -= 10;
					 getEnemy();
				 }
			 });
		 }
	 }, wait);
	}
	
	public void loseLife(){
		lifeText.setText(lives-- + "");
		if(lives < 0){
			newEnemy.cancel();
			newEnemy.purge();
			restartGame();
		}
	}
	
	public void getEnemy(){
		int enemyHole = (int) (Math.random() * 9);
		this.enemyHole = enemyHole;
		setToEnemy(holes[enemyHole]);
	}
	
	public void setToEnemy(ImageButton b) {
		b.setImageResource(R.drawable.whackzack);
		b.setOnClickListener(this);
		newEnemy.cancel();
		newEnemy.purge();
		newEnemy = new Timer();
		newEnemy.schedule(new TimerTask() {
			@Override
			public void run(){
				MainActivity.this.runOnUiThread(new Runnable(){ 
					@Override
					public void run(){
						if(MainActivity.this.clicked){
							MainActivity.this.clicked = false;
							limit = 0;
							disappear *= .95;
							waitFor();
						} else {
							if(limit >= disappear){
								if(lives == 0){
									limit = 0;
									disappear = 5000;
									loseLife();
								} else {
									loseLife();
									disappear *= .90;
									limit = 0;
									removeEnemy();
									waitFor();
								}
							} else {
								limit += 100;
							}
						}	
					}
				});
			}
		}, 0, 100);
	}
	
	public void startGame(){
		//startButton.setVisibility(startButton.INVISIBLE);
		startButton.setText("Stop Playing");
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				restartGame();
			}

		});
		timer = new Timer();
		timer.schedule(new UpdateTimer(), 1000, 1000);
		newEnemy = new Timer();
		waitFor();
	}
	
	class UpdateTimer extends TimerTask{
		
		@Override
		public void run(){
			MainActivity.this.runOnUiThread(new Runnable() {
				@Override
				public void run(){
					timeText.setText(--time + "");
					if(time == 0){
						scoreBoard();
						restartGame();
					}
				}
			});	
		}
	}

	public void scoreBoard(){
		
	}
	
	public void restartGame() {
		timer.cancel();
		timer.purge();
		newEnemy.cancel();
		newEnemy.purge();
		//startButton.setVisibility(startButton.VISIBLE);
		startButton.setText("Start Whacking");
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startGame();
			}

		});
		timer.cancel();
		timer.purge();
		newEnemy.cancel();
		newEnemy.purge();
		for (int i = 0; i <= 8; i++) {
			holes[i].setImageDrawable(null);
			holes[i].setOnClickListener(null);
		}
		timeText.setText(30 + "");
		time = 30;
		score = 0;
		lifeText.setText(3 + "");
		lives = 2;
		scoreText.setText(0 + "");
	}

	public void onDestroy(){
		super.onDestroy();
		timer.cancel();
		newEnemy.cancel();
	}
}
