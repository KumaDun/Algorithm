import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class MinHeapTest {
    MinHeap minHeap;

    @Before
    public void before(){
        int[] elements = {9,14,5,16,11,3,15,8,6,13};
        minHeap = new MinHeap(elements);
    }

    @Test
    public void constructor(){
        int[] arrExp = {3,6,5,8,11,9,15,14,16,13};
        assertArrayEquals(arrExp, minHeap.getArr());
        assertTrue(minHeap.isValid());
    }

    @Test
    public void insertLargest() {
        minHeap.insert(20);
        int[] arrExp = {3,6,5,8,11,9,15,14,16,13,20};
        assertArrayEquals(arrExp, minHeap.getArr());
        assertTrue(minHeap.isValid());
    }

    @Test
    public void insertSmallest(){
        minHeap.insert(1);
        int[] arrExp = {1,3,5,8,6,9,15,14,16,13,11};
        assertArrayEquals(arrExp, minHeap.getArr());
        assertTrue(minHeap.isValid());
    }

    @Test
    public void insertMedium(){
        minHeap.insert(7);
        int[] arrExp = {3,6,5,8,7,9,15,14,16,13,11};
        assertArrayEquals(arrExp, minHeap.getArr());
        assertTrue(minHeap.isValid());
    }

    @Test
    public void extract() {
        int root = minHeap.extract();
        assertEquals(3,root);
        assertTrue(minHeap.isValid());
    }

    @Test
    public void largeSclae(){
        int[] elements = new int[100];
        Random rd = new Random();
        for (int i=0; i< elements.length; i++){
            elements[i] = rd.nextInt(0,500);
        }
        minHeap = new MinHeap(elements);
        assertTrue(minHeap.isValid());
    }
}