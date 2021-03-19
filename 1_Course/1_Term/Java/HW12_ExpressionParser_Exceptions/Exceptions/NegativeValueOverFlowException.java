package expression.exceptions;

public class NegativeValueOverFlowException extends RuntimeException{
    public NegativeValueOverFlowException(String message) {
        super(message);
    }
}
