// Title: Passanger
// Author: Atilla/Abbas
// ID: 10000082
// Section: 1
// Assignment: 1
// Description:
// passanger class that extends person
// adds ticket and priority info
public class Passanger extends Person {
    String ticket;   // economy, economy-premium, or business
    int priority;    // smaller number = higher priority


    // Summary: Constructs a Passanger with ticket and priority.
    // Precondition: ticket is a non-null String; priority is an int.
    // Postcondition: A Passanger object is created; type is set to "passanger".
    public Passanger(String name, long ID, String ticket, int priority) {
        super(name, "passanger", ID); // parent constructor call
        this.ticket = ticket;
        this.priority = priority;
    }
    // Summary: Returns the priority used for ordering passangers.
    // Precondition: none.
    // Postcondition: returns integer priority.
    public int getPriority() {
        return priority;
    }

    // Summary: Returns required output format with ticket and priority appended.
    // Precondition: none.
    // Postcondition: Returns:
    //   "Name: ..., Type: passanger, ID: ... Ticket: <ticket>, Priority: <priority>"

    public String toString() {
        return super.toString() + " Ticket: " + ticket + ", Priority: " + priority;
    }
}

