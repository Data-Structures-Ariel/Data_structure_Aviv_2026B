package Week09.Structure;

public class C extends B {
    private int z;

    public C(int x, int y, int z) {
        super(x, y);
        this.z = z;
        System.out.println("C(int,int,int)");
    }

    @Override
    public String toString() {
        return "C:" + super.toString() + ":" + this.z;
    }

    @Override
    public int compute(int n) {
        return super.compute(n) + this.z;
    }
}
