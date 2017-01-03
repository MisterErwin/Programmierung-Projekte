package mySets;

/**
 * A class holding a set element and a 'pointer' to the next element holding class
 *
 * @author Luepges
 */
class MySetElement<T> {
    MySetElement<T> next;

    final T value;

    MySetElement(MySetElement<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    MySetElement(T value) {
        this(null, value);
    }
}
