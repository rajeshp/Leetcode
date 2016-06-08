import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prajesh on 6/3/16.
 */
public class IntersectionOfArraysII {

    public static void main(String[] args) {
        System.out.println(intersect(new int[]{1}, new int[]{1,1}));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i]))
            {
                map.put(nums1[i], map.get(nums1[i])+1);
            }else
                map.put(nums1[i],1);
        }

        List<Integer> res = new ArrayList<Integer>();

        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                    res.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i])-1);
                }

        }

        int[] result = new int[res.size()];

        for(int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }

        return result;
    }
}
