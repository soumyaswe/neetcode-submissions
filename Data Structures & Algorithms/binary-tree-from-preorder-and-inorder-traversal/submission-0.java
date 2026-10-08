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
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);    
    }
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preEnd < 0 || preStart > preEnd || inEnd < 0 || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inorderMap.get(preorder[preStart]);
        int leftNodes = rootIndex - inStart;

        root.left = helper(preorder, preStart+1, preStart + leftNodes, inorder, inStart, rootIndex-1);
        root.right = helper(preorder, preStart + leftNodes + 1, preEnd, inorder, rootIndex+1, inEnd);

        return root;
    }
}
