# ✈️ Polymorphic Airplane Management System (CMPE 223 - Q1)

This Java project is a university assignment that demonstrates advanced Object-Oriented Programming and custom data structure design. The core of the project is a **custom-built `LinkedList` from scratch** that handles different object types polymorphically.

This isn't a normal list—it's designed to hold different types of objects at the same time (`Passanger`, `Cabin_Crew`, and even other `SLinkedLists` themselves). It uses a single public `insert` method that intelligently checks the object's type (`instanceof`) to apply different sorting rules, as required by the assignment.

## ✨ Features

* **Polymorphic Insert:** A single `insert(Object data)` method that:
    * Sorts `Passanger` objects by **priority** (ascending).
    * Sorts `Cabin_Crew` objects by **credit** (ascending).
    * Appends entire `SLinkedList` objects to the end (for the "list of lists").
* **Recursive Operations:**
    * **`displayList()`:** Traverses the nested "list of lists" to print every person.
    * **`deleteByID(long id)`:** Recursively dives into all sub-lists to find and delete every person with a matching ID.
* **Merge and Sort:** A final operation combines all people from all sub-lists into a single, new list, sorted by their `ID` number.
* **Interactive Menu:** A console menu to add people, print lists, delete, and combine.

## 🎓 Concepts Demonstrated

* **Data Structures:** Building a `LinkedList` from the ground up (using `Node` and `head` pointers).
* **Object-Oriented Programming (OOP):**
    * **Inheritance:** Using a base `Person` class extended by `Passanger` and `Cabin_Crew`.
    * **Polymorphism:** Creating a single method (`insert`) that behaves differently based on the object's runtime type.
* **Recursion:** Using recursive calls to navigate a nested list structure for deleting and displaying.
* **Type Checking:** Using `instanceof` as a core part of the program's logic.

## 🚀 How to Run

1.  Ensure you have a Java Development Kit (JDK) installed.
2.  Compile all the Java files:
    ```bash
    javac Main.java Person.java Passanger.java Cabin_Crew.java SLinkedList.java Node.java
    ```
3.  Run the main program:
    ```bash
    java Main
    ```
4.  Follow the on-screen menu options (1-4).

## 🗂️ File Structure

* `Main.java`: The main program driver that contains the user menu and logic.
* `SLinkedList.java`: The custom polymorphic `LinkedList` class.
* `Node.java`: The basic node class that holds `Object` data.
* `Person.java`: The base
