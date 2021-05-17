import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsFileDataAccessObject {
    private String fileName;
    private Path dataFile;

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

    public void addContact(Contact contact) throws IOException {
        List<String> fileContents = Files.readAllLines(dataFile);
        fileContents.add(String.format("%s|%s|%s", contact.getFirstName(),contact.getLastName(),contact.getPhoneNumber()));
        Files.write(dataFile, fileContents);
    }

//    public List<Contact> getAll() throws IOException {
//        //Get all lines from the contacts.txt file.
//        List<String> fileContents = Files.readAllLines(dataFile);
//
//        //Convert all lines into actual instances of the class.
//        List<Contact> allContacts = new ArrayList<>();
//        for (String line : fileContents) {
//            String[] contactPartsFromLine = line.split("\\|");
//            allContacts.add(new Contact(contactPartsFromLine[0]),contactPartsFromLine[1], contactPartsFromLine[2]);
//        }
//        return allContacts;
//    }
}
