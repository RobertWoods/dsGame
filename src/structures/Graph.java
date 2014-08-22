package structures;

import java.util.ArrayList;
import java.util.Random;

public class Graph {
	
	int size=0;
        
	ArrayList<Node> visited;
	public int edgeSize;
	public ArrayList<Node> nodes;
	
	//Graph type is int, directed, all edge values equal
	
	public Graph(int s){
            size = s;
            nodes = new ArrayList<Node>(s);
            visited = new ArrayList<>(s);
	}
	
	public void addEdge(Node s, Node v){
		s.edges[s.index]=v;
		s.index++;
		edgeSize++;
	}
	
	public void addNode(Node n){
		nodes.add(n);
		size++;
	}
	
	public void addNode(int n){
		nodes.add(new Node(n));
		size++;
	}
	
	public boolean isReachable(Node a, Node b){
                visited.add(a);
		if(a.equals(b)){
			return true;
		} else {
			for(Node edge : a.edges){
				if(!visited.contains(edge) && edge!=null){
					visited.add(edge);
					if(isReachable(edge, b)){
						return true;
					}
				}
			}
		}
		return false;
	}
        
        public void resetVisited(){
            visited = new ArrayList<>(nodes.size());
        }
	
	
	public void addEdges(Node s, Node v){
		s.edges[s.index]=v;
		edgeSize++;
		s.index++;
		s.edges[v.index]=s;
		v.index++;
		edgeSize++;
	}
	
	public void fillGraph(){
		Random rand = new Random();
		for(int i = 0;i<size;i++){
			nodes.add(new Node(rand.nextInt()));
		}
		for(int i = 0;i<size;i++){
			for(int j = 0; j<size;j++){
				if(rand.nextBoolean()){
					addEdge(nodes.get(i),nodes.get(j));
				}
			}
		}
	}

	
	public class Node {

		public Node[] edges;
		public int value;
		int index=0;

		public Node(int d) {
			value = d;
			edges = new Node[size];
		}

	}
	
}
