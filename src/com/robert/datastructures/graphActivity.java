package com.robert.datastructures;

import java.util.ArrayList;

import structures.Graph;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class graphActivity extends Activity {
	
	final int UNSELECTED = 0;
	final int SELECTED = 1;
	final int GAME_WON = 2;
	int state = UNSELECTED;
	Button currentButton;
	int edgeCounter=0;
	ArrayList<Button> buttons = new ArrayList<Button>(9);
	Graph G;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graph);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setGraph();
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
	
	public void setGraph(){
		G = new Graph(3);
		G.fillGraph();
		for(int i = R.id.graphButton11; i <= R.id.graphButton13; i++){
			Button button = (Button) findViewById(i);
			if(G.nodes.get(0).edges[i-R.id.graphButton11]!=null){
				button.setText("1");
			} else {
				button.setText("0");
			}
		}
		for(int i = R.id.graphButton21; i <= R.id.graphButton23; i++){
			Button button = (Button) findViewById(i);
			if(G.nodes.get(1).edges[i-R.id.graphButton21]!=null){
				button.setText("1");
			} else {
				button.setText("0");
			}
		}
		for(int i = R.id.graphButton31; i <= R.id.graphButton33; i++){
			Button button = (Button) findViewById(i);
			if(G.nodes.get(2).edges[i-R.id.graphButton31]!=null){
				button.setText("1");
			} else {
				button.setText("0");
			}
		}
	}
	
	
	public void onClick(View view){
		switch(state){
		case UNSELECTED:
			currentButton = (Button) view;
			updateSelectedText(view);
			state = SELECTED;
			break;
		case SELECTED:
			if(isValidMatch(view)){
				makeConnection(view);
				checkWin();
			}
			deselect();
			updateSelectedText(view);
			break;
		case GAME_WON:
			break;
		default:
			break;
		}
	}

	private void checkWin() {
		if(edgeCounter==G.edgeSize){
			state = GAME_WON;
			Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
		}
	}

	private void deselect() {
		state = UNSELECTED;
		currentButton = null;
	}

	private void makeConnection(View view) {
		edgeCounter++;
		if(view!=currentButton){
			drawLine((Button) view);
		} else {
			pointToSelf();
		}
	}
	
	public void updateSelectedText(View view){
		TextView text = (TextView) findViewById(R.id.textCurrentNode);
		if(currentButton==null){
			text.setText("Currently selected node = ");
			return;
		}
			
		text.setText("Currently selected node = " + currentButton.getText().toString());
	}

	private void pointToSelf() {
		currentButton.setBackgroundResource(R.drawable.ouroboros_circle); 
	}

	private boolean isValidMatch(View view) { 
		int ID;
		int ID1;
		if(currentButton.getId()>R.id.node1){	//LinearLayout is between node1 and the other two, have to skip over
			ID = currentButton.getId()-R.id.node1-1;
		} else {
			ID = 0;
		}
		if(view.getId()>R.id.node1){	//LinearLayout is between node1 and the other two, have to skip over
			ID1 = view.getId()-R.id.node1-1;
		} else {
			ID1 = 0;
		}
		ID = ID*4+(ID1);
		ID = R.id.graphButton11+ID;
		Button button;
		button = (Button) findViewById(ID);
		for(Button b : buttons){
			if(b==button)
				return false;
		}
		if(button.getText().equals("1")){
			buttons.add(button);
			return true;
		}
		return false;
	}
	
	public void drawLine(Button button){
		LinearLayoutPlus layout = (LinearLayoutPlus) findViewById(R.id.graphLayout);
		layout.setButtons(button, currentButton);
		layout.postInvalidate();
	}

}