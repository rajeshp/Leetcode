/**
 * Created by prajesh on 5/16/16.
 */
public class WildcardMatching {

    public static void main(String[] args) {

//     System.out.println(isMatch("aaa","a*"));
     System.out.println(isMatch("a","aa"));
     System.out.println(isMatch("aaa","a*"));
     System.out.println(isMatch("aaaedf","aa*df"));
     System.out.println(isMatch("a","*"));
     System.out.println(isMatch("abefcdgiescdfimde","ab*cd?i*de"));



    }


    public static boolean isMatch(String s, String p) {
        if(s==null || p==null)
            return false;

        int i=0, j=0;

        char sc='\0',pc='\0';

        while(i<s.length() && j < p.length()){

            if(s.charAt(i)!=p.charAt(j) && (p.charAt(j)!='?' && p.charAt(j)!='*')){
                return false;
            }else{
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
                    i++;
                    j++;
                }else
                if(p.charAt(j)=='*'){
                    //i++;
                    j++;
                    if(j < p.length()){
                        while(i < s.length() && p.charAt(j)!=s.charAt(i)){
                            i++;
                        }


                    }else
                        return true;


                }


            }

        }

        if(i<s.length() || j<p.length())
            return false;



        return true;

    }

}
