/**
 * This minHeap is an int minHeap
 * This minHeap tolerates duplicated element
 */
public class MinHeap {
    private int[] heapArr;
    public MinHeap(int[] input){
        this.heapArr = input;
        this.heapify(this.heapArr);
    }

    public int[] getArr(){
        return this.heapArr;
    }
    private void heapify(int[] arr) {
        for(int j = arr.length-1; j>=0; j--){
            bubbleDown(arr,j);
        }
    }

    public boolean insert(int target){
//        for (int i =0; i<this.heapArr.length; i++){
//            if(this.heapArr[i] == target){
//                return false;
//            }
//        }
        try{
            int[] newArr = new int[this.heapArr.length+1];
            System.arraycopy(this.heapArr,0,newArr,0,this.heapArr.length);
            newArr[newArr.length-1] = target;
            bubbleUp(newArr, newArr.length-1);
            this.heapArr = newArr;
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public int extract(){
        int minNode = this.heapArr[0];
        swap(this.heapArr, heapArr.length-1, 0);
        int[] newArr = new int[heapArr.length-1];
        System.arraycopy(heapArr,0,newArr, 0,heapArr.length-1);
        this.heapArr = newArr;
        bubbleDown(heapArr,0);
        return minNode;
    }

    public boolean isValid(){
        for (int i=0; i<heapArr.length;i++){
            int parent = (i-1)/2;
            int lChild = 2 * i+1;
            int rChild = 2 * i+2;
            if (parent < i && heapArr[parent]>heapArr[i]){
                return false;
            }
            if (lChild< heapArr.length && heapArr[lChild]<heapArr[i]){
                return false;
            }
            if (rChild< heapArr.length && heapArr[rChild]<heapArr[i]){
                return false;
            }
        }
        return true;
    }

    private void bubbleDown(int[] arr, int src){
        int leftChild = 2*src+1;
        int rightChild = 2*src+2;
        int smallChild;
        if (leftChild>= heapArr.length){
            return;
        }
        if (rightChild>= heapArr.length){
            smallChild = leftChild;
        }
        else{
            smallChild = (arr[leftChild]>arr[rightChild])? rightChild:leftChild;
        }
        if (arr[src]>arr[smallChild]){
            swap(arr,src,smallChild);
            bubbleDown(arr,smallChild);
        }
        else{
            return;
        }
    }

    private void bubbleUp(int[] arr, int src){
        int parentIdx = (src-1)/2;
        if (parentIdx>=src){
            return;
        }
        if (arr[src] < arr[parentIdx]){
            swap(arr,src,parentIdx);
            bubbleUp(arr, parentIdx);
        }
        else{
            return;
        }
    }

    private void swap(int[] arr, int src, int des){
        int temp = arr[des];
        arr[des] = arr[src];
        arr[src] = temp;
    }
}
