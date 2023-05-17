import java.util.Arrays;

public class MergeSort {


    public static void mergeSort(int[] intArray) {
        if(intArray == null) {
            return;
        }
        if (intArray.length == 0 ){
            return;
        }
        splitAndMerge(intArray,0,intArray.length-1);
    }

    private static void splitAndMerge(int[] intArray, int startPos, int endPos) {
//        System.out.println("startPos " + startPos);
//        System.out.println("endPos " + endPos);
        if (startPos< endPos) {
            int midPos = (startPos + endPos) /2;
//            System.out.println("midPos " + midPos);
            splitAndMerge(intArray,startPos,midPos);
            splitAndMerge(intArray,midPos+1,endPos);
            merge(intArray,startPos,midPos,endPos);
        }
    }

    private static void merge(int[] intArray, int l, int m, int r){
        int[] A = Arrays.copyOfRange(intArray,l,m+1);
        int[] B = Arrays.copyOfRange(intArray,m+1,r+1);
        int i=0, j=0, k = l;
        while(i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                intArray[k] = A[i];
                i = i+1;
                k = k+1;
            }
            else{
                intArray[k] = B[j];
                j = j+1;
                k = k+1;
            }
        }
        while(i < A.length) {
            intArray[k] = A[i];
            i = i+1;
            k = k+1;
        }
        while(j < B.length) {
            intArray[k] = B[j];
            j = j+1;
            k = k+1;
        }
        System.out.println("Merged list finished");
    }

    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void main (String[] args) {

    }
}
