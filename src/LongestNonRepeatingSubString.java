import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajesh on 6/24/16.
 */
public class LongestNonRepeatingSubString {


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }



    public static int lengthOfLongestSubstringNaive(String s) {

        Map<Character, Integer> map ;

        int len=0, maxLen=0;

        for(int i=0;i<s.length();i++){

            map = new HashMap<>();
            len=0;

            for(int j=i;j<s.length();j++){

                if(!map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j),j);
                    len++;
                }
                else
                    break;

            }

            if(len > maxLen)
                maxLen=len;
        }

        return maxLen;
    }



    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int len=0, maxLen=0;

        int i=0,j=0;

        while(j<s.length()){

            if(!map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j),j);
                j++;
                len++;
            }else{
                len = len - map.get(s.charAt(j));
                map.put(s.charAt(j),j);
                i++;
                j++;
            }

            if(len > maxLen)
                maxLen=len;

        }

        return maxLen;
    }

}
