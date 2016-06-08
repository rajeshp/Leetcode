import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by prajesh on 6/7/16.
 */
public class LevelOrderTraversal {

   static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val=x;
        }
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;


        System.out.println(levelOrder(node1));

    }


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> currentList = new ArrayList<Integer>();

        if(root==null)
            return result;

        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();

        TreeNode marker = new TreeNode(Integer.MIN_VALUE);

        queue.offer(root);
        queue.offer(marker);

        TreeNode top=null;



        while(true){

            top = queue.poll();

            if(queue.isEmpty()) {
                result.add(currentList);
                break;
            }

            if(top==marker && queue.size()!=0){
                queue.offer(marker);
                result.add(currentList);
                currentList=new ArrayList<Integer>();
            }
            else{
                currentList.add(top.val);
                if(top.left!=null)
                    queue.offer(top.left);
                if(top.right!=null)
                    queue.offer(top.right);
            }

        }


        return result;
    }
}
