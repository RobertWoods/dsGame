package com.robert.datastructures;


import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import structures.Stack;

public class queueActivity extends stackActivity {
	
	public void setStack(){
		stack = new Stack(false);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	public void onPopClick(View view){
		if(currentIndex>0){
			for(int i = 0;i<currentIndex;i++){
				if(i<4){
					if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
						findViewById(R.id.imageView1+i).setBackground(findViewById(R.id.imageView1+i+1).getBackground());
						findViewById(R.id.imageView1+i+1).setBackground(null);
					} else {
						findViewById(R.id.imageView1+i).setBackgroundDrawable(findViewById(R.id.imageView1+i+1).getBackground());
						findViewById(R.id.imageView1+i+1).setBackgroundDrawable(null);
					}
				}
			}
			stack.pop();
			currentIndex--;
		} else {
			Toast.makeText(this, "Underflow", Toast.LENGTH_SHORT).show();
		}
	}

	
	
}
