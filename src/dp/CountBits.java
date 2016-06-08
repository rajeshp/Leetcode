package dp;

/**
 * Created by prajesh on 6/2/16.
 */
public class CountBits {
    public static void main(String[] args) {
        System.out.println(countBits(10));
    }

    static public int[] countBits(int num) {

        if(num<=0)
            return new int[1];

        int[] bits = new int[num+1];

        bits[0]=0;
        bits[1]=1;

        int lastPowerOf2=0;

        for(int i=2;i<=num;i++){
            if(is2Power(i)){
                bits[i]=1;
                lastPowerOf2=i;
            }else{
                bits[i]=1+bits[i-lastPowerOf2];
            }
        }

        return bits;
    }

   static boolean is2Power(int n){
        return (n & n-1)==0 ;
    }
}
