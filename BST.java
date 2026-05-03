import java.util.*;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public class Entry {
        private K key;
        private V val;

        public Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() { return key; }
        public V getValue() { return val; }
    }

    public void put(K key, V val){
        if(root == null){
            root = new Node(key, val);
            size++;
            return;
        }
        Node parent = null;
        Node current = root;

        while(current != null){
            parent = current;
            int cmp_val = key.compareTo(current.key);


            if(cmp_val < 0){
                current = current.left;
            }

            else if(cmp_val > 0){
                current = current.right;
            }

            else{
                current.val = val;
                return;
            }
        }

        int cmp_val = key.compareTo(parent.key);
        if (cmp_val < 0) parent.left = new Node(key, val);
        else parent.right = new Node(key, val);

        size++;
    }
    public V get(K key){
        Node current = root;

        while(current != null){
            int cmp_val = key.compareTo(current.key);

            if(cmp_val < 0){
                current = current.left;
            }
            else if(cmp_val > 0){
                current = current.right;
            }
            else{
                return current.val;
            }
        }

        return null;
    }
    public void delete(K key) {
        if (root == null) {
            return;
        }

        Node current = root;

        while (current != null) {
            int cmp_val = key.compareTo(current.key);

            if (cmp_val < 0) {
                current = current.left;
            } else if (cmp_val > 0) {
                current = current.right;
            } else {
                if (current.key != null) {
                    current.val = null;
                    current.key = null;
                    size--;
                }
                return;
            }
        }
    }
    public Iterable<Entry> iterator() {
        List<Entry> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if(current.key != null){
                result.add(new Entry(current.key, current.val));
            }
            current = current.right;
        }

        return result;
    }

    public int size() {
        return size;
    }
}
