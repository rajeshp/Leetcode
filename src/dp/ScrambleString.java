package dp;

/**
 * Created by prajesh on 6/3/16.
 */
public class ScrambleString {

    public static void main(String[] args) {

    }

    public boolean isScramble(String s1, String s2) {

        return false;
    }

    public boolean isScramble(char[] s1, char[] s2, int l1, int l2){

       if(s1[l1]==s2[l2])
           return true;

       if(s1[l2]==s2[l1])
           return true;


        return false;
    }

}
