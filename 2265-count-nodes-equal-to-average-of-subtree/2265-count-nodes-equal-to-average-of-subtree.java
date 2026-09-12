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
class Pair{
    int sum;
    int count;
    Pair(int sum,int count){
        this.sum = sum;
        this.count = count;
    }
}
class Solution {
    int result;
    Pair solve(TreeNode root){
        if(root == null) return new Pair(0,0);

        Pair pl = solve(root.left);
        Pair pr = solve(root.right);

        int totalSum = pl.sum + pr.sum + root.val;
        int totalCount = pl.count + pr.count + 1;
        if(totalSum / totalCount == root.val){
            result +=1;
        }

        return new Pair(totalSum,totalCount);
    }
    public int averageOfSubtree(TreeNode root) {
         result = 0;
         solve(root);
         return result;
    }
}