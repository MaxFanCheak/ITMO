package expression;


import expression.generic.Arithmetic;

public class Add extends AbstractMathOperation {
    public Add(AllVariableExpression first, AllVariableExpression second) {
        super(first, second);
    }

    @Override
    public char getMathOperation() {
        return '+';
    }

    @Override
    public int evaluate(int first, int second) {
        return first + second;
    }

    @Override
    protected <T extends Number> T apply(Arithmetic<T> arithmetic, T first, T second) {
        return arithmetic.add(first, second);
    }


}
