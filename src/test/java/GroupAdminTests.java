/**
 * This JUNIT class tests correctness of GroupAdmin class functionalities.
 * Goal: It makes sure that the registration, un-registration and other functions are successfully well-built.
 * @author Osama & Hamad.
 */

import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class GroupAdminTests {
    // Declaring a general object to be under-testing from type: GroupAdmin
    GroupAdmin group = new GroupAdmin(new UndoableStringBuilder(new StringBuilder("Ariel University"), new HashMap<>()));
    static final String BLUE = "\u001B[34m";
    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";

    @Test
    void registerTester () {
        System.out.println(BLUE + "----------------------------------------");
        System.out.println("| 'registerTester()' has been started. |");
        System.out.println("----------------------------------------" + RESET);

        System.out.println("Checking whether our subject has any observers that are observing him or not... ");
        // Making sure that we still don't have any observers - an empty ArrayList.
        assertTrue(group.getMembers().isEmpty());
        System.out.println(GREEN + "    Our subject's observers list is currently empty.");
        System.out.println("    Our subject's current string-value is: 'Ariel University'" + RESET);

        System.out.println("Attempting to register our first observer...");
        // Initializing the first observer and registering it to our subject - Ariel University.
        ConcreteMember o1 = new ConcreteMember(group, 0);
        // Testing if our defined observer has been successfully joined our subject - Ariel University.
        assertFalse(group.getMembers().isEmpty());
        assertSame(o1, group.getMembers().get(0));
        System.out.println(GREEN + "    A new observer has been successfully registered.");
        System.out.println("    It is listed at index 0 in our subject's list.");
        System.out.println("    Our latest-registered observer current string-value is: 'Ariel University'" + RESET);

        System.out.println("Attempting to register our second observer...");
        // Initializing the second observer and registering it to our subject - Ariel University.
        ConcreteMember o2 = new ConcreteMember(group, 1);
        // Testing if our defined observer has been successfully joined our subject - Ariel University.
        assertFalse(group.getMembers().isEmpty());
        assertSame(o2, group.getMembers().get(1));
        System.out.println(GREEN + "    A new observer has been successfully registered.");
        System.out.println("    It is listed at index 1 in our subject's list.");
        System.out.println("    Our latest-registered observer current string-value is: 'Ariel University'" + RESET);

        System.out.println("Attempting to register our third observer...");
        // Initializing the third observer and registering it to our subject - Ariel University.
        ConcreteMember o3 = new ConcreteMember(group, 2);
        // Testing if our defined observer has been successfully joined our subject - Ariel University.
        assertFalse(group.getMembers().isEmpty());
        assertSame(group.getMembers().get(2), o3);
        System.out.println(GREEN + "    A new observer has been successfully registered.");
        System.out.println("    It is listed at index 2 in our subject's list.");
        System.out.println("    Our latest-registered observer current string-value is: 'Ariel University'" + RESET);

        System.out.println("Making sure that our subject's list currently has 3 observers...");
        // Making sure that our subject is being observed by 3 observes who are grouped in 1 place - A common ArrayList.
        assertEquals(group.getMembers().size(), 3);
        System.out.println(GREEN + "    Our subject's list DOES include 3 observers." + RESET);

        System.out.println("Making sure that the whole observers who are observing the same subject, are different from each other...");
        // Testing that the whole observers are different from each other and are observing the same subject.
        assertTrue(o1.getNum() != o2.getNum() && o1.getSubject().equals(o2.getSubject()));
        assertTrue(o1.getNum() != o3.getNum() && o1.getSubject().equals(o3.getSubject()));
        assertTrue(o2.getNum() != o3.getNum() && o2.getSubject().equals(o3.getSubject()));
        System.out.println(GREEN + "    The whole observers are observing the same subject and are different from each other." + RESET);

        System.out.println();
    }

    @Test
    void unregisterTester () {
        System.out.println(BLUE + "------------------------------------------");
        System.out.println("| 'unregisterTester()' has been started. |");
        System.out.println("------------------------------------------" + RESET);

        // Making sure that we still don't have any observers - an empty ArrayList.
        assertTrue(group.getMembers().isEmpty());

        System.out.println("Attempting to register our first observer...");
        // Initializing the first observer and registering it to our subject - Ariel University.
        ConcreteMember o1 = new ConcreteMember(group, 0);
        // Testing if our defined observer has been successfully joined our subject - Ariel University.
        assertFalse(group.getMembers().isEmpty());
        assertSame(o1, group.getMembers().get(0));
        System.out.println(GREEN + "    A new observer has been successfully registered.");
        System.out.println("    It is listed at index 0 in our subject's list.");
        System.out.println("    Our latest-registered observer current string-value is: 'Ariel University'" + RESET);

        System.out.println("Attempting to register our second observer...");
        // Initializing the second observer and registering it to our subject - Ariel University.
        ConcreteMember o2 = new ConcreteMember(group, 1);
        // Testing if our defined observer has been successfully joined our subject - Ariel University.
        assertFalse(group.getMembers().isEmpty());
        assertSame(o2, group.getMembers().get(1));
        System.out.println(GREEN + "    A new observer has been successfully registered.");
        System.out.println("    It is listed at index 1 in our subject's list.");
        System.out.println("    Our latest-registered observer current string-value is: 'Ariel University'" + RESET);

        System.out.println("Attempting to register our third observer...");
        // Initializing the third observer and registering it to our subject - Ariel University.
        ConcreteMember o3 = new ConcreteMember(group, 2);
        // Testing if our defined observer has been successfully joined our subject - Ariel University.
        assertFalse(group.getMembers().isEmpty());
        assertSame(group.getMembers().get(2), o3);
        System.out.println(GREEN + "    A new observer has been successfully registered.");
        System.out.println("    It is listed at index 2 in our subject's list.");
        System.out.println("    Our latest-registered observer current string-value is: 'Ariel University'" + RESET);

        System.out.println("Making sure that our subject's list currently has 3 observers...");
        // Making sure that our subject is being observed by 3 observes who are grouped in 1 place - A common ArrayList.
        assertEquals(group.getMembers().size(), 3);
        System.out.println(GREEN + "    Our subject's list DOES include 3 observers." + RESET);

        System.out.println("Attempting to unregister our first observer...");
        // Unregistering the first observer and making sure that the second observer has taken the first observer's place.
        group.unregister(o1);
        assertNotEquals(group.getMembers().get(0), o1);
        assertSame(group.getMembers().get(0), o2);
        assertEquals(group.getMembers().size(), 2);
        assertFalse(group.getMembers().isEmpty());
        System.out.println(GREEN + "    Our first observer has been successfully unregistered.");
        System.out.println("    Our subject's list is currently holding 2 observers left.");
        System.out.println("    Our second observer's index has been changed to 0." + RESET);

        System.out.println("Making sure that our second observer is still observing our subject's string-value after moving to index 0...");
        // Making sure that the second observer has maintained its own attributes.
        assertEquals(group.getMembers().get(0).toString(), o2.toString());
        assertSame(group.getMembers().get(0), o2);
        assertNotSame(group.getMembers().get(0), o1);
        System.out.println(GREEN + "    Our second observer is still observing our subject's string-value: 'Ariel University'" + RESET);

        System.out.println("Attempting to unregister our observer that was moved to index 0...");
        // Unregistering the o2 observer.
        group.unregister(o2);
        assertFalse(group.getMembers().isEmpty());
        assertSame(group.getMembers().get(0), o3);
        System.out.println(GREEN + "    Our observer has been successfully unregistered.");
        System.out.println("    Our subject's list is currently holding 1 observer left.");
        System.out.println("    Our left observer's index has been changed to 0." + RESET);


        System.out.println();
    }

    @Test
    void UpdatingFunctionalityTester () {
        System.out.println(BLUE + "-----------------------------------------------------");
        System.out.println("| 'UpdatingFunctionalityTester()' has been started. |");
        System.out.println("-----------------------------------------------------" + RESET);

        // Making sure that we still don't have any observers - an empty ArrayList.
        assertTrue(group.getMembers().isEmpty());

        System.out.println("Attempting to register 2 observers for our subject...");
        // Initializing the first observer and registering it to our subject - Ariel University.
        ConcreteMember o1 = new ConcreteMember(group, 0);
        // Testing if our defined observer has been successfully joined our subject - Ariel University.
        assertFalse(group.getMembers().isEmpty());
        assertEquals(group.getMembers().get(0), o1);

        // Initializing the second observer and registering it to our subject - Ariel University.
        ConcreteMember o2 = new ConcreteMember(group, 1);
        // Testing if our defined observer has been successfully joined our subject - Ariel University.
        assertFalse(group.getMembers().isEmpty());
        assertSame(group.getMembers().get(1), o2);
        System.out.println(GREEN + "    2 observers has been successfully registered." + RESET);

        // Performing changes on our U.S.B object and updating the whole observers that are attached to it.
        // Then, making sure that our whole attached observers have been successfully informed / updated.

        System.out.println("Attempting to insert 'This is ' string-value into our subject at offset 0...");
        group.insert(0, "This is ");
        assertEquals("This is Ariel University", group.getUsb().toString());
        System.out.println(GREEN + "    Our subject's current string-value is: 'This is Ariel University'");

        // Testing if our observers has been successfully updated with: "This is Ariel University".
        for (int i = 0; i < group.getMembers().size(); i++) {
            assertEquals(group.getMembers().get(i).toString(), group.getUsb().toString());
        }
        System.out.println("    Our whole subject's observers have been successfully updated with latest subject's changes.");
        System.out.println("    Our observers are currently observing the string-value: 'This is Ariel University'" + RESET);

        System.out.println("Attempting to append ' - Computer Science' string-value into our subject...");
        group.append(" - Computer Science");
        assertEquals("This is Ariel University - Computer Science", group.getUsb().toString());
        System.out.println(GREEN + "    Our subject's current string-value is: 'This is Ariel University - Computer Science'");

        // Testing if our observers has been successfully updated with: "This is Ariel University - Computer Science".
        for (int i = 0; i < group.getMembers().size(); i++) {
            assertEquals(group.getMembers().get(i).toString(), group.getUsb().toString());
        }
        System.out.println("    Our whole subject's observers have been successfully updated with latest subject's changes.");
        System.out.println("    Our observers are currently observing the string-value: 'This is Ariel University - Computer Science'" + RESET);

        System.out.println("Attempting to delete a sub-string of our subject from 0 to 26 (inclusive)...");
        group.delete(0, 27);
        assertEquals("Computer Science", group.getUsb().toString());
        System.out.println(GREEN + "    Our subject's current string-value is: 'Computer Science'");

        // Testing if our observers has been successfully updated with: "Computer Science".
        for (int i = 0; i < group.getMembers().size(); i++) {
            assertEquals(group.getMembers().get(i).toString(), group.getUsb().toString());
        }
        System.out.println("    Our whole subject's observers have been successfully updated with latest subject's changes.");
        System.out.println("    Our observers are currently observing the string-value: 'Computer Science'" + RESET);

        System.out.println("Attempting to retrieve 'This is Ariel University - Computer Science'...");
        group.undo();
        assertEquals("This is Ariel University - Computer Science", group.getUsb().toString());
        System.out.println(GREEN + "    'This is Ariel University - Computer Science' has been successfully retrieved.");

        // Testing if our observers has been successfully updated with: "This is Ariel University - Computer Science".
        for (int i = 0; i < group.getMembers().size(); i++) {
            assertEquals(group.getMembers().get(i).toString(), group.getUsb().toString());
        }
        System.out.println("    Our whole subject's observers have been successfully updated with latest subject's changes.");
        System.out.println("    Our observers are currently observing the string-value: 'This is Ariel University - Computer Science'" + RESET);

        System.out.println("Attempting to retrieve 'This is Ariel University'...");
        group.undo();
        assertEquals("This is Ariel University", group.getUsb().toString());
        System.out.println(GREEN + "    'This is Ariel University' has been successfully retrieved.");

        // Testing if our observers has been successfully updated with: "This is Ariel University".
        for (int i = 0; i < group.getMembers().size(); i++) {
            assertEquals(group.getMembers().get(i).toString(), group.getUsb().toString());
        }
        System.out.println("    Our whole subject's observers have been successfully updated with latest subject's changes.");
        System.out.println("    Our observers are currently observing the string-value: 'This is Ariel University'" + RESET);

        System.out.println("Attempting to retrieve 'Ariel University'...");
        group.undo();
        assertEquals("Ariel University", group.getUsb().toString());
        System.out.println(GREEN + "    'Ariel University' has been successfully retrieved.");

        // Testing if our observers has been successfully updated with: "Ariel University".
        for (int i = 0; i < group.getMembers().size(); i++) {
            assertEquals(group.getMembers().get(i).toString(), group.getUsb().toString());
        }
        System.out.println("    Our whole subject's observers have been successfully updated with latest subject's changes.");
        System.out.println("    Our observers are currently observing the string-value: 'Ariel University'" + RESET);

        System.out.println("Attempting to retrieve our subject's default string-value: an empty string...");
        group.undo();
        assertEquals("", group.getUsb().toString());
        System.out.println(GREEN + "    An empty string has been successfully retrieved.");

        // Testing if our observers has been successfully updated with: "".
        for (int i = 0; i < group.getMembers().size(); i++) {
            assertEquals(group.getMembers().get(i).toString(), group.getUsb().toString());
        }
        System.out.println("    Our whole subject's observers have been successfully updated with latest subject's changes.");
        System.out.println("    Our observers are currently observing an empty string-value: ''" + RESET);
        System.out.println();
    }
}
