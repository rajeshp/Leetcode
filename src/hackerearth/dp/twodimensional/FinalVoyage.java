package hackerearth.dp.twodimensional;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by prajesh on 7/11/16.
 */
public class FinalVoyage {

    static  Map<Integer,Integer> map=null;

    public static void main(String[] args) {

        map=new HashMap<>();
        System.out.println(getMaxValueRecursive(new int[]{1,2,3}, new int[]{2,4,8},3,0,0));
        System.out.println(getMaxValueRecursive(new int[]{2,4,5,7}, new int[]{4,9,7,5},8,0,0));

/*

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        long[] result = new long[cases];


        for(int i=0;i<cases;i++){

            int n = scanner.nextInt();
            int w = scanner.nextInt();

            int[] weights = new int[n];
            int[] values = new int[n];

            for(int k=0;k<n;k++)
                weights[k]=scanner.nextInt();

            for(int k=0;k<n;k++)
                values[k] = scanner.nextInt();


            map=new HashMap<>();

            result[i] = getMaxValueRecursiveMemoization(weights, values,w,0,0);
        }

        for(int i=0;i<cases;i++){
            System.out.println(result[i]);
        }
*/

    }


   static int getMaxValueRecursive(int[] weights, int[] values, int weight, int value, int index){

        if(weights==null || weights.length==0 || values==null || values.length==0 || weight<=0 || index>=weights.length || index < 0)
            return value;

        int choose=0, leave=0;

        if(weights[index] <= weight)
        choose = getMaxValueRecursive(weights,values, weight-weights[index], value+values[index],index+1);

       leave = getMaxValueRecursive(weights,values,weight,value,index+1);


        return Math.max(choose, leave);
    }


    static int getMaxValueRecursiveMemoization(int[] weights, int[] values, int weight, int value, int index){

        if(weights==null || weights.length==0 || values==null || values.length==0 || weight<=0 || index>=weights.length || index < 0)
            return value;

        int choose=0, leave=0;

        if(!map.containsKey(index)) {

            if (weights[index] <= weight)
                choose = getMaxValueRecursiveMemoization(weights, values, weight - weights[index], value + values[index], index + 1);

            leave = getMaxValueRecursiveMemoization(weights, values, weight, value, index + 1);
        }else
            return map.get(index);


        map.put(index, Math.max(choose, leave));
        return Math.max(choose, leave);
    }

}
