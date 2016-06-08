package dp;

import java.util.HashMap;

/**
 * Created by prajesh on 5/22/16.
 */
public class EditDistance {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
       // System.out.println(editDistanceDP("cd".toCharArray() ,"cd".toCharArray(),0,0));
        System.out.println(editDistanceDP("a" ,"b"));
        //System.out.println(editDistanceDP("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef" ,"bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"));
    }


    //Recursion method
    /*
        if word1="abc" word2="adb"

        find the mins(insertCost, removeCost, replaceCost);


     */

   static int editDistance(String word1, String word2){
        if(word1.equals("") || word1==null)
            return word2.length();

        if(word2.equals("") || word2==null)
            return word1.length();

        if(word1.equals(word2))
            return 0;

       if(map.get(word1+"/"+word2)!=null)
           return map.get(word1+"/"+word2);

        int m = word1.length()-1;

        int n = word2.length()-1;

       if(m >=0 && n>=0) {


           if (word1.charAt(m) == word2.charAt(n))
               return editDistance(word1.substring(0, m), word2.substring(0, n));
           else {

               int insertCost = 1 + editDistance(word1 + word2.charAt(n), word2);
               int removeCost = 1 + editDistance(word1.substring(0, m), word2);
               int replaceCost = 1 + editDistance(word1.substring(0, m) + word2.charAt(n), word2);

               int minCost =  min(insertCost, removeCost, replaceCost);

               map.put(word1+"/"+word2,minCost);

               return minCost;
           }

       }

       return 0;
    }


    static int min(int a, int b, int c){

        if(a>b && a>c)
            return a;
        if(b>c && b>a)
            return b;

        return c;
    }



    static int editDistanceDP(String word1, String word2){

       int m = word1.length();
       int n = word2.length();




       int[][] dist = new int[m+1][n+1];


       for(int i=0;i<=m;i++){

           for(int j=0;j<=n;j++){

               if(i==0)
                   dist[i][j]=j+1;
               else
                if(j==0)
                   dist[i][j]=i+1;
                else
                    if(word1.charAt(i)==word2.charAt(j))
                        dist[i][j]=dist[i-1][j-1];
                    else
                        dist[i][j] = 1+ min(dist[i][j-1], dist[i-1][j],dist[i-1][j-1]);


               }

           }






        return dist[m][n];
    }


}
