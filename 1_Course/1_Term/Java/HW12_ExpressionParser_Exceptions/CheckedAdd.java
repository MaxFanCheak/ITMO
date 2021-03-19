package expression;

import expression.exceptions.NegativeValueOverFlowException;
import expression.exceptions.ValueOverFlowException;

public class CheckedAdd extends AbstractMathOperation {
    public CheckedAdd(AllVariableExpression first, AllVariableExpression second) {
        super(first, second);
    }
    @Override
    public char getMathOperation() {
        return '+';
    }

    private void checkNormalExpression(int first, int second){
        if (second > 0 && Integer.MAX_VALUE - second < first) {
            throw new ValueOverFlowException("Overflow");
        }else if(second < 0 && Integer.MIN_VALUE - second > first){
            throw new NegativeValueOverFlowException("Overflow");
            //System.err.print("Overflow");
        }
    }

    @Override
    public int evaluate(int first, int second) {
        checkNormalExpression(first,second);
        return first+second;
    }

}
