package mySets;

import java.util.Collection;

/**
 * An immutable set.
 *
 * @author Luepges
 */
class MyImmutableSet<T> extends MyAbstractSet<T> implements MyMinmalSet<T> {
    MyImmutableSet(MySetElement<T> head) {
        super(head);
    }

    /**
     * Fuegt alle Elemente dieser Menge zu der Collection hinzu
     *
     * @param col die Collection
     * @throws UnmodifiableCollectionException Falls col nicht modifizierbar ist
     */
    @Override
    public void addAllTo(Collection<T> col) throws UnmodifiableCollectionException {
        try {
            //Collection#addAll koennte toArray benoetigen (z.B. ArrayList)
            for (T t : this)
                col.add(t);
        } catch (UnsupportedOperationException e) {
            throw new UnmodifiableCollectionException();
        }
    }
}
