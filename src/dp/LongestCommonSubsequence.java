package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajesh on 6/2/16.
 */
public class LongestCommonSubsequence {

    static Map<String, Integer> map = new HashMap<>();


    public static void main(String[] args) {
        //System.out.println(lcs("".toCharArray(),"".toCharArray(),0,0));
        //System.out.println(lcs("BCA".toCharArray(),"B".toCharArray(),2,0));
        System.out.println(lcs("ACBAADUUDUUAJJAJJA".toCharArray(),"KAJDGKJA8QJJKJAKJKJA".toCharArray(),17,19));
    }


    //memoization solution;

    static int lcs(char[] a, char [] b, int m, int n){

        if(a.length==0 || b.length==0)
            return 0;

        if(n<0 || m <0)
            return 0;

        int count=0;

        if(a[m]==b[n])
            count=1;

        if(!map.containsKey(m+","+n))
        {
            int maxlcs = max(count + lcs(a,b,m-1,n-1), count + lcs(a,b,m-1,n),count + lcs(a,b,m,n-1));
            map.put(m+","+n,maxlcs);

        }


        return map.get(m+","+n);
    }


    static int max(int a, int b, int c)
    {
        if(a>b&& a>c)
            return a;

        if(b>a && b>c)
            return b;

        return c;
    }

}
