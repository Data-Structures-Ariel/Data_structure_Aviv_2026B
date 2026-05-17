package Week09.Structure;

public class A {
    private static int countA = 0;
    protected int x;

    public A() {
        countA++;
        this.x = 1;
        System.out.println("A()");
    }

    public A(int x) {
        countA++;
        this.x = x;
        System.out.println("A(int)");
    }

    @Override
    public String toString() {
        return "A:" + this.x;
    }

    public int compute(int n) {
        return this.x + n;
    }

    public static int getCountA() {
        return countA;
    }

    /**
     * פעולת עזר לבדיקה בלבד.
     */
    public static void __resetCountAForTests() {
        countA = 0;
    }
}
