package expression;

import expression.exceptions.DivisionByZeroException;

public class CheckedDivide extends AbstractMathOperation {

    public CheckedDivide(AllVariableExpression first, AllVariableExpression second) {
        super(first, second);
    }

    @Override
    public char getMathOperation() {
        return '/';
    }

    private void checkNormalExpression(int divider) {
        if (divider == 0) {
            throw new DivisionByZeroException("divide by zero");
        }
    }

    @Override
    public int evaluate(int numerator, int denominator) {
        checkNormalExpression(denominator);
        return numerator/denominator;
    }


}
