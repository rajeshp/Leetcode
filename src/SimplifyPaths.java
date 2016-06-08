import java.util.Stack;

/**
 * Created by prajesh on 6/3/16.
 */
public class SimplifyPaths {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/c"));
        System.out.println(simplifyPath("/a/b/c"));
        System.out.println(simplifyPath("/a/./../b/c"));
        System.out.println(simplifyPath("/.."));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] directories = path.split("/");

        int i=0;

        while(i<directories.length){

            if(!directories[i].equals(".") && !directories[i].equals("")){

                if(directories[i].equals("..")){
                    if( !stack.isEmpty())
                        stack.pop();

                }else
                    stack.push(directories[i]);


            }

            i++;
        }

        StringBuilder sb = new StringBuilder();

        if(stack.isEmpty())
            return "/";

        while(!stack.isEmpty()){
            sb.insert(0,"/"+stack.pop());


        }

        return sb.toString();
    }

}
