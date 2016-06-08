package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by prajesh on 6/3/16.
 */
public class ValidParanthesis {

    public static void main(String[] args) {
        System.out.println(isValid("[[]]["));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}','{');
        map.put(']','[');

        int i=0;

        char c = '\0',top='\0';
        while(i<s.length()){

            c=s.charAt(i);

            if(!map.containsKey(c)){


                stack.push(c);

            }else{


                if(stack.isEmpty() || map.get(c)!=stack.peek())
                    return false;

                stack.pop();
            }


            i++;
        }

        return stack.isEmpty();

    }
}
