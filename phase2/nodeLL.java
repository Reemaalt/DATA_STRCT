package phase2;

import org.w3c.dom.events.Event;

public class nodeLL<T> implements Comparable<nodeLL<Events>> { 

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

@Override
public int compareTo(nodeLL<Events> o) {
    return ((Events) this.getData()).getTitle().compareTo(o.getData().getTitle());
}

}
