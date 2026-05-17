package Week09.Structure;



public class B extends A {
    private static int countB = 0;
    protected int y;

    public B() {
        super(5);
        countB++;
        this.y = 0;
        System.out.println("B()");
    }

    public B(int x, int y) {
        super(x);
        countB++;
        this.y = y;
        System.out.println("B(int,int)");
    }

    @Override
    public String toString() {
        return "B:" + super.toString() + ":" + this.y;
    }

    @Override
    public int compute(int n) {
        return super.compute(n) * this.y;
    }

    public static int getCountB() {
        return countB;
    }

    /**
     * פעולת עזר לבדיקה בלבד.
     */
    public static void __resetCountBForTests() {
        countB = 0;
    }
}
