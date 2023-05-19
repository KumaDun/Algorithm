import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSelectTest {
    QuickSelect selector;

    Integer[] intArray1 = {21, 20, 3, 4, 6, 5};
    Integer[] intArray2 = {108, 3, 2, 100, 17, 18, 20, 7, 102, 103, 99, 98, 97, 5, 4,9};
    Integer[] intArray3 = {0,2};
    String[] strArray = {"a", "orange", "citrus", "apple", "dandelion", "banana", "b", "d"};

    Integer[] nonUniqueIntArr = {2,2,8,8,6,6,0,0,3,3,11,11,7,7,1,1};
    @Test
    public void quickSelectIntArr1(){
        selector = new QuickSelect<Integer>();
        Integer target = (Integer) selector.quickSelect(2,intArray1, 0, intArray1.length-1);
        assertTrue(target==5);
    }

    @Test
    public void quickSelectIntArr2(){
        selector = new QuickSelect<Integer>();
        Integer target = (Integer) selector.quickSelect(5,intArray2, 0, intArray2.length-1);
        assertTrue(target==9);
    }

    @Test
    public void quickSelectStrArr(){
        selector = new QuickSelect<String>();
        String target = (String) selector.quickSelect(4,strArray, 0, strArray.length-1);
        assertTrue(target.equals("citrus"));
    }


}