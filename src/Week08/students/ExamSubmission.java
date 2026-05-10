package Week08.students;

/* ============================================================
 *  EXAM SUBMISSION TEMPLATE
 * ============================================================
 *  Instructions:
 *    1. Fill in your student ID and full name in the static
 *       constants below. Submissions without a valid 9-digit ID
 *       will not be graded.
 *    2. You must answer 2 questions out of 3 in EACH section:
 *           Section A: Q1, Q2, Q3
 *           Section B: Q4, Q5, Q6
 *           Section C: Q7, Q8, Q9
 *    3. Each function below corresponds to one sub-question.
 *       Replace the body (which currently throws
 *       UnsupportedOperationException) with your own
 *       implementation. Functions you don't choose to answer
 *       can be left untouched.
 *    4. Do NOT change function signatures (name, parameters,
 *       return type) or the data-structure helper classes
 *       (Node, Queue, Stack, BinTreeNode).
 *    5. Q3, Q4, Q6 and the trace/UML/complexity sub-parts of
 *       Q5, Q8, Q9 are answered on PAPER — see the exam
 *       booklet. Only the coding sub-parts are submitted here.
 * ============================================================
 */
public class ExamSubmission {

    // ------------------------------------------------------------
    // STUDENT IDENTIFICATION  ***  FILL THESE IN  ***
    // ------------------------------------------------------------
    public static final String STUDENT_ID   = "000000000"; // 9-digit ID
    public static final String STUDENT_NAME = "Your Full Name";

    // ============================================================
    // SECTION A
    // ============================================================

    /* -------------------- Q1 (16 pts) ----------------------------
     * canBuild(qu1, qu2)
     *   Decide whether the queue qu1 can be "built" out of qu2 — i.e.,
     *   whether qu1 is a sub-sequence of qu2. The elements of qu1 must
     *   appear in qu2 in the SAME order (extra elements between them
     *   in qu2 are allowed).
     *
     *   Examples:
     *     qu1 = <1,3,5> ,  qu2 = <1,2,3,4,5>      -> true
     *     qu1 = <2,4>   ,  qu2 = <4,2,4,1>        -> true
     *     qu1 = <3,1>   ,  qu2 = <1,3,5>          -> false
     *     qu1 = <>      ,  qu2 = anything         -> true
     *
     *   IMPORTANT: at the end of the function, both queues must be
     *   restored to their original state.
     * ------------------------------------------------------------ */
    public static boolean canBuild(Queue<Integer> qu1, Queue<Integer> qu2) {
        // TODO: implement
        throw new UnsupportedOperationException("canBuild not implemented");
    }

    /* -------------------- Q2 (16 pts) ----------------------------
     * chainToDigits(chain)
     *   Receives a linked list (chain) of non-negative integers and
     *   returns a NEW linked list where every digit of every number
     *   appears as its own node, preserving the original order.
     *
     *   Examples:
     *     chain = (12, 3, 405)  ->  (1, 2, 3, 4, 0, 5)
     *     chain = (7)           ->  (7)
     *     chain = (10, 200)     ->  (1, 0, 2, 0, 0)
     *     chain = null          ->  null
     *
     *   The original chain must remain unchanged.
     * ------------------------------------------------------------ */
    public static Node<Integer> chainToDigits(Node<Integer> chain) {
        // TODO: implement
        throw new UnsupportedOperationException("chainToDigits not implemented");
    }

    /* -------------------- Q3 (16 pts) ----------------------------
     * Q3 is a TRACE / paper question — no code submission required.
     * Answer in the exam booklet.
     * ------------------------------------------------------------ */


    // ============================================================
    // SECTION B
    // ============================================================

    /* -------------------- Q4 (16 pts) ----------------------------
     * Q4 is a UML / TRACE / errors paper question — no code.
     * Answer in the exam booklet.
     * ------------------------------------------------------------ */


    /* -------------------- Q5a (7 pts) ----------------------------
     * isSplitStack(s)
     *   A "split stack" is a stack whose elements can be partitioned
     *   into two contiguous groups (top half and bottom half) such
     *   that the SUM of the top half equals the SUM of the bottom
     *   half. The split point may be anywhere inside the stack
     *   (not at the very top or the very bottom — both halves must
     *   be non-empty).
     *
     *   Examples (top of stack on the left):
     *     s = [1,4,2,3]    -> true   (1+4 == 2+3)
     *     s = [5,5]        -> true   (5 == 5)
     *     s = [1,2,3]      -> true   (1+2 == 3)
     *     s = [1,2,2]      -> false
     *     s = [7]          -> false  (cannot split — only 1 element)
     *
     *   IMPORTANT: at the end of the function, the stack must be
     *   restored to its original state.
     * ------------------------------------------------------------ */
    public static boolean isSplitStack(Stack<Integer> s) {
        // TODO: implement
        throw new UnsupportedOperationException("isSplitStack not implemented");
    }

    /* -------------------- Q5b (7 pts) ----------------------------
     * getAverages(s)
     *   Receives a stack of integers and returns a NEW Queue<Double>
     *   containing the running averages of the FIRST k elements
     *   popped from the stack, for k = 1, 2, 3, ...
     *
     *   Examples (top on the left):
     *     s = [4,2,6]  -> averages popped are
     *                       k=1: 4/1 = 4.0
     *                       k=2: (4+2)/2 = 3.0
     *                       k=3: (4+2+6)/3 = 4.0
     *                     -> queue <4.0, 3.0, 4.0>
     *     s = []       -> empty queue <>
     *
     *   IMPORTANT: at the end of the function, the stack must be
     *   restored to its original state.
     * ------------------------------------------------------------ */
    public static Queue<Double> getAverages(Stack<Integer> s) {
        // TODO: implement
        throw new UnsupportedOperationException("getAverages not implemented");
    }

    /* -------------------- Q5c (2 pts) ----------------------------
     * Q5c is a complexity question — answer on paper.
     * ------------------------------------------------------------ */


    /* -------------------- Q6 (16 pts) ----------------------------
     * Q6 is an Overloading / equals trace paper question — no code.
     * ------------------------------------------------------------ */


    // ============================================================
    // SECTION C
    // ============================================================

    /* -------------------- Q7 (18 pts) ----------------------------
     * Implement Student.java and PriorityQueue.java in the
     * separate files (also provided). See the specs there.
     * ------------------------------------------------------------ */


    /* -------------------- Q8a (3 pts) ----------------------------
     * Tree-drawing — paper question.
     * ------------------------------------------------------------ */


    /* -------------------- Q8b (6 pts) ----------------------------
     * isEquivalent(tree)  — RECURSIVE
     *   A binary tree is "equivalent" if it is structurally
     *   symmetric AND value-symmetric, i.e. its left subtree is
     *   the mirror image (in both shape and values) of its right
     *   subtree.
     *
     *   Formally, the helper relation mirror(a, b) is:
     *     - if a == null and b == null            -> true
     *     - if exactly one of them is null        -> false
     *     - else: a.value == b.value
     *             AND mirror(a.left, b.right)
     *             AND mirror(a.right, b.left)
     *   isEquivalent(t) := t == null OR mirror(t.left, t.right)
     *
     *   Examples:
     *           5                  5
     *          / \                / \
     *         3   3      OK      3   3      OK
     *        / \ / \                  \
     *       1 2 2  1                   1     NOT OK
     *
     *   You MUST implement this RECURSIVELY.
     * ------------------------------------------------------------ */
    public static boolean isEquivalent(BinTreeNode<Integer> tree) {
        // TODO: implement (recursively)
        throw new UnsupportedOperationException("isEquivalent not implemented");
    }

    /* -------------------- Q8c, Q8d -------------------------------
     * Pre/in/post-order traversal listing on paper — no code.
     * ------------------------------------------------------------ */


    /* -------------------- Q8e (4 pts) ----------------------------
     * posOrder(tree)
     *   Returns a NEW linked list (Node<Integer>) containing the
     *   values of the binary tree in POST-ORDER (left, right, root).
     *
     *   Examples:
     *           1
     *          / \
     *         2   3        ->  posOrder = (2, 3, 1)
     *
     *           4
     *          / \
     *         2   5
     *        / \
     *       1   3           ->  posOrder = (1, 3, 2, 5, 4)
     *
     *     tree = null       ->  null
     * ------------------------------------------------------------ */
    public static Node<Integer> posOrder(BinTreeNode<Integer> tree) {
        // TODO: implement
        throw new UnsupportedOperationException("posOrder not implemented");
    }

    /* -------------------- Q9a, Q9b -------------------------------
     * UML / Trace — paper questions.
     * ------------------------------------------------------------ */


    /* -------------------- Q9c (8 pts) ----------------------------
     * filterPerfectSquares(qu)
     *   Returns a NEW Queue<Integer> containing only the elements
     *   of qu that are perfect squares (n = k*k for some k >= 0).
     *   The relative order of the kept elements is preserved.
     *
     *   Examples:
     *     qu = <1,2,3,4,9,10,16> -> <1,4,9,16>
     *     qu = <0,7,25,30>       -> <0,25>
     *     qu = <2,3,5>           -> <>
     *     qu = <>                -> <>
     *
     *   IMPORTANT: at the end of the function, the input queue qu
     *   must be restored to its original state.
     *   Negative numbers are NOT considered perfect squares.
     * ------------------------------------------------------------ */
    public static Queue<Integer> filterPerfectSquares(Queue<Integer> qu) {
        // TODO: implement
        throw new UnsupportedOperationException("filterPerfectSquares not implemented");
    }
}
