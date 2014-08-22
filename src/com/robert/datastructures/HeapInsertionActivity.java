package com.robert.datastructures;

import structures.Heap;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class HeapInsertionActivity extends Activity {

	Heap heap = new Heap();
	final int DELETING = 0;
	final int REPLACING = 1;
	final int BUBBLING = 2;
	final int GAME_WON = 3;
	Button currentElement;
	int state = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_heap_deletion);
		heapSetup();
		setInstr();
		currentElement = (Button) findViewById(R.id.nodeDepth0);
	}

	public void heapSetup(){
		heap.buildHeap(7);
		drawTree();
	}

	public void drawTree(){
		Button button = (Button) findViewById(R.id.nodeDepth0);
		button.setText(""+heap.array[0]);
		button = (Button) findViewById(R.id.nodeDepth11);
		button.setText(""+heap.array[1]);
		button = (Button) findViewById(R.id.nodeDepth12);
		button.setText(""+heap.array[2]);
		button = (Button) findViewById(R.id.nodeDepth21);
		button.setText(""+heap.array[3]);
		button = (Button) findViewById(R.id.nodeDepth22);
		button.setText(""+heap.array[4]);
		button = (Button) findViewById(R.id.nodeDepth23);
		button.setText(""+heap.array[5]);
		button = (Button) findViewById(R.id.nodeDepth24);
		button.setText(""+heap.array[6]);
	}

	public void setInstr(){
		TextView text = (TextView) findViewById(R.id.textInstructions);
		switch(state){
		case(DELETING):
			text.setText("Delete the first element from the Heap."+"\n\n");
		break;
		case(REPLACING):
			text.setText(text.getText().toString().replaceFirst("\n", "\nChoose an element to replace the deleted element.")+" ");
		break;
		case(BUBBLING):
			text.setText(text.getText().toString().replaceFirst("\n ","\nBubble the element down."));
		break;
		case(GAME_WON):
			Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
		break;
		}
	}

	public void onClick(View view){
		switch(state){
		case(DELETING):
			if(view.getId()==R.id.nodeDepth0){
				Button button1 = (Button) view;
				button1.setText("");
				state=REPLACING;
				setInstr();
			}
		break;
		case(REPLACING):
			if(view.getId()==R.id.nodeDepth24){
				Button button1 = (Button) view;
				Button button2 = (Button) findViewById(R.id.nodeDepth0);
				button2.setText(button1.getText());
				button1.setText("");
				state=BUBBLING;
				currentElement = button2;
				setInstr();
				findViewById(R.id.nodeDepth0).setBackgroundResource(R.drawable.circle_highlighted);
				view.setVisibility(View.INVISIBLE);
				if(isValid()){
					state=GAME_WON;
					setInstr();
				}
			}
		
		break;
		case(BUBBLING):
			if(currentElement==findViewById(R.id.nodeDepth0)){
				Button button = (Button) view;
				if((view == findViewById(R.id.nodeDepth11) || view == findViewById(R.id.nodeDepth12)) && Integer.parseInt((String) button.getText())<Integer.parseInt((String) currentElement.getText())){
					CharSequence temp =  button.getText();
					button.setText(currentElement.getText());
					currentElement.setText(temp);
					//Makes visual distinction for currentElement change
					currentElement.setBackgroundResource(R.drawable.circle);
					currentElement = getActiveButton();
					currentElement.setBackgroundResource(R.drawable.circle_highlighted);
				}
			} else if(currentElement==findViewById(R.id.nodeDepth11)){
				Button button = (Button) view;
				if((view == findViewById(R.id.nodeDepth21) || view == findViewById(R.id.nodeDepth22)) && Integer.parseInt((String) button.getText())<Integer.parseInt((String) currentElement.getText())){
					CharSequence temp =  button.getText();
					button.setText(currentElement.getText());
					currentElement.setText(temp);
					//Makes visual distinction for currentElement change
					currentElement.setBackgroundResource(R.drawable.circle);
					currentElement = getActiveButton();
					currentElement.setBackgroundResource(R.drawable.circle_highlighted);
				}
			} else if(currentElement==findViewById(R.id.nodeDepth12)){
				Button button = (Button) view;
				if((view == findViewById(R.id.nodeDepth23) || view == findViewById(R.id.nodeDepth24)) && Integer.parseInt((String) button.getText())<Integer.parseInt((String) currentElement.getText())){
					CharSequence temp =  button.getText();
					button.setText(currentElement.getText());
					currentElement.setText(temp);
					//Makes visual distinction for currentElement change
					currentElement.setBackgroundResource(R.drawable.circle);
					currentElement = getActiveButton();
					currentElement.setBackgroundResource(R.drawable.circle_highlighted);
				}
			}
			if(isValid()){
				state=GAME_WON;
				setInstr();
				currentElement.setBackgroundResource(R.drawable.circle);
			}
		break;
		case(GAME_WON):
			break;
		}
	}

	public boolean isValid(){
		Button button = (Button) findViewById(R.id.nodeDepth0);
		int num0 = Integer.parseInt((String) button.getText());
		button = (Button) findViewById(R.id.nodeDepth11);
		int num11 = Integer.parseInt((String) button.getText());
		button = (Button) findViewById(R.id.nodeDepth12);
		int num12 = Integer.parseInt((String) button.getText());
		button = (Button) findViewById(R.id.nodeDepth21);
		int num21 = Integer.parseInt((String) button.getText());
		button = (Button) findViewById(R.id.nodeDepth22);
		int num22 = Integer.parseInt((String) button.getText());
		button = (Button) findViewById(R.id.nodeDepth23);
		int num23 = Integer.parseInt((String) button.getText());

		if((num0<=num11 && num0 <=num12) && (num11<=num21 && num11<=num22) && (num12<=num23)){
			return true;
		}
		return false;
	}
	
	public Button getActiveButton(){
		int parentNode;
		int childNode1;
		int childNode2;
		
		Button button = (Button) findViewById(R.id.nodeDepth12);
		parentNode = Integer.parseInt((String) button.getText());
		button = (Button) findViewById(R.id.nodeDepth23);
		childNode1 = Integer.parseInt((String) button.getText());
		if(parentNode > childNode1){
			return (Button) findViewById(R.id.nodeDepth12);
		}
		
		button = (Button) findViewById(R.id.nodeDepth11);
		parentNode = Integer.parseInt((String) button.getText());
		button = (Button) findViewById(R.id.nodeDepth21);
		childNode1 = Integer.parseInt((String) button.getText());
		button = (Button) findViewById(R.id.nodeDepth22);
		childNode2 = Integer.parseInt((String) button.getText());
		if(parentNode > childNode1 || parentNode > childNode2){
			return (Button) findViewById(R.id.nodeDepth11);
		}
		
		return (Button) findViewById(R.id.nodeDepth0);
	}
	
}
