import java.util.*;
import java.util.AbstractMap.SimpleEntry;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        // Map<column, list of nodes>
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();

        queue.offer(new AbstractMap.SimpleEntry<>(root, 0));

        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> removed = queue.poll();
            TreeNode node = removed.getKey();
            int col = removed.getValue();

            if (node != null) {
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }

                map.get(col).add(node.val);

                min = Math.min(min, col);
                max = Math.max(max, col);

                queue.offer(new AbstractMap.SimpleEntry<>(node.left, col - 1));
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, col + 1));
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        // Example tree:
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        VerticalTraversal vt = new VerticalTraversal();
        System.out.println(vt.verticalTraversal(root));
    }

}
