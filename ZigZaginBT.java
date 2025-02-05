import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// TC: O(n), as all the nodes are visited.
// SC: O(n) iterative approach makes use of queue which contains the max size
// per level.

// Direction flag is used for appending the values from start or end of the list
public class ZigZaginBT {
    static List<List<Integer>> result;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        result = new ArrayList<>();
        print(root);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void print(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int direction = -1;
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode current = queue.poll();
                if (direction == 1)
                    list.add(0, current.val);
                else
                    list.add(list.size(), current.val);
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            if (direction == 1) {
                direction = -1;
            } else
                direction = 1;
            result.add(list);
        }
    }
}