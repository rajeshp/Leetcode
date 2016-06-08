/**
 * Created by prajesh on 5/17/16.
 */
public class RangeSearch {

    public static void main(String[] args) {

        System.out.println(searchRange(new int[] {1,1,2,3,3,3,4,5,6,8,10}, 3));

    }



    public static int[] searchRange(int[] nums, int target) {
        int start = findStart(nums, 0, nums.length-1, target);
        int end = findEnd(nums, 0, nums.length-1, target);

        return new int[]{start, end};
    }



    static int findStart(int[] nums, int low, int high, int target){

        if(low<0)
            return -1;

        if(low==0 && nums[low]==target)
            return low;
        else{
            if(target < nums[low] || target > nums[high])
                return -1;

            if(nums[low]==target && nums[low-1] < target && low > 0)
                return low;
            else{

                int mid = (low+high)/2;

                if(low==mid && nums[high]==target)
                    return high;


                int left = findStart(nums, low, mid, target);

                int right=-1;

                if(left==-1)
                    right = findStart(nums, mid, high, target);


                return (left!=-1)? left : right;
            }

        }

        // return -1;
    }

    static int findEnd(int[] nums, int low, int high, int target){

        if(high >= nums.length || target > nums[high] || target < nums[low])
            return -1;


        if(high==nums.length-1 && nums[high]==target)
            return high;
        else{

            if(nums[low]==target && nums[low+1] > target)
                return low;
            else{
                int mid = (low+high)/2;

                if(high==mid && nums[high]==target)
                    return high;


                int right= findEnd(nums, mid, high, target);

                int left=-1;

                if(right==-1)
                    left = findEnd(nums, low, mid, target);



                return (right!=-1) ? right : left;

            }

        }


    }

}
