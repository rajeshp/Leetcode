package dp;

/**
 * Created by prajesh on 6/2/16.
 */
public class MaximumProdSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,-3,-2,4}));
    }

    public static int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;

        int[] temp = new int[nums.length];

        temp[0]=nums[0];

        int prod=0, maxProd=Integer.MIN_VALUE;

        for(int i=1;i<nums.length;i++){

            if(nums[i] > (temp[i-1] * nums[i])){
                temp[i] =  nums[i];

            }else{
                temp[i] = temp[i-1]*nums[i];

            }

            prod = temp[i];

            if(prod > maxProd)
                maxProd = prod;

        }

        return maxProd;
    }
}
