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
import android.text.format.Time;



public class MainActivity extends Activity implements OnClickListener{
	//private static final int SELECT_PICTURE = 1;
	//private String selectedImagePath;
	//private String filemanagerstring;
	private int score=0;
	private int time;
	//private int lives=3;
	private ImageButton hole1,hole2,hole3,hole4,hole5,hole6,hole7,hole8,hole9;
	private ImageButton[] holes= new ImageButton[9];
	private TextView timeText,scoreText;
	private Button startButton;
	//private ImageView selectedImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		timeText= (EditText)(findViewById(R.id.time_count));
		startButton= (Button)(findViewById(R.id.start));
		startButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
			
					playGame();
				
			}
			
		});
		scoreText= (EditText)(findViewById(R.id.EditText01));
		hole1= (ImageButton)(findViewById(R.id.hole1));
		//hole1.setOnClickListener(this);
		holes[0]=hole1;
		hole2= (ImageButton)(findViewById(R.id.hole2));
		//hole2.setOnClickListener(this);
		holes[1]=hole2;
		hole3= (ImageButton)(findViewById(R.id.hole3));
		//hole3.setOnClickListener(this);
		holes[2]=hole3;
		hole4= (ImageButton)(findViewById(R.id.hole4));
		//hole4.setOnClickListener(this);
		holes[3]=hole4;
		hole5= (ImageButton)(findViewById(R.id.hole5));
		//hole5.setOnClickListener(this);
		holes[4]=hole5;
		hole6= (ImageButton)(findViewById(R.id.hole6));
		//hole6.setOnClickListener(this);
		holes[5]=hole6;
		hole7= (ImageButton)(findViewById(R.id.hole7));
		//hole7.setOnClickListener(this);
		holes[6]=hole7;
		hole8= (ImageButton)(findViewById(R.id.hole8));
		//hole8.setOnClickListener(this);
		holes[7]=hole8;
		hole9= (ImageButton)(findViewById(R.id.hole9));
		//hole9.setOnClickListener(this);
		holes[8]=hole9;
	
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
		score+=10;
		scoreText.setText(score+"");
		
	}
	public void setToFriendly(ImageButton b){
		//b.setImageDrawable(R.drawable.whackzack);
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				score-=10;
				scoreText.setText(score+"");
				
			}
			
		});
	}
	public void setToEnemy(ImageButton b){
		b.setOnClickListener(this);			
	}
	public void playGame() {
		for(int i=0;i<=8;i++){
			holes[i].setImageDrawable(null);
		}
		long endTime= System.currentTimeMillis()+30000;
		while (true){
			timeText.setText((endTime-System.currentTimeMillis())/1000+"");
			if(System.currentTimeMillis()>endTime){
				break;
			}
			int enemyHole= (int)(Math.random()*9);
			int friendlyHole;
			do {
				friendlyHole = (int)(Math.random()*9);
			}while(friendlyHole!=enemyHole);
			setToEnemy(holes[enemyHole]);	
			setToFriendly(holes[friendlyHole]);
			//Thread.sleep(1000);
		}
	}
}
