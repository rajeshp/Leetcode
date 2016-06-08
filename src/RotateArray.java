/**
 * Created by prajesh on 6/7/16.
 */
public class RotateArray {

    public static void main(String[] args) {

        //rotate(new int[]{1,2,3,4,5,6,7,8,9},2);
        rotate(new int[]{1,2,3},2);
    }


    public static void rotate(int[] nums, int k) {

        int i=0,n=nums.length-1;

        while(i<k){
            swap(nums,i, n-i);
            i++;
        }


        int x=0;

        while(i+x<n-k-x){
            swap(nums,i+x,n-k-x);
            x++;
        }

        i=k;
        x=0;

        while(i+x<n-x){
            swap(nums,i+x,n-x);
            x++;
        }

    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }

}
