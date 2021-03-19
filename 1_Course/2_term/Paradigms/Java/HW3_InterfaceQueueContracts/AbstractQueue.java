package queue;

public abstract class AbstractQueue implements Queue {
    protected int size = 0;
    // Post: Result = size && a == a'
    public int size() {
        return size;
    }
    // Post: Result = (size == 0) && a == a'
    public boolean isEmpty() {
        return size == 0;
    }

}
