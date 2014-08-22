package structures;

public class Hash {
	
	int[] table;
	public int hash;
	public int[] unhashedTable;
	
	//Hash table key and value type is integer
	
	//sets hash size and determines random hash
	public Hash(int n){
		table = new int[n];
		setHash();
	}
	
	//add int num to the hash table
	//O(1)-O(n)
	public void add(int num){
		int pos = ((num*hash)%table.length);
		pos = linearProbe(pos);
		table[pos]=num;
	}
	
	//handles collision
	private int linearProbe(int pos) {
		while(table[pos]!=0){
			pos++;
			if(pos>7){
				pos=0;
			}
		}
		return pos;
	}
	
	//sets the hash function used to map values to indexes
	private void setHash(){
		hash= (int) (Math.random()*10);
	}
	
	private int[] getEntries(){
		int[] entries = new int[table.length];
		for(int i = 0; i<table.length;i++){
			entries[i]=(int) (1+Math.random()*10);
		}
		return entries;
	}
	
	//returns value at position pos
	//O(1)
	public int get(int pos){
		return table[pos];
	}
	
	//returns position of stored value num. If does not exist, returns -1
	//O(1)-O(n)
	public int retrieve(int num){
		int pos = ((num*hash)%(table.length));
		int start = pos;
		if(pos == num)
			return pos;
		pos++;
		while(pos!=num){
			pos++;
			if(pos==table.length){
				pos=0;
			}
			if(pos==start){
				return -1;
			}
		}
		return pos;
	}
	
	//fills table with random ints
	public void fillTable(){
		int[] entries = getEntries();
		unhashedTable = entries;
		for(int i = 0; i<table.length;i++){
			add(entries[i]);
		}
	}

}
