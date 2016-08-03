/**
 * Created by prajesh on 6/12/16.
 */
public class ExcelTitle {
    public static void main(String[] args) {
        String res = convertToTitle(3);
        System.out.println(res);
    }

    public static String convertToTitle(int n) {

        int origN=n;

        if(n<=26 && n >0){
           n=n+64;
           return new String(""+(char)n);

        }

        int len=0;

        while(n>0){

            len++;
            n=n/10;
        }

        len--;
        n=origN;


        double res = 0d;

        while(len>0){
            res = Math.pow(10,len) * n/len;

            len--;
        }

        return null;
    }

}
