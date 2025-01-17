package Exception;

public class InvalidShapeSizeException extends RuntimeException{
    public InvalidShapeSizeException(){
        super();
    }

    public InvalidShapeSizeException(String message){
        super(message);
    }

    public InvalidShapeSizeException(String message,Throwable cause){
        super(message,cause);
    }

}
