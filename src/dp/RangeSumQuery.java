package dp;

/**
 * Created by prajesh on 5/12/16.
 */
public class RangeSumQuery {

    public static class NumArray {

        static int[][] result = null;

        int[] nums=null;

        public NumArray(int[] nums) {

            result = new int[nums.length][nums.length];

            for(int i=0;i< nums.length;i++){
                for(int j=0;j<nums.length;j++){
                    result[i][j]=Integer.MIN_VALUE;
                }
            }

            this.nums = nums;
        }

        public int sumRange(int i, int j) {

            if(i==j){
                result[i][j]= this.nums[i];
                return this.nums[i];
            }

          /*
            //recursive function , doesn't use intermediate k values
            if(result[i][j]==Integer.MIN_VALUE) {
                result[i][j] = sumRange(i, j-1) + nums[j];

            }

            */



            //for(int k=i;k<j;k++){

              //  if(result[i][k] == Integer.MIN_VALUE){
                    result[i][j] = sumRange(i,i) + sumRange(i+1,j);
               // }

            //}

            return result[i][j];
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{-2,0,3,-5,2,1};

        NumArray numArray = new NumArray(input);

     //   System.out.println(numArray.sumRange(0,2));
          System.out.println(numArray.sumRange(2,5));

     //   System.out.println(numArray.sumRange(2,5));
     //   System.out.println(numArray.sumRange(0,5));

    }
}
