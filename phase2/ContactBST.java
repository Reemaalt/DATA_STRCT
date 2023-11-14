package phase2;

import javax.swing.tree.TreeNode;

public class ContactBST <T extends Comparable<T>> {

private  Node<Contact> root , current;
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
public Contact searchKey(String key) {
    return searchKeyRecursive(root, key);
}

//search for the in the tree
private Contact searchKeyRecursive(Node<Contact> info, String key) {
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
    Node<Contact> p = root ,q = root;
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
    Node<Contact> p;
    Node<Contact> q= current;

    //is rec in order used correctly?
    if (findkey (contact.getName()) || contactExists(contact))
    {  
       current=q;
       return false;
    }
    
    p=new Node<Contact>(name, contact);
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

private boolean contactExists(Node<Contact> node, Contact contact) {
        if (node == null) {
            return false;
        }

        int compareResult = contact.compareToPhone(node.getData().getPhoneNumber());

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

//print all contacts with the same first name 
public void searchSameFirstName(String name) {
        searchSameFirstNameRec(root, name);
    }
    
private void searchSameFirstNameRec(Node<Contact> p, String name) {
        if (p == null) 
            return;

        String[] allContact = ((Contact) p.data).getName().split(" ");
            if (allContact[0].compareToIgnoreCase(name) == 0) 
              System.out.println(((Contact) p.data).toString());
            
        
        searchSameFirstNameRec(p.left, name);
        searchSameFirstNameRec(p.right, name);
    }


public void searchByCriteria(int criteria , String value) {
        searchByCriteriaRec(root, criteria, value);
    }
    
    private void searchByCriteriaRec(Node<Contact> p, int criteria, String value) {
        if (p == null) {
            return;
        }
    
        switch (criteria) {
            case 1:
                if (((Contact) p.data).getPhoneNumber().equalsIgnoreCase(value)) {
                     System.out.println(((Contact) p.data).toString());
                }
                break;

            case 2:
                if (((Contact) p.data).getEmailAddress().equalsIgnoreCase(value)) {
                     System.out.println(((Contact) p.data).toString());
                }
                break;

            case 3:
                if (((Contact) p.data).getAddress().equalsIgnoreCase(value)) {
                    System.out.println(((Contact) p.data).toString());
                }
                break;

            case 4:
                if (((Contact) p.data).getBirthday().equalsIgnoreCase(value)) {
                     System.out.println(((Contact) p.data).toString());
                }
                break;
            
        }
    
        searchByCriteriaRec(p.left, criteria, value);
        searchByCriteriaRec(p.right, criteria, value);
    }
    
    
//printing all the tree
private String recInOrderTraversal(Node<Contact> node, String result) {
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

