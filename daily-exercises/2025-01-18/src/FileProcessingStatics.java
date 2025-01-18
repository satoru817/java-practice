import java.io.IOException;

public class FileProcessingStatics {
    public <P extends FileProcessor<P>> long  measureNanoTime(P processor,String filePath) throws IOException {
        long start = System.nanoTime();
        P process = processor.process();
        long end = System.nanoTime();
        return end - start;
    }

    private List<>



}
