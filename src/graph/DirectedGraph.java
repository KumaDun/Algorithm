package graph;

import java.util.*;

public class DirectedGraph {

    private HashMap<Integer, Integer[]> adjacencyList;
    private ArrayList<Integer> sources;
    private ArrayList<Integer> sinks;
    private HashSet<Integer> vertices = new HashSet<>();
    private HashMap<Integer, ArrayList<Integer>> incomingVertices = new HashMap<>();
    private final int graphType = 1;
    private LinkedList<Integer> traverseResultDecreseFinishTime = new LinkedList<>();
    private HashSet<Integer> visited = new HashSet<>();
    private DirectedGraph GTransposed = null;
    private boolean isTranspoed = false;

    private HashSet<ArrayList<Integer>> SCCs = null;

    public DirectedGraph(HashMap<Integer, Integer[]> adjacencyList){
        this.adjacencyList = adjacencyList;
        update();
    }

    public DirectedGraph(HashMap<Integer, Integer[]> adjacencyList, boolean transFlag){
        this.adjacencyList = adjacencyList;
        this.isTranspoed = transFlag;
        update();
    }

    public void addEdge(int u, int v){
        if (vertices.contains(u)){
            Integer[] uOldNeighbors = adjacencyList.get(u);
            Integer[] uNewNeighbors = new Integer[uOldNeighbors.length+1];
            System.arraycopy(uOldNeighbors,0, uNewNeighbors,0,uOldNeighbors.length);
            uNewNeighbors[uOldNeighbors.length] = v;
//            System.out.println(Arrays.toString(uNewNeighbors));
            adjacencyList.replace(u,uNewNeighbors);
        }
        else{
           adjacencyList.put(u,new Integer[]{v});
        }
        update();
    }

    public Integer[] getNeighbors(int u){
        if (!this.adjacencyList.containsKey(u)){
            return null;
        }
        else{
            return this.adjacencyList.get(u);
        }
    }

    public LinkedList<Integer> getTraverseResultDecreseFinishTime(){
        return traverseResultDecreseFinishTime;
    }

    public HashSet<Integer> getVisited(){
        return visited;
    }

    public DirectedGraph getGTransposed(){
        return GTransposed;
    }

    public HashSet<ArrayList<Integer>> getSCCs(){
        return this.SCCs;
    }

    private void setIsTransposed(boolean flag){
        this.isTranspoed = flag;
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

    public void update(){
        this.vertices = new HashSet<>();
        this.sinks = new ArrayList<>();
        this.sources = new ArrayList<>();
        this.incomingVertices = new HashMap<>();
        updateVertices();
        updateIncomingVertices();
        findSources();
        findSinks();
        if (!isTranspoed){
            topologicalSort();
        }
    }

    private void updateVertices(){
        for(Map.Entry<Integer, Integer[]> entry: adjacencyList.entrySet()){
            int u = entry.getKey();
            vertices.add(u);
            for (int v : entry.getValue()){
                vertices.add(v);
            }
        }
    }

    private void updateIncomingVertices(){
        Iterator<Map.Entry<Integer, Integer[]>> mapIt = this.adjacencyList.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry<Integer,Integer[]> entry = mapIt.next();
            int u = entry.getKey();
            Integer[] neighbors = entry.getValue();
            if (neighbors!= null && neighbors.length>=1) {
                for (int neighbor: neighbors) {
                    if (incomingVertices.containsKey(neighbor)){
                        ArrayList<Integer> neighborIncomingArray = incomingVertices.get(neighbor);
                        neighborIncomingArray.add(u);
                    }
                    else{
                        ArrayList<Integer> newArr = new ArrayList<>();
                        newArr.add(u);
                        incomingVertices.put(neighbor,newArr);
                    }
                }
            }
        }
    }

    private void findSources(){
        this.sources = new ArrayList<>(vertices);
        for(Map.Entry<Integer, ArrayList<Integer>> entry: incomingVertices.entrySet()){
            if (entry.getValue()!=null || entry.getValue().size()>0){
                sources.remove(entry.getKey());
            }
        }
    }

    private void findSinks(){
        this.sinks = new ArrayList<>(vertices);
//        System.out.println(sinks.size());
        for(Map.Entry<Integer, Integer[]> entry: adjacencyList.entrySet()){
            int u = entry.getKey();
//            System.out.println("Node " + u + " neighbors: " + Arrays.toString(entry.getValue()));
            sinks.remove((Integer)u);
//            System.out.println("sinks is " + sinks.toString());
        }
    }

    public HashSet<Integer> getVertices(){
        return this.vertices;
    }

    public ArrayList<Integer> getSources(){
        return this.sources;
    }

    public ArrayList<Integer> getSinks(){
        return this.sinks;
    }

    public void topologicalSort(){
        this.visited = new HashSet<>();
        this.traverseResultDecreseFinishTime = new LinkedList<>();
        if (sources.size()==0){
            dfsTraverse((Integer) vertices.toArray()[0]);
        }
        this.visited = new HashSet<>();
        for (int u : sources){
            dfsTraverse(u);
        }
    }

    public boolean isTopological(LinkedList<Integer> sorted){
        int first = sorted.removeFirst();
        while (sorted.size()>0){
            int next = sorted.removeFirst();
            if (sources.contains(next)){
                first = next;
                continue;
            }
            HashSet<Integer> neighbors = new HashSet<>(Arrays.asList(getNeighbors(first)));
            if (!neighbors.contains(next)){
                System.out.println(next +" not neighbor of " + first);
                return false;
            }
            first = next;
        }
        return true;
    }

    public void transpose(){
        HashMap<Integer, Integer[]> transAdjList = new HashMap<>();
        Iterator<Map.Entry<Integer, Integer[]>> mapIt = this.adjacencyList.entrySet().iterator();
        for (int v: vertices){
            transAdjList.put(v, new Integer[]{});
        }
        while(mapIt.hasNext()){
            Map.Entry<Integer,Integer[]> entry = mapIt.next();
            int u = entry.getKey();
            Integer[] neighbors = entry.getValue();
            for (int neighbor: neighbors){
                Integer[] oldList = transAdjList.get(neighbor);
                Integer[] newList = new Integer[oldList.length+1];
                System.arraycopy(oldList,0,newList,0,oldList.length);
                newList[oldList.length] = u;
                transAdjList.replace(neighbor, newList);
            }
        }
//        printAdjList(transAdjList);

        GTransposed = new DirectedGraph(transAdjList);
        GTransposed.setIsTransposed(true);
    }

    public void dfsTraverse(int u) {
        Integer[] neighbors = getNeighbors(u);
        if (neighbors!= null){
            for (int neighbor: neighbors) {
                if (!visited.contains(neighbor)){
                    visited.add(neighbor);
                    dfsTraverse(neighbor);
                }
            }
        }
        traverseResultDecreseFinishTime.addFirst(u);
    }

    public void dfsTraver(int u, ArrayList<Integer> scc){
        Integer[] neighbors = getNeighbors(u);
        if (neighbors!= null){
            for (int neighbor: neighbors) {
//                System.out.println("scc is " + scc.toString() + "\nvisited is " + this.visited + "\nneighbor is " + neighbor );
                if (!visited.contains(neighbor) && !scc.contains(neighbor)){
                    scc.add(neighbor);
                    dfsTraver(neighbor,scc);
                }
            }
        }
    }

    public HashSet findSCC(){
        this.visited = new HashSet<>();
        if (this.GTransposed == null){
            transpose();
        }
        HashSet<ArrayList<Integer>> sccSet = new HashSet<>();
        for (int u : traverseResultDecreseFinishTime){
            ArrayList<Integer> scc = new ArrayList<>();
            scc.add(u);
            GTransposed.dfsTraver(u, scc);
            if(scc.size()>1){
                sccSet.add(scc);
            }
//            System.out.println("scc is " + scc.toString());
            GTransposed.visited.addAll(scc);
//            System.out.println("visited is " + GTransposed.getVisited());
//            System.out.println();
        }
        this.SCCs = sccSet;
        return sccSet;
    }

    public void printAdjList(HashMap adjList){
        Iterator<Map.Entry<Integer, Integer[]>> mapIt = adjList.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry<Integer,Integer[]> entry = mapIt.next();
            int u = entry.getKey();
            Integer[] neighbors = entry.getValue();
            System.out.println(u + " :" + Arrays.toString(neighbors));
        }
    }
}
