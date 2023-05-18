import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest<E> {
    Integer[] intArray1 = {21, 20, 3, 4, 6, 5};
    Integer[] intArray2 = {108, 3, 2, 100, 17, 18, 20, 7, 102, 103, 99, 98, 97, 5, 4,9};
    Integer[] intArray3 = {0,2};
    Integer[] intArray4 = {21, 20, 3, 4, 6, 5,4};
    String[] strArray = {"a", "orange", "citrus", "apple", "dandelion", "banana", "b", "d"};

    Integer[] nonUniqueIntArr = {2,2,8,8,6,6,0,0,3,3,11,11,7,7,1,1};

    QuickSort sorter;
    @Test
    public void quickSortInt() {
        sorter = new QuickSort<Integer>();

        sorter.quickSort(intArray1,0,intArray1.length-1);
        Integer[] intArray1Exp = {3, 4, 5, 6, 20, 21};
        assertArrayEquals(intArray1Exp,intArray1);

        sorter.quickSort(intArray2,0,intArray2.length-1);
        Integer[] intArray2Exp = {2,3, 4,5,7,9,17,18,20,97,98,99,100,102, 103,108};
        assertArrayEquals(intArray2Exp,intArray2);

        sorter.quickSort(intArray3,0,intArray3.length-1);
        Integer[] intArray3Exp = {0,2};
        assertArrayEquals(intArray3Exp,intArray3);

        sorter.quickSort(intArray4,0,intArray4.length-1);
        Integer[] intArray4Exp = {3, 4, 4, 5, 6, 20, 21};
        assertArrayEquals(intArray4Exp,intArray4);
    }

    @Test
    public void quickSortStr(){
        sorter = new QuickSort<String>();
        sorter.quickSort(strArray,0,strArray.length-1);
        String[] strArrExp = {"a", "apple", "b", "banana", "citrus", "d", "dandelion", "orange"};
        assertArrayEquals(strArrExp,strArray);
    }

    @Test
    public void quickSortNonUnique(){
        sorter = new QuickSort<Integer>();
        sorter.quickSort(nonUniqueIntArr,0,nonUniqueIntArr.length-1);
        Integer[] nonUniqueIntArrExp = {0,0,1,1,2,2,3,3,6,6,7,7,8,8,11,11};
        assertArrayEquals(nonUniqueIntArrExp,nonUniqueIntArr);
    }
}