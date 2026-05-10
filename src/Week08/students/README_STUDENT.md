# Submission Template — Java Data Structures Exam

## Files in this folder

| File                | What you do with it                          |
|---------------------|----------------------------------------------|
| `ExamSubmission.java` | **EDIT THIS.** Most coding answers go here. |
| `Student.java`        | **EDIT THIS.** Q7 part (a) goes here.       |
| `PriorityQueue.java`  | **EDIT THIS.** Q7 part (c) goes here.       |
| `Node.java`           | Provided helper. **DO NOT EDIT.**           |
| `Queue.java`          | Provided helper. **DO NOT EDIT.**           |
| `Stack.java`          | Provided helper. **DO NOT EDIT.**           |
| `BinTreeNode.java`    | Provided helper. **DO NOT EDIT.**           |

---

## How to submit

1. Open `ExamSubmission.java`. At the top, fill in:

   ```java
   public static final String STUDENT_ID   = "000000000"; // your 9-digit ID
   public static final String STUDENT_NAME = "Your Full Name";
   ```

   Submissions whose `STUDENT_ID` is missing or not a 9-digit
   number may not be matched to your account.

2. **You answer 2 of 3 questions in each section** (A, B, C). The
   sub-questions of the questions you choose are split between:
   - **Code** — fill in the function body in `ExamSubmission.java`
     (or `Student.java` / `PriorityQueue.java` for Q7).
   - **Paper** — answer in your exam booklet.

   Functions you don't choose to answer can be **left untouched**;
   their default body throws `UnsupportedOperationException` and
   the grader will simply award 0 for those tests.

3. **Do not change function signatures or class names.** If you
   change a return type, parameter list, or method name, the file
   may fail to compile and you may lose points on questions you
   actually answered correctly.

4. **Do not modify** `Node.java`, `Queue.java`, `Stack.java`,
   `BinTreeNode.java`. The grader will replace them with its own
   reference copies anyway.

5. Submit all three of your edited files together.

---

## How to test your code locally

You can compile your submission with:

```bash
javac -encoding UTF-8 *.java
```

If it doesn't compile, fix the errors before submitting.

Each function has examples in its comment block. Try them out by
adding a `main` method temporarily (you can delete it before
submitting). E.g.:

```java
public static void main(String[] args) {
    Queue<Integer> a = new Queue<>();
    a.insert(1); a.insert(3); a.insert(5);
    Queue<Integer> b = new Queue<>();
    b.insert(1); b.insert(2); b.insert(3); b.insert(4); b.insert(5);
    System.out.println(canBuild(a, b));   // expect true
}
```

---

## Reminders

- Q3, Q4, Q6 are entirely paper questions. Don't add code for them.
- Q5c, Q8a/c/d, Q9a/b are paper sub-parts of mostly-coded questions.
- For all functions that take a `Stack` or `Queue` and don't
  explicitly return one, the original input must be **restored**
  to its starting state by the time the function returns. This is
  tested.
- Negative numbers are NOT perfect squares (Q9c).

Good luck!
