import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

public class UndoableStringBuilderTests {
    // Declaring a general object to be under-testing from type: UndoableStringBuilder
    UndoableStringBuilder an_under_testing_usb = new UndoableStringBuilder();

    @Test
    void UndoableStringBuilderTester() {
        // Making sure that our constructor initializes our attributes as it was told in our class.
        // Gives the StringBuilder object an empty string and that the HashMap is initialized empty.
        assertNotNull(an_under_testing_usb.getSb());
        assertEquals("", an_under_testing_usb.toString());
        assertTrue(an_under_testing_usb.getStorage().isEmpty());
    }

    @Test
    void appendTester() {
        // "toBeAppended" variable will be appended into our object.
        String toBeAppended = "CS-AUUUUUUUUUUUUUUUUUUUUUUUUUU";

        // Making sure that our object's content is different from "toBeAppended" variable's content.
        assertNotEquals(an_under_testing_usb.getSb().toString(), toBeAppended);

        // Checking that our HashMap is still empty - before appending any string.
        assertTrue(an_under_testing_usb.getStorage().isEmpty());
        an_under_testing_usb.append(toBeAppended);

        // Making sure that "toBeAppended" variable was successfully appended into our object's content.
        assertEquals(an_under_testing_usb.getSb().toString(), toBeAppended);

        // Making sure that our inner HashMap is now NOT empty. It should be holding the content we appended.
        assertFalse(an_under_testing_usb.getStorage().isEmpty());
        assertEquals(an_under_testing_usb.getStorage().get(0), an_under_testing_usb.getSb().toString());

        // Performing negativity of our object's content - that it doesn't actually contain any different strings.
        String other = "UUUUUUUUUUUUUUUUUUUUUUUUUUA-SC";
        assertNotEquals(an_under_testing_usb.getSb().toString(), other);
    }

    @Test
    void deleteTester() {
        // Assigning "Elizabeth" value into our object by using append() function.
        an_under_testing_usb.append("Elizabeth");

        // Deleting a substring that holds a range of [3, 9) = "zabeth".
        an_under_testing_usb.delete(3, an_under_testing_usb.getSb().length());

        // Making sure that our HashMap now holds our object's recent content. In that case, it is NOT empty.
        assertTrue(!(an_under_testing_usb.getStorage().isEmpty()));
        assertEquals(an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1),
                                                                                    an_under_testing_usb.toString());

        // Making sure that the requested substring range was successfully deleted.
        assertEquals("Eli", an_under_testing_usb.toString());

        // Continuing to delete the leftover.
        an_under_testing_usb.delete(0, 3);

        // Making sure that our object's content is no longer "Eli".
        assertNotEquals("Eli", an_under_testing_usb.toString());

        // Making sure that our object's content has nothing in it left.
        assertEquals("", an_under_testing_usb.toString());

        // Making sure that our HashMap now holds our object's recent content - an empty string.
        assertEquals(an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1),
                                                                                    an_under_testing_usb.toString());
    }

    @Test
    void insertTester() {
        // Goal: Building "Computer Science" by using insert() function.

        // Assigning "C S" value into our object by using append() function.
        an_under_testing_usb.append("C S");

        // Inserting "omputer" into our object at index #1.
        an_under_testing_usb.insert(1, "omputer");

        // Making sure that the insert() function was perfectly performed. Out object's content should be: "Computer S".
        assertEquals("Computer S", an_under_testing_usb.toString());

        // Checking that our object's content is not "Computer Science" yet.
        assertNotEquals("Computer Science", an_under_testing_usb.toString());

        // Finishing the stage where our object content's must be "Computer Science".
        an_under_testing_usb.insert(10, "cience");
        assertEquals("Computer Science", an_under_testing_usb.toString());

        // Making sure that our HashMap is now holding "Computer Science" as its latest-value.
        assertFalse(an_under_testing_usb.getStorage().isEmpty());
        assertEquals(an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1),
                                                                                    an_under_testing_usb.toString());
    }

    @Test
    void replaceTester() {
        /*
            First goal: Turning "Computer Science" to "Science Computer" by using replace() function in 2 steps.
        */

        // Assigning "Computer Science" into our object by using append() function.
        an_under_testing_usb.append("Computer Science");

        // Replacing the substring "Computer" with "Science".
        an_under_testing_usb.replace(0, 8, "Science");

        // Making sure that the substring "Computer" was replaced with "Science".
        assertNotEquals("Computer Science", an_under_testing_usb.toString());
        assertEquals("Science Science", an_under_testing_usb.toString());

        // Checking if our HashMap's last value was updated with the new value after performing the latest changes on our object.
        assertNotEquals(an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1), "Computer Science");
        assertEquals(an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1), an_under_testing_usb.toString());

        // Replacing the second "Science" with "Computer".
        an_under_testing_usb.replace(8, an_under_testing_usb.getSb().length(), "Computer");
        assertEquals("Science Computer", an_under_testing_usb.toString());

        // Checking if our HashMap's last value was updated with the new value after performing the latest changes on our object.
        assertNotEquals(an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1), "Science Science");
        assertEquals(an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1), an_under_testing_usb.toString());

        /*
            Second goal: Turning "Science Computer" to "Computer Science" by using replace() function in 1 step.
        */

        //Replacing the whole latest "Science Computer" value into "Computer Science".
        an_under_testing_usb.replace(0, an_under_testing_usb.getSb().length(), "Computer Science");

        // Making sure that our object's content is now fully replaced to "Computer Science".
        assertNotEquals("Science Computer", an_under_testing_usb.toString());
        assertEquals("Computer Science", an_under_testing_usb.toString());

        // Checking if our HashMap's last value was updated with the new value after performing the latest changes on our object.
        assertNotEquals(an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1), "Science Computer");
        assertEquals(an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1), an_under_testing_usb.toString());
    }

    @Test
    void reverseTester() {
        // Initializing a string and its reversed version.
        String unreversed = "I would like to have a cup of tea please.";
        String reversed = ".esaelp aet fo puc a evah ot ekil dluow I";

        // Assigning the original sentence into our object.
        an_under_testing_usb.append(unreversed);

        // Making sure that our HashMap is holding the original sentence and not a reversed one.
        assertNotEquals(reversed, an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1));
        assertEquals(an_under_testing_usb.toString(), an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1));

        // Reversing the whole sentence from last to first.
        an_under_testing_usb.reverse();

        // Making sure that our object now contains the sentence in a reversed order and not the original one.
        assertNotEquals(unreversed, an_under_testing_usb.toString());
        assertEquals(reversed, an_under_testing_usb.toString());

        // Now, we make sure that our HashMap is now holding our object's new value - reversed sentence.
        assertNotEquals(unreversed, an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1));
        assertEquals(an_under_testing_usb.toString(), an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1));
    }

    @Test
    void undoTester() {
        /*
            The undo() function is fully relied on our HashMap attribute.
            Thus, this current tester will be dealing with our HashMap's behavior.
         */

        /*
            We will be performing all the above tested functions on our main object and observe how our HashMap
            accumulates their results. In parallel, we will be comparing our HashMap attribute with a temporary HashMap
            that will be pushed with those results manually. Then, a complete comparison will be performed between the
            temporary HashMap and our own HashMap attribute.
         */

        // Initializing a temporary HashMap to compare it with our object's HashMap attribute.
        HashMap <Integer, String> temp = new HashMap<>();

        // Checking that the two HashMaps are empty before performing any changes.
        assertTrue(an_under_testing_usb.getStorage().isEmpty());
        assertTrue(temp.isEmpty());

        // Tweaking our object's content and each tweak (object's content) is pushed into the temporary HashMap.
        an_under_testing_usb.append("to be or not to be");

        temp.put(0, an_under_testing_usb.toString());
        an_under_testing_usb.replace(3, 5, "eat");
        temp.put(1, an_under_testing_usb.toString());
        an_under_testing_usb.replace(17, 19, "eat");
        temp.put(2, an_under_testing_usb.toString());
        an_under_testing_usb.reverse();
        temp.put(3, an_under_testing_usb.toString());

        // Checking that the two HashMaps are NOT empty after performing the above changes. Also, are equal.
        assertFalse(an_under_testing_usb.getStorage().isEmpty());
        assertFalse(temp.isEmpty());
        assertEquals(an_under_testing_usb.getStorage(), temp);

        // Observing how the undo() function affects our HashMap attribute.
        temp.remove(temp.size() - 1, an_under_testing_usb.toString());
        an_under_testing_usb.undo();

        // Checking if both HashMaps latest-values are now holding the string "to eat or not to eat" - second-latest object's content.
        assertEquals(temp.get(temp.size() - 1), an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1));
        assertEquals(temp, an_under_testing_usb.getStorage());

        temp.remove(temp.size() - 1, an_under_testing_usb.toString());
        an_under_testing_usb.undo();

        // Checking if both HashMaps latest-values are now holding the string "to eat or not to be" - second-latest object's content.
        assertEquals(temp.get(temp.size() - 1), an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1));
        assertEquals(temp, an_under_testing_usb.getStorage());

        temp.remove(temp.size() - 1, an_under_testing_usb.toString());
        an_under_testing_usb.undo();

        // Checking if both HashMaps latest-values are now holding the string "to be or not to be" - second-latest object's content.
        assertEquals(temp.get(temp.size() - 1), an_under_testing_usb.getStorage().get(an_under_testing_usb.getStorage().size() - 1));
        assertEquals(temp, an_under_testing_usb.getStorage());

        // Testing undo() in case our object has an empty value - special case.
        temp.remove(temp.size() - 1, an_under_testing_usb.toString());
        an_under_testing_usb.undo();
        assertEquals("", an_under_testing_usb.toString());
        assertTrue(temp.isEmpty());

        // Finally, we make sure that the two HashMaps are equal even after performing undo() multiple times.
        assertEquals(temp, an_under_testing_usb.getStorage());
    }
}
