import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajesh on 6/11/16.
 */
public class FindDuplicatesinArray {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{2,4,1,2,6,1,6,3,0}));
    }


    static List<Integer> findDuplicates(int[] arr){
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<arr.length;i++){

            if(arr[Math.abs(arr[i])]<0)
                result.add(Math.abs(arr[i]));
            else{
                arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
            }
        }


        return result;
    }

}
