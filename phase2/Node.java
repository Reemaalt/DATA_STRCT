package phase2;
public class Node<K extends Comparable<K> , T> { 
        public K key ;
        public T data; 
        public Node<K ,T> left , right;

public Node () { 
    left = right = null ;
    }

public Node (K key ,T data) {
    this.key = key  ;  
    this.data = data;
    left = right = null;
} 

public Node(K key, T data, Node<K,T> left, Node<K,T> right){
    this.key = key  ;  
    this.data = data;
    this.left = left;
    this.right = right ;
}

public T getData() {
        return data;
    }


public void setData(T data) {
        this.data = data;
    }


}
