package structures;

import java.util.Random;

public class Heap {
	
	public int[] array = new int[10];
	int lastIndex = 0;
	
	public Heap(){
		for(int i = 0;i<array.length;i++){
			array[i]=-1;
		}
	}
	
	//Inserts and bubbles a new int n
	//O(1)-O(logn)
	public void insert(int n){
		array[lastIndex]=n;
		swap(lastIndex);
		lastIndex++;
	}
	
	//Swaps a child and parent when necessary
	public void swap(int index){
		int parent = computeParent(index);
        int temp = array[parent];
        if (array[parent] > array[index]) {
            array[parent] = array[index];
            array[index] = temp;
            swap(parent);
        }
	}
	
	//Returns the index of the parent of index child
	public int computeParent(int child) {
        int parent = 0;
        if (child > 0) {
            parent = ((child - 1) / 2);
        }
        return parent;
    }
	
	//Deletes first entry in heap and reshuffles heap
	//0(logn)
	public int pop(){
		int x = array[0];
		int currentIndex = 0;
		int currentPos=0;
		array[0]=array[lastIndex-1];
		while(array[((currentIndex+1)*2-1)]>-1){
			currentIndex=(currentPos+1)*2-1;
			if(array[currentIndex]<array[currentPos]){
				int temp = array[currentIndex];
				array[currentIndex]=array[currentPos];
				array[currentPos]=temp;
				currentPos=currentIndex;
			} else if(array[currentIndex]<array[currentPos++]){
				currentIndex=(currentPos+1)*2;
				int temp = array[currentIndex];
				array[currentIndex]=array[currentPos];
				array[currentPos]=temp;
				currentPos=currentIndex;
			} else {
				return x;
			}
		}
		return x;
	}
	
	public int peek(){
		return array[0];
	}
	
	//Builds a heap of size n from random Integers from 0-9
	public void buildHeap(int n){
		for(int i = 0; i<n;i++){
			Random rand = new Random();
			insert(rand.nextInt(10));
		}
	}
}
