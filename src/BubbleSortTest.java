import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;
public class BubbleSortTest {
    BubbleSort sorter;

    Integer[] intArr1 = {3,6,9,2,7,1};
    Integer[] intArr2 = {1,1,1};
    String[] strArr = {"a","banana","dandelion","d","b","citrus","c"};
    @Test
    public void sortTestInt(){
        sorter = new BubbleSort<Integer>();
        sorter.bubbleSort(intArr1,0,intArr1.length-1);
        Integer[] intArr1Exp = {1,2,3,6,7,9};
        assertArrayEquals(intArr1Exp, intArr1);

        sorter.bubbleSort(intArr2, 0, intArr2.length-1);
        Integer[] intArr2Exp = {1, 1, 1};
        assertArrayEquals(intArr2Exp, intArr2);
    }

    @Test
    public void sortTestStr(){
        sorter = new BubbleSort<String>();
        sorter.bubbleSort(strArr, 0, strArr.length-1);
        String[] strArrExp = {"a","b","banana","c","citrus","d","dandelion"};
        assertArrayEquals(strArrExp,strArr);
    }

    @Test
    public void sortTestLargeScale(){
        sorter = new BubbleSort<Integer>();
        Random rd = new Random();
        Integer[] intArrLargeScale = new Integer[1000];
        for (int i=0; i<intArrLargeScale.length; i++){
            intArrLargeScale[i] = (Integer) rd.nextInt(0,3000);
        }
//        System.out.println("Before sort");
//        System.out.println(Arrays.toString(intArrLargeScale));
        sorter.bubbleSort(intArrLargeScale,0, intArrLargeScale.length-1);
//        System.out.println("After sort");
//        System.out.println(Arrays.toString(intArrLargeScale));
        for (int i=0; i<intArrLargeScale.length-1; i++){
            assertTrue(intArrLargeScale[i]<=intArrLargeScale[i+1]);
        }

    }
}
