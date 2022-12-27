package observer;

/**
 * "Ex0 : Part B" - Building Observer Design Pattern -> "Ex0 : Part A" assignment-related.
 * This class represents a single subject that has a number of observers that are observing him.
 * @author Osama & Hamad.
 */

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {
    private List <Member> members;
    private UndoableStringBuilder usb;

    /**
     * Constructor 1: A default constructor.
     */
    public GroupAdmin () {
        this.usb = new UndoableStringBuilder();
        this.members = new ArrayList<>();
    }

    /**
     * Constructor 2: This constructor assigns the given usb into our usb attribute and initializes the observers list as empty.
     * @param usb
     */
    public GroupAdmin (UndoableStringBuilder usb) {
        this.usb = usb;
        this.members = new ArrayList<>();
    }

    /**
     * This is a getter function.
     * @return our members ArrayList attribute.
     */
    public List<Member> getMembers() {
        return this.members;
    }

    /**
     * This is a getter function.
     * @return our usb attribute.
     */
    public UndoableStringBuilder getUsb() {
        return this.usb;
    }

    /**
     * This is a setter function - sets our usb attribute to the given parameter.
     * @param usb
     */
    public void setUsb(UndoableStringBuilder usb) {
        this.usb = usb;
    }

    /**
     * This function registers a certain observer to our specified subject by adding him to our collection of observers.
     * @param obj - An observer.
     */
    @Override
    public void register(Member obj) {
        try {
            this.members.add(obj);
        }
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function unregisters a certain observer from our specified subject by removing him out of our collection of observers.
     * @param obj - An observer.
     */
    @Override
    public void unregister(Member obj) {
        try {
            this.members.remove(obj);
        }
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset, obj);

        // Updating each observer with the latest performed change - inserting some string.
        for (int i = 0; i < members.size(); i++) {
            this.members.get(i).update(this.usb);
        }
    }

    @Override
    public void append(String obj) {
        this.usb.append(obj);

        // Updating each observer with the latest performed change - appending some string.
        for (int i = 0; i < members.size(); i++) {
            this.members.get(i).update(this.usb);
        }
    }

    @Override
    public void delete(int start, int end) {
        this.usb.delete(start, end);

        // Updating each observer with the latest performed change - deleting some string.
        for (int i = 0; i < this.members.size(); i++) {
            this.members.get(i).update(this.usb);
        }
    }

    @Override
    public void undo() {
        this.usb.undo();

        // Updating each observer with the latest performed change - retrieving latest-value using undo() function .
        for (int i = 0; i < members.size(); i++) {
            this.members.get(i).update(this.usb);
        }
    }
}
