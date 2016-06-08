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

        if(s==null || s.length()==0)
            return 0;

        if(s.length()==1){
            return 1;
        }

        if(s.length()==2){
            int n = Integer.parseInt(s);

            if(n<=26)
                return 2;
            else
                return 1;
        }


        int count=1, len=s.length();

        int[] temp = new int[s.length()];

        temp[0] = numDecodings(s.substring(s.length()-1));
        temp[1] = numDecodings(s.substring(s.length()-2));

        for(int i=2;i<s.length();i++){
            temp[i]= numDecodings(s.substring(s.length()-i-1, s.length()-i+1));
            temp[i]+=temp[i-2];
        }

        return temp[temp.length-1];
    }



}
