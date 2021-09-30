

public class BinarySearchTree {
    private static class Node {
        Node left;
        Node right;
        int value;
        int key;

        public Node(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }

    Node root = null;

    public Node search(int key) {
        return search(this.root, key);
    }

    public void add(int key, int value) {
        this.root = staticAdd(this.root, key, value);
    }

    public static Node staticAdd(Node root, int key, int value) {
        if (root == null) {
            root = new Node(value, key);
        } else if (root.key == key) {
            root.value = value;
        } else if (root.key < key) {
            root = staticAdd(root.right, key, value);
        } else {
            root = staticAdd(root.left, key, value);
        }
        return root;

    }

    public void remove(int key) {
        this.root = staticRemove(this.root, key);
    }

    public static Node staticRemove(Node root, int key) {
        if (root.key == key) {
            root = null;
        } else if (root.key < key) {
            root = staticRemove(root.right, key);
        } else {
            root = staticRemove(root.left, key);
        }
        return root;

    }

    public static Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        } else if (root.key < key) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }

    public static void main(String[] args) {


    }
}