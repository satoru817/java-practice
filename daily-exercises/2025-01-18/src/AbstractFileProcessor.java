import java.io.File;
import java.io.IOException;

abstract class AbstractFileProcessor<T> implements FileProcessor<T> {
    protected String filePath;
    protected T content;

    public AbstractFileProcessor(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public long getSize() {
        // ファイルサイズを返す基本実装
        return new File(filePath).length();
    }

    // 各ファイルタイプ固有の処理を強制する
    @Override
    abstract public T process() throws IOException;

    // ファイル形式の判定を強制する
    @Override
    abstract public String getFormat();
}