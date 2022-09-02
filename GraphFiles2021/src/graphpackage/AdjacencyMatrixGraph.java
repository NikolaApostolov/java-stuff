package graphpackage;

import java.util.ArrayList;

public class AdjacencyMatrixGraph implements DiGraphADT{
	
	private int matrix[][];
	private int numNodes;
	private int edges;
	
	AdjacencyMatrixGraph(int nodes){	
		numNodes = nodes;
		matrix = new int[numNodes][numNodes];
		
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
	        matrix[node1][node2]=1;
	        edges++;
	        return true;
	}

	public boolean isEdge(int node1, int node2) {
		if (matrix[node1][node2] == 1)
			return true;
		else return false;
	}

	public ArrayList<Integer> successors(int node) {
		ArrayList<Integer> successorNodes = new ArrayList<Integer>();
        for (int i=0; i<numNodes; i++)
           if (matrix[node][i] == 1) successorNodes.add(i);
        return successorNodes;
	}

	public ArrayList<Integer> predecessors(int node) {
		ArrayList<Integer> predecessorNodes = new ArrayList<Integer>();
        for (int i=0; i<numNodes; i++)
           if (matrix[i][node] == 1) predecessorNodes.add(i);
        return predecessorNodes;
	}

	public int outDegree(int node) {
		return successors(node).size();
	}

	public int inDegree(int node) {
		return predecessors(node).size();
	}
}
