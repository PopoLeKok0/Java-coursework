import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        this.top = 0;
        if (capacity > DEFAULT_INC) {
            elems = (E[]) new Object[capacity];
            return;
        } 
        elems = (E[]) new Object[DEFAULT_INC];
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        if(top == 0){
            throw new EmptyStackException();
        }
        return elems[top-1];
    }


    @SuppressWarnings( "unchecked" )
     private void arr(int nouveau) {
        E[] elems2=(E[]) new Object[nouveau];
        int arrete=elems.length;
        if (nouveau<elems.length) {
            arrete=nouveau;
        }
        for (int x=0; x<arrete; x++) {
            elems2[x]=elems[x];
        }
        elems=elems2;
    }
    @SuppressWarnings( "unchecked" )
    // Removes and returns the top element of this stack
    public E pop() {
        if(top == 0){throw new EmptyStackException();}
        E retournee = elems[--top];
        elems[top] = null;
        if (elems.length != DEFAULT_INC && elems.length-top >= DEFAULT_INC) {arr(elems.length-DEFAULT_INC);}
        return retournee; 
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        elems[top++] = element;
        if (top == elems.length){
            arr(elems.length+DEFAULT_INC);
        }
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        elems = (E[]) new Object[DEFAULT_INC];
        top = 0;
    }

}