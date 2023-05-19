public class BubbleSort<E extends Comparable> {

    public void bubbleSort(E[] arr, int low, int high) {
        for (int i=low; i<=high; i++) {
            for (int j=0; j<=high-i-1;j++){
                if(arr[j].compareTo(arr[j+1])>0){
                    E temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
