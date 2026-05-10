package Week08.students;

/* ============================================================
 *  Q7 — PriorityQueue<Student>  (part of Section C)
 * ============================================================
 *  A priority queue of Students, ordered by their average grade.
 *  Higher average = higher priority.
 *
 *  Required public interface:
 *    PriorityQueue()             // creates an empty PQ
 *    void   add(Student s)       // inserts a student
 *    Student remove()            // removes & returns student with
 *                                //   the HIGHEST average. Throws
 *                                //   if the PQ is empty.
 *    boolean isEmpty()           // true iff no students in PQ
 *
 *  You may store the elements internally using a Node<Student>
 *  chain (sorted on insert, or unsorted with a scan on remove)
 *  or any other valid implementation. The public interface
 *  above is fixed.
 *
 *  Tie-breaking: if two students share the highest average,
 *  either may be returned (the tests will tolerate either order).
 * ============================================================
 */
public class PriorityQueue {

    // TODO: declare your internal storage field(s) here

    public PriorityQueue() {
        // TODO: initialize
    }

    /** Inserts a student into the priority queue. */
    public void add(Student s) {
        // TODO: implement
        throw new UnsupportedOperationException("PriorityQueue.add not implemented");
    }

    /**
     * Removes and returns the student with the HIGHEST average
     * grade. Throws RuntimeException if the queue is empty.
     */
    public Student remove() {
        // TODO: implement
        throw new UnsupportedOperationException("PriorityQueue.remove not implemented");
    }

    /** Returns true iff the priority queue contains no students. */
    public boolean isEmpty() {
        // TODO: implement
        throw new UnsupportedOperationException("PriorityQueue.isEmpty not implemented");
    }
}
