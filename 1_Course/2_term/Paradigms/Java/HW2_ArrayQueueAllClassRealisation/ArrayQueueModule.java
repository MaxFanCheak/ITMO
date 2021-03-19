package queue;

import java.util.Arrays;

// Inv: a - ArrayQueue(Circular)
//     |a| >= 0 ∧ ∀i=0..|a|-1 : a[i] != null
public class ArrayQueueModule {
    private static int size = 0;
    private static int start = 0;
    private static int end = 0;
    private static Object[] elements = new Object[10];

    //Pred: element != null && element - Object
    //Post: |a| == |a'| + 1
    //      ∀i=0..|a'|, Q[i] == Q'[i]
    //      a[|a'|] = element
    public static void enqueue(Object element) {
        assert element != null;

        ensureCapacity(size + 1);
        elements[end++] = element;
        size++;
        end %= elements.length;
    }

    private static void ensureCapacity(int capacity) {
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
    public static Object dequeue() {
        assert size > 0;

        Object value = element();
        size--;
        elements[start] = null;
        start = (start + 1) % elements.length;

        return value;
    }

    // Pre: |a| > 0
    // Post: Result = a[0] && a' == a
    public static Object element() {
        assert size > 0;

        return elements[start];
    }

    // Post: Result = size && a == a'
    public static int size() {
        return size;
    }

    // Post: Result = (size == 0) && a == a'
    public static boolean isEmpty() {
        return size == 0;
    }

    // Post: |a| = 0
    public static void clear() {
        elements = new Object[10];
        size = 0;
        start = 0;
        end = 0;
    }

    // Pred: |a| > 0
    // Post: Result = a && a == a'
    public static Object[] toArray() {
        Object copy[] = new Object[size];
        for (int i = 0; i < size; i++) {
            copy[i] = elements[(start + i) % elements.length];
        }
        return copy;
    }
}

