/**
 * Created by prajesh on 5/11/16.
 */
public class HammingWeight {

    public static void main(String[] args) {

       System.out.println(getHammingWeight(19));
    }

    static int getHammingWeight(int n){

       // if((n & (n-1)) != 0){

        //}else
          //  return 1;

        int count=0;

        while(n > 0){
            n = n & (n-1);
            count++;
        }

        return count;
    }
}
