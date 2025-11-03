// Title: Node
// Author: Atilla/Abbas
// ID: 10000082
// Section: 1
// Assignment: 1
// Description:
// normal linked list node
// can hold either a Person or another SLinkedList
public class Node {
    Object data; // holds the actual data
    Node next;   // pointer to the next node

    // Summary: Constructs a node with the given data; next is null.
    // Precondition: data can be null or an Object (Person or SLinkedList expected).
    // Postcondition: A Node is created with next = null.
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}
