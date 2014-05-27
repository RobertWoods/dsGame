package org.example.datastructuresname;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainMenuActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
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
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_menu,
					container, false);
			return rootView;
		}
	}
	
	public void onGraphClick(View v){
		Intent intent = new Intent(this, graphMenuActivity.class);
		startActivity(intent);
	}
	
	public void onStackClick(View v){
		Intent intent = new Intent(this, stackMenuActivity.class);
		startActivity(intent);
	}
	
	public void onLLClick(View v){
		Intent intent = new Intent(this, listMenuActivity.class);
		startActivity(intent);
	}
	
	public void onBTClick(View v){
		Intent intent = new Intent(this, treeMenuActivity.class);
		startActivity(intent);
	}
	
	public void onHashClick(View v){
		Intent intent = new Intent(this, hashMenuActivity.class);
		startActivity(intent);
	}
	
	public void onHeapClick(View v){
		Intent intent = new Intent(this, heapMenuActivity.class);
		startActivity(intent);
	}
}
