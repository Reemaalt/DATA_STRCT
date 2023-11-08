package phase2;

import javax.print.DocFlavor.STRING;

public class ContactBST <T extends Comparable<T>> {
    private  Node<T> root , current;
    private T data;
   


public ContactBST() {
        root = null;
        current = null ;
       
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

public boolean findkey(String name) { 
    Node<T> p = root ,q = root;
    if(isEmpty())
    return false;

    while(p != null) { 
        q = p;
    if(p.key.equals(name)) 
    { 
    current = p;
    return true;
    }
    else if(name.compareTo(p.key)< 0)
    p=p.left;
    else 
    p=p.right;
    }
    
    current = q; 
    return false;
}

private boolean addcontact ( <Contact> contact, String name){
    Node<T> p;
    Node<T> q=current;

    //is rec in order used correctly?
    if (findkey (contact.getName())|| recInOrderTraversal(contact , contact.getPhoneNumber()))
    {  
       current=q;
       return false;
    }
    
    p=new Node<T>(name, contact);
    if (isEmpty()){
        root=current=p;
        return true;
    }
    else{
        //current on parent of key
        if(name.compareTo(current.key)<0)//to insert in alphabatecal order
              current.left=p;
        else
              current.right=p;
        current=p;
        return true;
    }
    
}


public String toString() {
    String str = "";
    if (isEmpty())
      return str;
    str = recInOrderTraversal ( root , str );
    return str;

}
//how does it work
private String recInOrderTraversal(Node<T> node, String result) {
    if (!isEmpty()) {
        result = recInOrderTraversal(node.left, result);
        result += node.data.toString()+ "    ";
        result = recInOrderTraversal(node.right, result);
    }
    return result;
}

}
