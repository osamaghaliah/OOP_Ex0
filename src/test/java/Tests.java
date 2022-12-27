import observer.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    static final String BLUE = "\u001B[34m";
    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        // One observer is observing one subject.
        UndoableStringBuilder usb = new UndoableStringBuilder();
        Sender group = new GroupAdmin(usb);
        Member observer = new ConcreteMember((GroupAdmin) group);

        System.out.println(BLUE + "---------------------------------------------------------------------------------------------------------");
        System.out.println(BLUE + "| Calculating total memory sizes of default objects of types: UndoableStringBuilder, Member & Sender... |" );
        System.out.println(BLUE + "---------------------------------------------------------------------------------------------------------" + RESET);
        System.out.println();

        logger.info(()->JvmUtilities.memoryStats(usb));
        logger.info(()->JvmUtilities.memoryStats(observer));
        logger.info(()->JvmUtilities.memoryStats(group));
        logger.info(()->JvmUtilities.objectTotalSize(usb, observer, group));

        System.out.println(GREEN + "    An accumulated total size of the 3 objects is: 256 Bytes." + RESET);

        group.register(observer);
        group.append("Observer Pattern");
        System.out.println();

        System.out.println(BLUE + "-----------------------------------------------------------------------------------------");
        System.out.println(BLUE + "| 'Observer Pattern' string-value has been appended into our U.S.B object.              |");
        System.out.println(BLUE + "| Calculating total memory sizes of the 3 objects after appending 'Observer Pattern'... |" + RESET);
        System.out.println(BLUE + "-----------------------------------------------------------------------------------------");
        System.out.println();

        logger.info(()->JvmUtilities.memoryStats(usb));
        logger.info(()->JvmUtilities.memoryStats(observer));
        logger.info(()->JvmUtilities.memoryStats(group));
        logger.info(()->JvmUtilities.objectTotalSize(usb, observer, group));

        System.out.println(GREEN + "    An accumulated total size of the 3 objects after appending 'Observer Pattern' is: 440 Bytes." + RESET);
        System.out.println();

        System.out.println("Attempting to retrieve the previous case of the whole 3 objects by using undo() function...");
        group.undo();
        logger.info(()->JvmUtilities.objectTotalSize(usb, observer, group));
        System.out.println(GREEN + "    An accumulated total size of the 3 objects after performing undo() is: 256 Bytes." + RESET);
        System.out.println();

        System.out.println(BLUE + "Here is the following JVM info:" + RESET);
        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
