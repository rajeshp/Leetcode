import java.util.Stack;

/**
 * Created by prajesh on 5/5/16.
 */
public class KthSmallestBST {


    /**
     * Definition for a binary tree node.
     **/
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


        Stack<TreeNode> stack = new Stack<TreeNode>();


        public int kthSmallest(TreeNode root, int k) {

            while(true){


                while(root!=null){
                    this.stack.push(root);
                    root=root.left;
                }

                while(k>0 && !stack.isEmpty()){
                    root = stack.pop();

                    k--;

                    if(root.right!=null && k > 0){
                        root=root.right;
                        break;
                    }


                }

                if(k==0)
                    break;

            }

            return root.val;

        }

}
