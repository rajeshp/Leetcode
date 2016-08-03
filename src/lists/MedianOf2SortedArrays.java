package lists;

/**
 * Created by prajesh on 6/27/16.
 */
public class MedianOf2SortedArrays {

    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0d;
    }

    static double findMedianSortedArrays(int[] nums1, int i, int[] nums2, int j) {

        if(i==0)

            if(nums1[i] < nums2[j]){

                findMedianSortedArrays(nums1, (i+nums1.length)/2,nums2, j);

            }else{

                findMedianSortedArrays(nums1, i,nums2, (j+nums2.length)/2);

            }

        return 0d;
    }

}
