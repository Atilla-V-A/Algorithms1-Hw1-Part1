// basic person class
// we will use this as the parent class for both passanger and cabin crew
public class Person {
    String name;   // person's name
    String type;   // passanger or cabin-crew
    long ID;       // unique id

    // Summary: Constructs a Person with given name, type and ID.
    // Precondition: name != null; type is either "passanger" or "cabin-crew".
    // Postcondition: A Person object is created with the provided values.
    public Person(String name, String type, long ID) {
        this.name = name;
        this.type = type;
        this.ID = ID;
    }

    // Summary: Returns the unique ID of this person.
    // Precondition: none.
    // Postcondition: returns ID as long.
    public long getID() {
        return ID;
    }

    // Summary: Converts this Person to the exact print format required.
    // Precondition: none.
    // Postcondition: Returns a String like:
    //   "Name: <name>, Type: <type>, ID: <ID>"
    public String toString() {
        return "Name: " + name + ", Type: " + type + ", ID: " + ID;
    }
}
