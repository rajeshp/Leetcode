package dp;

/**
 * Created by prajesh on 6/7/16.
 */
public class MergeSortedArray {

    public static void main(String[] args) {

      int[] arr1 = new int[5];
      arr1[0]=1;
      arr1[1]=4;
      arr1[2]=5;

      merge(arr1,3, new int[]{2,3},2);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int j=m+n-1;

        if(m > 0 && n>0){


            int p=0,q=0;

            while(j>=0){

                if(p==m || q==n)
                    break;

                if(nums1[p] < nums2[q])
                    nums1[j]=nums1[p++];
                else
                    nums1[j]=nums2[q++];

                j--;
            }

            if(p==m){

                while(q<n){
                    nums1[j--]=nums2[q++];
                }
            }


        }

    }

}
