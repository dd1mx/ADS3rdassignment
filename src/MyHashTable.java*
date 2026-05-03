public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    //comment for push
    private HashNode<K, V>[] array;
    private int M = 13;
    private int size;

    public MyHashTable(){
        array = new HashNode[M];
        size = 0;
    }
    public MyHashTable(int M){
        this.M = M;
        array = new HashNode[M];
        size = 0;
    }
    private int hash(K key){
        return (key.hashCode() & Integer.MAX_VALUE) % M;
    }
    public void put(K key, V value){
        int bucketIndex = hash(key);
        HashNode<K, V> head = array[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = array[bucketIndex];
        array[bucketIndex] = newNode;
    }
    public V get(K key){
        int bucketIndex = hash(key);
        HashNode<K, V> head = array[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
    public V remove(K key){
        int bucketIndex = hash(key);
        HashNode<K, V> head = array[bucketIndex];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    array[bucketIndex] = head.next;
                } else {
                    prev.next = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
    public boolean contains(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = array[i];
            while (head != null) {
                if (head.value != null && head.value.equals(value)) {
                    return true;
                } else if (head.value == null && value == null) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }
    public K getKey(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = array[i];
            while (head != null) {
                if (head.value != null && head.value.equals(value)) {
                    return head.key;
                } else if (head.value == null && value == null) {
                    return head.key;
                }
                head = head.next;
            }
        }
        return null;
    }
    public void printBucketSizes() {
        System.out.println("Total elements: " + size);
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> head = array[i];
            while (head != null) {
                count++;
                head = head.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }

    public int size() {
        return size;
    }

}
