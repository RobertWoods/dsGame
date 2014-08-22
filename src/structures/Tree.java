package structures;

import java.util.Random;

public class Tree {

	public Node rootNode;
	
	public Tree(){
		createValidGameTree();
		assignPos();
	}
	
	
	public Tree(int n){
	}

	//adds random int to tree at random position
	//O(logn)-O(n)
	public void insertAtRandomPosition() {
		if (rootNode == null) {
			rootNode = new Node(0);
			return;
		}
		int rand = (int) (Math.random() * 2);
		Node current = rootNode;
		while (current.child[rand] != null) {
			current = current.child[rand];
			rand = (int) (Math.random() * 2);
			if(current.depth==2){
				current=rootNode;
			}
		}
		current.child[rand] = new Node(current.depth+1);
	}
	
	//adds int n to binary search tree
	//O(logn)-O(n)
	public int bstAdd(int n){
		if (rootNode == null){
			rootNode = new Node((double) n);
			return n;
		}
		Node current = rootNode;
		int pos;
		if (n > current.value){
			pos = 1;
		} else {
			pos = 0;
		}
		while(current.child[pos] != null){
			current = current.child[pos];
			if(n > current.value){
				pos = 1;
			} else {
				pos = 0;
			}
		}
		current.child[pos]= new Node((double) n);
		return n;
	}
	
	public void createValidGameTree() {
		rootNode = new Node(0);
		rootNode.child[0] = new Node(1);
		rootNode.child[1] = new Node(1);
		insertAtRandomPosition();
		insertAtRandomPosition();
	}
	
	public int[] createValidGameBST(){
		Random rand = new Random();
		int[] sequence = new int[5];
		//root
		sequence[0]=bstAdd((rand.nextInt(9)+1));
		//2 values larger than root
		sequence[1]=bstAdd((rand.nextInt(10-sequence[0])+sequence[0]+1));
		rand = new Random();
		sequence[2]=bstAdd((rand.nextInt(10-sequence[0])+sequence[0]+1));
		//2 values smaller than root
		sequence[3]=bstAdd(rand.nextInt(sequence[0]));
		rand = new Random();
		sequence[4]=bstAdd(rand.nextInt(sequence[0]));
		return sequence;
	}
	
	public void delete(Node n){
		Node current = rootNode;
		//Searches for Node n parent
		while(current.child[0]!=n && current.child[1]!=n){
			if(current.value>n.value){
				current=current.child[1];
			} else if(current.value<n.value){
				current=current.child[0];
			}
		}
		//replaces parent child with n child or null
		if(current.child[0]==n){
			if(n.child[1]!=null) current.child[0]=n.child[1];
			else if(n.child[0]!=null) current.child[0]=n.child[0];
			else current.child[0]=null;
		} else if (current.child[1]==n){
			if(n.child[0]!=null) current.child[1]=n.child[0];
			else if(n.child[1]!=null) current.child[1]=n.child[1];
			else current.child[1]=null;
		}
	}
	
	public void assignPos() {
		for(int i = 0; i<2; i++){
			if(rootNode.child[0].child[i]!=null){
				rootNode.child[0].child[i].xPos=(i);
			}
			if(rootNode.child[1].child[i]!=null){
				rootNode.child[1].child[i].xPos=(i+2);
			}
		}
	}
	
	//O(n)
	public String inTraverse(Node node) {
		String string="",left="",right = "";
		if (node.child[0] != null) {
			left = inTraverse(node.child[0]);
		}
		String middle = "" + node.value;

		if (node.child[1] != null) {
			right = inTraverse(node.child[1]);
		}
		string = left + middle + right;
		return string;
	}
	
	//O(n)
	public String preTraverse(Node node) {
		String string="",left="",right = "";
		if (node.child[0] != null) {
			left = preTraverse(node.child[0]);
		}
		String middle = "" + node.value;
		if (node.child[1] != null) {
			right = preTraverse(node.child[1]);
		}
		string = middle + left + right;
		return string;
	}
	
	//O(n)
	public String postTraverse(Node node) {
		String string="",left="",right = "";
		if (node.child[0] != null) {
			left = postTraverse(node.child[0]);
		}
		String middle = "" + node.value;
		if (node.child[1] != null) {
			right = postTraverse(node.child[1]);
		}
		string = left + right + middle;
		return string;
	}
	
	public int[] getLowDepthPos(){
		int[] nodePos = new int[2];
		int current = 0;
		for(int i =0;i<2;i++){
			if(rootNode.child[0].child[i]!=null){
				nodePos[current]=rootNode.child[0].child[i].xPos;
				current++;
			}
			if(rootNode.child[1].child[i]!=null){
				nodePos[current]=rootNode.child[1].child[i].xPos;
			}
		}
		return nodePos;
	}

	public class Node {

		public Node[] child = new Node[2];
		public int value;
		int depth;
		int xPos;

		public Node(int d) {
			value = (int) (Math.random() * 10);
			depth = d;
		}
		
		public Node(double d){
			value = (int) d;
		}
	}

}