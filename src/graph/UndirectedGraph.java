package graph;

import java.util.HashMap;

public class UndirectedGraph {
    private HashMap<Integer, Integer[]>  adjacencyList;
    private int graphType = 0;
    public UndirectedGraph(HashMap<Integer, Integer[]> adjacencyList){
        this.adjacencyList = adjacencyList;
    }

    public Integer[] getNeighbors(int u){
        if (!this.adjacencyList.containsKey(u)){
            return null;
        }
        else{
            return this.adjacencyList.get(u);
        }
    }

    public boolean checkEdge(int u, int v){
        Integer[] uAdjacency = getNeighbors(u);
        if (uAdjacency != null){
            for(Integer uNeighbor: uAdjacency) {
                if (uNeighbor == v) {
                    return true;
                }
            }
        }
        return false;
    }
}
