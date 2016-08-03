/**
 * Created by prajesh on 7/4/16.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"abab","abc",""};
        //String[] strs = new String[]{""};

        LongestCommonPrefix lcp = new LongestCommonPrefix();

        System.out.println(lcp.longestCommonPrefix(strs));
    }


    public String longestCommonPrefix(String[] strs) {

        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        String prefix="";

        if(strs.length>0){


            while(i<strs[0].length()){

                 prefix = strs[0].substring(0,i+1);

                for(j=1;j<strs.length;j++){
                    if(!strs[j].startsWith(prefix))
                        break;
                }

                if(j<strs.length)
                    break;

                i++;
            }

            if(prefix !=null && prefix.length() > 0&& j<strs.length)
             prefix = prefix.substring(0,prefix.length()-1);

        }

        return prefix;
    }
}
