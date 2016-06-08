package dp;

/**
 * Created by prajesh on 6/1/16.
 */
public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();

      //  System.out.println(obj.lengthOfLIS(new int[]{1,3,5,3,2,4,7}));
        System.out.println(obj.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int[] lis = new int[nums.length];

        lis[0] = 1;
        int maxSofar=nums[0];

        int k=0;

        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                lis[i]=lis[i-1]+1;
                k=i;
            }
            else{
                lis[i]=lis[i-1];

            }

        }

        return lis[nums.length-1];
    }

}
