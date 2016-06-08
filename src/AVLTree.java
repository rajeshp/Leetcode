/**
 * Created by prajesh on 5/22/16.
 */
public class AVLTree {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        int height=0;

        TreeNode(int x){
            val=x;
        }

    }


    TreeNode root;

    void insert(TreeNode root, int t){

        if(root==null)
            this.root= new TreeNode(t);
        else{
            if(root.val > t)
                insert(root.left, t);
            else
                insert(root.right, t);

//            int height = max(height(root.left), height(root.right))+1;

  //          int balanceFactor = getBalance(root);

        }


    }

    int height(TreeNode root){
        if(root==null)
            return 0;

        return root.height;
    }



}
