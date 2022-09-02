package graphpackage;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyListGraph implements DiGraphADT{

	private int numNodes;
	private int edges;
	private LinkedList<Integer> List[];
	
	AdjacencyListGraph(int nodes) {
		numNodes = nodes;
		List = new LinkedList[numNodes];
		for(int i = 0; i < numNodes; i++) {
			List[i] = new LinkedList<>();
		}
		
	}

	public int nNodes() {
		return numNodes;
	}

	public int nEdges() {
		return edges;
	}

	public boolean addEdge(int node1, int node2) {
		if (isEdge(node1,node2))
	          return false;
	        List[node1].add(node2);
	        edges++;
	        return true;
	}

	public boolean isEdge(int node1, int node2) {
		if (List[node1].contains(node2)) return true;
		else return false;
	}

	public ArrayList<Integer> successors(int node) {
		ArrayList<Integer> successorNodes = new ArrayList<Integer>();
        for (int i = 0; i < List[node].size(); i++) {
        	successorNodes.add(List[node].get(i));
        }
        return successorNodes;
	}

	public ArrayList<Integer> predecessors(int node) {
		ArrayList<Integer> predecessorNodes = new ArrayList<Integer>();
        for (int i = 0; i < numNodes; i++) {
        	if (List[i].contains(node)) predecessorNodes.add(i);
        }
        return predecessorNodes;
	}

	public int outDegree(int node) {
		return successors(node).size();
	}

	public int inDegree(int node) {
		return predecessors(node).size();
	}
	
}
