package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajesh on 6/2/16.
 */
public class IntegerBreak {

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
     //   System.out.println(integerBreak(10));

        map.put(0,0);
        map.put(1,1);

        System.out.println(maxProduct(7));
    }

    public static int integerBreak(int n) {

        if(n<=0)
            return 0;

        if(n==1)
            return 1;

        int[] result =  new int[n+1];

        result[1]=1;

        int prod=0, maxProd=0;

        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=i/2+1;j++){
                prod = j * result[i-j];

                if(prod > maxProd)
                    maxProd=prod;
            }

            result[i]=maxProd;
        }

        return result[n];
    }




    static int maxProduct(int n){

        int maxProd=0, prod=0;

        if(n==0)
            return 0;

        if(n==1)
            return 1;

        if(map.containsKey(n))
            return map.get(n);


        for(int i=1;i<n/2;i++){

            prod = maxProduct(i) * maxProduct(n-i);

            if(prod > maxProd)
                maxProd = prod;
        }


        map.put(n,maxProd);

        return maxProd;
    }

}
