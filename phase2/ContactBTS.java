package phase2;

public class ContactBTS <K extends Comparable<K>, T> {
    private  Node<K,T> root , current;
    //WHY K AND T NOT ONLY T?
    private T data;
    private String key;
    private ContactBTS<K,T> left , right;


//bst 
public ContactBTS() {
        root = null;
        current = null;
}
public ContactBTS(String name, T val){
    key=name;
    data=val;
    left=right=null;
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

    private boolean addcontact (String name, T val){
        ContactBTS<K,T> p , q=current;
        //also usse order traversal for phone num
        if (findkey (name))
        {  
           current=q;
           return false;
        }
        p=new ContactBTS<K,T>(name,val);
        if (empty()){
            root=current=p;
            return true;
        }
        else{
            //current on parent of key
            if(name.compareTo(cuurrent.key)<0)//how does compareto work
            current.left=p;
            else
            current.right=p;
            current=p;
            return true;
        }
        
    }
}
}
