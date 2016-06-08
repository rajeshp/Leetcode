/**
 * Created by prajesh on 5/25/16.
 */
public class NimGame {

    public static void main(String[] args) {

        for(int i=0;i<10;i++)
        System.out.println(canWinNim(i));
    }


    public static boolean canWinNim(int n) {

        return playA(n);
    }


    public static boolean playA(int n){

        if(n==0)
            return true;

        if(n<4)
            return true;

        if(n==4)
            return false;

        return (!playB(n-1)) || (!playB(n-2)) || (!playB(n-3));
    }

    public static boolean playB(int n){

        if(n==0)
            return false;

        if(n<4)
            return true;

        if(n==4)
            return false;


    return playA(n-1) || playA(n-2) || playA(n-3);

    }

}
