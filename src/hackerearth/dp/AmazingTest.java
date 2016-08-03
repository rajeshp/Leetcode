package hackerearth.dp;

/**
 * Created by prajesh on 7/8/16.
 */
public class AmazingTest {

    public static void main(String[] args) {

        System.out.println(checkIfCandiesPossible(new int[]{2},1,0,1,1));
        //System.out.println(checkIfCandiesPossible(new int[]{2,4,2},4,0,4,4));
    }

// student = index in a;
    static boolean checkIfCandiesPossible(int[] a, int t, int student, int A, int B){


        if(t==0)
            return false;

        int temp =0;

        if(student<a.length)
            temp = a[student];

        if(student==a.length && A>0 && B>0)
            return true;


        if(A<=0 &&  B<=0)
            return false;
        else
            if(A<=0)
                return  checkIfCandiesPossible(a,t,student++,A,B-temp);
            else
                if(B<=0)
                return checkIfCandiesPossible(a,t,student++,A-temp,B);





        return checkIfCandiesPossible(a,t,student+1, A-temp,B) || checkIfCandiesPossible(a,t,student+1,A,B-temp);

    }
}
