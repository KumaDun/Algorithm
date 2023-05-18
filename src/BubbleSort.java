public class BubbleSort<E extends Comparable> {

    public void bubbleSort(E[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length-i-1;j++){
                if(arr[j].compareTo(arr[j+1])>0){
                    E temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
