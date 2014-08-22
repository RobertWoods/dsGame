package structures;

import java.util.LinkedList;

public class Stack {
	
	public LinkedList<Integer> list;
	final int STACK = 0;
	final int QUEUE = 1;
	int state;
	
	public Stack(boolean isStack){
		if(isStack){
			state = STACK;
		} else {
			state = QUEUE;
		}
		list = new LinkedList<Integer>();
	}
	
	public Integer pop(){
		Integer integer = list.get(0);
		list.remove(0);
		return integer;
	}
	
	public Integer peek(){
		return list.get(0);
	}
	
	public void push(int n){
		switch(state){
		case STACK:
			list.addFirst((Integer) n);
			break;
		case QUEUE:
			list.addLast((Integer) n);
			break;
		}
	}

}
