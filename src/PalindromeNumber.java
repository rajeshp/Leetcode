/**
 * Created by prajesh on 6/7/16.
 */
public class PalindromeNumber {

    public static void main(String[] args) {

       // System.out.println(isPalindrome(1331));
        System.out.println(isPalindrome(9999));

    }

    public static boolean isPalindrome(int x) {
        int len =0,n=x;

        if(n<0)
            return false;

        while(n>0){
            n=n/10;
            len++;
        }

        len--;
        int i=0;

        n=x;

        while(len>0){
            if(! (n%10==n/(int)Math.pow(10,len)))
                return false;


            n=n%(int)Math.pow(10,len) ;
            n=n/10;

            i++;
            len=len-2;
        }

        return true;
    }
}
