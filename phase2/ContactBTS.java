package phase2;

public class ContactBTS <K extends Comparable<K>, T> {
    private  Node<K,T> root , current;



public ContactBTS() {
        root = null;
        current = null;
}

public boolean empty() {
        return root == null;
}

public T searchKey(K key) {
    return searchKeyRecursive(root, key);
}

private T searchKeyRecursive(Node<K, T> data, K key) {
    if (empty()) {
        return null;
    }

    if (key.compareTo(data.key) == 0) {
        return data.data;
    }

    if (key.compareTo(data.key) < 0) {
        return searchKeyRecursive(data.left, key);
    }

    return searchKeyRecursive(data.right, key);
}
}
