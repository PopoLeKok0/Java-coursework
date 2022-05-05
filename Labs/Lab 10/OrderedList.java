import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
      head=new Node(null, null, null);
      head.next=head;
      head.previous=head;
    }

    // Calculates the size of the list

    public int size() {
        int count=0;
      	Node a=head;
        while (a.next!=head) {
            count++;
            a=a.next;
        }
        return count;
    }


    public Object get( int pos ) {
       Node a=head.next;
       if (pos<0){ 
            throw new IndexOutOfBoundsException(Integer.toString(pos)); 
        } 
        for (int i=0; i<pos; i++){ 
            if (a.next==head){ 
                throw new IndexOutOfBoundsException(Integer.toString(pos)); 
            } else{ 
                a=a.next; 
            }
        }
        return a.value; 
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
        if (o == null){ 
            throw new IllegalArgumentException("C'est Null"); 
        }
        if (head.next==head){ 
            head.next=new Node(o,head,head.next); 
        } else { 
            Node a=head; 
            while(a.next!=head && a.next.value.compareTo(o)<0){ 
                a=a.next; 
            }
            Node b=a.next; 
            a.next=new Node(o, a, b); 
            b.previous=a.next; 
        }
        return true; 
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
        if (pos<0){
            throw new IndexOutOfBoundsException( Integer.toString(pos));
        }
        Node a=head.next;
        for (int i=0; i<pos; i++) 
            if (a.next==head){
                throw new IndexOutOfBoundsException(Integer.toString(pos));
            } else{
                a=a.next;
            }      
            Node delete=a; 
            a=a.previous; 
            Node b=delete.next; 
            a.next=b;
            b.previous=a;
            delete.value=null;
            delete.next=null;
            delete.previous=null;
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
       Node a=head.next; 
       Node b=other.head.next; 
        while(b!=other.head){ 
            if (a==head){ 
                a.next=new Node(b.value, a, a.next); 
                a=a.next; 
                b=b.next; 
            } else if (b.value.compareTo(a.value)<0){ 
                a.previous=new Node(b.value, a.previous, a); 
                a.previous.previous.next=a.previous; 
                b=b.next; 
            } else if (a.next==head){
                a.next=new Node(b.value, a, head ); 
                a=a.next;
                b=b.next;
            } else{
                a=a.next;
            }
        }
    }
}