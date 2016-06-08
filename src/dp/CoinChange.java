package dp;

/**
 * Created by prajesh on 5/20/16.
 */
public class CoinChange {

    static int[] lookup_table ;

    public static void main(String[] args) {

        System.out.println(coinChangeDP(new int[]{1,2,3}, 4));



    }



   static public int coinChangeRecursive(int[] coins, int amount) {

        if(amount==0)
                return 0;

        int count=0, min_count=Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            if(coins[i]==amount)
                return 1;
            else
                if(amount-coins[i]>=0) {
                    count = 1 + coinChangeRecursive(coins, amount - coins[i]);
                }

            if(count < min_count)
                min_count=count;

        }

       return min_count;
    }

    static public int coinChangeRecursiveMemoization(int[] coins, int amount) {

        if(amount==0)
            return 0;

        int count=0, min_count=Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            if(coins[i]==amount)
                return 1;
            else
            if(amount-coins[i]>=0) {

                if(lookup_table[amount-coins[i]]==-1) {
                    lookup_table[amount-coins[i]] = 1 + coinChangeRecursiveMemoization(coins, amount - coins[i]);
                }

                count = lookup_table[amount-coins[i]];
            }

            if(count < min_count)
                min_count=count;

        }

        return min_count;
    }



    static public int coinChangeDP(int[] coins, int amount){

        if(amount==0)
            return 0;


        int[] change = new int[amount+1];

        change[0]=0;

        int count=0, min_count=Integer.MAX_VALUE;

        for(int i=1;i<amount;i++){

            count=0;
            min_count=Integer.MAX_VALUE;

            for(int j=0;j<coins.length;j++){

                if(coins[j] >= i && change[amount-i]>=0){

                    count = change[amount-i]+1;
                }

                if(count<min_count)
                    min_count=count;
            }

            coins[i]=min_count;

        }

        return min_count;

    }

}
