package phase2;
public class nodeLL<T> { 

public T data; 
public nodeLL<T> next;

public nodeLL<T> getNext() {
    return next;
}

public void setNext(nodeLL<T> next) {
    this.next = next;
}

public nodeLL () { 
    data = null; 
    next = null; 
}
    
public nodeLL (T val) {
    data = val;
    next = null; 
}

public T getData() {
        return data;
}

public void setData(T data) {
        this.data = data;
}

}
