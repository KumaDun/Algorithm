public class BinarySearch<E extends Comparable<E>>{
    public int binarySearch(E[] arr, E target, int low, int high){
        if (high<low) {
            return -1;
        }
        int mid = (low+high)/2;
        if(arr[mid].equals(target)){
            return mid;
        }
        else if(arr[mid].compareTo(target)>0){
            return binarySearch(arr, target, low,mid-1);
        }
        else{
            return binarySearch(arr, target, mid+1, high);
        }
    }
}
