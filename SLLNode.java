/**
 *
 * @author Adam Drozdek, Data Structures and Algorithms in Java, 3rd Edition.
 */

public class SLLNode<T> {
    public T info;
    public SLLNode<T> next;

    public SLLNode() {
        this(null,null);
    }

    public SLLNode(T el) {
        this(el,null);
    }

    public SLLNode(T el, SLLNode<T> ptr) {
        info = el;
        next = ptr;
    }
}
