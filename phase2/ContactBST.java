package phase2;

public class ContactBST <T extends Comparable<T>> {
    private  Node<T> root , current;
    private T data;
    private String key;
    private ContactBST<T> left , right;



public ContactBST() {
        root = null;
        current = null ;
       
}

public ContactBST(String name, T val){
    key=name;
    data=val;
    left=right=null;
}

public boolean isEmpty() {
        return root == null;
}

public T searchKey(String key) {
    return searchKeyRecursive(root, key);
}

private T searchKeyRecursive(Node<T> data, String key) {
    if (isEmpty()) {
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

private boolean addcontact (String name, T val){
    ContactBST<T> p;
    Node<T> q=current;
    //also usse order traversal for phone num
    if (findkey (name))
    {  
       current=q;
       return false;
    }
    p=new ContactBST<T>(name,val);
    if (isEmpty()){
        root=current=p;
        return true;
    }
    else{
        //current on parent of key
        if(name.compareTo(current.key)<0)//how does compareto work
        current.left=p;
        else
        current.right=p;
        current=p;
        return true;
    }
    
}
}

public String toString() {
    String str = "";
    if (isEmpty())
      return str;
    str = recInOrderTraversal ( root , str );
    return str;

}

private String recInOrderTraversal(Node<T> node, String result) {
    if (!isEmpty()) {
        result = recInOrderTraversal(node.left, result);
        result += node.data.toString()+ "    ";
        result = recInOrderTraversal(node.right, result);
    }
    return result;
}

}
