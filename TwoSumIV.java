
import java.util.*;
 class Treenode{
    int val;
    Treenode left, right;
    Treenode(int val) {
        this.val = val;
    }
}

class TwoSumIV {
    public boolean findTarget(Treenode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper(root, set, k);
    }

    private boolean helper(Treenode node, Set<Integer> set, int k) {
        if (node == null) return false;

        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);

        return helper(node.left, set, k) || helper(node.right, set, k);
    }

    public static void main(String[] args) {
        // Example BST
        Treenode root = new Treenode(5);
        root.left = new Treenode(3);
        root.right = new Treenode(6);
        root.left.left = new Treenode(2);
        root.left.right = new Treenode(4);
        root.right.right = new Treenode(7);

        TwoSumIV ts = new TwoSumIV();
        System.out.println(ts.findTarget(root, 9));  // ✅ true
        System.out.println(ts.findTarget(root, 28)); // ❌ false
    }
}
