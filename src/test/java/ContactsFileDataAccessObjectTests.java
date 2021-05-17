import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    @Test
    public void TestIfWeCanWriteAContactToAFile() throws IOException {
        String firstName = "Write";
        String lastName = "Test";
        String phoneNumber = "9999999999";
        Contact contact = new Contact(firstName, lastName, phoneNumber);

        String fileName = "contacts.txt";
        String directory = ".";
        Path dataFile = Paths.get(directory, fileName);

        if(Files.exists(dataFile)) {
            Files.delete(dataFile);
        }

        ContactsFileDataAccessObject dataAccessObject = new ContactsFileDataAccessObject(fileName);

        dataAccessObject.addContact(contact);

        List<String> fileContents = Files.readAllLines(dataFile);
        assertEquals(1, fileContents.size());

    }
}
