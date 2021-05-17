import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
    @Test
    public void testIfContactConstructs() {
        String firstName = "John";
        String lastName = "Doe";
        String phoneNumber = "1231231234";
        Contact contact = new Contact(firstName, lastName, phoneNumber);

        assertEquals(firstName, contact.getFirstName());
        assertEquals(lastName, contact.getLastName());
        assertEquals(phoneNumber, contact.getPhoneNumber());
    }
}
