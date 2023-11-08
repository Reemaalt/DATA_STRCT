package phase2;

import javax.swing.tree.TreeNode;

public class ContactBST <T extends Comparable<T>> {

private  Node<T> root , current;
private T data;
   


public ContactBST() {
        root = null;
        current = null ;
       
}

//cheak if the tree is empty
public boolean isEmpty() {
        return root == null;
}

//take the string of the key the call searchKeyRecursive to find it
public T searchKey(String key) {
    return searchKeyRecursive(root, key);
}

//search for the in the tree
private T searchKeyRecursive(Node<T> info, String key) {
    if (isEmpty()) {
        return null;
    }

    if (key.compareTo(info.key) == 0) {
        return info.data;
    }

    if (key.compareTo(info.key) < 0) {
        return searchKeyRecursive(info.left, key);
    }

    return searchKeyRecursive(info.right, key);
}

//find name dose the key exsis 
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

private boolean addcontact( Contact contact, String name){
    Node<T> p;
    Node<T> q= current;

    //is rec in order used correctly?
    if (findkey (contact.getName())|| recInOrderTraversal( contact , contact.getPhoneNumber()))
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
public boolean contactExists(Contact contact) {
    return contactExists(root, contact);
}

private boolean contactExists(TreeNode node, Contact contact) {
        if (node == null) {
            return false;
        }

        int compareResult = contact.compareTo(node.contact);

        if (compareResult == 0) {
            // The contact with the same name already exists.
            return true;
        } else if (compareResult < 0) {
            // The contact may exist in the left subtree.
            return contactExists(node.left, contact);
        } else {
            // The contact may exist in the right subtree.
            return contactExists(node.right, contact);
        }
    }



//printing all the tree
private String recInOrderTraversal(Node<T> node, String result) {
    if (!isEmpty()) {
        result = recInOrderTraversal(node.left, result);
        result += node.data.toString()+ "    ";
        result = recInOrderTraversal(node.right, result);
    }
    return result;
}
//printing
public String toString() {
    String str = "";
    if (isEmpty())
      return str;
    str = recInOrderTraversal ( root , str );
    return str;

}

}
