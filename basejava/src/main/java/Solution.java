import java.util.*;

/**
 * @author 梦醉
 * @date 2020/2/26--14:05
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
//           System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList nums = new ArrayList();
        LinkedList list = new LinkedList();
        levelOrder(root, list, nums);
        int[] result = new int[nums.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) nums.get(i);
        }
        return result;

    }

    public void levelOrder(TreeNode root, LinkedList list, ArrayList nums) {
        if (root == null) {
            return;
        }
        nums.add(root.val);
        if (root.left != null)
            list.add(root.left);
        if (root.right != null)
            list.add(root.right);
        if (list.size() > 0) {
            TreeNode node = (TreeNode) list.removeFirst();
            if (node != null)
                levelOrder(node, list, nums);

        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
