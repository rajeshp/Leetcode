import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajesh on 5/11/16.
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        if(nums.length==1)
            return nums[0];

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && map.get(nums[i]) >= 1){
                map.put(nums[i], map.get(nums[i])+1);

                if(map.get(nums[i]) > nums.length/2)
                    return nums[i];
            }
            else
                map.put(nums[i],1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > nums.length/2)
                return key;
        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {1,2,2,2}));
    }
}
