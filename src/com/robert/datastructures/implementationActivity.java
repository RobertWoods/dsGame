package com.robert.datastructures;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class implementationActivity extends Activity {
	
	final int BINARY_TREE = 0;
	final int BINARY_SEARCH_TREE = 1;
	final int GRAPH = 2;
	final int HASH_TABLE = 3;
	final int HEAP = 4;
	final int LINKED_LIST = 5;
	final int STACK = 6;
	final int ABOUT = 7;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		int key = intent.getIntExtra("key", 0);
		if(key==ABOUT) setContentView(R.layout.activity_about);
		else setContentView(R.layout.activity_implementation);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setText(key);
	}
	
	public void setText(int key){
		int text;
		TextView view = (TextView) findViewById(R.id.implementationText);
		switch(key){
		case BINARY_SEARCH_TREE:
			text = R.string.tree;
			break;
		case BINARY_TREE:
			text = R.string.tree;
			break;
		case HASH_TABLE:
			text = R.string.hash;
			break;
		case STACK:
			text = R.string.stack;
			break;
		case HEAP:
			text = R.string.heap;
			break;
		case GRAPH:
			text = R.string.graph;
			break;
		case LINKED_LIST:
			text = R.string.list;
			break;
		case ABOUT:
			text = R.string.about;
			view.setGravity(Gravity.CENTER_VERTICAL);
			view.setText(text);
			view.setMovementMethod(new ScrollingMovementMethod());
			setAbout();
			return;
		default:
			text = R.string.hash;
			break;
		}
		view.setText(text);
	//	view.setMovementMethod(new ScrollingMovementMethod());
	}
	
	public void setAbout(){
		TextView aboutText = (TextView) findViewById(R.id.implementationText);
		SpannableString ss = new SpannableString(aboutText.getText());
		
		//Email
		ClickableSpan clickableSpan = new ClickableSpan() {
			@Override
			public void onClick(View textView) {
				Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
						"mailto","rwapps@gmail.com", null));
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Data Structures App");
				startActivity(Intent.createChooser(emailIntent, "Send email..."));
			}
		};
		ss.setSpan(clickableSpan, 42, 58, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//twitter
		clickableSpan = new ClickableSpan() {
			@Override
			public void onClick(View textView) {
				Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/rwapps"));
				startActivity(twitterIntent);
			}
		};
		ss.setSpan(clickableSpan, 73, 80, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//tumblr
		clickableSpan = new ClickableSpan() {
			@Override
			public void onClick(View textView) {
				Intent tumblrIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bwinks.tumblr.com"));
				startActivity(tumblrIntent);
			}
		};
		ss.setSpan(clickableSpan, 143, 160, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		aboutText.setText(ss);
		aboutText.setMovementMethod(LinkMovementMethod.getInstance());
	}
	

}
