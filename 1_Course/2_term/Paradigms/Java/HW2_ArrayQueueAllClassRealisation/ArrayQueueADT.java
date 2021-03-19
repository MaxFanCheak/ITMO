package queue;

import java.util.Arrays;

// Inv: a - ArrayQueue(Circular)
//     |a| >= 0 ∧ ∀i=0..|a|-1 : a[i] != null
public class ArrayQueueADT {
    private /*static*/ int size = 0;
    private /*static*/ int start = 0;
    private /*static*/ int end = 0;
    private /*static*/ Object[] elements = new Object[10];

    //Pred: element != null && element - Object && a != null
    //Post: |a| == |a'| + 1
    //      ∀i=0..|a'|, Q[i] == Q'[i]
    //      a[|a'|] = element
    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;

        ensureCapacity(queue, queue.size + 1);
        queue.elements[queue.end++] = element;
        queue.size++;
        queue.end %= queue.elements.length;
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity > queue.elements.length) {
            Object[] newElements = new Object[capacity * 2];
            for (int i = 0; i < queue.size; i++) {
                newElements[i] = queue.elements[(queue.start + i) % queue.elements.length];
            }
            queue.end = queue.size;
            queue.start = 0;
            queue.elements = newElements;
        }
    }
    //Pred: |a| > 0 && a != null
    //Post: Result = a[0]
    //      |a| == |a'| - 1
    //      ∀i=0..|a|-1, a[i] == a'[i]
    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0;

        Object value = element(queue);
        queue.size--;
        queue.elements[queue.start] = null;
        queue.start = (queue.start + 1) % queue.elements.length;

        return value;
    }

    // Pre: |a| > 0 && a != null
    // Post: Result = a[0] && a' == a
    public static Object element(ArrayQueueADT queue) {
        assert queue.size > 0;

        return queue.elements[queue.start];
    }

    // Pred: a != null
    // Post: Result = size && a == a'
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    // Pred: a != null
    // Post: Result = (size == 0) && a == a'
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }
    // Pred: a != null
    // Post: |a| = 0
    public static void clear(ArrayQueueADT queue) {
        queue.elements = new Object[10];
        queue.size = 0;
        queue.start = 0;
        queue.end = 0;
    }

    // Pred: |a| > 0 && a != null
    // Post: Result = a && a == a'
    public static Object[] toArray(ArrayQueueADT queue) {
        Object copy[] = new Object[queue.size];
        for (int i = 0; i < queue.size; i++) {
            copy[i] = queue.elements[(queue.start + i) % queue.elements.length];
        }
        return copy;
    }
}
