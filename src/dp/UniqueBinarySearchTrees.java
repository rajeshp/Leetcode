package dp;

/**
 * Created by prajesh on 5/30/16.
 */
public class UniqueBinarySearchTrees {


    static int[] T =null;


    public static void main(String[] args) {

        UniqueBinarySearchTrees obj = new UniqueBinarySearchTrees();

        System.out.println(obj.numTrees(5));

    }



    public int numTrees(int n) {

        T = new int[n+1];

        T[0]=1;
        T[1]=1;

        int sum = 0;

        int j=0;

        for(int i=2;i<=n;i++){

            j=1;

            while(j<=i){
                sum+=T[j-1]*T[i-j];
                j++;
            }

            T[i] = sum;
            sum=0;
        }



        return T[n];
    }

}
