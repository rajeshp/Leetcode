/**
 * Created by prajesh on 5/18/16.
 */
public class RotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5,6,7,8,9,1,2}));
        System.out.println(findMin(new int[]{1,2,3}));
    }

    public static int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        return findMin(nums, 0, nums.length-1);

    }


    static int findMin(int[] nums, int low, int high){
        if(low > high)
            return -1;

        if(nums[low]==nums[high])
            return nums[low];


        if(nums[low] < nums[high])
            return nums[low];

        int mid = (low+high)/2;

        int left=-1, right=-1;

        if(nums[low] > nums[mid])
            left = findMin(nums, low, mid);

        if(nums[mid] > nums[high])
            right = findMin(nums, mid+1, high);

        if(left==-1 && right==-1)
            return -1;

        if(left==-1)
            return right;
        else
        if(right==-1)
            return left;

        return (left > right)? left : right;
    }

    static int min(int a, int b, int c){
        if(a < b && a< c)
            return a;

        if(b < c && b < a)
            return b;

        return c;
    }

}
