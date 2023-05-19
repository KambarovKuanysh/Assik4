import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HashTable<K, V> {
    private LinkedList<HashNode<K, V>>[] chain;
    private int M = 11;
    private int size;
    public HashTable() {
        chain = new LinkedList[M];
        size = 0;
    }
    public HashTable(int m) {
        this.M = m;
        chain = new LinkedList[M];
        size = 0;
    }
    private int hash(K key) {
        return key.hashCode() % M;
    }
    public void put(K key, V value) {
        int index = hash(key);
        if (chain[index] == null){
            chain[index] = new LinkedList<HashNode<K, V>>();
        }
        for (HashNode<K, V> node: chain[index]){
            if(node.getKey().equals(key)){
                node.setValue(value);
                return;
            }
        }
        chain[index].add(new HashNode<K, V>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (chain[index] == null) return null;

        for (HashNode<K, V> node: chain[index]){
            if(node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }
    public V remove(K key) {
        int index = hash(key);
        if (chain[index] == null) return null;

        for (HashNode<K, V> node: chain[index]){
            if(node.getKey().equals(key)) {
                chain[index].remove(node);
                size--;
                return node.getValue();
            }
        }
        size--;
        return null;
    }
    public boolean contains(V value) {
        for(LinkedList<HashNode<K,V>> list: chain) {
            for(HashNode<K,V> node: list){
                if (node.getValue().equals(value)) return true;
            }
        }
        return false;
    }
    public K getKey(V value) {
        for(LinkedList<HashNode<K,V>> list: chain) {
            for(HashNode<K,V> node: list){
                if (node.getValue().equals(value)) return node.getKey();
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }
    public int[] getBucketSize() {
        int[] bucketSize = new int[M];
        for (int i = 0; i < M; i++) {
            if (chain[i] != null) {
                bucketSize[i] = chain[i].size();
            }
        }
        return bucketSize;
    }
    public void replace(K key, V oldValue, V newValue){
        for (LinkedList<HashNode<K, V>> list : chain) {
            if (list != null) {
                for (HashNode<K, V> node : list) {
                    if(node.getKey().equals(key) && node.getValue().equals(oldValue)){
                        node.setValue(newValue);
                    }
                }
            }
        }
    }

}