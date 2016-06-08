/**
 * Created by prajesh on 5/17/16.
 */
public class RemoveElement {

    public static void main(String[] args) {
       // System.out.println(removeElement(new int[]{3,1,1},3));
        //System.out.println(removeElement(new int[]{3,2,2,3},3));
        System.out.println(removeElement(new int[]{4,5},5));
    }

    public static  int removeElement(int[] nums, int val) {

        int index = 0, i = 0;

        while (i < nums.length && index<nums.length){

            if(nums[index]!=val)
                index++;

            if(nums[i]!=val && index < nums.length && i > index){
                nums=swap(nums,index,i);
                index++;
            }

        i++;
    }

        return index;
    }




    static int[] swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;

        return nums;
    }

}
