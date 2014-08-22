package com.robert.datastructures;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandAdapter extends BaseExpandableListAdapter{

	 public ArrayList<String> groupItem, tempChild;
	 public ArrayList<Object> Childtem = new ArrayList<Object>();
	 public LayoutInflater minflater;
	 public Activity activity;

	 public ExpandAdapter(ArrayList<String> grList, ArrayList<Object> childItem) {
		 groupItem = grList;
		 this.Childtem = childItem;
	 }

	 public void setInflater(LayoutInflater mInflater, Activity act) {
		 this.minflater = mInflater;
		 activity = act;
	 }

	 @Override
	 public Object getChild(int arg0, int arg1) {
		 // TODO Auto-generated method stub
		 return null;
	 }

	 @Override
	 public long getChildId(int groupPosition, int childPosition) {
		 // TODO Auto-generated method stub
		return 0;
	 }

	 @Override
	 public View getChildView(final int groupPosition, final int childPosition,
			 boolean isLastChild, View convertView, ViewGroup parent) {
		 tempChild = (ArrayList<String>) Childtem.get(groupPosition);
		 TextView text = null;
		 if (convertView == null) {
			 convertView = minflater.inflate(R.layout.child_row, null);
		 }
		 text = (TextView) convertView.findViewById(R.id.childText);
		 text.setText(tempChild.get(childPosition));
		 
		 ImageView image = (ImageView) convertView.findViewById(R.id.childImage);
		 image.setImageResource(getImage(childPosition));
		 convertView.setOnClickListener(new OnClickListener() {
			 @Override
			 public void onClick(View v) {
				 determineAction(groupPosition,childPosition);
			 }
		 });
		 return convertView;
	 }

	 public void determineAction(int groupPosition, int childPosition){
		 if(groupPosition==7){
			 goToAbout();
			 return;
		 }
		 switch(childPosition){
		 case 0:
			 getImplementation(groupPosition);
			 break;
		 case 1:
			 getOnline(groupPosition);
			 break;
		 case 2:
			 getReview(groupPosition);
			 break;
		 case 3:
			 getReview(7);
			 break;
		 }
	 }


	private void getImplementation(int groupPosition){
		 Intent intent = new Intent(activity.getApplicationContext(),implementationActivity.class).putExtra("key", groupPosition);
		 activity.startActivity(intent);
	 }

	 private void getOnline(int groupPosition){
		 String javadoc = "";
		 switch(groupPosition){
		 case 0:
			 javadoc = "http://en.wikipedia.org/wiki/Tree_(data_structure)";
			 break;
		 case 1:
			 javadoc = "http://en.wikipedia.org/wiki/Binary_search_tree";
			 break;
		 case 2:
			 javadoc = "http://en.wikipedia.org/wiki/Graph_(abstract_data_type)";
			 break;
		 case 3:
			 javadoc = "http://en.wikipedia.org/wiki/Hash_table";
			 break;
		 case 4:
			 javadoc = "http://en.wikipedia.org/wiki/Heap_(data_structure)";
			 break;
		 case 5:
			 javadoc = "http://en.wikipedia.org/wiki/Linked_list";
			 break;
		 case 6:
			 javadoc = "http://en.wikipedia.org/wiki/Stack_(abstract_data_type)";
			 break;
		 }
		 Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(javadoc));
		 activity.startActivity(intent);
	 }

	 private void getReview(int groupPosition){
		 Intent intent = new Intent(activity.getApplicationContext(),graphActivity.class);
		 switch(groupPosition){
		 case 0:
			 intent = new Intent(activity.getApplicationContext(),treeTraversalActivity.class);
			 break;
		 case 1:
			 intent = new Intent(activity.getApplicationContext(),bstreeSetupActivity.class);
			 break;
		 case 2:
			 intent = new Intent(activity.getApplicationContext(),graphActivity.class);
			 break;
		 case 3:
			 intent = new Intent(activity.getApplicationContext(),hashInsertionActivity.class);
			 break;
		 case 4:
			 intent = new Intent(activity.getApplicationContext(),HeapInsertionActivity.class);
			 break;
		 case 5:
			 intent = new Intent(activity.getApplicationContext(),listLinkerActivity.class);
			 break;
		 case 6:
			 intent = new Intent(activity.getApplicationContext(),stackActivity.class);
			 break;
		 case 7:
			 intent = new Intent(activity.getApplicationContext(),queueActivity.class);
			 break;
		 }
		 activity.startActivity(intent);
	 }
	 
	 private void goToAbout() {
		 Intent intent = new Intent(activity.getApplicationContext(),implementationActivity.class).putExtra("key", 7);
		 activity.startActivity(intent);
		}

	 public int getImage(int childPosition){
		 switch(childPosition){
		 case 0:
			 return R.drawable.paper;
		 case 1:
			 return R.drawable.za_warudo;
		 case 2:
			 return R.drawable.paper_and_pencil;
		 case 3:
			 return R.drawable.paper_and_pencil;
		 }
		 return 0;
	 }
	 
	 @Override
	 public int getChildrenCount(int groupPosition) {
		 return ((ArrayList<String>)Childtem.get(groupPosition)).size();
	 }

	 @Override
	 public Object getGroup(int groupPosition) {
		 // TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		return groupItem.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

		convertView = minflater.inflate(R.layout.group_row, null);
		((CheckedTextView) convertView).setText("         "+groupItem.get(groupPosition));
		((CheckedTextView) convertView).setChecked(isExpanded);
		//Checks for about clicks and sets listener
		if(((CheckedTextView) convertView).getText().toString().equals("         About")){
			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					goToAbout();
				}
			});
		}
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}


}
