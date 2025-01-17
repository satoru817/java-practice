package Exception;

public class ShapeNotFoundException extends RuntimeException{
    public ShapeNotFoundException(){
        super();
    }
    public ShapeNotFoundException(String message){
        super(message);
    }
    public ShapeNotFoundException(String message,Throwable cause){
        super(message, cause);
    }
}
