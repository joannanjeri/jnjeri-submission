public class NEmptyPList<E> extends PList<E> {
    static class TODO extends RuntimeException {} // TODO: remove this line when you're done
    private final E first;
    private final PList<E> rest;

    public NEmptyPList(E first, PList<E> rest) {
        this.first = first;
        this.rest = rest;
    }

    public int size() {
        return 1 + rest.size();
        //throw new TODO();
    }

    public boolean isEmpty() {
        return false;
        //throw new TODO();
    }
    public boolean contains (E element) {
        if (first.equals(element)) {
            return true;
        } else {
            return rest.contains(element);
        }
    }
    public int indexOf (E element) throws NotFoundException {
        if (first.equals(element)) {
            return 0;
        } else {
           int indexInRest = rest.indexOf(element);
           if (indexInRest == -1) {
               throw new NotFoundException();
           }
           return 1 + indexInRest;
           }
        }


    public int lastIndexOf (E element) throws NotFoundException {
        int indexInRest = rest.lastIndexOf(element);
        if (indexInRest != -1) {
            return 1 + indexInRest;
        } else if (first.equals(element)) {
            return 0;
        } else {
            throw new NotFoundException();
        }


    }
    public E get (int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            return first;
        } else {
            return rest.get(index - 1);
        }
        //throw new TODO();
    }

    public PList<E> remove (int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            return rest;
        } else if (index > 0) {
            PList<E> newRest = rest.remove(index - 1);
            return new NEmptyPList<>(first, newRest);
        } else {
            throw new IndexOutOfBoundsException();
        }
        // throw new TODO();
    }

    public PList<E> subList (int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        } else if (fromIndex == 0) {
            return new NEmptyPList<>(first, rest.subList(0, toIndex - 1));
        } else {
            return rest.subList(fromIndex - 1, toIndex - 1);
        }
        // throw new TODO();
    }

    public boolean equals (Object other) {
        if (other instanceof NEmptyPList<?> otherList) {
            return first.equals(otherList.first) && rest.equals(otherList.rest);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return first.hashCode() + rest.hashCode();
    }
}
