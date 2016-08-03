import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by prajesh on 6/28/16.
 */
public class HappyNumber {

    public static void main(String[] args) {

       HappyNumber obj = new HappyNumber();

        System.out.println(obj.isHappy(17));

    }

    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<Integer>());
    }


    public boolean isHappy(int n, Set<Integer> prevNums){

        if(n==1)
            return true;

        if(prevNums.contains(n))
            return false;
        else
            prevNums.add(n);

        int result=0, digit=0;

        while(n>0){
            digit = n%10;
            result+= digit*digit;
            n=n/10;
        }



        return isHappy(result, prevNums);

    }
}
