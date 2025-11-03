
// Title: Main
// Author: Atilla/Abbas
// ID: 10000082
// Section: 1
// Assignment: 1
// Description:
//   - Creates the four people lists and the list_of_lists (which stores the four lists).
//   - Menu 1: add a person (reads fields, inserts into correct people list).
//   - Menu 2: print all lists (walks list_of_lists).
//   - Menu 3: delete by ID (traverses all inside lists).
//   - Menu 4: combine by ID, print, EXIT.
//
// main program with menu
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 4 people lists
        SLinkedList economy = new SLinkedList();
        SLinkedList ecoPremium = new SLinkedList();
        SLinkedList business = new SLinkedList();
        SLinkedList crew = new SLinkedList();

        // list of lists
        SLinkedList all = new SLinkedList();
        all.insert(economy);
        all.insert(ecoPremium);
        all.insert(business);
        all.insert(crew);

        while (true) {
            System.out.println("Enter the operation:");
            System.out.println("1: Add a person");
            System.out.println("2: Print all the lists");
            System.out.println("3: Delete all the people with the given ID");
            System.out.println("4: Combine all the lists sorted by ID, print and then exit");

            String s = sc.nextLine();
            if (s.equals("1")) {// add person
                System.out.print("Enter the name: ");
                String name = sc.nextLine();
                System.out.print("Enter the ID: ");
                long id = Long.parseLong(sc.nextLine());
                System.out.print("Enter the type (passanger or cabin-crew): ");
                String type = sc.nextLine();

                if (type.equals("passanger")) {
                    System.out.print("Enter the ticket type (economy, economy-premium, business): ");
                    String ticket = sc.nextLine();
                    System.out.print("Enter the priority: ");
                    int pr = Integer.parseInt(sc.nextLine());
                    Passanger p = new Passanger(name, id, ticket, pr);
                    // decide which list to add into
                    if (ticket.equals("economy")) economy.insert(p);
                    else if (ticket.equals("economy-premium")) ecoPremium.insert(p);
                    else if (ticket.equals("business")) business.insert(p);
                } else if (type.equals("cabin-crew")) {
                    System.out.print("Enter the job: ");
                    String job = sc.nextLine();
                    System.out.print("Enter the credit: ");
                    double cr = Double.parseDouble(sc.nextLine());
                    Cabin_Crew c = new Cabin_Crew(name, id, cr, job);
                    crew.insert(c);
                }
                System.out.println(); // space after each op
            }

            else if (s.equals("2")) {// print lists
                all.displayList();
                System.out.println();
            }

            else if (s.equals("3")) { // delete by ID
                System.out.print("Enter the ID to delete: ");
                long del = Long.parseLong(sc.nextLine());

                // check if everything is empty before calling delete
                if (economy.head == null && ecoPremium.head == null && business.head == null && crew.head == null) {
                    System.out.println("List is empty, nothing to delete.\n");
                } else {
                    all.deleteByID(del);
                    System.out.println();
                }
            }


            else if (s.equals("4")) {// combine + exit
                SLinkedList comb = SLinkedList.combineByID(all);
                comb.displayList();
                System.out.println();
                break;
            }
        }
    }
}
