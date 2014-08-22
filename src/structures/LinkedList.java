package structures;

public class LinkedList {
	
	Node start;
	Node last;
	int length=0;
	
	//Adds node to start of list
	public void addFirst(int n){
		if(start==null){
			start = new Node(n);
			last = start;
		} else {
			start.prev=new Node(n);
			start=start.prev;
		}
		length++;
	}
	
	//Adds node to end of list
	public void addLast(int n){
		if(start==null){
			start = new Node(n);
			last = start;
		} else {
			last.next= new Node(n);
			last = last.next;
		}
		length++;
	}
	
	//Removes node at position index from list
	//O(n)
	public void remove(int index){
		Node current = start;
		for(int i = 0;i<index;i++){
			current = current.next;
		}
		current.next.prev=current.prev;
		current.prev.next=current.next;
		length--;
	}
	
	//Removes node n from list
	//O(n)
	public void remove(Node n){
		n.next.prev=n.prev;
		n.prev.next=n.next;
		length--;
	}
	
	//Returns value of node at index
	//O(n)
	public int get(int index){
		Node current = start;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		return current.value;
	}

	
	public class Node{
		Node next;
		Node prev;
		int value;
		
		public Node(int n){
			value = n;
		}
	}

}
