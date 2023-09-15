import exceptions.EmptyPCollectionException;
import exceptions.IndexOutOfBoundsException;
import interfaces.QueueI;

public class SlowQueue<E> implements QueueI<E> {
    /**
     * This class implements a queue by internally maintaining a PList.
     *
     * The enqueue operation is O(n)
     * The dequeue operation must be O(1)
     *
     */
    protected PList<E> list;
    public SlowQueue() {
        list = new EmptyPList<>();
    }

    // Constant time operations

    public boolean isEmpty () {
        return false; // TODO: fix this
    } // O(1)

    public int size () {
        return 0; // TODO: fix this
    } // O(1)

    public E dequeue() throws EmptyPCollectionException { // O(1)
      return null; // TODO: fix this
    }

    // Linear time operations
    public void enqueue (E element) {
        // TODO: fix this
    } // O(n)

}
