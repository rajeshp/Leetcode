import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by prajesh on 5/14/16.
 */
public class BinaryTreeRightView {

    class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int x){
            val=x;
        }

    }

    public static void main(String[] args) {

    }


    public List<Integer> rightSideView(TreeNode root) {


        if(root==null)
            return null;

        List<Integer> result = new ArrayList<Integer>();




       /* TreeNode marker = new TreeNode(Integer.MIN_VALUE);

        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();

        queue.put(root);
        queue.put(marker);

        TreeNode prevRoot;

        while(!queue.isEmpty()){
            root=queue.poll();

            if(root==marker){
                if(prevRoot==marker)
                    break;

                result.add(prevRoot);
                queue.put(marker);
            }else{
                if(root.left!=null)
                    queue.put(root.left);
                if(root.right!=null)
                    queue.put(root.right);
            }


            prevRoot=root;
        }*/


        return result;
    }


}
