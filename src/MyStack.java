
import java.util.EmptyStackException;

/**
 * Generic version of the Stack class.
 *
 * @param <T> the type of the value
 */
class MyStack<T> {

    /**
     * Head node contains front node in the stack
     */
    Node<T> head;

    public MyStack() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void push(T x) {
        head = new Node<>(x, head);

    }

    public T top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        return (head.info);

    }

    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        T x = head.info;

        head = head.next;

        return (x);

    }

}