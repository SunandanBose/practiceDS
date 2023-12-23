import java.util.Comparator;

public class MyTreeMap<K, V> {
    private Node root;
    private Comparator<? super K> comparator;

    public MyTreeMap() {
        this(null);
    }

    public MyTreeMap(Comparator<? super K> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        int cmp = compare(key, node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public V get(K key) {
        Node result = get(root, key);
        return (result == null) ? null : result.value;
    }

    private Node get(Node node, K key) {
        while (node != null) {
            int cmp = compare(key, node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    private int size(Node node) {
        return (node == null) ? 0 : node.size;
    }

    private int compare(K key1, K key2) {
        if (comparator != null) {
            return comparator.compare(key1, key2);
        } else {
            @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key1;
            return k.compareTo(key2);
        }
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.left = this.right = null;
        }
    }

}
