package Week08.students;

/* ============================================================
 *  Q7 — Student class (part of Section C)
 * ============================================================
 *  Implements a student record with name, ID, and a list of
 *  grades. Supports adding grades and computing the average.
 *
 *  Spec:
 *    - The student stores zero or more integer grades (0..100).
 *    - addGrade(grade) appends a grade to the end of the list.
 *    - getAverage() returns the arithmetic mean of all grades
 *      stored so far. If no grades have been added, it returns 0.
 *
 *  Internally, you may store the grades using a Queue<Integer>,
 *  a Node<Integer> chain, or any reasonable structure of your
 *  own — but the public interface below is fixed.
 * ============================================================
 */
public class Student {

    private String _name;
    private String _id;
    // TODO: add field(s) for storing grades

    /**
     * Creates a Student with no grades yet.
     */
    public Student(String name, String id) {
        _name = name;
        _id = id;
        // TODO: initialize grade-storage field
    }

    public String getName() { return _name; }
    public String getId()   { return _id; }

    /**
     * Q7b. Appends `grade` to the student's list of grades.
     *
     * NOTE on signature: the printed exam shows
     *     "public double addGrade()"
     * — but the description says: "receives a grade and adds it
     * to the list of grades". The signature in the exam booklet
     * is inconsistent with the description. We use the signature
     * that matches the description (void + int parameter).
     */
    public void addGrade(int grade) {
        // TODO: implement
        throw new UnsupportedOperationException("addGrade not implemented");
    }

    /**
     * Q7c. Returns the average of all grades added so far.
     * If no grades have been added, returns 0.0.
     */
    public double getAverage() {
        // TODO: implement
        throw new UnsupportedOperationException("getAverage not implemented");
    }
}
