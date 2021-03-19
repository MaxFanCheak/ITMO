package queue;

// Inv: a - ArrayQueue(Circular)
//     |a| >= 0 ∧ ∀i=0..|a|-1 : a[i] != null
public interface Queue {

    //Pred: element != null && element - Object
    //Post: |a| == |a'| + 1
    //      ∀i=0..|a'|, Q[i] == Q'[i]
    //      a[|a'|] = element
    void enqueue(Object element);

    // Pre: |a| > 0
    // Post: Result = a[0] && a' == a
    Object element();

    //Pred: |a| > 0
    //Post: Result = a[0]
    //      |a| == |a'| - 1
    //      ∀i=0..|a|-1, a[i] == a'[i]
    Object dequeue();

    // POST: ℝ = n ∧ n' = n ∧ ∀i=1..n : a'[i] = a[i]
    int size();

    // POST: ℝ = n > 0 ∧ n' = n ∧ ∀i=1..n : a'[i] = a[i]
    boolean isEmpty();

    // Post: |a| = 0
    void clear();

    // Pred: |a| > 0
    // Post: Result = a && a == a'
    Object[] toArray();

}
