package com.robert.datastructures;

import java.util.ArrayList;


import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

public class ExtandableListActivty extends ExpandableListActivity {
	
	ArrayList<Object> childItem = new ArrayList<Object>();
	ArrayList<String> groupItem = new ArrayList<String>();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ExpandableListView listview = new ExpandableListView(this);
		listview.setDividerHeight(2);
		listview.setGroupIndicator(null);
		listview.setClickable(true);
		
		setChildData();
		setGroupData();
		
		ExpandAdapter adapter = new ExpandAdapter(groupItem, childItem);
		adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		getExpandableListView().setAdapter(adapter);
		
		
	}
	
	public void setGroupData(){
		groupItem.add("Binary Tree");
		groupItem.add("Binary Search Tree");
		groupItem.add("Graph");
		groupItem.add("Hash Table");
		groupItem.add("Heap");
		groupItem.add("Linked List");
		groupItem.add("Stacks & Queues");
		groupItem.add("About");
	}
	
	public void setChildData(){
		ArrayList<String> child = new ArrayList<String>();
		for(int i = 0;i<6;i++){
			child.add("Implmentation");
			child.add("Read More Online");
			child.add("Review");
			childItem.add(child);
			child = new ArrayList<String>();
		}
		//Stacks/Queues
		child.add("Implmentation");
		child.add("Read More Online");
		child.add("Review Stacks");
		child.add("Review Queues");
		childItem.add(child);
		//About
		child = new ArrayList<String>();
		child.add("About");
		childItem.add(child);
	}
	




}
