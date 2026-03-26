package com.corporate.talent;

public class ArchitectureNotes {

    /*
        This class has the documentation and the difference between java 8 (Legacy) and java 17/21 LTS
     */

    /*
        Java 8 (Legacy): in this version we need to know the syntax and structure of the classes,
        because we need to create the constructor, the getters(Obtain) and the setters(Set),
        make it mutable (with setters),you need give the type of data like String, int, etc...
        this was know how POJOs(Plain Old Java Objects).This cause the "Boilerplate code"(repetitive code).

        Java 17/21 LTS: with these versions we have a new technologies like the Records that allow us
        to create classes simpler and practical with only one line of code and are unchanging (without setters).
        this feature is only for transport data.Java automatically create the accessors.
        But no only this tool too the GC(Garbage Collector) and the JVM(Java Virtual Machine).
        This tools help us to improve the quality of our code and our
        memory management, because with the GC we won more efficiency
        to cleaning our information with the Heap memory.
        Improve it use with the algorithms G1 and ZGC these are created for resolve the problem with
        old versions of Java called Stop-the-World that freeze the apps while clean the memory.

        GC (Garbage Collector): this tool is used for Java to improve the performance to the apps or code
        this tool working in the Heap storage where you can find objects, arrays instead classes,
        and when this code don't have owner or isn't used for the main code this tool delete this objects.

        JVM (Java Virtual Machine): the JVM is the heart of Java, why?, because "Write Once, Run Anywhere"
        this is the tool that allow the traduction of Java in different operative system
        like Linux, Windows and macOS . But with the new version we have the upgrade of
        JIT (Just-In-Time compiler) that make the Java code lighter,
        identify the "Hot Spots", repetitve code like loops or calcs; the JIT compile and then
        become the code in Machine code and save it.
     */

    /*
        We can watch the difference between the old classes and the new records.
        With the old classes, you need create the class, its variables with its type, then
        you need create a Constructor with redundancy repeat the same code, become this in
        Boilerplate code. In contrast, records are more simple because you only declare the
        variables and Java internally with the complier generate a class with the file .class;
        this class is created how final class that y close and secure.
     */
}

