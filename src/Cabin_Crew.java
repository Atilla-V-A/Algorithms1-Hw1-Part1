// Title: Cabin_Crew
// Author: Atilla/Abbas
// ID: 10000082
// Section: 1
// Assignment: 1
// Description:
// cabin crew class extends person
// adds job title and credit score
public class Cabin_Crew extends Person {
    String job;     // like pilot, hostess etc
    double credit;  // smaller credit = higher order

    // Summary: Constructs a Cabin_Crew with job and credit.
    // Precondition: job is non-null; credit is a double (>= 0 assumed).
    // Postcondition: A Cabin_Crew object is created; type is "cabin-crew".
    public Cabin_Crew(String name, long ID, double credit, String job) {
        super(name, "cabin-crew", ID);
        this.job = job;
        this.credit = credit;
    }

    // Summary: Returns credit used for ordering cabin crew.
    // Precondition: none.
    // Postcondition: returns credit as double.
    public double getCredit() {
        return credit;
    }


    // Summary: Returns required output format with job and credit appended.
    // Precondition: none.
    // Postcondition: Returns:
    //   "Name: ..., Type: cabin-crew, ID: ... Job: <job>, Credit: <credit>"
    public String toString() {
        return super.toString() + " Job: " + job + ", Credit: " + credit;
    }
}
