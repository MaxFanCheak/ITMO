package expression;

public class Const implements AllVariableExpression {
    private final Integer x;

    public Const(int x) {
        this.x=x;
    }

    @Override
    public int evaluate(int x) {
        return evaluate(x,0,0);
    }

    @Override
    public String toString() {
        return x.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Const c = (Const) o;
        return c.x.equals(x);
    }
    public int hashCode() {
        return Integer.hashCode(x);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return this.x;
    }
}

