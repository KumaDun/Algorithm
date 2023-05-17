import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;

public class BinarySearchTest<E> {

    Integer[] arr1 = {1,4,6,8,10,12,18,33,36};
    String[] arr2 = {"a","apple","b","banana","c","citrus","d","dandelion"};
    Character[] arr3 = {'!','`', '1', 'a','d'};

    private BinarySearch searcher;

    @Test
    public void binarySearchInt() {
        searcher = new BinarySearch<Integer>();
        int intSearchIdx = searcher.binarySearch(arr1, 6,0,arr1.length-1);
        int intSearchExpected = 2;
        try {
            assertEquals(intSearchExpected,intSearchIdx);
        }catch (Exception e){
            fail("intSearchIdx: " + intSearchIdx + " is not " + intSearchExpected);
        }
    }

    @Test
    public void binarySearchStr(){
        searcher = new BinarySearch<String>();
        int strSearchIdx = searcher.binarySearch(arr2, "citrus",0,arr2.length-1);
        int strSearchExpected = 5;
        try {
            assertEquals(strSearchExpected,strSearchIdx);
        }catch (Exception e){
            fail("intSearchIdx: " + strSearchIdx + " is not " + strSearchExpected);
        }
    }

    @Test
    public void binarySearchChar(){
        searcher = new BinarySearch<Character>();
        int charSearchIdx = searcher.binarySearch(arr3, '!',0,arr3.length-1);
        int charSearchExpected = 0;
        try {
            assertEquals(charSearchExpected,charSearchIdx);
        }catch (Exception e){
            fail("intSearchIdx: " + charSearchIdx + " is not " + charSearchExpected);
        }
    }
}