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
        System.out.println(obj.numDecodings("23112"));
        System.out.println(obj.numDecodings("23318"));



    }

    public int numDecodings(String s) {

        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        if(s.length()==2){
            if(Integer.parseInt(s) > 26)
                return 2;
            else
                return 1;
        }


        return 1 + numDecodings(s.substring(0,2));

    }



}
