package com.robert.datastructures;

import java.util.Random;

import structures.Tree;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class bstreeSetupActivity extends Activity {

	int[] sequence;
	Tree tree;
	String textSequence;
	int activeNumber;
	int tracker=0;
	boolean gameWon = false;
	int[] hash = new int[7];
	TextView dirs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.bst_setup_activity);
		createTree();
		drawSequence();
		activeNumber = sequence[0];
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
	
	public void createTree(){
		tree = new Tree(1);
		sequence = tree.createValidGameBST();
		drawTree();
	}

	public void drawSequence(){
		int temp;
		int pos;
		Random rand = new Random();
		textSequence = "";
		//Create text from original sequence
		for(int i = 0;i<sequence.length-1;i++){
			textSequence=textSequence+sequence[i]+", ";
		}
		textSequence=textSequence+sequence[sequence.length-1]+".";
		//Randomizes array for locating values in the tree
		for(int i = 0;i<sequence.length;i++){
			pos = rand.nextInt(sequence.length-i)+i;
			temp = sequence[i];
			sequence[i]=sequence[pos];
			sequence[pos]=temp;
		}
		TextView dirs = (TextView) findViewById(R.id.textSequence);
		dirs.setText("Insertion Sequence: " + textSequence + System.getProperty("line.separator") + "Place the following into the BST: "+sequence[0]);
	}

	public void drawTree(){
		hash[R.id.nodeDepth0%7] = sequence[0];
		//Left node should be a lower value, which means its sequence is 3
		hash[R.id.nodeDepth11%7] = sequence[3];
		//Right node should be higher value, which means its sequence is 1
		hash[R.id.nodeDepth12%7] = sequence[1];
		
		Button button;
		
		//Left subnodes will be 4, right subnodes will be 2
		if(tree.rootNode.child[0].child[0]!=null){
			button = (Button) findViewById(R.id.nodeDepth21);
			button.setBackgroundResource(R.drawable.circle);
			hash[R.id.nodeDepth21%7] = sequence[4];

		}
		if(tree.rootNode.child[0].child[1]!=null){
			button = (Button) findViewById(R.id.nodeDepth22);
			button.setBackgroundResource(R.drawable.circle);
			hash[R.id.nodeDepth22%7] = sequence[4];

		}
		if(tree.rootNode.child[1].child[0]!=null){
			button = (Button) findViewById(R.id.nodeDepth23);
			button.setBackgroundResource(R.drawable.circle);
			hash[R.id.nodeDepth23%7] = sequence[2];
		}
		if(tree.rootNode.child[1].child[1]!=null){
			button = (Button) findViewById(R.id.nodeDepth24);
			button.setBackgroundResource(R.drawable.circle);
			hash[R.id.nodeDepth24%7] = sequence[2];
		}
	}
	
	public void gameWon(){
		Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
		gameWon=true;
	}
	
	public void updateCorrect(View view){
		Button buttonPressed = (Button) view;
		buttonPressed.setText(activeNumber+"");
		tracker++;
		if(tracker>=5){
			gameWon();
			return;
		}
		activeNumber=sequence[tracker];
		dirs = (TextView) findViewById(R.id.textSequence);
		dirs.setText("Insertion Sequence: " + textSequence + System.getProperty("line.separator") + "Place the following into the BST: "+activeNumber);
	}
	
	public void updateWrong(){
		Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
	}
	
	
	public void onClick(View view){
		if(gameWon){
			return;
		}
		if(activeNumber==hash[(view.getId()%7)]){
			updateCorrect(view);
		} else {
			updateWrong();
		}
		
	}
}
