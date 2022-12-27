package observer;

/**
 * "Ex0 : Part B" - Building Observer Design Pattern -> "Ex0 : Part A" assignment-related.
 * This class represents a single observer that is observing a subject.
 * @author Osama & Hamad.
 */

public class ConcreteMember implements Member {
    private GroupAdmin subject;
    private int num;

    /**
     * Constructor 1: A default constructor.
     */
    public ConcreteMember () {
        this.subject = new GroupAdmin();
    }

    /**
     * Constructor 2: This constructor has a given subject that our current observer gets registered to.
     * @param subject
     */
    public ConcreteMember (GroupAdmin subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    /**
     * Constructor 3: This constructor assigns the given parameters into our attributes and registers our member to the given subject.
     * @param subject
     * @param num
     */
    public ConcreteMember (GroupAdmin subject, int num) {
        this.subject = subject;
        this.subject.register(this);
        this.num = num;
    }

    /**
     * This is a getter function.
     * @return subject attribute of type GroupAdmin
     */
    public GroupAdmin getSubject() {
        return this.subject;
    }

    /**
     * This is a getter function.
     * @return num attribute of primitive type int.
     */
    public int getNum() {
        return this.num;
    }

    /**
     * This function updates our observer with U.S.B's recent performed change.
     * @param usb
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.subject.setUsb(usb);
    }

    /**
     * This function represents our observer's current under-observing string-value (subject's content).
     * @return A string that our current observer is observing.
     */
    @Override
    public String toString() {
        return this.subject.getUsb().toString();
    }
}
