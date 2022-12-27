package observer;

import java.util.HashMap;

/**
 * Ex0 : Part A - UndoableStringBuilder is a custom Java's built-in StringBuilder class
 * with a little twist - supports undo() function: where it retrieves the object's second-latest string value back.
 * @author Osama & Hamad.
 */
public class UndoableStringBuilder {
    // This attribute is helpful to manage general strings by using its own built-in functions.
    private StringBuilder sb;
    // This attribute plays a significant role for the undo() function - purposed to store every sb's value.
    private HashMap <Integer, String> storage;

    /**
     * Constructor 1 - Receives no parameters and initializes our 2 main attributes as empty.
     */
    public UndoableStringBuilder() {
        // Initializing our sb and storage attributes as empty.
        this.sb = new StringBuilder();
        this.storage = new HashMap <> ();
    }

    /**
     * Constructor 2 - Receives 2 parameters and assigning them into our 2 main attributes.
     */
    public UndoableStringBuilder(StringBuilder sb, HashMap <Integer, String> storage) {
        // Updating our 2 main attributes with the new given values.
        this.sb = sb;
        this.storage = storage;
        this.storage.put(this.storage.size(), this.sb.toString());
    }

    public StringBuilder getSb() {
        return this.sb;
    }

    public HashMap<Integer, String> getStorage() {
        return this.storage;
    }

    /**
     * This function appends the received string to our current StringBuilder object "sb".
     * @param str
     * @return A new UndoableStringBuilder object with the new appended string.
     */
    public UndoableStringBuilder append(String str) {
        this.sb.append(str);

        return new UndoableStringBuilder(this.sb, this.storage);
    }

    /**
     * This function deletes a specified sub-string of our "sb" attribute by specifying starting & ending points.
     * The range is defined as the following: [start, end) .
     * @param start
     * @param end
     * @return A new UndoableStringBuilder object after deleting the specified substring.
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            this.sb.delete(start, end);
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds!");
        }

        return new UndoableStringBuilder(this.sb, this.storage);
    }

    /**
     * This function inserts the given string into a specified index (offset) and pushes the old-rest.
     * @param offset
     * @param str
     * @return A new UndoableStringBuilder object after inserting the given string.
     */
    public UndoableStringBuilder insert(int offset, String str) {
        try {
            this.sb.insert(offset, str);
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds!");
        }

        return new UndoableStringBuilder(this.sb, this.storage);
    }

    /**
     * This function replaces a substring of the specified starting & ending points with the given string.
     * The range is defined as the following: [start, end) .
     * @param start
     * @param end
     * @param str
     * @return A new UndoableStringBuilder object after replacing it with the given string.
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            this.sb.replace(start, end, str);
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds!");
        }

        return new UndoableStringBuilder(this.sb, this.storage);
    }

    /**
     * This function reverses our current "sb" attribute's string content.
     * For instance: Old string: OsamaHamad , New String: damaHamasO
     * @return A new UndoableStringBuilder object.
     */
    public UndoableStringBuilder reverse() {
        this.sb.reverse();

        return new UndoableStringBuilder(this.sb, this.storage);
    }

    /**
     * This function gives our current "sb" attribute's content the second-latest string it used to have.
     * It is performed by support of our HashMap "storage" attribute which is updated everytime
     * we make a change on our "sb" attribute.
     * Mechanism: once the undo() function is called, it removes out the HashMap's last key-value pair and assigns the
     * last HashMap's pair's value into our "sb" attribute's content.
     */
    public void undo() {
        try {
            this.storage.remove(this.storage.size() - 1, this.storage.get(this.storage.size() - 1));
            this.sb.replace(0, sb.length(), this.storage.get(this.storage.size() - 1));
        }
        catch (NullPointerException e) {
            this.sb = new StringBuilder();
            this.storage = new HashMap<>();
        }
    }

    /**
     * This function is helpful for our Main to help us print out this class general objects values.
     * @return Our "sb" attribute's content - a string.
     */
    @Override
    public String toString() {
        return this.sb.substring(0);
    }
}
