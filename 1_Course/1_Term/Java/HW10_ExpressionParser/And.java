package expression;

public class And extends AbstractMathOperation {
    public And(AllVariableExpression first, AllVariableExpression second) {
        super(first, second);
    }

    @Override
    public char getMathOperation() {
        return '&';
    }

    @Override
    public int evaluate(int first, int second) {
        return first & second;
    }
}
