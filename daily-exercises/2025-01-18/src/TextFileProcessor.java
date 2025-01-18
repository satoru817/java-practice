import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileProcessor extends AbstractFileProcessor<String>{
    public TextFileProcessor(String filePath) {
        super(filePath);
    }

    @Override
    public String process() throws IOException {
        Path filePathToRead = Paths.get(filePath);
        try{
            return Files.readString(filePathToRead);
        }catch(IOException e){
           throw new RuntimeException(e);
        }

    }

    @Override
    public String getFormat() {
        return "String";
    }
}
