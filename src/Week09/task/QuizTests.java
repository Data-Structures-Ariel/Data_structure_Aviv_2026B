package Week09.task;

import Week09.Quiz;
import Week09.Structure.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * ============================================================================
 *  QuizTests.java
 *
 *  קובץ בדיקה אוטומטי למרצה.
 *  הקובץ מכיל בדיקות אוטומטיות לפונקציות שהסטודנט נדרש לממש,
 *  ובסוף מציג סיכום ניקוד מפורט לפי שאלה וסעיף.
 *
 *
 * להרצה:
 *      javac Quiz.java QuizTests.java
 *      java QuizTests
 *
 *  הערה חשובה:
 *      שאלות שאינן ניתנות לבדיקה אוטומטית מלאה (שאלת מעקב, סיבוכיות,
 *      פלט שאלה 7, UML והסברים מילוליים) מסומנות כ-"בדיקה ידנית".
 *      קובץ זה רק יציג את התשובה הצפויה כדי שתוכלו להשוות לתשובת הסטודנט.
 *  ניקוד לפי quiz.md:
 *      ש"1: 12 (10 מימוש + 2 סיבוכיות[ידני])
 *      ש"2: 12 (10 מימוש + 2 סיבוכיות[ידני])
 *      ש"3: 10 (7 מימוש + 3 סיבוכיות[ידני])
 *      ש"4: 16 (6 + 8 מימוש + 2 סיבוכיות[ידני])
 *      ש"5: 18 (3 UML[ידני] + 8 מחלקות + 5 פעולה חיצונית + 2 סיבוכיות[ידני])
 *      ש"6: 16 (כולה ידנית - מעקב)
 *      ש"7: 16 (כולה ידנית - מעקב)
 *      סה"כ אוטומטי: 49 נקודות (מתוך 100)
 *      סה"כ ידני:    51 נקודות (מתוך 100)
 * ============================================================================
 */
public class QuizTests {

    // -----------------------------------------------------------------------
    // תשתית בדיקה
    // -----------------------------------------------------------------------

    private static int totalAutoPoints = 0;     // סכום נקודות הניתנות לבדיקה אוטומטית
    private static int earnedAutoPoints = 0;    // סכום נקודות שהושגו אוטומטית
    private static StringBuilder report = new StringBuilder();

    private static void section(String title) {
        report.append("\n").append("=".repeat(70)).append("\n");
        report.append("  ").append(title).append("\n");
        report.append("=".repeat(70)).append("\n");
        System.out.println("\n" + "=".repeat(70));
        System.out.println("  " + title);
        System.out.println("=".repeat(70));
    }

    /**
     * בודק טענה בודדת. אם passed=true נחשבת ההצלחה ומוסיפה את הניקוד.
     */
    private static void check(String description, int points, boolean passed) {
        totalAutoPoints += points;
        String mark;
        if (passed) {
            earnedAutoPoints += points;
            mark = "✓ PASS";
        } else {
            mark = "✗ FAIL";
        }
        String line = String.format("  %-6s [%d pt] %s", mark, points, description);
        report.append(line).append("\n");
        System.out.println(line);
    }

    /**
     * בודק טענה שעלולה לזרוק חריגה. אם נזרקה חריגה הטענה נחשבת ככישלון.
     */
    private static void checkSafe(String description, int points, BooleanSupplier predicate) {
        try {
            check(description, points, predicate.get());
        } catch (Throwable t) {
            check(description + "  [exception: " + t.getClass().getSimpleName() + "]", points, false);
        }
    }

    @FunctionalInterface
    private interface BooleanSupplier {
        boolean get() throws Exception;
    }

    // -----------------------------------------------------------------------
    // עזרי בדיקה לתורים ולמחסניות
    // -----------------------------------------------------------------------

    private static Stack<Integer> buildStack(int... topToBottom) {
        // האיברים מתקבלים בסדר top→bottom; נדחוף בסדר הפוך כדי שהראשון יהיה ב-top
        Stack<Integer> s = new Stack<>();
        for (int i = topToBottom.length - 1; i >= 0; i--) {
            s.push(topToBottom[i]);
        }
        return s;
    }

    private static boolean stackEquals(Stack<Integer> s, int... topToBottom) {
        Stack<Integer> copy = new Stack<>();
        for (int v : topToBottom) {
            // יצירה לפי הסדר ב-array, כשהראשון בראש
        }
        // נשווה ע"י pop
        Stack<Integer> tmp = new Stack<>();
        for (int expected : topToBottom) {
            if (s.isEmpty()) return false;
            int got = s.pop();
            tmp.push(got);
            if (got != expected) {
                // שחזור
                while (!tmp.isEmpty()) s.push(tmp.pop());
                return false;
            }
        }
        boolean empty = s.isEmpty();
        // שחזור
        while (!tmp.isEmpty()) s.push(tmp.pop());
        return empty;
    }

    private static Queue<Integer> buildQueue(int... headToTail) {
        Queue<Integer> q = new Queue<>();
        for (int v : headToTail) q.insert(v);
        return q;
    }

    private static boolean queueEquals(Queue<Integer> q, int... headToTail) {
        // נעתיק את התור ונבדוק לפי הסדר
        Queue<Integer> copy = new Queue<>();
        Queue<Integer> tmp = new Queue<>();
        for (int expected : headToTail) {
            if (q.isEmpty()) {
                // restore
                while (!tmp.isEmpty()) q.insert(tmp.remove());
                return false;
            }
            int got = q.remove();
            tmp.insert(got);
            if (got != expected) {
                while (!tmp.isEmpty()) q.insert(tmp.remove());
                return false;
            }
        }
        boolean empty = q.isEmpty();
        while (!tmp.isEmpty()) q.insert(tmp.remove());
        return empty;
    }

    private static Node<Integer> buildChain(int... values) {
        if (values.length == 0) return null;
        Node<Integer> head = new Node<>(values[0]);
        Node<Integer> cur = head;
        for (int i = 1; i < values.length; i++) {
            cur.setNext(new Node<>(values[i]));
            cur = cur.getNext();
        }
        return head;
    }

    // -----------------------------------------------------------------------
    // בדיקות שאלה 1 - מחסנית - removeAll
    // ניקוד מימוש: 10 נק'
    // -----------------------------------------------------------------------

    private static void testQ1() {
        section("שאלה 1 (מחסנית) – removeAll  [10 נק']");

        // מקרה בסיסי – הדוגמה מהשאלה
        checkSafe("דוגמת השאלה: [3,5,2,5,7,5,1] removeAll k=5 → [3,2,7,1]", 2, () -> {
            Stack<Integer> s = buildStack(3, 5, 2, 5, 7, 5, 1);
            Week09.Quiz.removeAll(s, 5);
            return stackEquals(s, 3, 2, 7, 1);
        });

        // מחסנית בלי k כלל - לא משתנה
        checkSafe("מחסנית ללא k - ללא שינוי: [1,2,3] removeAll k=5 → [1,2,3]", 2, () -> {
            Stack<Integer> s = buildStack(1, 2, 3);
            Week09.Quiz.removeAll(s, 5);
            return stackEquals(s, 1, 2, 3);
        });

        // כל האיברים שווים ל-k - מחסנית ריקה
        checkSafe("כל האיברים = k: [5,5,5] removeAll k=5 → []", 2, () -> {
            Stack<Integer> s = buildStack(5, 5, 5);
            Week09.Quiz.removeAll(s, 5);
            return s.isEmpty();
        });

        // מחסנית ריקה - נשארת ריקה
        checkSafe("מחסנית ריקה: removeAll k=5 → []", 2, () -> {
            Stack<Integer> s = new Stack<>();
            Week09.Quiz.removeAll(s, 5);
            return s.isEmpty();
        });

        // k בראש המחסנית בלבד
        checkSafe("k רק בראש: [5,1,2] removeAll k=5 → [1,2]", 1, () -> {
            Stack<Integer> s = buildStack(5, 1, 2);
            Week09.Quiz.removeAll(s, 5);
            return stackEquals(s, 1, 2);
        });

        // k בתחתית המחסנית בלבד
        checkSafe("k רק בתחתית: [1,2,5] removeAll k=5 → [1,2]", 1, () -> {
            Stack<Integer> s = buildStack(1, 2, 5);
            Week09.Quiz.removeAll(s, 5);
            return stackEquals(s, 1, 2);
        });
    }

    // -----------------------------------------------------------------------
    // בדיקות שאלה 2 - תור - getEvens
    // ניקוד מימוש: 10 נק'
    // -----------------------------------------------------------------------

    private static void testQ2() {
        section("שאלה 2 (תור) – getEvens  [10 נק']");

        // דוגמה מהשאלה - בדיקת התור המוחזר
        checkSafe("דוגמה: q=[3,8,5,4,2,7,6] → result=[8,4,2,6]", 3, () -> {
            Queue<Integer> q = buildQueue(3, 8, 5, 4, 2, 7, 6);
            Queue<Integer> r = Week09.Quiz.getEvens(q);
            return queueEquals(r, 8, 4, 2, 6);
        });

        // אותה דוגמה - בדיקה שהתור המקורי לא השתנה
        checkSafe("דוגמה: התור המקורי q לא השתנה", 3, () -> {
            Queue<Integer> q = buildQueue(3, 8, 5, 4, 2, 7, 6);
            Week09.Quiz.getEvens(q);
            return queueEquals(q, 3, 8, 5, 4, 2, 7, 6);
        });

        // תור ריק
        checkSafe("תור ריק: result ריק וגם q נשאר ריק", 1, () -> {
            Queue<Integer> q = new Queue<>();
            Queue<Integer> r = Week09.Quiz.getEvens(q);
            return r.isEmpty() && q.isEmpty();
        });

        // כל האיברים אי-זוגיים
        checkSafe("כולם אי-זוגיים: q=[1,3,5,7] → result=[]; q לא משתנה", 1, () -> {
            Queue<Integer> q = buildQueue(1, 3, 5, 7);
            Queue<Integer> r = Week09.Quiz.getEvens(q);
            return r.isEmpty() && queueEquals(q, 1, 3, 5, 7);
        });

        // כל האיברים זוגיים
        checkSafe("כולם זוגיים: q=[2,4,6] → result=[2,4,6]; q לא משתנה", 1, () -> {
            Queue<Integer> q = buildQueue(2, 4, 6);
            Queue<Integer> r = Week09.Quiz.getEvens(q);
            return queueEquals(r, 2, 4, 6) && queueEquals(q, 2, 4, 6);
        });

        // איבר יחיד זוגי
        checkSafe("איבר יחיד זוגי: q=[4] → result=[4]", 1, () -> {
            Queue<Integer> q = buildQueue(4);
            Queue<Integer> r = Week09.Quiz.getEvens(q);
            return queueEquals(r, 4) && queueEquals(q, 4);
        });
    }

    // -----------------------------------------------------------------------
    // בדיקות שאלה 3 - שרשרת חוליות - countEvenPairs
    // ניקוד מימוש: 7 נק'
    // -----------------------------------------------------------------------

    private static void testQ3() {
        section("שאלה 3 (שרשרת חוליות) – countEvenPairs  [7 נק']");

        // דוגמה מהשאלה
        checkSafe("דוגמה: 3→5→4→1→7→2 → 2", 2, () -> {
            Node<Integer> lst = buildChain(3, 5, 4, 1, 7, 2);
            return Week09.Quiz.countEvenPairs(lst) == 2;
        });

        // שרשרת ריקה
        checkSafe("שרשרת ריקה (null) → 0", 1, () -> Week09.Quiz.countEvenPairs(null) == 0);

        // חוליה אחת
        checkSafe("חוליה אחת: [5] → 0", 1, () ->
            Week09.Quiz.countEvenPairs(buildChain(5)) == 0);

        // שני איברים זוגי-זוגי
        checkSafe("שני זוגיים: [2,4] → 1", 1, () ->
            Week09.Quiz.countEvenPairs(buildChain(2, 4)) == 1);

        // שני איברים זוגי-אי-זוגי
        checkSafe("פריות שונות: [3,4] → 0", 1, () ->
            Week09.Quiz.countEvenPairs(buildChain(3, 4)) == 0);

        // ארבעה איברים זוגיים
        checkSafe("[2,4,6,8] → 3 (כל זוג סמוך זוגי)", 1, () ->
            Week09.Quiz.countEvenPairs(buildChain(2, 4, 6, 8)) == 3);
    }

    // -----------------------------------------------------------------------
    // בדיקות שאלה 4 - עצים
    // ניקוד מימוש: 6 + 8 = 14 נק'
    // -----------------------------------------------------------------------

    private static BinNode<Integer> sampleTree() {
        /*
                  8
                /   \
               3     12
              / \    / \
             1   5  9   15
                  \
                   4
        */
        BinNode<Integer> n4 = new BinNode<>(4);
        BinNode<Integer> n5 = new BinNode<>(null, 5, n4); // 5 with right child 4
        BinNode<Integer> n1 = new BinNode<>(1);
        BinNode<Integer> n3 = new BinNode<>(n1, 3, n5);
        BinNode<Integer> n9 = new BinNode<>(9);
        BinNode<Integer> n15 = new BinNode<>(15);
        BinNode<Integer> n12 = new BinNode<>(n9, 12, n15);
        return new BinNode<>(n3, 8, n12);
    }

    private static void testQ4() {
        section("שאלה 4.א (עצים) – countOneChild  [6 נק']");

        // עץ הדוגמה: רק חוליה 5 יש לה ילד אחד
        checkSafe("עץ הדוגמה (8,3,12,1,5,9,15 + 4 ימני של 5) → 1", 2, () ->
            Week09.Quiz.countOneChild(sampleTree()) == 1);

        // עץ ריק
        checkSafe("עץ ריק (null) → 0", 1, () -> Week09.Quiz.countOneChild(null) == 0);

        // צומת בודד (עלה) - 0
        checkSafe("צומת בודד → 0", 1, () ->
            Week09.Quiz.countOneChild(new BinNode<>(42)) == 0);

        // שורש עם ילד שמאלי בלבד -> 1
        checkSafe("שורש עם ילד שמאלי בלבד → 1", 1, () -> {
            BinNode<Integer> child = new BinNode<>(2);
            BinNode<Integer> root = new BinNode<>(child, 1, null);
            return Week09.Quiz.countOneChild(root) == 1;
        });

        // עץ עם שני צמתים בעלי ילד אחד
        checkSafe("עץ ספציפי עם שני צמתים בעלי ילד אחד → 2", 1, () -> {
            /*
                    1
                   /
                  2
                   \
                    3
            */
            BinNode<Integer> n3 = new BinNode<>(3);
            BinNode<Integer> n2 = new BinNode<>(null, 2, n3);
            BinNode<Integer> n1 = new BinNode<>(n2, 1, null);
            return Week09.Quiz.countOneChild(n1) == 2;
        });

        section("שאלה 4.ב (עצים) – maxLeafValue  [8 נק']");

        // עץ הדוגמה: עלים הם 1, 4, 9, 15 → 15
        checkSafe("עץ הדוגמה → 15", 3, () ->
            Week09.Quiz.maxLeafValue(sampleTree()) == 15);

        // צומת בודד = עלה
        checkSafe("צומת בודד עם ערך 7 → 7", 1, () ->
            Week09.Quiz.maxLeafValue(new BinNode<>(7)) == 7);

        // שני עלים
        checkSafe("עץ עם שני עלים 3 ו-9 → 9", 1, () -> {
            BinNode<Integer> l = new BinNode<>(3);
            BinNode<Integer> r = new BinNode<>(9);
            BinNode<Integer> root = new BinNode<>(l, 100, r);
            return Week09.Quiz.maxLeafValue(root) == 9;
        });

        // עץ עם ערכים שליליים בעלים
        checkSafe("עלים שליליים: -3 ו--7 → -3", 1, () -> {
            BinNode<Integer> l = new BinNode<>(-3);
            BinNode<Integer> r = new BinNode<>(-7);
            BinNode<Integer> root = new BinNode<>(l, 0, r);
            return Week09.Quiz.maxLeafValue(root) == -3;
        });

        // עץ שורש בלי ילד שמאלי, רק עם ילד ימני שהוא עלה
        checkSafe("רק ילד ימני שהוא עלה: root → 5 → leaf → 5", 1, () -> {
            BinNode<Integer> leaf = new BinNode<>(5);
            BinNode<Integer> root = new BinNode<>(null, 999, leaf);
            return Week09.Quiz.maxLeafValue(root) == 5;
        });

        // עץ ארוך משמאל, העלה הוא מספר גדול
        checkSafe("שרשרת ארוכה משמאל, עלה=100 → 100", 1, () -> {
            BinNode<Integer> leaf = new BinNode<>(100);
            BinNode<Integer> n3 = new BinNode<>(leaf, 3, null);
            BinNode<Integer> n2 = new BinNode<>(n3, 2, null);
            BinNode<Integer> root = new BinNode<>(n2, 1, null);
            return Week09.Quiz.maxLeafValue(root) == 100;
        });
    }

    // -----------------------------------------------------------------------
    // בדיקות שאלה 5 - מחלקות
    // ניקוד מימוש: 8 (מחלקות) + 5 (mostExpensive) = 13 נק'
    // -----------------------------------------------------------------------

    private static void testQ5() {
        section("שאלה 5.ב (מחלקות) – Product/SimpleProduct/CompoundProduct  [8 נק']");

        // איפוס המונה אם הסטודנט מימש את resetCounter
        try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}

        // יצירת Product וקריאה ל-getters
        checkSafe("יצירת Product בסיסי + getName/getPrice", 1, () -> {
            try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}
            Product p = new Product("apple", 12.5);
            return "apple".equals(p.getName()) && p.getPrice() == 12.5;
        });

        // המונה אוטומטי - שני מוצרים מקבלים מספרים עוקבים
        checkSafe("מספר מוצר ייחודי ועוקב: p1.num+1 == p2.num", 2, () -> {
            try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}
            Product p1 = new Product("a", 1);
            Product p2 = new Product("b", 2);
            return p2.getNum() == p1.getNum() + 1;
        });

        // SimpleProduct - יורש מ-Product, יש לו weight, ומקבל num אוטומטי
        checkSafe("SimpleProduct יורש מ-Product ויש לו weight", 2, () -> {
            try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}
            SimpleProduct sp = new SimpleProduct("widget", 50.0, 250);
            return (sp instanceof Product)
                && "widget".equals(sp.getName())
                && sp.getPrice() == 50.0
                && sp.getWeight() == 250;
        });

        // CompoundProduct - יורש מ-Product, מערך parts באורך 20, numParts=0
        checkSafe("CompoundProduct יורש מ-Product, parts באורך 20 ו-numParts=0", 2, () -> {
            try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}
            CompoundProduct cp = new CompoundProduct("box", 100.0);
            return (cp instanceof Product)
                && cp.getParts() != null
                && cp.getParts().length == 20
                && cp.getNumParts() == 0;
        });

        // הוספת חלק ל-CompoundProduct
        checkSafe("addPart מגדיל numParts ושומר את הרכיב", 1, () -> {
            try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}
            CompoundProduct cp = new CompoundProduct("set", 200.0);
            SimpleProduct sp = new SimpleProduct("nail", 1.0, 5);
            cp.addPart(sp);
            return cp.getNumParts() == 1 && cp.getParts()[0] == sp;
        });

        section("שאלה 5.ג (מחלקות) – mostExpensive  [5 נק']");

        // מקרה רגיל
        checkSafe("mostExpensive על מערך מעורב מחזיר את שם היקר ביותר", 2, () -> {
            try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}
            Product[] arr = new Product[] {
                new SimpleProduct("cheap", 10.0, 5),
                new CompoundProduct("medium", 50.0),
                new SimpleProduct("expensive", 200.0, 10),
                new CompoundProduct("low", 30.0)
            };
            return "expensive".equals(Week09.Quiz.mostExpensive(arr));
        });

        // איבר אחד
        checkSafe("מערך עם איבר אחד", 1, () -> {
            try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}
            Product[] arr = new Product[] { new SimpleProduct("only", 7.7, 1) };
            return "only".equals(Week09.Quiz.mostExpensive(arr));
        });

        // היקר ראשון במערך
        checkSafe("היקר נמצא בתחילת המערך", 1, () -> {
            try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}
            Product[] arr = new Product[] {
                new SimpleProduct("top", 500.0, 10),
                new SimpleProduct("a", 10.0, 1),
                new SimpleProduct("b", 20.0, 1)
            };
            return "top".equals(Week09.Quiz.mostExpensive(arr));
        });

        // היקר אחרון במערך
        checkSafe("היקר נמצא בסוף המערך", 1, () -> {
            try { Product.__resetCounterForTests(); } catch (Throwable ignored) {}
            Product[] arr = new Product[] {
                new SimpleProduct("a", 10.0, 1),
                new SimpleProduct("b", 20.0, 1),
                new SimpleProduct("top", 999.99, 10)
            };
            return "top".equals(Week09.Quiz.mostExpensive(arr));
        });
    }

    // -----------------------------------------------------------------------
    // שאלה 6 - שאלת מעקב - בדיקה ידנית
    // -----------------------------------------------------------------------

    private static void manualQ6() {
        section("שאלה 6 – שאלת מעקב  [16 נק' – בדיקה ידנית]");

        String expected =
            "תשובות צפויות לשאלה 6 (לצורך השוואה):\n" +
            "  סעיף א' (7 נק'): ערך מוחזר = 3.\n" +
            "    המעקב צריך להציג שש קריאות רקורסיביות (כולל קריאה לתור ריק)\n" +
            "    ולכל קריאה את ערכי y, rest, התור לפני ה-insert וערך מוחזר.\n" +
            "    y בעת המוצא: 3, 7, 2, 8, 5; rest מהקריאות בחזרה: 3,2,2,1,0.\n" +
            "  סעיף ב' (3 נק'): התור אחרי הקריאה: head → [5, 8, 2, 7, 3] → tail.\n" +
            "                   (התור התהפך לחלוטין מהמצב המקורי.)\n" +
            "  סעיף ג' (4 נק'): הפעולה מחזירה את מספר האיברים בתור q שערכם > x,\n" +
            "                   ובמהלך הריצה היא הופכת את סדר האיברים בתור.\n" +
            "  סעיף ד' (2 נק'): סיבוכיות זמן O(n) - קריאה רקורסיבית לכל איבר;\n" +
            "                   סיבוכיות מקום O(n) - עומק הסטאק של הרקורסיה.\n" +
            "                   (n = מספר האיברים בתור)";
        report.append(expected).append("\n");
        System.out.println(expected);
    }

    // -----------------------------------------------------------------------
    // שאלה 7 - מעקב הורשה - בדיקה ידנית (אך מציגים את הפלט הצפוי)
    // -----------------------------------------------------------------------

    private static void manualQ7() {
        section("שאלה 7 – מעקב הורשה ודריסה  [16 נק' – בדיקה ידנית]");

        // נריץ את main של שאלה 7 ונציג את הפלט הצפוי
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(baos));
            Quiz.runQuestion7Main();
        } catch (Throwable t) {
            System.setOut(original);
            System.out.println("שגיאה בהרצת main של שאלה 7: " + t);
            return;
        } finally {
            System.setOut(original);
        }

        String captured = baos.toString();
        String header = "פלט צפוי לשאלה 7 (סעיף א', 10 נק'):";
        report.append(header).append("\n").append(captured).append("\n");
        System.out.println(header);
        System.out.println(captured);

        String more =
            "סעיף ב' (4 נק'): countA = 4, כי הבנאי של A הופעל ארבע פעמים:\n" +
            "  1. new A(3) בשורה a1.\n" +
            "  2. super(2) בתוך B(2,4) שמגיע מ-a2.\n" +
            "  3. super(5) בתוך B() שמגיע מ-b1.\n" +
            "  4. super(2) בתוך B(2,3) שמגיע מ-C(2,3,5) של a3.\n" +
            "\nסעיף ג' (2 נק'): סיבוכיות a3.compute(2) היא O(1).\n" +
            "  שרשרת הקריאות C.compute → B.compute → A.compute היא באורך קבוע (3),\n" +
            "  וכל פעולה מבצעת מספר קבוע של פעולות חשבון.";
        report.append(more).append("\n");
        System.out.println(more);
    }

    // -----------------------------------------------------------------------
    // הצגת סיכום סופי
    // -----------------------------------------------------------------------

    private static void printSummary() {
        String divider = "=".repeat(70);
        System.out.println("\n" + divider);
        System.out.println("  סיכום ניקוד");
        System.out.println(divider);

        System.out.printf("  נקודות שהושגו אוטומטית: %d מתוך %d%n",
                          earnedAutoPoints, totalAutoPoints);
        System.out.println();
        System.out.println("  בדיקה ידנית נדרשת עבור:");
        System.out.println("    - סיבוכיות בשאלות 1.ב (2 נק'), 2.ב (2 נק'), 3.ב (3 נק'),");
        System.out.println("      4.ג (2 נק'), 5.ד (2 נק')                              = 11 נק'");
        System.out.println("    - תרשים UML בשאלה 5.א                                    =  3 נק'");
        System.out.println("    - שאלה 6 (מעקב + סיבוכיות) כולה                          = 16 נק'");
        System.out.println("    - שאלה 7 (מעקב הורשה) כולה                               = 16 נק'");
        System.out.println("  סה\"כ ידני אפשרי                                            = 46 נק'");
        System.out.println();
        System.out.printf("  סה\"כ מקסימלי אוטומטי: %d נק' מתוך 100 בבוחן%n", totalAutoPoints);
        System.out.println("  סה\"כ מקסימלי ידני:    " + (100 - totalAutoPoints) + " נק' מתוך 100 בבוחן");
        System.out.println(divider);
        System.out.println("\nלפירוט בדיקה ידנית, עיינו ב-teacher_guide.md");
    }

    // -----------------------------------------------------------------------
    // main
    // -----------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("בדיקה אוטומטית של בוחן מבני נתונים ותכנות מונחה עצמים");
        System.out.println("=".repeat(70));

        // בדיקות אוטומטיות
        testQ1();
        testQ2();
        testQ3();
        testQ4();
        testQ5();

        // הצגת תשובות צפויות לבדיקה ידנית
        manualQ6();
        manualQ7();

        printSummary();
    }
}
