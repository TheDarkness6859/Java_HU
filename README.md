# Java 8 (Legacy) vs Java 17/21 LTS:

## Week 1 (Record, Class, GC, JVM, Helpful and object comparative).

### Class vs Record:


**Java 8 (Legacy):** in this version we need to know the syntax and structure of the classes,
because we need to create the constructor, the **getters** (Obtain) and the **setters** (Set),
make it **mutable** (with setters),you need give the type of data like String, int, etc...
this was known as **POJOs**(Plain Old Java Objects).This cause the **"Boilerplate code"** (repetitive code).

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
this tool works in the **Heap storage** where you can find objects, arrays instead classes,
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
although it only can use in **methods (Local variable)**, cannot be used as a **parameter**,
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

## Week 3 (Java Collections Framework: From Legacy to Modern)

### JCF (Java Collections Framework):

**Java (Legacy):** For know the sintaxis of **Java 8**, We need know before the **first** versions of **Java** more
specific **Java 1.0 & 1.1**, here even not exist JCF it was included in **Java 1.2**, but We had the **similar**.

- **Arrays []**: It was the unique form to save multiple data, but **ONLY** with specific size.
- **Vector**: It was the **ancestor** of the **ArrayList**.
- **Hashtable:** It was the **ancestor** of **HashMap**.
- **Stack:** It was for use **pile** (LIFO).
- **Enumeration:** It the **old** form to iterate data (before of exist **Iterator**).

**Vector**: It was used how **dynamic Array**, but It had some **problems**, the most important was
the **thread-safe** It make that only one element join to the list and when this finished , again join another;
this was very bad because if you have **100 employees** for join to the office , you in the **99%** of cases
only have a **thread** (one person), but **Java** continue work **under the hood**, **open** and **close** the list.
Spend the **time** and **memory** (overhead).

      // Legacy Form ( without defined type )
      Vector vector = new Vector();
      vector.add("Emmanuel");
      vector.add(17); // You can mixed data, It was dangerous
      
      // Acceder a un elemento
      String name = (String) vector.get(0); // You need did manual Casting

**Hashtable**: It was not allow the **nulls** in the **keys** or **values**, when you try **insert** **null** for
something, **immediately** It throws **NullPointerException**, It's a problem because in the **currently** we 
sometimes need put **null** for say **"Hey, this value not exists yet"**.

      Hashtable table = new Hashtable();
      table.put("ID_6859", "Emmanuel");
      table.put("ID_2535", "Project Domipet");
      
      // for get a value
      String project = (String) table.get("ID_2535");

**Stack**: It was a very big problem, a heritage problem because, It was like a
Vector disguised, supposed to the stack only allow two things push in top (push) and
get of top (pop), but how was It heritage all the Vector, you can use almost all
methods of a list.

      Stack stack = new Stack();
      stack.push("Base");
      stack.push("Middle");
      stack.push("Top");
      
      // Get the up element
      String top = (String) stack.pop(); // Return "Top" and delete It

**Enumeration**: It was very **basic**, you only can **go forward**, you cannot go back, and
too you **unknown** the index, and finally you never can restart the iteration.

      Vector names = new Vector();
      names.add("Java 1.0");
      names.add("Legacy");
      
      // Obtain the enumeration
      Enumeration en = names.elements();
      
      // to iterate while exist elements
      while (en.hasMoreElements()) {
      System.out.println(en.nextElement());
      }

**Java 17/21 LTS**: Thanks to the **Generics** (<>) now all are more secure and faster
and not repetitive code.

**ArrayList (Evolution of vector)**: This is a pretty list, is **dynamic** and **not synchronize**, is faster than
the old **vector**

var employees = new ArrayList<Employable>();

      // Add elements
      employees.add(new Employable(...));
      employees.add(new Employable(...));
      
      // Java 21 (Sequenced Collections): ¡the new!
      Employable first = employees.getFirst(); // bye to .get(0)
      Employable last = employees.getLast();   // bye to .size() - 1
      
      System.out.println("First employee: " + first.getFullName());

**HashMap (Evolution of Hashtable)**: Is a **key-value** Map. Is the best for find something for its key
without **iteration** all the list.

      var employeeMap = new HashMap<String, Employable>();
      
      // Save data (allow null in the key, in contrast of Hashtable)
      employeeMap.put("EMP-6859", new Employable(...));
      
      // Buscar es instantáneo O(1)
      Employable found = employeeMap.get("EMP-6859");
      
      // Verificar si existe antes de buscar
      if (employeeMap.containsKey("EMP-6859")) {
      System.out.println("Employee found: " + found.getFullName());
      }

**Iterator (Evolution of Enumeration): The **Iterator** is the more **secure** form to iterate a list if you
want to **delete** something **while** you iterate the list. If you try to **delete** with **for** the system
explode, but not with the **Iterator**.

      var it = employees.iterator();
      
      while (it.hasNext()) {
      Employable e = it.next();
      
       // if the point is less than 50, take out of the list.
       if (e.getTestPoint() < 50) {
           it.remove(); // The Iterator know how delete secure.
       }
      }

**Factory Methods**: In **Java 8** It doesn't exist, from **Java 9** and **Java 11**, We can create **lists** and **maps**
in only one line. **Why Immutable is safer?** Using **List.of()** or **Map.of()** is **safer** because it prevents side effects.
Since the **collection** cannot be **modified**, you don't have to worry about other parts of your code changing your configuration
data **(like "sedes" or "Technologies")** by accident. It follows the **"Fail-Fast"** principle: if you try to change it, **Java stops** you immediately.

      // Inmutable lists (You cannot changes its values)
      var sedes = List.of("Medellín", "Bogotá", "Cali");
      var tecnologies = Map.of("Backend", "Java", "Frontend", "React");
      
      // Try to do it give us the error (UnsupportedOperationException):
      // sedes.add("Pereira");


## Java 21 (Sequenced Collections)

Beyond **getFirst()** and **getLast()**, we now have the **reversed()** method. This provides a **reverse-order** view of the collection
without the need to **manually** sort or copy the data. It **improves** readability and prevents 
**off-by-one** errors when iterating backwards.

      // Our original list
      var employees = new ArrayList<Employable>();
      employees.add(emp1); // First
      employees.add(emp2); // Last
      
      // --- Java 8 Way (Legacy) ---
      // This modifies the 'employees' list permanently!
      Collections.reverse(employees);
      
      // --- Java 21 Way (Modern) ---
      // This creates a reversed VIEW. 'employees' stays the same.
      var reversedEmployees = employees.reversed();
      
      // You can iterate it directly
      for (Employable e : employees.reversed()) {
      System.out.println(e.getFullName());
      }

**Functional Filtering (Java 8+)**: Instead of using a **manual Iterator** with 5 lines of code, we use **removeIf**. This method
uses a Predicate **(lambda / ->)** to filter and remove elements in a **single**, **safe**, and readable line.

      // Before (Manual Iterator):
      var it = employees.iterator();
      while (it.hasNext()) {
      if (it.next().getTestPoint() < 60) it.remove();
      }
      
      // Now (Modern Functional Style):
      employees.removeIf(e -> e.getTestPoint() < 60);