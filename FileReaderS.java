import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderS {
    String fileName;

    FileReaderS(String fileName) {
        this.fileName = fileName;
    }

    public String fileReader() throws IOException {
        BufferedReader fileReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName)));
        String data = fileReader.readLine();
        fileReader.close();
        return data;
    }
}
