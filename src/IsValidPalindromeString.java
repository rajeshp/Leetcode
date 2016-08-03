/**
 * Created by prajesh on 7/4/16.
 */
public class IsValidPalindromeString {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {

        s=removeChars(s.toLowerCase());

        int len = s.length();
        s=s.toLowerCase();

        int i=0, j=len-1;

        while(i<j){

            if((s.charAt(i)>=97 && s.charAt(i) <=122) || (s.charAt(i)>=48 && s.charAt(i)<=57)){

                if((s.charAt(j)>=97 && s.charAt(j) <=122) || (s.charAt(j)>=48 && s.charAt(j)<=57)){

                    if(s.charAt(i)==s.charAt(j)){
                        i++;
                        j--;

                    }else
                        break;


                }else{
                    j--;
                    continue;
                }


            }else{
                i++;
                continue;
            }



        }

        return (i>=j);
    }


    public static String removeChars(String s){
        StringBuilder sb = new StringBuilder();

        int len = s.length(), i=0;

        char c='\0';

        while(i<len){

            c=s.charAt(i);

            if((c>=97 && c<=122) || (c>=48 && c<=57)) {
            sb.append(c);
            }

            i++;
        }

        return sb.toString();
    }


}
