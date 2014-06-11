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
<<<<<<< HEAD
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;
import android.provider.MediaStore;
=======
import android.widget.TextView;
import android.text.format.Time;


>>>>>>> e3f68022f777581da57311725746d1dee658a5af

public class MainActivity extends Activity implements OnClickListener{
	//private static final int SELECT_PICTURE = 1;
	//private String selectedImagePath;
	//private String filemanagerstring;
	private int score=0;
	private int time;
	//private int lives=3;
	private ImageButton hole1,hole2,hole3,hole4,hole5,hole6,hole7,hole8,hole9;
	private ImageButton[] holes= new ImageButton[9];
<<<<<<< HEAD
	private Button start;
	private TextView timeText,scoreText;
=======
	private TextView timeText,scoreText;
	private Button startButton;
>>>>>>> e3f68022f777581da57311725746d1dee658a5af
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
<<<<<<< HEAD
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
=======
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
>>>>>>> e3f68022f777581da57311725746d1dee658a5af
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


<<<<<<< HEAD
=======
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
>>>>>>> e3f68022f777581da57311725746d1dee658a5af
}
