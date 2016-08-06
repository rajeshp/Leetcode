import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajesh on 4/15/16.
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        char c;

        int maxSize=0,currSize=0;

        int start=0, end=0;

        while(end < s.length()){
            c = s.charAt(end);

            if(!map.containsKey(c)){
                map.put(c,end);

                currSize++;
            }
            else{
                currSize=(end - map.get(c));
                start = end;
                map.put(c,end);

            }

            end++;

            if(currSize>maxSize)
                maxSize=currSize;

        }


        return maxSize;
    }

    public static void main(String[] args){

        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abba"));


    }

}
