import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BinaryFileProcessor extends AbstractFileProcessor<byte[]>{
    public BinaryFileProcessor(String filePath) {
        super(filePath);
    }

    @Override
    public byte[] process() throws IOException {
        Path filePathToRead = Paths.get(filePath);
        try{
            byte[] fileBytes = Files.readAllBytes(filePathToRead);
            return fileBytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getFormat() {
        return "byte";
    }
}
