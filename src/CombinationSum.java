import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prajesh on 6/3/16.
 */
public class CombinationSum {

    public static void main(String[] args) {

        combinationSum(new int[]{2,3,6,7}, 7);

    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<candidates.length;i++){
            map.put(candidates[i],i);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i=0;i<candidates.length;i++){
            List<Integer> resultset = new ArrayList<Integer>();
            if(candidates[i]==target)
            {
                resultset.add(candidates[i]);
                result.add(resultset);
                continue;
            }

            if(candidates[i]<target)
            {
                int x=candidates[i];

                resultset.add(x);

                while(true){



                        if(map.containsKey(target-x))
                             resultset.add(x);

                    if(target==0){
                        result.add(resultset);
                    }else
                    if(target<0)
                        break;


                    target = target-x;

                }

            }

        }

        return result;
    }


}
