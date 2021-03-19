package expression;


public class CheckedNegate implements AllVariableExpression {
    private AllVariableExpression expression;

    public CheckedNegate(AllVariableExpression expression) {
        this.expression = expression;
    }


    @Override
    public String toString() {
        return "-(" + expression.toString() + ")";
    }

    @Override
    public String toMiniString() {
        boolean hasBrackets = expression instanceof AbstractMathOperation;
        return "-" + (hasBrackets ? "(" : "") + expression.toMiniString() + (hasBrackets ? ")" : "");
    }

    @Override
    public int evaluate(int x) {
        return -x;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return evaluate(expression.evaluate(x, y, z));
    }

}

