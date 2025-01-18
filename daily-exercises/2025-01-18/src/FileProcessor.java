import java.io.IOException;

public interface FileProcessor <T>{
    T process() throws IOException;
    long getSize();
    String getFormat();
}
