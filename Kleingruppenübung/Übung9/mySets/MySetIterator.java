package mySets;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator for {@link MyAbstractSet}
 *
 * @author Luepges
 */
class MySetIterator<T> implements Iterator<T> {
    private MySetElement<T> current;


    MySetIterator(MySetElement<T> current) {
        this.current = current;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        T value = current.value;
        this.current = current.next;
        return value;
    }

    //remove wirft in der default Methode von Iterator eine UnsupportedOperationException
}
