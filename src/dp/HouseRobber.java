package dp;

/**
 * Created by prajesh on 5/18/16.
 */
public class HouseRobber {

    public static void main(String[] args) {

        System.out.println(rob(new int[]{2,1,1,2}));
        System.out.println(rob(new int[]{1,3,1}));

    }

    public static int rob(int[] nums) {

     if(nums==null)
         return 0;

        if(nums.length==1)
            return nums[0];

        if(nums.length==2)
            return max(nums[0], nums[1]);



         int[] out = new int[nums.length];

         out[0] = nums[0];

         if (nums[1] > nums[0])
             out[1] = nums[1];
         else
             out[1] = nums[0];


         for (int i = 2; i < nums.length; i++) {
             out[i] =  max(nums[i] + out[i - 2], out[i - 1]);
         }


         return out[nums.length - 1];



    }


    static int max(int a, int b){
        return (a>b)? a : b;
    }
}
