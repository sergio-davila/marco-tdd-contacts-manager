import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactsFileDataAccessObject {
    private String fileName;

    public ContactsFileDataAccessObject(String fileName) throws IOException {
        this.fileName = fileName;

        String directory = ".";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, fileName);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }
    }

    public String getFileName() {
        return fileName;
    }
}
