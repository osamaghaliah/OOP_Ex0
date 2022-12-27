/**
 * This JUNIT class tests correctness of ConcreteMember class functionality.
 * Goal: It makes sure that after every change that was performed on the subject, our observers actually do get updated.
 * @author Osama & Hamad.
 */

import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConcreteMemberTests {
    // Declaring a general 2 objects to be under-testing from types: GroupAdmin & ConcreteMember.
    GroupAdmin group = new GroupAdmin(new UndoableStringBuilder());
    ConcreteMember observer = new ConcreteMember(group, 1);
    static final String BLUE = "\u001B[34m";
    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";

    // NOTE: Each function that was performed on "group" contains an update() function!
    @Test
    void updateTester() {
        System.out.println(BLUE + "--------------------------------------");
        System.out.println("| 'updateTester()' has been started. |");
        System.out.println("--------------------------------------" + RESET);

        System.out.println("Checking that our subject is currently holding an empty string..." );
        // Testing that our current observer is holding the default U.S.B object's value.
        assertEquals(observer.getSubject().getUsb().toString(), "");
        System.out.println(GREEN + "   Our subject DOES hold an empty string." + RESET);

        System.out.println("Attempting to append 'OOP Course' string-value into our subject...");
        // Performing changes and updating our observer with the latest change - appending some content.
        group.append("OOP Course.");
        System.out.println(GREEN + "   Our subject's current string-value is: 'OOP Course.'" + RESET);

        System.out.println("Making sure that our subject's observer has been successfully updated with 'OOP Course.'...");
        // Testing that our observer has been successfully updated with U.S.B (after changes) - "OOP Course.".
        assertEquals(observer.getSubject().getUsb().toString(), "OOP Course.");
        System.out.println(GREEN + "   Our subject's observer has been successfully updated with 'OOP Course.'" + RESET);

        System.out.println("Attempting to insert 'This is an ' string-value into our subject at 0 offset...");
        // Performing changes and updating our observer with the latest change - inserting some content.
        group.insert(0, "This is an ");
        System.out.println(GREEN + "   Our subject's current string-value is: 'This is an OOP Course.'" + RESET);

        System.out.println("Making sure that our subject's observer has been successfully updated with 'This is an OOP Course.'...");
        // Testing that our observer has been successfully updated with U.S.B (after changes) - "This is an OOP Course.".
        assertEquals("This is an OOP Course.", observer.getSubject().getUsb().toString());
        System.out.println(GREEN + "   Our subject's observer has been successfully updated with 'This is an OOP Course.'" + RESET);

        System.out.println("Attempting to delete our whole subject's string-value...");
        // Performing changes and updating our observer with the latest change - deleting some content.
        group.delete(0, 22);
        System.out.println(GREEN + "   Our subject's current string-value is: ''." + RESET);

        System.out.println("Making sure that our subject's observer has been successfully updated with ''...");
        // Testing that our observer has been successfully updated with U.S.B (after changes) - an empty string.
        assertEquals("", observer.getSubject().getUsb().toString());
        System.out.println(GREEN + "   Our subject's observer has been successfully updated with ''." + RESET);

        System.out.println("Attempting to retrieve 'This is an OOP Course.'... ");
        // Performing changes and updating our observer with the latest change - restoring previous content.
        group.undo();

        // Testing that our observer has been successfully updated with U.S.B (after changes) - "This is a String".
        assertEquals("This is an OOP Course.", observer.getSubject().getUsb().toString());
        System.out.println(GREEN + "   'This is an OOP Course.' has been successfully retrieved.");
        System.out.println("   Our subject's current string-value is: 'This is an OOP Course.'");
        System.out.println("   Our subject's observer has been successfully updated with: 'This is an OOP Course.'." + RESET);

        System.out.println("Attempting to retrieve 'OOP Course.'... ");
        // Performing changes and updating our observer with the latest change - restoring previous content.
        group.undo();

        // Testing that our observer has been successfully updated with U.S.B (after changes) - "This is a String".
        assertEquals("OOP Course.", observer.getSubject().getUsb().toString());
        System.out.println(GREEN + "   'OOP Course.' has been successfully retrieved.");
        System.out.println("   Our subject's current string-value is: 'OOP Course.'");
        System.out.println("   Our subject's observer has been successfully updated with: 'OOP Course.'." + RESET);

        // Performing changes and updating our observer with the latest change - restoring previous content.
        group.undo();

        System.out.println("Attempting to retrieve our subject's default string-value... ");
        // Testing that our observer has been successfully updated with U.S.B (after changes) - "This is a String".
        assertEquals("", observer.getSubject().getUsb().toString());
        System.out.println(GREEN + "   Our subject's default string-value has been successfully retrieved.");
        System.out.println("   Our subject's current string-value is: an empty string-value.");
        System.out.println("   Our subject's observer has been successfully updated with: an empty string-value" + RESET);
        System.out.println();
    }
}
