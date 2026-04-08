# Java 8 (Legacy) vs Java 17/21 LTS:

## Week 1 (Record, Class, GC, JVM, Helpful and object comparative).

### Class vs Record:


**Java 8 (Legacy):** in this version we need to know the syntax and structure of the classes,
because we need to create the constructor, the **getters** (Obtain) and the **setters** (Set),
make it **mutable** (with setters),you need give the type of data like String, int, etc...
this was know how **POJOs**(Plain Old Java Objects).This cause the **"Boilerplate code"** (repetitive code).

**Java 17/21 LTS:** with these versions we have a new technologies like the **Record** that allow us
to create classes simpler and practical with only **one line of code** and are **unchanging** (without setters).
this feature is only for transport data. **Java** automatically create the accessors.
But no only this tool, also the **GC**(Garbage Collector) and the **JVM**(Java Virtual Machine).
This tools help us to improve the **quality of our code** and our
**memory management**, because with the **GC** we won more **efficiency**
to cleaning our information with the **Heap memory**.

### Class Example:

    //Tradinional class (POJO - Plain Old Java Object).
    public class User {

        private String username;
        private int id;                                                     

        //1. Constructor (Repeat the variables name).
        public User(String username, int id) {
            this.username = username;
            this.id = id;
        }
    
        //2. Getters (For obtain info).
        public String getUsername() {
            return username;
        }
    
        //3. Setters (For change info - Mutability).
        public void setUsername(String username) {
            this.username = username;
        }
    }

### Record Example:

    //Just a only line of code.
    public record User(String username, int id) {}

Can watch the difference between the old **classes** and the new **records**.
With the old **classes**, you need create the **class**, its **variables** with its **type**, then
you need create a **Constructor** with redundancy repeat the same code, become this in
**Boilerplate code**. In contrast, **records** are more simple because you only declare the
**variables** and **Java** internally with the **complier** generate a class with the file **.class**;
this **class** is created how **final class** that are close and **secure**.

### GC(Garbage Collector) and JVM(Java Virtual Machine):

**GC (Garbage Collector):** this tool is used for **Java** to improve the **performance** to the apps or code
this tool working in the **Heap storage** where you can find objects, arrays instead classes,
and when this code don't have **owner** or isn't **used** for the main code this tool **delete** this objects.
Improve it use with the algorithms **G1**(Garbage First) and **ZGC**(Z Garbage Collector) these are created for resolve the problem with
**old versions** of Java called **Stop-the-World** that **freeze** the apps while clean the memory.

**JVM (Java Virtual Machine)**: the **JVM** is the heart of **Java**, why?, because **"Write Once, Run Anywhere"**
this is the **tool** that allow the traduction of **Java** in **different operative system**
like **Linux**, **Windows** and **macOS** . But with the new version we have the **upgrade** of
**JIT** (Just-In-Time compiler) that make the Java code lighter,
identify the **"Hot Spots"**, **repetitve code** like loops or calcs; the **JIT** compile and then
become the code in **Machine code** and save it.

### Helpful:

With the integration of the **helpful NPEs**(JEP 358) in **Java 14** we can watch in the **console** the error and where are this
**error**, this was an **experimental feature** that after become in the standard with **Java 17/21**; it allows that
the **error message** was more **descriptive**. **Java** internally **analyze** the **bytecode** at the moment to run the code,
where the error appears and give us a **message**. Previously in **Java 8** you only watch the **error**, but you never know
what is the variable with the **null** or **problem**.

### Object comparative:

When you compare an **object**, **Java** don't compare the **value**, **Java** uses the **reference** (memory address) of the object, when
you use the **==** operator. With this context we can understand the following: although you create the **same object**,
**Java** assigns different **reference** when the **object** is created in the **heap**, because the operator **new** (instance) creates a
place in the **memory**; there, the **heap** gives to the **object** a **reference** like this **"models.Employable@7ad123"**. In contrast,
the **.equals()** method goes into the **object**, **"look inside"** and checks its content. By **overriding** this method;
here we can define our **own rules** to compare, this allows **Java** to confirm if two different **instances** (new) have the
same logic.

## Week 2 (Switch, var, Casting and Helpful)

### Old Switch vs New Switch:

**Java 8 (Legacy):** In this version the **switch** was only for instructions or **"statement"**,
what means that?, is like you create a **code block** for follow an
instruction or **cases** for response is all a direct **task** or **command**; we had
a problem with the **old switch** it never **return**, only follow the **command**, you can't
save the result of the **switch**. Also, we have a **heritage problem** from **c** and **c++** called
**fall-through** (neglect), this phenomenon appear when you **forget the break** in as far as
case. although in some situations the people did that **intentional** but **usually**
was **forgotten** the **break**, this caused that all case was displayed **sequentially execution**.

**Java 17(Transition):** Between **Java 17** and **Java 21** was added different things for the **switch**. First in **Java 17** was added
the **switch expression(->)** and allow **return** values with this was deleted the **fall-through** and the use
necessary of **break**; but in this version you have a limit of data **types**(Strings, numbers and Enums).
yet not use the **pattern matching** because was a preview feature, it was hidden,
but in **Java 21** is an official feature.

**Java 21(Now - JEP 441):** In this would implement the **pattern matching**, in this version you don't need
to create an if inside the **switch**, already you can control the **conditionals** directly in the **switch** using
**Guarded Pattern**(when). Now you can create a **case** of **null**, verification the **type** of object in the **case**.

### Old variables vs var:

**Java 8 (Legacy):** In this version the language is very **strict** with the **data**, because you need no matter
what define the type of it, leading to a **verbose coding style**, this became the code more long and
repeat the code **(boilerplate)**.

**Java 10+ (JEP 286):** In this version would add the reserved word **"var"**,
but It doesn't mean **Java** is no longer **strictly typed**,
only the **compiler** is **smarter** and identify the type of the data, use the data by its side **(right)**,
although it only can use in **methods (Local variable)**, don't can use like a **parameter**,
attribute without value, etc. It deletes the **redundancy** and improve the **clean code**.

### Casting:

In **Java**, we have something called **"Narrowing"**, basically **transform** a **big object** (64 bits) into a
**small box** (32 bits), where you do this **"(int) average"** happen **two critical things**.

1. **Overflow:** A **double** can save larger numbers than **int**. if the **double** is more than the limit of
**int** (2,147,483,647), when you transform it into **int**, the value is **broken**, and only you had the biggest
value of **int**, lost the real **value**.

2. **Truncation:** **Java** doesn't **round** the number at number more near, **Java** only cut the **decimal** part, for example
if you have **3.999999**, you lost the **.99...** and you had only the **Integer** 3.

### Casting Examples:

1. Widening Casting (Implicit / Automatic): Converting a smaller type to a larger type size. No data loss occurs here.
   
        int myInt = 17;
        double myDouble = myInt; // Automatic casting: int to double (17 -> 17.0)

        // Small -> Large: byte -> short -> char -> int -> long -> float -> double

2. Narrowing Casting (Explicit / Manual):Converting a larger type to a smaller size type. You must do this manually, and data loss (like decimals) will happen.

       double mySalary = 2500.85; 
       int manualInt = (int) mySalary; // Manual casting: double to int (2500.85 -> 2500)
    
       // Large -> Small: double -> float -> long -> int -> char -> short -> byte



