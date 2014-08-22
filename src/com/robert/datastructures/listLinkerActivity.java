package com.robert.datastructures;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class listLinkerActivity extends Activity{
	
	final int STARTUP_STATE = -1;
	int[] list = new int[8];
	int currentIndex = STARTUP_STATE;
	int currentId;
	int listColorId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_linker);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		createArray();
	}
	
	public void createArray(){
		int value = R.id.button11;
		for(int i = 0;i<8;i++){
			list[i]= (int) (Math.random()*10);
			Button button = (Button) findViewById(value);
			button.setText(list[i]+"");
			value++;
		}
	}
	
	public void nextIteration(View view){
		if(view.getId()==(currentId+1)){
			currentIndex++;
			currentId++;
			update();
		}
	}
	
	public void gameWon(){
		Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
		for(int id = R.id.button11; id<R.id.button24+1;id++){
			findViewById(id).setBackgroundResource(listColorId);
		}
	}
	
	public void update(){
		findViewById(currentId-1).setBackgroundResource(listColorId);
		findViewById(currentId).setBackgroundResource(R.drawable.circle_highlighted);
	}

	public void onClick(View view){
		switch(currentIndex){
		case STARTUP_STATE:
			if(view==findViewById(R.id.button11)){
				currentIndex=0;
				currentId=view.getId();
				listColorId = R.drawable.circle;
				view.setBackgroundResource(R.drawable.circle_highlighted);
			} else if(view==findViewById(R.id.button21)){
				currentIndex=4;
				currentId=view.getId();
				listColorId = R.drawable.alt_circle;
				view.setBackgroundResource(R.drawable.circle_highlighted);
			}
			break;
		case 3:
			if(view.getId()==R.id.button21){
				gameWon();
			}
			break;
		case 7:
			if(view.getId()==R.id.button11){
				gameWon();
			}
		default:
			if(view.getId()==(currentId+1)){
				nextIteration(view);
			}
			break;
		}

	}

}
