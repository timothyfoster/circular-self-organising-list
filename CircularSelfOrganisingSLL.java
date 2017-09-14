public class CircularSelfOrganisingSLL<T> {
    protected SLLNode<T> tail;

    public CircularSelfOrganisingSLL(){
        tail = null;
    }

    public T deleteFromTail()
	{
		SLLNode<T> previous = tail;
		SLLNode<T> current = tail.next;

		T temp = tail.info;

		while( previous.next.next != tail)
			previous = previous.next;

		previous.next = current;
		tail = previous;

		return temp;
    }

    public void moveToFront(SLLNode<T> n)
	{
		// Make the node before it point to the node after it
		// Make it point to the head (which is tail.next)
		// Make tail point to it
	
		SLLNode<T> temp = tail;
		SLLNode<T> before = tail;
		
		while( temp.next != n)
		{
			temp = temp.next;
			before = temp;
		}
		
		before.next = n.next;
		n.next = tail.next;
		tail.next = n;
    }

    /*Checks if the list is empty.*/
     public boolean isEmpty() {
        return tail == null;
    }

     /*
      *This method adds a generic element T to the tail of the circular self-organising list.
      */
    public void addToTail(T el) {
        if (isEmpty()) {
            tail = new SLLNode<T>(el);
            tail.next = tail;
        }
        else {
            tail.next = new SLLNode<T>(el,tail.next);
            tail = tail.next;
        }
    }

    /*
     *Returns whether the element exists in the list or not.
     *In terms of the self-organizing functionality this method considered an access.
     */
    public boolean access(T el) {
        SLLNode<T> tmp;

        //starts access from head (tail.next)
        for (tmp = tail.next; !tmp.info.equals(el) && tmp != tail; tmp = tmp.next) {}

        if (tmp.info.equals(el)) {
            moveToFront(tmp);
            return true;
        } else {
            addToTail(el);
            return false;
        }
    }

    /*
     * This method prints out a round trip of the list from a particular element.
     */
    public void printRoundtrip( T el ) {
        if (!isEmpty()) {
            SLLNode<T> start = null;

            if ( tail.info.equals(el)) {
                start = tail;
            } else {
                SLLNode<T> tmp = null;
                for (tmp = tail.next; tmp != tail && !tmp.info.equals(el); tmp = tmp.next) { }
                if (tmp.info.equals(el)) {
                    start =  tmp;
                }
            }

            if ( start == null) {
                System.out.println("Element does not exist in list");
            }
            else {
                System.out.print("Roundtrip: " + start.info + " ");
                for (SLLNode<T> tmp = start.next; tmp != start; tmp = tmp.next) {
                    System.out.print(tmp.info + " ");
                }
                System.out.println("");
            }
        }
    }

    /*
     * This method prints out the list starting from the head.d.
     */
    @Override
    public String toString() {
        String t = "";
        if (isEmpty()) return t;
        SLLNode<T> tmp;
        for ( tmp = tail.next; tmp != tail; tmp = tmp.next)
           t+= (tmp.info + " ");
        t+= (tmp.info + " ");
        return t;
    }
}
