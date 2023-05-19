### defence: replace
Description: This function seeks for key and value. And if it matches up changes it
Code:
```java
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
```



### hashCode
Description: This function takes 3 params from MyTestingClass @jobId @fullname @salary and conpiles it to hash by primary moves. Uses written stringToHashCode method.
Code:
```java
public int hashCode() {
        int result = 17;
        result = 31 * result + jobId;
        result = 31 * result + (fullName == null ? 0 : stringHashCode(fullName));
        long temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return Math.abs(result);
    }
```

### stringHasgCode
Description: This function was designed to be used in hashCode method instead of using Object.hash()
Code:
```java
 private int stringHashCode(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = 31 * hash + s.charAt(i);
        }
        return Math.abs(hash);
    }
```

### put
Description: This function is used to insert a key-value pair into the hash table. It calculates the index using the hash function, and if the chain at that index is null, it creates a new LinkedList to store multiple key-value pairs. It then iterates over the chain to check if the key already exists. If found, it updates the value; otherwise, it adds a new HashNode with the given key and value.

Code:
```java
public void put(K key, V value) {
    int index = hash(key);
    if (chain[index] == null) {
        chain[index] = new LinkedList<HashNode<K, V>>();
    }
    for (HashNode<K, V> node : chain[index]) {
        if (node.getKey().equals(key)) {
            node.setValue(value);
            return;
        }
    }
    chain[index].add(new HashNode<K, V>(key, value));
    size++;
}
```

### get
Description: This function is used to retrieve the value associated with a given key from the hash table. It calculates the index using the hash function and then iterates over the chain at that index to find the matching key. If found, it returns the corresponding value; otherwise, it returns null.

Code:
```java
public V get(K key) {
    int index = hash(key);
    if (chain[index] == null) {
        return null;
    }
    for (HashNode<K, V> node : ch paain[index]) {
        if (node.getKey().equals(key)) {
            return node.getValue();
        }
    }
    return null;
}
```

### remove
Description: This function is used to remove a key-value pair from the hash table. It calculates the index using the hash function and then iterates over the chain at that index to find the matching key. If found, it removes the corresponding HashNode from the chain, decrements the size, and returns the value; otherwise, it returns null.

Code:
```java
public V remove(K key) {
    int index = hash(key);
    if (chain[index] == null) {
        return null;
    }
    for (HashNode<K, V> node : chain[index]) {
        if (node.getKey().equals(key)) {
            chain[index].remove(node);
            size--;
            return node.getValue();
        }
    }
    size--;
    return null;
}
```

### contains
Description: This function checks if the hash table contains a specific value. It iterates over all the chains in the hash table and checks if any HashNode's value matches the given value. If found, it returns true; otherwise, it returns false.

Code:
```java
public boolean contains(V value) {
    for (LinkedList<HashNode<K, V>> list : chain) {
        for (HashNode<K, V> node : list) {
            if (node.getValue().equals(value)) {
                return true;
            }
        }
    }
    return false;
}
```
