package basic;

/**
 * Created by prajesh on 6/9/16.
 */
public class HeapSort {

    public static void main(String[] args) {

        HeapSort heapSortObj = new HeapSort();
        int[] input = new int[]{2,5,1,3,7,9,8,4};

        heapSortObj.maxHeapify(input, input.length-1, input.length);

    }

    int[] heapSort(int[] arr){

        int parent=0;

        for(int i=arr.length-1;i>0;i--){

            parent = i-1/2;
        }


        return arr;
    }


    void maxHeapify(int[] arr, int currIndex, int heapsize){

        int left = 2*currIndex+1;
        int right = 2*currIndex+2;
        int larger = 0;

        if(left<heapsize && arr[left]>arr[currIndex])
            larger=left;

        if(right<heapsize && arr[right] > arr[currIndex])
            larger = right;

        if(larger!=currIndex) {
            swap(arr, currIndex, larger);
            maxHeapify(arr,larger,heapsize);
        }

    }

    void swap(int[] arr, int a, int b){
        int temp = arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }

}
