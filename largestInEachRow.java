
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
 * Tc --> O(n)
 * Sc --> O(n)
 */
class Solution {

    List<Integer> res;

    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        bfs(root);
        return res;

    }

    public void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return;
        }
        res.add(root.val);
        q.add(root);

        while (!q.isEmpty()) {
            int s = q.size();
            int max_val = Integer.MIN_VALUE;
            boolean flag = false;
            for (int i = 0; i < s; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    if (node.left.val >= max_val) {
                        max_val = node.left.val;
                        flag = true;

                    }

                    q.add(node.left);

                }//if

                if (node.right != null) {
                    if (node.right.val >= max_val) {
                        max_val = node.right.val;
                        flag = true;

                    }

                    q.add(node.right);

                }//if

            }//for
            if (flag) {
                res.add(max_val);
            }

        }//while

    }
}
