/**
 * Created by prajesh on 6/3/16.
 */
public class FindDuplicates {

    public static void main(String[] args) {

        //System.out.println(findDuplicate(new int[]{1,2,3,1}));
       // System.out.println(findDuplicate(new int[]{3,2,3,3}));
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));

    }

    public static int findDuplicate(int[] nums) {

        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])] < 0)
                return Math.abs(nums[i]);
            else
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }

        return -1;
    }
}
