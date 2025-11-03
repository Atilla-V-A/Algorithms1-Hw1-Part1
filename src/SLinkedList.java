// Title: Linked List
// Author: Atilla/Abbas
// ID: 10000082
// Section: 1
// Assignment: 1
// Description:
// one single linked list class
// we insert according to type (passanger, cabin crew, or list)
public class SLinkedList {
    Node head;


    // Summary: Public insertion entry point. Chooses insertion rule by type.
    // Precondition: data is Person or SLinkedList per the assignment usage.
    // Postcondition:
    //   - If data is SLinkedList: appended to the tail.
    //   - If Passanger: inserted by ascending priority.
    //   - If Cabin_Crew: inserted by ascending credit.
    //   - If Person: inserted by ascending ID (used during combine step).
    public void insert(Object data) {

        if (data instanceof Passanger) {
            insertPassanger((Passanger) data);
        } else if (data instanceof Cabin_Crew) {
            insertCabinCrew((Cabin_Crew) data);
        } else if (data instanceof SLinkedList) {
            insertList((SLinkedList) data);
        } else if (data instanceof Person) {
            insertByID((Person) data);
        }
    }

    // Summary: Inserts a Passanger by ascending priority.
    // Precondition: p != null.
    // Postcondition: The list remains sorted ascending by priority among Passangers.
    //   (Assumes this SLinkedList is a passanger list.)
    private void insertPassanger(Passanger p) {
        Node n = new Node(p);

        //checking the priority
        if (head == null || ((Passanger) head.data).getPriority() > p.getPriority()) {
            n.next = head;
            head = n;
            return;
        }
        Node current = head;
        while (current.next != null && ((Passanger) current.next.data).getPriority() <= p.getPriority())
            current = current.next;
        n.next = current.next;
        current.next = n;
    }

    // Summary: Inserts a Cabin_Crew by ascending credit.
    // Precondition: c != null.
    // Postcondition: The list remains sorted ascending by credit among Cabin_Crew.
    //   (Assumes this SLinkedList is a cabin crew list.)
    private void insertCabinCrew(Cabin_Crew c) {
        Node n = new Node(c);
       //checking credits
        if (head == null || ((Cabin_Crew) head.data).getCredit() > c.getCredit()) {
            n.next = head;
            head = n;
            return;
        }


        Node current = head;
        while (current.next != null && ((Cabin_Crew) current.next.data).getCredit() <= c.getCredit())
            current = current.next;
        n.next = current.next;
        current.next = n;
    }

    // Summary: Appends a sublist to the tail (for list_of_lists construction).
    // Precondition: l != null.
    // Postcondition: The SLinkedList 'l' is stored as a node at the end of this list.
    private void insertList(SLinkedList l) {
        Node n = new Node(l);
        if (head == null) {
            head = n;
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = n;
    }

    // Summary: Inserts a Person by ascending ID (used only for the combined list).
    // Precondition: p != null.
    // Postcondition: The list of Person nodes remains sorted ascending by ID.
    private void insertByID(Person p) {
        Node n = new Node(p);
        if (head == null || ((Person) head.data).getID() > p.getID()) {
            n.next = head;
            head = n;
            return;
        }
        Node current = head;
        while (current.next != null && ((Person) current.next.data).getID() <= p.getID())
            current = current.next;
        n.next = current.next;
        current.next = n;
    }

    // Summary: Deletes every Person whose ID equals 'id' in this list,
    //          then recursively applies the same operation to any sublists.
    // Precondition: none.
    // Postcondition: All nodes matching ID in this list and nested lists are removed.
    //                Silent if the list is empty (Main handles user message).
    public void deleteByID(long id) {
        // if list empty, just skip silently
        if (head == null) {
            return;
        }
        // delete inside this list
        head = deleteHere(head, id);

        // now go through nodes and check if any of them is another list
        Node cur = head;
        while (cur != null) {
            if (cur.data instanceof SLinkedList) {
                ((SLinkedList) cur.data).deleteByID(id);
            }
            cur = cur.next;
        }
    }
    // Summary: Helper that removes all matching Person-ID nodes from a single list.
    // Precondition: h can be null (empty list).
    // Postcondition: Returns the new head of the filtered list (without ID matches).
    private Node deleteHere(Node h, long id) {
        Node temp = new Node(null);
        temp.next = h;
        Node prev = temp;
        Node current = h;
        while (current != null) {
            if (current.data instanceof Person && ((Person) current.data).getID() == id)
                prev.next = current.next;
            else
                prev = current;
            current = current.next;
        }
        return temp.next;
    }

    // Summary: Prints every Person stored in this list; if a node is an SLinkedList,
    //          prints its contents too (recursive).
    // Precondition: none.
    // Postcondition: All stored people are printed in their current order.
    //                Silent if the list is empty (Main may print a message).
    public void displayList() {
        Node current = head;
        while (current != null) {
            if (current.data instanceof SLinkedList)
                ((SLinkedList) current.data).displayList();
            else
                System.out.println(current.data.toString());
            current = current.next;
        }
    }

    // Summary: Builds and returns a NEW SLinkedList that contains all Person
    //          items from the four sublists, ordered strictly by ascending ID.
    // Precondition: list_of_lists is a list whose nodes are exactly the four people lists.
    // Postcondition: Returns a new SLinkedList containing only Person nodes sorted by ID.
    public static SLinkedList combineByID(SLinkedList list_of_lists) {
        SLinkedList comb = new SLinkedList();
        Node current = list_of_lists.head;
        while (current != null) {
            if (current.data instanceof SLinkedList) {
                SLinkedList sub = (SLinkedList) current.data;
                Node inside = sub.head;
                while (inside != null) {
                    if (inside.data instanceof Person)
                        comb.insertByID((Person) inside.data);
                    inside = inside.next;
                }
            }
            current = current.next;
        }
        return comb;
    }
}
