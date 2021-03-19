package queue;

/**
 * @author Maksim Shatskikh ( 309697@niuitmo.ru )
 */

public class ArrayQueueTest1 {
    public static void fill(ArrayQueue stack) {
        for (int i = 0; i < 10; i++) {
            stack.enqueue(i);
        }
    }

    public static void dump(ArrayQueue stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.size() + " " +
                    stack.element() + " " + stack.dequeue());
        }
    }

    public static void main(String[] args) {
        ArrayQueue stack = new ArrayQueue();
        fill(stack);
        dump(stack);
    }

}
