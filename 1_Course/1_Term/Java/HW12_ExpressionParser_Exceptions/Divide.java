package expression;

public class Divide extends AbstractMathOperation {

    public Divide(AllVariableExpression first, AllVariableExpression second) {
        super(first, second);
    }

    @Override
    public char getMathOperation() {
        return '/';
    }

    @Override
    public int evaluate(int numerator, int denominator) {
        return numerator/denominator;
    }


}
