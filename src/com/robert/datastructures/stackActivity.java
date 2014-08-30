package com.robert.datastructures;

import java.util.Random;

import structures.Stack;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class stackActivity extends Activity {
	
	int state;
	Stack stack;
	int currentIndex = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stack);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setStack();
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

	public void setStack(){
		stack = new Stack(true);
	}

	public void onPushClick(View view){
		if(currentIndex<5){
			Random rand = new Random();
			int num = rand.nextInt(10);
			stack.push(num);
			findViewById(R.id.imageView1+currentIndex).setBackgroundResource(R.drawable.circle_0+num);
			currentIndex++;
		} else {
			Toast.makeText(this, "Overflow", Toast.LENGTH_SHORT).show();
		}
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public void onPopClick(View view){
		if(currentIndex>0){
			if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
				findViewById(R.id.imageView1+currentIndex-1).setBackground(null);
			} else {
				findViewById(R.id.imageView1+currentIndex-1).setBackgroundDrawable(null);
			}
			stack.pop();
			currentIndex--;
		} else {
			Toast.makeText(this, "Underflow", Toast.LENGTH_SHORT).show();
		}
	}


}
