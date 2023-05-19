/**
 * NOT FINISHED
 */
public class DeterministicSelect<E extends Comparable> {
    BubbleSort bubbleSorter = new BubbleSort();
    public E deterministicSelect(E[] arr, int i, int low, int high){
        if (arr.length <= 10){
            bubbleSorter.bubbleSort(arr,low,high);
            return arr[i];
        }
        E[] subGroups = (E[] )new Object[(high-low)/5 + 1];
        int k;
        for (k =0; k< subGroups.length; k++) {
            subGroups[k] = deterministicSelect(arr, 3, k*5, (k*5+4>high)? high:k*5+4);
        }
        E M = deterministicSelect(subGroups, k/2, 0, subGroups.length-1);

        //TODO
        return null;
    }
}
