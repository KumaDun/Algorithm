import java.util.Random;

public class QuickSort<E extends Comparable> {

    Random rd = new Random();

    public void quickSort(E[] arr, int low, int high) {
        if (low < high) {
            int randIdx = rd.nextInt(low,high+1);
            E pivot = arr[randIdx];
            int p = positionAndPartition(arr, low, high, pivot);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }

    /**
     * For a section staring at low ending at high of arr
     * Find the position of pivot in the arr and meanwhile
     * put smaller E to left of pivot
     * put larger E to right of pivot
     * @param arr array
     * @param low lowest index of the arr section
     * @param high highest index of the arr section
     * @param pivot pivot element
     * @return correct position of the pivot
     */
    private int positionAndPartition(E[] arr, int low, int high, E pivot) {
        int i = low;
        int j = high;
        // index of the element being checked
        int k = low;
//        System.out.println(pivot);
        int pivotCount = 0;
        for (int a=low; a<=high;a++){
            if (arr[a] == pivot){
                pivotCount += 1;
            }
        }
        while(j>i+pivotCount-1) {
//            System.out.println("i: " + i + " j: " + j + " k: " + k);
            if (arr[k].compareTo(pivot)>0){
                // move larger element to tail
                swap(arr,k,j);
                j = j-1;
            }
            else if(arr[k].compareTo(pivot)<0) {
                // move smaller element to head
                swap(arr,k,i);
                i = i+1;
                // move checking index
                k = k+1;
            }
            else{
                // skip pivot
                k = k+1;
            }
        }
//        System.out.println(i);
        return i;
    }

    private void swap(E[] arr, int src, int des) {
        if(src == des) {return;}
        E temp = arr[des];
        arr[des] = arr[src];
        arr[src] = temp;
    }
}
