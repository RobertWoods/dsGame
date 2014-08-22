package com.robert.datastructures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;


public class LinearLayoutPlus extends LinearLayout {
	Button button1;
	Button button2;
	Paint paint = new Paint();
	LinearLayout layout;
	int[][] dimensions = new int[4][10];
	int index = 0;

	public LinearLayoutPlus(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(5);
	}
	
	public LinearLayoutPlus(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(5);
	}
	
	public LinearLayoutPlus(Context context) {
		super(context);
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(5);
	}

	@Override
	public void dispatchDraw(Canvas canvas){
		//TODO Find out why this doesn't work with a loop LOOL
		setWillNotDraw(false);
		if(dimensions[0][0]!=0){
			canvas.drawLine(dimensions[0][0], dimensions[1][0], dimensions[2][0], dimensions[3][0], paint);
		}
		if(dimensions[0][1]!=0){
			canvas.drawLine(dimensions[0][1], dimensions[1][1]-2, dimensions[2][1], dimensions[3][1]-2, paint);	//Y is decremented by 2 in order to bold the lines when a second line is drawn between the nodes
		}
		if(dimensions[0][2]!=0){
			canvas.drawLine(dimensions[0][2], dimensions[1][2]-4, dimensions[2][2], dimensions[3][2]-4, paint);
		}
		if(dimensions[0][3]!=0){
			canvas.drawLine(dimensions[0][3], dimensions[1][3]-6, dimensions[2][3], dimensions[3][3]-6, paint);
		}
		if(dimensions[0][4]!=0){
			canvas.drawLine(dimensions[0][4], dimensions[1][4]-8, dimensions[2][4], dimensions[3][4]-8, paint);
		}
		if(dimensions[0][5]!=0){
			canvas.drawLine(dimensions[0][5], dimensions[1][5]-10, dimensions[2][5], dimensions[3][5]-10, paint);
		}
		if(dimensions[0][6]!=0){
			canvas.drawLine(dimensions[0][6], dimensions[1][6]-12, dimensions[2][6], dimensions[3][6]-12, paint);
		}
		super.dispatchDraw(canvas);	
	}

	public void setButtons(Button button1, Button button2){
		this.button1 = button1;
		this.button2 = button2;
		setPosition();
	}
	
	public void setPosition(){
		layout = (LinearLayout) findViewById(R.id.layout2);
		if(button1==findViewById(R.id.node1)){
			dimensions[0][index] = (button1.getLeft()+button1.getWidth()/2);
			dimensions[1][index] = (button1.getTop()+button1.getHeight()/2);
		} else {
			dimensions[0][index] = (layout.getLeft()+button1.getLeft()+button1.getWidth()/2);
			dimensions[1][index] = (layout.getTop()+button1.getTop()+button1.getHeight()/2);
		}
		if(button2==findViewById(R.id.node1)){
			dimensions[2][index] = (button2.getLeft()+button1.getWidth()/2);
			dimensions[3][index] = (button2.getTop()+button1.getHeight()/2);
		} else {
			dimensions[2][index] = (layout.getLeft()+button2.getLeft()+button1.getWidth()/2);
			dimensions[3][index] = (layout.getTop()+button2.getTop()+button1.getHeight()/2);
		}
		index++;
	}

}
