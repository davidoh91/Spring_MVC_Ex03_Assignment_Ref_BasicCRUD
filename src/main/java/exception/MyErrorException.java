package exception;

public class MyErrorException extends Exception{
    //custom error message
    public MyErrorException(String errorMessage) {
        super(errorMessage);
    }
}
