package queue;



public class LinkedQueue extends AbstractQueue {
    private Node start, end;

    public LinkedQueue() {
        start = end = null;
        size = 0;
    }

    public class Node {
        private Object element;
        private Node next;

        public Node(Object element) {
            assert element != null;
            this.element = element;
            this.next = null;
        }
    }


    public void enqueue(Object element) {
        if (end == null) {
            start = end = new Node(element);
        } else {
            end.next = new Node(element);
            end = end.next;
        }
    }


    public Object element() {
        return start.element;
    }


    public Object dequeue() {
        Object copy = element();
        start = start.next;
        if (size - 1 == 0) end = null;
        return copy;
    }


    public void clear() {
        start = end = null;
    }

    public Object[] toArray() {
        Object[] copy = new Object[size];
        Node elem = start;
        for (int i = 0; i < size; i++) {
            copy[i]=elem.element;
            elem=elem.next;
        }
        return copy;
    }
}
