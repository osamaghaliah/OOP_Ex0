<h1 align="center"> Observer Design Pattern • String-Related </h1>
<h2> An Object-Oriented-Programming Assignment </h2>
 
 <h3> Definition: </h3>
 
_Object-oriented programming (OOP) is a computer programming model that organizes software design around data, or objects, rather than functions and logic. An object can be defined as a data field that has unique attributes and behavior._

<h3> Assignment: </h3>

* **Objective -** _Implementing an Observer Design Pattern on a customized StringBuilder class that was built under the name of "UnodableStringBuilder"._

* **U.M.L Diagram** - 

![UML - UndoableStringBuilder](https://user-images.githubusercontent.com/75171676/209716339-8216c442-9362-4bd8-83a5-217d4161b58c.JPG)

<ins>**How was the Observer Design Pattern related to the shown U.M.L Diagram ?**</ins>
* _ConcrecteMember class which implements Memeber interface is playing the role of an **Observer**._
* _GroupAdmin class which implements Sender interface is palying the role of a **Subject**._
* _UndoableStringBuilder class which is the self-built customized StringBuilder plays the role of the essential object that is common between Sender & Member._

<h3> JUNIT5 Classes: </h3>

_Each class has its own JUNIT testers that proves the correctness of its implementaion. The following Java files are the tests that are included in our code:_

* _UndoableStringBuilderTests.java_

![Capture](https://user-images.githubusercontent.com/75171676/209718251-6fe3b07c-8452-4a13-87f9-ab8f91d00854.PNG)

* _ConcreteMemberTests.java_

![CMTests](https://user-images.githubusercontent.com/75171676/209718372-3863e109-a096-41eb-b2c2-69793cfdd794.PNG)


* _GroupAdminTests.java_

![GroupAdminTests](https://user-images.githubusercontent.com/75171676/209718427-c112adff-e67d-4398-859e-591f530e5808.PNG)

> _**NOTE: The whole testers were successfully passed.**_

<h3> Heap Trace In J.V.M: </h3>

_We were provided a JvmUtilities.java file which helps us to track our objects in terms of memory size in bytes. This class has the following functions:_

* _**static String jvmInfo()** - Tells us how much memory & available cores were allocated at the beginning of the program._ 
* _**static String objectFootprint(Object... roots)** - Provides us a textual data about shallow & deep memory size footprint of an object/objects._
* _**static String objectTotalSize(Object... roots)** - Calculates a deep memory size of an object/objects (without footprint)._
* _**static String memoryStats(Object o)** - This function combines both objectFootprint(Object... roots) & objectTotalSize(Object... roots)._

_The following table explains how each object of certain type consumes in bytes in the heap:_

| Object Type | Bytes |
|:-------------:|:-------------:|
| _UndoableStringBuilder_ | _128_ |
| _Member_      | _256_ |
| _Sender_ | _256_ |

_The above table results were fully relied on the following JUNIT tester of the heap:_

* _Tests.java_

![Capture](https://user-images.githubusercontent.com/75171676/209722646-aa1f670c-f792-44d6-bed0-6b255ad4a9ad.PNG)

> _**NOTE: This test was sucessfully passed too.**_




