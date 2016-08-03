/**
 * Created by prajesh on 5/25/16.
 */
public class NimGame {

    public static void main(String[] args) {

        for(int i=0;i<50;i++)
        System.out.println("n="+i + "  "+canWinNim(i));
    }


    public static boolean canWinNim(int n) {

        return (n%4!=0);
    }





}
