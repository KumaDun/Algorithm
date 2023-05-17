import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {
    int[] arr1 = {4, 8, 92, 7, 17, 89, 6, 10};
    int[] arr1Expected = {4,6,7,8,10,17,89,92};

    int[] arr2 = {0};
    int[] arr2Expected = {0};

    int[] arr3 = {4, 8, 92, 7, 17, 89, 6};
    int[] arr3Expected = {4,6,7,8,17,89,92};

    int[] nullArr = null;
    int[] defaultArr = new int[1];
    int[] defaultArrExpected = {0};

    int[] emptyArr;
    int[] emptyArrExpected = null;

    @org.junit.Test
    public void mergeSort1() {
        MergeSort.mergeSort(arr1);
        try {
            assertArrayEquals(arr1, arr1Expected);
        }
        catch (Exception e){
            MergeSort.printArray(arr1);
        }
    }

    @org.junit.Test
    public void mergeSort2() {
        MergeSort.mergeSort(arr2);
        try {
            assertArrayEquals(arr2, arr2Expected);
        }
        catch (Exception e){
            MergeSort.printArray(arr2);
        }
    }

    @Test
    public void mergeSort3() {
        MergeSort.mergeSort(arr3);
        try {
            assertArrayEquals(arr3, arr3Expected);
        }
        catch (Exception e){
            MergeSort.printArray(arr3);
        }
    }

    @Test
    public void mergeSortNullArr() {
        MergeSort.mergeSort(nullArr);
        try {
            assertNull(nullArr);
        }
        catch (Exception e){
            fail("NullList not null after mergeSort()");
        }
    }

    @Test
    public void mergeSortDefaultArr() {
        MergeSort.mergeSort(defaultArr);
        try {
            assertArrayEquals(defaultArr, defaultArrExpected);
        }
        catch (Exception e){
            fail("defaultArr not equal to {0}");
        }
    }

    @Test
    public void mergeSortEmptyArr() {
        MergeSort.mergeSort(emptyArr);
        try {
            assertArrayEquals(emptyArr, emptyArrExpected);
        }
        catch (Exception e){
            MergeSort.printArray(emptyArr);
            fail("emptyArr not being empty after mergeSort");
        }
    }
}