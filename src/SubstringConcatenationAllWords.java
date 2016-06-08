import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by prajesh on 6/3/16.
 */
public class SubstringConcatenationAllWords {

    public static void main(String[] args) {

        System.out.println(findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"}));


    }


    public static List<Integer> findSubstring(String s, String[] words) {

        Set<String> set = new HashSet<>();

        for(int i=0;i<words.length;i++){
            set.add(words[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();

        int len = words[0].length();

        int i=0;




        while(i<s.length() && (i+len) < s.length()){

           if(set.contains(s.substring(i,i+len))){
               result.add(i);
               i=i+len+1;

           }else {
               i++;
           }
        }




        return result;


    }
}
