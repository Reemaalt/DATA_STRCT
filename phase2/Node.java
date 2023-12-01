package phase2;
public class Node<T> { 
        public String key ;
        public T data; 
        public Node<T> left , right;



        
    public Node(String key, T data) {
        this.key = key;
        this.data = data;
        this.left = null;
        this.right = null;
    }


public T getData() {
        return data;
    }


public void setData(T data) {
        this.data = data;
    }


}
