/**
 * Created by prajesh on 6/28/16.
 */
public class RomanToInteger {

    public static void main(String[] args) {

    }



    public int romanToInt(String s) {

return 0;
    }

    public int romanToIntHelper(String s, int sum, int index){

        if(index >= s.length())
            return sum;

        if(s.charAt(index)=='L')
            return romanToIntHelper(s, 1000, index++);

        if(s.charAt(index)=='L')
            return romanToIntHelper(s, 1000, index++);

        return 10;
    }

}
