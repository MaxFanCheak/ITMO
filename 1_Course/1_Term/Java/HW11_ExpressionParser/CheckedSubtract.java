package expression;

import expression.exceptions.NegativeValueOverFlowException;
import expression.exceptions.ValueOverFlowException;

public class CheckedSubtract extends AbstractMathOperation {
    public CheckedSubtract(AllVariableExpression first, AllVariableExpression second) {
        super(first, second);
    }

    @Override
    public char getMathOperation() {
        return '-';
    }

    private void checkNormalExpression(int first, int second){
        if (second > 0 && Integer.MIN_VALUE + second > first) {
            throw new NegativeValueOverFlowException("overflow");
        }else if(Integer.MAX_VALUE + second < first&&second < 0){
            throw new ValueOverFlowException("overflow");
        }
    }

    @Override
    public int evaluate(int minuend, int subtrahend) {
        checkNormalExpression(minuend,subtrahend);
        return minuend-subtrahend;
    }
}

