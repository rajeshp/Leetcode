package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by prajesh on 6/2/16.
 */
public class PerfectSquares {

    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {

        System.out.println(numSquares(10));
    }

    public static int numSquares(int n) {

        if(n==0)
            return 0;

        if(n==1)
            return 1;


        if(map.containsKey(n))
            return 1;

        int square =0;

        for(int i=(int)Math.sqrt(n)+1;i>0;i--){

            square = i*i;

            if(!map.containsKey(square))
                map.put(square,i);
            else
                break;
        }

        int[] temp = new int[n+1];

        for(int i=1;i<=n;i++){

            if(map.containsKey(i))
                temp[i]=1;
            else {
                //temp[i] = Integer.MAX_VALUE;
                int count=0, minCount=Integer.MAX_VALUE;

                for(int key : map.keySet()){

                    if(key > n)
                        continue;

                    while(key<n){

                        count = 1+temp[n-key];
                        n=n-key;
                    }

                    if(count < minCount)
                        minCount = count;

                }

                temp[i] =  minCount;

            }
        }

        return temp[n];
    }

    static int min(int a, int b){
        return (a<b)?a:b;
    }
}
