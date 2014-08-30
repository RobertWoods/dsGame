package com.robert.datastructures;

import structures.Hash;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class hashInsertionActivity extends Activity {
	
	Hash hash;
	int winCounter = 0;
	int[] table;
	int currentNumber;
	int currentIndex = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertion);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		gameSetUp();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case android.R.id.home:
	        this.finish();
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	private void gameSetUp(){
		setHash();
		setText();
	}
	
	public String getInstructions(){
		String instr = "Add the following sequence to the hash table with hash function x*"+hash.hash+"%8";
		return instr;
	}
	
	private void setHash(){
		hash = new Hash(8);
		hash.setEntries();
		hash.addNextEntry();
		table = hash.unhashedTable;
		currentNumber = table[currentIndex];
		currentIndex++;
	}
	
	public void onButtonClick(View view){
		//Check current number against what number is in the table at that position
		//Show number and increment winCounter if correct
		if(winCounter>7){
			return;
		}
		Button button;
		int id = view.getId();
		switch (id) {
		case R.id.button1:
			if(hash.get(0)==currentNumber){
				winCounter++;
				button = (Button) view;
				button.setText(""+hash.get(0));
				updateGame();
			} else {
				Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button2:
			if(hash.get(1)==currentNumber){
				winCounter++;
				button = (Button) view;
				button.setText(""+hash.get(1));
				updateGame();
			} else {
				Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button3:
			if(hash.get(2)==currentNumber){
				winCounter++;
				button = (Button) view;
				button.setText(""+hash.get(2));
				updateGame();
			} else {
				Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button4:
			if(hash.get(3)==currentNumber){
				winCounter++;
				button = (Button) view;
				button.setText(""+hash.get(3));
				updateGame();
			} else {
				Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button5:
			if(hash.get(4)==currentNumber){
				winCounter++;
				button = (Button) view;
				button.setText(""+hash.get(4));
				updateGame();
			} else {
				Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button6:
			if(hash.get(5)==currentNumber){
				winCounter++;
				button = (Button) view;
				button.setText(""+hash.get(5));
				updateGame();
			} else {
				Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button7:
			if(hash.get(6)==currentNumber){
				winCounter++;
				button = (Button) view;
				button.setText(""+hash.get(6));
				updateGame();
			} else {
				Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button8:
			if(hash.get(7)==currentNumber){
				winCounter++;
				button = (Button) view;
				button.setText(""+hash.get(7));
				updateGame();
			} else {
				Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
	}
	
	public void updateIndex(){
		currentNumber=table[currentIndex];
		currentIndex++;
	}
	
	public void updateGame(){
		if(winCounter>=8){
			Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
		} else {
			hash.addNextEntry();
			updateIndex();
			updateText();
		}
	}
	
	private void setText(){
		TextView numberText = (TextView) findViewById(R.id.textView2);
		numberText.setText(getNumberSequence());
		TextView instrText = (TextView) findViewById(R.id.textView1);
		instrText.setText(getInstructions());
	}
	
	private void updateText(){
		TextView numberText = (TextView) findViewById(R.id.textView2);
		numberText.setText(getNumberSequence());
	}
	
	public String getNumberSequence(){
		return "Place the following into the table: " + currentNumber;
	}

}
