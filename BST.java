import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    public class Node {
        K key;
        V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = putNode(root, key, val);
        size++;
    }

    private Node putNode(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = putNode(node.left, key, val);
        } else if (cmp > 0) {
            node.right = putNode(node.right, key, val);
        } else {
            node.val = val;
        }

        return node;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node != null ? node.val : null;
    }

    private Node getNode(Node node, K key) {
        if (node == null || key.equals(node.key)) {
            return node;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    public void delete(K key) {
        root = deleteNode(root, key);
        size--;
    }

    private Node deleteNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = deleteNode(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node successor = findSuccessor(node.right);
                node.key = successor.key;
                node.val = successor.val;
                node.right = deleteNode(node.right, successor.key);
            }
        }

        return node;
    }

    private Node findSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int size() {
        return size;
    }

    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inorderTraversal(root, keys);
        return keys;
    }

    private void inorderTraversal(Node node, List<K> keys) {
        if (node != null) {
            inorderTraversal(node.left, keys);
            keys.add(node.key);
            inorderTraversal(node.right, keys);
        }
    }

    public Iterable<Node> entries() {
        List<Node> entries = new ArrayList<>();
        entryInorderTraversal(root, entries);
        return entries;
    }

    private void entryInorderTraversal(Node node, List<Node> entries) {
        if (node != null) {
            entryInorderTraversal(node.left, entries);
            entries.add(node);
            entryInorderTraversal(node.right, entries);
        }
    }
}
