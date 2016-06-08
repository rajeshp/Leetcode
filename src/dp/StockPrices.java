package dp;

/**
 * Created by prajesh on 5/20/16.
 */
public class StockPrices {
    public static void main(String[] args) {

        System.out.println(maxProfitDP(new int[] {5,4,7,14,1,3,18,5,6}));

    }

    public static int maxProfit(int[] prices) {

        if(prices==null || prices.length==0)
            return 0;


        int[][] profit = new int[prices.length][prices.length];

        int maxProfit=0;

        for(int i=0;i<profit.length;i++){

            for(int j=i+1;j<profit.length;j++){

                profit[i][j] = prices[j] -  prices[i];

                if(profit[i][j] > maxProfit)
                    maxProfit = profit[i][j];
            }



        }


        return maxProfit;
    }


    public static int maxProfitDP(int[] prices) {

        if(prices==null || prices.length==0)
            return 0;


        int profit=0, maxProfit=0, max_so_far=prices[0], min_so_far=prices[0];

        for(int i=1;i<prices.length;i++){

            if(prices[i] < min_so_far){
                min_so_far = prices[i];

                //buy

            }

            if(prices[i] > min_so_far){
                max_so_far = prices[i];

                //sell
                profit = max_so_far-min_so_far;

                if(profit > maxProfit)
                    maxProfit=profit;
            }


        }


        return maxProfit;
    }


}


