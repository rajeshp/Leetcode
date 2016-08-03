package hackerearth.dp.twodimensional;

import java.util.HashMap;
import java.util.Scanner;



/**
 * Created by prajesh on 7/11/16.
 */
public class RoyAndFarm {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        //System.out.println(getMaxEarnings(new int[]{80,60}, new int[]{40,20}, 50,0, 0));
       System.out.println(getMaxEarnings(new int[]{100,50,40,60,100}, new int[]{40,40,50,20,50}, 100,0, 0,0));
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        int[][] result = new int[cases][2];

        for(int i=0;i<cases;i++) {

            int n = scanner.nextInt();

            int amount = scanner.nextInt();

            int[] prices = new int[n];
            int[] cost = new int[n];

            for(int j=0;j<n;j++){
                prices[j] = scanner.nextInt();
                cost[j] = scanner.nextInt();
            }


            result[i] = getMaxEarnings(prices, cost, amount, 0,0, 0);

        }

        for(int i=0;i<cases;i++) {
            System.out.println(result[i][0] + " "+ result[i][1]);
        }
    }

   static int[] getMaxEarnings(int[] prices, int[] cost, int amount, int earnings, int expense, int index){

       if(amount<=0 || index>=cost.length || index <0)
           return new int[]{expense, earnings + amount};


       if(amount<cost[index])
           return new int[] {expense, earnings + amount};

       int[] buy = getMaxEarnings(prices, cost, amount - cost[index], earnings+prices[index],expense + cost[index],index+1);
       int[] leave = getMaxEarnings(prices, cost, amount , earnings,expense,index+1);


       if(buy[1] > leave[1]){
           map.put(index, buy[1]);
           return buy;
       }else
           if(buy[1] < leave[1]){
               map.put(index, leave[1]);
               return leave;
           }
           else
               if(buy[1]==leave[1]){
                map.put(index, buy[1]);
                return new int[]{Math.min(buy[0], leave[0]), buy[1]};
               }


      // map.put(index, Math.max(buy, leave));

       return new int[]{expense, map.get(index)};
    }

}
