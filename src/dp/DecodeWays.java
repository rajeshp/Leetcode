package dp;

/**
 * Created by prajesh on 6/1/16.
 */
public class DecodeWays {

    public static void main(String[] args) {

        DecodeWays obj = new DecodeWays();

       // obj.numDecodings("5");
       // obj.numDecodings("24");
       // obj.numDecodings("55");
       //System.out.println(obj.numDecodings("231"));
       //System.out.println(obj.numDecodings("2315"));
       //System.out.println(obj.numDecodings("2331"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("1234"));
        System.out.println(numDecodings("1226"));
       // System.out.println(numDecodings("23318"));



    }

    public static int numDecodings(String s) {

       if(s==null || s.length()==0)
           return -1;

       int count=1;

       if(s.length()>=2){

           if(Integer.parseInt(s.substring(0,2))<=26)
               count++;
           //else
             //  count++;

           for(int i=2;i<s.length();i++){

               if(Integer.parseInt(s.substring(i-1,i+1)) <=26)
                   count++;


           }
       }

        return count;
    }



}
