package com.robert.datastructures;

import java.util.Random;

import structures.Tree;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class treeTraversalActivity extends Activity {
	EditText mEditText;
	TextView mTextView;
	String answer;
	Random random;
	Tree tree;
	int gameType; 
	public static final int PRE_ORDER = 0;
	public static final int IN_ORDER = 1;
	public static final int POST_ORDER = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traversal);
		answer = determineAnswer();
		random = new Random();
		gameType = random.nextInt(3);
		mEditText = (EditText) findViewById(R.id.editText1);
		mTextView = (TextView) findViewById(R.id.textView1);
		gameSetUp();
		getActionBar().setDisplayHomeAsUpEnabled(true);
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

	public void gameSetUp(){
		setInstructions();
		determineAnswer();
		createEditText();
		drawTree(tree);
	}

	public void createEditText(){
		mEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
		mEditText.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				boolean handled = false;
				if (actionId == EditorInfo.IME_ACTION_DONE){
					checkWinner();
				}
				return handled;
			}
		});

	}

	public boolean isCorrectValue(){
		String field = mEditText.getText().toString();
		if(field.equals(answer)){
			return true;
		}
		return false;
	}

	public void checkWinner(){
		if(isCorrectValue()){
			Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
		}
	}

	public void setInstructions(){
		switch(gameType){
		case PRE_ORDER:
			mTextView.setText(R.string.pre_traversal);
			break;
		case IN_ORDER:
			mTextView.setText(R.string.in_traversal);
			break;
		case POST_ORDER:
			mTextView.setText(R.string.post_traversal);
			break;
		}
	}

	private String determineAnswer() {
		tree = new Tree();
		switch (gameType) {
		case PRE_ORDER:
			answer = tree.preTraverse(tree.rootNode);
			break;
		case IN_ORDER:
			answer = tree.inTraverse(tree.rootNode);
			break;
		case POST_ORDER:
			answer = tree.postTraverse(tree.rootNode);
			break;
		}
		return null;
	}

	public void drawTree(Tree tree){
		ImageView image = (ImageView) findViewById(R.id.nodeDepth0);
		image.setImageResource(R.drawable.circle_0+tree.rootNode.value);

		image = (ImageView) findViewById(R.id.nodeDepth11);
		image.setImageResource(R.drawable.circle_0+tree.rootNode.child[0].value);

		image = (ImageView) findViewById(R.id.nodeDepth12);
		image.setImageResource(R.drawable.circle_0+tree.rootNode.child[1].value);
		
		if(tree.rootNode.child[0].child[0]!=null){
			image = (ImageView) findViewById(R.id.nodeDepth21);
			image.setImageResource(R.drawable.circle_0+tree.rootNode.child[0].child[0].value);
			image.setVisibility(0);
		}
		if(tree.rootNode.child[0].child[1]!=null){
			image = (ImageView) findViewById(R.id.nodeDepth22);
			image.setImageResource(R.drawable.circle_0+tree.rootNode.child[0].child[1].value);
			image.setVisibility(0);
		}
		if(tree.rootNode.child[1].child[0]!=null){
			image = (ImageView) findViewById(R.id.nodeDepth23);
			image.setImageResource(R.drawable.circle_0+tree.rootNode.child[1].child[0].value);
			image.setVisibility(0);
		}
		if(tree.rootNode.child[1].child[1]!=null){
			image = (ImageView) findViewById(R.id.nodeDepth24);
			image.setImageResource(R.drawable.circle_0+tree.rootNode.child[1].child[1].value);
			image.setVisibility(0);
		}
	}

}