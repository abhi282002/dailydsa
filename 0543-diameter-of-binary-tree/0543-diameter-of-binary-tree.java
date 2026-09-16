/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter;
    int solve(TreeNode root){
        if(root == null) return 0;

        int lh = solve(root.left);
        int rh = solve(root.right);

        diameter = Math.max(diameter,lh + rh);

        return Math.max(lh,rh) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        solve(root);

        return diameter;
    }
}