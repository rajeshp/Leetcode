
/**
 * Created by prajesh on 5/16/16.
 */



public class SumRootToLeafNumbers {


    /**
     * Definition for a binary tree node.
     */
   static public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }



    public static int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;

        if(root.left==null && root.right==null)
            return root.val;

        int left=0, right=0, pow=0;

        if(root.left!=null){
            left= sumNumbers(root.left);
            pow =  find10Power(left);
            pow++;
            left = (root.val * (int) Math.pow(10, pow)) + left;
        }

        if(root.right!=null){
            right = sumNumbers(root.right);

            pow =  find10Power(right);
            pow++;
            right = (root.val * (int) Math.pow(10, pow)) + right;

        }





        return left+right;
    }

   static int find10Power(int x){

        int count=0;

        while(x>9){
            x=x/10;
            count++;
        }

        return count++;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);

        root.left = root1;
        root.right =  root2;

        System.out.println(sumNumbers(root));

    }

}
