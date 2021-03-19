package expression;

import expression.exceptions.NegativeValueOverFlowException;
import expression.exceptions.ValueOverFlowException;

public class CheckedMultiply extends AbstractMathOperation {
    public CheckedMultiply(AllVariableExpression first, AllVariableExpression second) {
        super(first, second);
    }

    @Override
    public char getMathOperation() {
        return '*';
    }
    private static int myabs(int t) {
        int abs = t >> 31;
        int x = abs ^ t;
        x -= abs;
        return x;
    }
    private void checkNormalExpression(int first, int second){
        if(Math.abs(first)<=1||Math.abs(second)<=1){ }
        //else if(myabs(first*second)<=1){ throw new ValueOverFlowException("Overflow"); }
        else if (first * second == Integer.MIN_VALUE && Integer.MIN_VALUE / second == first) { }
        else if (Integer.MAX_VALUE / myabs(first) < myabs(second)) { throw new ValueOverFlowException("Overflow"); }
    }

    @Override
    public int evaluate(int first, int second) {
        checkNormalExpression(first, second);
        return first*second;
    }
}
