package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DirectedGraphTest {

    private DirectedGraph G;
    Integer[] zeroNeighbor = {6};
    Integer[] oneNeighbor = {0};
    Integer[] twoNeighbor = {6,5,4};
    Integer[] threeNeighbor = {0,6};
    Integer[] fourNeighbor = {5};
    Integer[] fiveNeighbor = {6};
    Integer[] sixNeighbor = {1};
    HashMap<Integer, Integer[]> adjList = new HashMap<>();

    @Before
    public void init(){
        adjList.put(0,zeroNeighbor);
        adjList.put(1,oneNeighbor);
        adjList.put(2,twoNeighbor);
        adjList.put(3,threeNeighbor);
        adjList.put(4,fourNeighbor);
        adjList.put(5,fiveNeighbor);
        adjList.put(6,sixNeighbor);
        this.G = new DirectedGraph(adjList);
    }


    @Test
    public void getNeighborsTest() {
        assertArrayEquals(zeroNeighbor,G.getNeighbors(0));
        assertArrayEquals(twoNeighbor,G.getNeighbors(2));
    }

    @Test
    public void checkEdgeTest() {
        assertTrue(G.checkEdge(3,6));
        assertTrue(G.checkEdge(6,1));
        assertFalse(G.checkEdge(1,2));
    }

    @Test
    public void getVerticesTest() {
        assertArrayEquals(new Integer[]{0,1,2,3,4,5,6}, G.getVertices().toArray());
    }

    @Test
    public void getSources() {
//        System.out.println(G.getSources().toString());
        assertArrayEquals(new Integer[]{2,3}, G.getSources().toArray());
    }

    @Test
    public void addEdgeTest(){
        G.addEdge(7,2);
        assertTrue(G.checkEdge(7,2));
        assertFalse(G.checkEdge(2,7));
        assertArrayEquals(new Integer[]{0,1,2,3,4,5,6,7}, G.getVertices().toArray());
        assertArrayEquals(new Integer[]{3,7}, G.getSources().toArray());
    }

    @Test
    public void getSinks() {
        G.addEdge(2,7);
        assertArrayEquals(new Integer[]{0,1,2,3,4,5,6,7},G.getVertices().toArray());
        assertArrayEquals(new Integer[]{7}, G.getSinks().toArray());
    }

    @Test
    public void topologicalSort() {
        //[3, 2, 4, 5, 6, 1, 0]
        System.out.println(G.getTraverseResultDecreseFinishTime().toString());
        assertTrue(G.isTopological(G.getTraverseResultDecreseFinishTime()));
    }

    @Test
    public void transposeTest(){
        G.transpose();
        DirectedGraph G_T = G.getGTransposed();
        assertArrayEquals(new Integer[]{1,3},G_T.getNeighbors(0));
        assertArrayEquals(new Integer[]{6}, G_T.getNeighbors(1));
        assertArrayEquals(new Integer[]{}, G_T.getNeighbors(3));
        assertArrayEquals(new Integer[]{2}, G_T.getNeighbors(4));
        assertArrayEquals(new Integer[]{2,4}, G_T.getNeighbors(5));
        assertArrayEquals(new Integer[]{0,2,3,5}, G_T.getNeighbors(6));
    }

    @Test
    public void findSCCTest(){
        //[3, 2, 4, 5, 6, 1, 0]
        G.transpose();
        HashSet<Integer> sccSet = G.findSCC();
        Iterator it = sccSet.iterator();
        assertTrue(sccSet.contains(new ArrayList<>(Arrays.asList(6,0,1))));
//        while(it.hasNext()){
//            System.out.println(it.next().toString());
//        }
    }
}