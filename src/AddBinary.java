/**
 * Created by prajesh on 7/4/16.
 */
public class AddBinary {


    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();

       // System.out.println(addBinary.addBinary("11","1"));
        System.out.println(addBinary.addBinary("1010","1011"));
    }

    public String addBinary(String a, String b) {
        a = reverse(a);
        b = reverse(b);

        int i=0, sum=0, carry=0;
        StringBuilder result = new StringBuilder();

        if(a.length() > b.length()){

            while(i<b.length()){
                sum=carry + (int) a.charAt(i) - 48 + (int)b.charAt(i) - 48;
                if(sum==2){
                    sum=0;
                    carry=1;
                }else
                if(sum==3){
                    sum=1;
                    carry=1;
                }else{
                    carry=0;
                }

                result.append(sum);
                i++;
            }

            while(i<a.length()){
                sum=carry+(int)a.charAt(i) - 48;
                if(sum==2){
                    sum=0;
                    carry=1;
                }else
                if(sum==3){
                    sum=1;
                    carry=1;
                }else {
                    carry = 0;
                }

                result.append(sum);
                i++;
            }

            if(carry!=0)
                result.append(carry);

        }else{


            while(i<a.length()){
                sum=carry + (int)a.charAt(i) - 48 + (int)b.charAt(i)-48;
                if(sum==2){
                    sum=0;
                    carry=1;
                }else
                if(sum==3){
                    sum=1;
                    carry=1;
                }else{
                    carry=0;
                }

                result.append(sum);
                i++;
            }

            while(i<b.length()){
                sum=carry+ (int) b.charAt(i) - 48;
                if(sum==2){
                    sum=0;
                    carry=1;
                }else
                if(sum==3){
                    sum=1;
                    carry=1;
                }else{
                    carry=0;
                }


                result.append(sum);
                i++;
            }

            if(carry!=0)
                result.append(carry);

        }

        return reverse(result.toString());
    }

    String reverse(String s){
        StringBuilder sb = new StringBuilder();

        int i=s.length()-1;

        while(i>=0){
            sb.append(s.charAt(i));
            i--;
        }

        return sb.toString();
    }
}
