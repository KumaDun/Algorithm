import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    Integer[] arrInt = {1,4,6,8,10,12,18,33,36};
    String[] arrStr = {"a","apple","b","banana","c","citrus","d","dandelion"};
    Character[] arrChar = {'!','`', '1', 'a','d'};

    private BinarySearch searcher;

    @Test
    public void binarySearchInt() {
        searcher = new BinarySearch<Integer>();
        int intSearchIdx = searcher.binarySearch(arrInt, 6,0, arrInt.length-1);
        int intSearchExpected = 2;
        if (intSearchIdx == -1) {
            fail("binarySearch() return -1");
        }
        try {
            assertEquals(intSearchExpected,intSearchIdx);
        }catch (Exception e){
            fail("intSearchIdx: " + intSearchIdx + " is not " + intSearchExpected);
        }
    }

    @Test
    public void binarySearchStr(){
        searcher = new BinarySearch<String>();
        int strSearchIdx = searcher.binarySearch(arrStr, "citrus",0, arrStr.length-1);
        int strSearchExpected = 5;
        if (strSearchIdx == -1) {
            fail("binarySearch() return -1");
        }
        try {
            assertEquals(strSearchExpected,strSearchIdx);
        }catch (Exception e){
            fail("intSearchIdx: " + strSearchIdx + " is not " + strSearchExpected);
        }
    }

    @Test
    public void binarySearchChar(){
        searcher = new BinarySearch<Character>();
        int charSearchIdx = searcher.binarySearch(arrChar, '!',0, arrChar.length-1);
        int charSearchExpected = 0;
        if (charSearchIdx == -1) {
            fail("binarySearch() return -1");
        }
        try {
            assertEquals(charSearchExpected,charSearchIdx);
        }catch (Exception e){
            fail("intSearchIdx: " + charSearchIdx + " is not " + charSearchExpected);
        }
    }
}