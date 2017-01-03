package mySets;

import java.util.Collection;
import java.util.Set;

/**
 * A mutable set which allows null elements
 *
 * @author Luepges
 */
public class MyMutableSet<T> extends MyAbstractSet<T> implements Set<T> {

    public MyMutableSet() {
        super(null);
    }

    /**
     * Adds the specified element to this set if it is not already present.
     * More formally, adds the specified element
     * <tt>e</tt> to this set if the set contains no element <tt>e2</tt>
     * such that
     * <tt>(e==null&nbsp;?&nbsp;e2==null&nbsp;:&nbsp;e.equals(e2))</tt>.
     * If this set already contains the element, the call leaves the set
     * unchanged and returns <tt>false</tt>.  In combination with the
     * restriction on constructors, this ensures that sets never contain
     * duplicate elements.
     * <p>
     * Allows null elements
     *
     * @param o element to be added to this set
     * @return <tt>true</tt> if this set did not already contain the specified
     * element
     */
    @Override
    public boolean add(T o) {
        if (this.head == null)
            //Kopf setzen
            this.head = new MySetElement<>(o);
        else {
            if (this.head.value == null ? o == null : this.head.value.equals(o))
                return false; //Bereits vorhanden als Kopf

            //Zum Ende gehen und anhaengen
            MySetElement<T> e = this.head;
            while (e.next != null) {
                if (e.next.value == null ? o == null : e.next.value.equals(o))
                    return false; //Bereits vorhanden
                e = e.next;
            }
            e.next = new MySetElement<>(o);
        }
        return true;
    }


    /**
     * Removes the specified element from this set if it is present.
     * More formally, removes an element <tt>e</tt>
     * such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>, if
     * this set contains such an element.  Returns <tt>true</tt> if this set
     * contained the element (or equivalently, if this set changed as a
     * result of the call).  (This set will not contain the element once the
     * call returns.)
     *
     * @param o object to be removed from this set, if present
     * @return <tt>true</tt> if this set contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        MySetElement<T> e = this.head;
        if (e == null) return false; //Liste ist leer = nichts vorhanden
        if (e.value == null ? o == null : e.value.equals(o)) {
            //Den Kopf Loeschen
            this.head = this.head.next;
            return true;
        }
        while (e.next != null) {
            //Suche nach o und loesche die Verknuepfung des Vergaengers
            if (e.next.value == null ? o == null : e.next.value.equals(o)) {
                e.next = e.next.next;
                return true;
            }
            e = e.next;
        }
        //Nichts gefunden/geloescht
        return false;
    }

    // Bulk Operations


    /**
     * Adds all of the elements in the specified collection to this set if
     * they're not already present.  If the specified
     * collection is also a set, the <tt>addAll</tt> operation effectively
     * modifies this set so that its value is the <i>union</i> of the two
     * sets.  The behavior of this operation is undefined if the specified
     * collection is modified while the operation is in progress.
     *
     * @param c collection containing elements to be added to this set
     * @return <tt>true</tt> if this set changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     * @see #add(Object)
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T t : c)
            if (this.add(t))
                modified = true;
        return modified;
    }

    /**
     * @throws UnsupportedOperationException not implemented/required
     */
    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("retainAll");
    }

    /**
     * Removes from this set all of its elements that are contained in the
     * specified collection.  If the specified
     * collection is also a set, this operation effectively modifies this
     * set so that its value is the <i>asymmetric set difference</i> of
     * the two sets.
     *
     * @param c collection containing elements to be removed from this set
     * @return <tt>true</tt> if this set changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean removeAll(Collection c) {
        boolean modified = false;
        for (Object o : c)
            if (this.remove(o))
                modified = true;
        return modified;
    }

    /**
     * Removes all of the elements from this set.
     * The set will be empty after this call returns.
     */
    @Override
    public void clear() {
        this.head = null;
    }

    /**
     * Returns an unmodifiable copy of this set and clears this set
     *
     * @return an unmodifiable copy of this set
     */
    public MyMinmalSet<T> freezeAndClear() {
        MySetElement<T> oldHead = this.head;
        this.head = null;
        return new MyImmutableSet<>(oldHead);
    }
}
