package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajesh on 5/12/16.
 */
public class StairClimbing {
    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            System.out.println(i + " => "+climbStairs(i));
        }
    }


    public static int climbStairs(int n) {

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        map.put(0,0);
        map.put(1,1);
        map.put(2,2);

        if(n > 2) {

            for (int i = 3; i <= n; i++) {
                map.put(i, map.get(i - 1) + map.get(i - 2));
            }

        }

        return map.get(n);
    }
}
