/**
 * Created by prajesh on 6/3/16.
 */
public class FindDuplicates {

    public static void main(String[] args) {

        //System.out.println(findDuplicate(new int[]{1,2,3,1}));
        System.out.println(findDuplicate(new int[]{2,2,2,1}));

    }

    public static int findDuplicate(int[] nums) {

        int res = 0;

        int x=0;

        for(int i=0;i<nums.length;i++){
            res=res^nums[i];
            x=x^i;
        }

        return res;
    }

}
