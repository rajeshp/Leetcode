/**
 * Created by prajesh on 5/21/16.
 */
public class LastWordLength {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("     "));
    }

    public static int lengthOfLastWord(String s) {
        if(s==null || s.equals(""))
            return 0;

        char[] c = s.toCharArray();

        int j = c.length-1;

        int len=0;


        while(c[j]==' ' && j>0){
            j--;
        }

        while(j>=0){
            if(c[j]==' ')
                break;
            j--;
            len++;
        }



        return len;
    }

}
