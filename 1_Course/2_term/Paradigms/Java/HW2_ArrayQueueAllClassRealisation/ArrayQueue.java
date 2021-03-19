package queue;

import java.util.Arrays;

// Inv: a - ArrayQueue(Circular)
//     |a| >= 0 ∧ ∀i=0..|a|-1 : a[i] != null
public class ArrayQueue extends AbstractQueue{
    //private int size = 0;
    private int start = 0;
    private int end = 0;
    private Object[] elements = new Object[10];

    //Pred: element != null && element - Object
    //Post: |a| == |a'| + 1
    //      ∀i=0..|a'|, Q[i] == Q'[i]
    //      a[|a'|] = element
    public void enqueue(Object element) {
        assert element != null;

        ensureCapacity(size + 1);
        elements[end++] = element;
        size++;
        end %= elements.length;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            Object[] newElements = new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(start + i) % elements.length];
            }
            end = size;
            start = 0;
            elements = newElements;
        }
    }
    //Pred: |a| > 0
    //Post: Result = a[0]
    //      |a| == |a'| - 1
    //      ∀i=0..|a|-1, a[i] == a'[i]
    public Object dequeue() {
        assert size > 0;

        Object value = element();
        size--;
        elements[start] = null;
        start = (start + 1) % elements.length;

        return value;
    }
    // Pre: |a| > 0
    // Post: Result = a[0] && a' == a
    public Object element() {
        assert size > 0;

        return elements[start];
    }


    // Post: |a| = 0
    public void clear() {
        elements = new Object[10];
        size = 0;
        start = 0;
        end = 0;
    }
    // Pred: |a| > 0
    // Post: Result = a && a == a'
    public Object[] toArray() {
        Object copy[] = new Object[size];
        for (int i = 0; i < size; i++) {
            copy[i] = elements[(start + i) % elements.length];
        }
        return copy;
    }
}
