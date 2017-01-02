package mySets;

import java.util.Collection;

/**
 * A minimal Set
 *
 * @author Luepges
 */
public interface MyMinmalSet<T> extends Iterable<T> {
    /**
     * Ueberprueft ob ein ELement Teil der Menge ist
     *
     * @param element Das Element
     * @return true falls element in der Menge vorhanden ist. Ansonsten false
     */
    boolean contains(T element);

    /**
     * Fuegt alle Elemente dieser Menge zu der Collection hinzu
     *
     * @param col die Collection
     * @throws UnmodifiableCollectionException Falls col nicht modifizierbar ist
     */
    void addAllTo(Collection<T> col) throws UnmodifiableCollectionException;
}
