import java.util.Random;

public class QuickSelect<E extends Comparable> {

    Random rd = new Random();
    public E quickSelect(int i, E[] arr, int low, int high) {
        if (i >= arr.length) {
            return null;
        }
        if (low>high){
            return null;
        }
        if (low == high) {
            if (low == i) {
//                System.out.println("low == i");
                return arr[low];
            }
            else{
                return null;
            }
        }
        int pivotIdx = rd.nextInt(low, high);
        E pivot = arr[pivotIdx];
        int p = positionAndPartition(arr,low,high,pivot);
        if (p<i) {
            return quickSelect(i,arr,p+1,high);
        }
        else if (p>i){
            return quickSelect(i,arr,low,p-1);
        }
        else{
            return pivot;
        }
    }

    private int positionAndPartition(E[] arr, int low, int high, E pivot){
        int i = low;
        int j = high;
        int k = low;
        int pivotCount = 0;
        for (int a =low; a<=high; a++) {
            if (arr[a]==pivot) {
                pivotCount ++;
            }
        }
//         System.out.println(pivot);
        while(j>i+pivotCount-1){
//             System.out.println("i: " + i + ", j: " + j + ", k: " + k);
            if (arr[k].compareTo(pivot)>0) {
                swap(arr,k,j);
                j = j-1;
            }
            else if (arr[k].compareTo(pivot) < 0){
                swap(arr,k,i);
                i = i+1;
                k = k+1;
            }
            else{
                k = k+1;
            }
        }
        return i;
    }

    private void swap (E[] arr, int src, int des){
        if (src == des) {
            return;
        }
        E temp = arr[des];
        arr[des] = arr[src];
        arr[src] = temp;
    }
}
