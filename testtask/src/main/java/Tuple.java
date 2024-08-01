import java.util.Objects;

public class Tuple {

    private int l;
    private int r;
    private int k;

    public Tuple(int l, int r, int k) {
        this.l = l;
        this.r = r;
        this.k = k;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return l == tuple.l && r == tuple.r && k == tuple.k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(l, r, k);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "l=" + l +
                ", r=" + r +
                ", k=" + k +
                '}';
    }
}
