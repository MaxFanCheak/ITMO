package expression;

import expression.exceptions.NegativeValueOverFlowException;
import expression.exceptions.ValueOverFlowException;

public class Multiply extends AbstractMathOperation {
    public Multiply(AllVariableExpression first, AllVariableExpression second) {
        super(first, second);
    }

    @Override
    public char getMathOperation() {
        return '*';
    }

    @Override
    public int evaluate(int first, int second) {
        return first*second;
    }
}
