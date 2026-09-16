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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return res;
        boolean flip = false;
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> row = new ArrayList<>(); 
                // Create space for this level
                for (int i = 0; i < size; i++) {
                    row.add(0);
                }

            for(int i = 0; i < size; i++){
                TreeNode ele = q.poll();

                int index = flip ? (size - 1 - i) : i;

                row.set(index,ele.val);
                
                if(ele.left != null){
                    q.offer(ele.left);
                }
                if(ele.right != null){
                    q.offer(ele.right);
                }
            }
             res.add(row);
            flip = !flip;
        }

        return res;
    }
}