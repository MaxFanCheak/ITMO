package expression;

public class Subtract extends AbstractMathOperation {
    public Subtract(AllVariableExpression first, AllVariableExpression second) {
        super(first, second);
    }

    @Override
    public char getMathOperation() {
        return '-';
    }

    @Override
    public int evaluate(int minuend, int subtrahend) {
        return minuend-subtrahend;
    }
}
