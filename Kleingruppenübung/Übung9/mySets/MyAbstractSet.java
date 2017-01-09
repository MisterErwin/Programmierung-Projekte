package mySets;

import java.util.Collection;
import java.util.Iterator;

/**
 * An abstract class with the basic functions of a Set.
 *
 * `null` elements are allowed
 *
 * @author Luepges
 */
abstract class MyAbstractSet<T> implements Iterable<T> {

    MySetElement<T> head; //package-private ist strikter als protected

    MyAbstractSet(MySetElement<T> head) {
        this.head = head;
    }

    /**
     * Returns the number of elements in this set (its cardinality).  If this
     * set contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this set (its cardinality)
     */
    public int size() {
        int size = 0;
        for (MySetElement<T> elem = head; elem != null; elem = elem.next) {
            if (size < Integer.MAX_VALUE) size++;
        }
        return size;
    }

    /**
     * Returns <tt>true</tt> if this set contains no elements.
     *
     * @return <tt>true</tt> if this set contains no elements
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Returns <tt>true</tt> if this set contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this set
     * contains an element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this set is to be tested
     * @return <tt>true</tt> if this set contains the specified element
     */
    public boolean contains(Object o) {
        for (T t : this) //Da Set Iterable ist
            if (t == null ? o == null : t.equals(o))
                return true;
        return false;
    }

    /**
     * Returns an iterator over the elements in this set.  The elements are
     * returned in no particular order (unless this set is an instance of some
     * class that provides a guarantee).
     *
     * @return an iterator over the elements in this set
     */
    @Override
    public Iterator<T> iterator() {
        return new MySetIterator<>(this.head);
    }

    /**
     * @throws UnsupportedOperationException not implemented
     * @return not implemented
     */
    public T[] toArray() {
        throw new UnsupportedOperationException("toArray");
    }

    /**
     * @throws UnsupportedOperationException not implemented
     * @param a not implemented
     * @return not implemented
     */
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("toArray");
    }

    // Bulk Operations

    /**
     * Returns <tt>true</tt> if this set contains all of the elements of the
     * specified collection.  If the specified collection is also a set, this
     * method returns <tt>true</tt> if it is a <i>subset</i> of this set.
     *
     * @param c collection to be checked for containment in this set
     * @return <tt>true</tt> if this set contains all of the elements of the
     * specified collection
     * @see #contains(Object)
     */
    public boolean containsAll(Collection c) {
        for (Object o : c)
            if (!this.contains(o))
                return false;
        return true;
    }

}
