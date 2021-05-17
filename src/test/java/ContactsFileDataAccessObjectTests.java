import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ContactsFileDataAccessObjectTests {
    @Test
    public void testIfDataAccessObjectContactsFileExitsOnConstruction() throws IOException {
        String fileName = "contacts.txt";
        String directory = ".";
        Path dataFile = Paths.get(directory, fileName);

        ContactsFileDataAccessObject dataAccessObject = new ContactsFileDataAccessObject(fileName);

        assertTrue("Contacts.txt file does not exist", Files.exists(dataFile));
    }
}
