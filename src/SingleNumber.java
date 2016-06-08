/**
 * Created by prajesh on 5/12/16.
 */
public class SingleNumber {
    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{1,2,2,1,3,5}));

    }


    public static int[] singleNumber(int[] nums) {

        int res=0;

        for(int i=0;i<nums.length;i++){
            res = res ^ nums[i];
        }


        return null;
    }

}
