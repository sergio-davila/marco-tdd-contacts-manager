import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContactsFileDataAccessObjectTests {
    private String fileName;
    private String directory;
    private String dataFile;
    //private

//    @Before
//    public void setUp() throws IOException {
//        String fileName = "contacts.txt";
//        String directory = ".";
//        Path dataFile = Paths.get(directory, fileName);
//
//        if(Files.exists(dataFile)) {
//            Files.delete(dataFile);
//        }
//
//        ContactsFileDataAccessObject dataAccessObject = new ContactsFileDataAccessObject(fileName);
//    }

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

//    @Test
//    public void testIfWeCanGetAllContactsFromAFile() {
//        //Create some contact objects
//        Contact firstContact = new Contact("First1", "Last1", "1111111111");
//        Contact secondContact = new Contact("First2", "Last2", "2222222222");
//
//        //Convert contact objects to our format
//        List<String> testFileContents = new ArrayList<>();
//        testFileContents.add(String.format("%s|%s|%s", firstContact.getFirstName(), firstContact.getLastName(), firstContact.getPhoneNumber()));
//        testFileContents.add(String.format("%s|%s|%s", secondContact.getFirstName(), secondContact.getLastName(), secondContact.getPhoneNumber()));
//
//        //Write out the contacts to a file
//        Files.write(dataFile, testFileContents);
//
//        // Execute
//    }
}
