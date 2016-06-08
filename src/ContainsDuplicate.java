/**
 * Created by prajesh on 5/11/16.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

        System.out.println(containsDuplicate(new int[]{1,2,3,4,4}));
    }

    public static boolean containsDuplicate(int[] nums) {

        boolean result =false;

        int n=0;

        for(int i=0;i<nums.length-1;i++){
            n  = n ^ nums[i] ;
        }

        if(n==1 || n==5)
            return true;
        else
            return false;
    }


    public KthSmallestBST.TreeNode lowestCommonAncestor(KthSmallestBST.TreeNode root, KthSmallestBST.TreeNode p, KthSmallestBST.TreeNode q) {

        if(root==null) return null;

        boolean isMatch=false;

        if(root==p || root == q)
            isMatch=true;

        return null;
       // return (isMatch || lowestCommonAncestor(root.left,p,q) ||  lowestCommonAncestor(root.right,p,q) );
    }

}
