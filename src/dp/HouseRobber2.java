package dp;

/**
 * Created by prajesh on 6/2/16.
 */
public class HouseRobber2 {

    public static void main(String[] args) {

        //System.out.println(rob(new int[]{3,2,1,4}));
       // System.out.println(rob(new int[]{10,8,1,2,5,9,3,7}));
       // System.out.println(rob(new int[]{1,1,1,1}));
       // System.out.println(rob(new int[]{1,2,1,0}));
        System.out.println(rob(new int[]{2,1,1,1}));
        //System.out.println(rob(new int[]{1,2,1,0}));
    }


    public static int rob(int[] nums) {

        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        if(nums.length==2)
            return max(nums[0], nums[1]);


        int[] temp = new int[nums.length];

        temp[1]=nums[1];
       // temp[2]=max(nums[1],nums[2]);

        for(int i=2;i< nums.length-1;i++){

            temp[i] = nums[i]+max(temp[i-2], temp[i-1]-nums[i-1]);


        }

      //  int a = max(temp[nums.length-2], temp[nums.length-3]);

      //  int b = max(nums[0], nums[nums.length-1]);

        if(nums.length>3) {


                return max(temp[nums.length - 2] + nums[0],temp[nums.length - 3] + nums[nums.length - 1]);

            //} else
              //  return temp[nums.length - 3] + nums[nums.length - 1];

        }else {
            return max(nums[0], max(nums[1], nums[2]));
        }

        //if(nums.length > 3)
        //temp[0] = nums[0] + max(temp[nums.length-2],temp[nums.length-1]-nums[nums.length-1]);

        //return max(temp[0], temp[nums.length-1]);

       // return (a + b);

    }


    static int max(int a, int b){
        return (a>b)? a : b;
    }
}
