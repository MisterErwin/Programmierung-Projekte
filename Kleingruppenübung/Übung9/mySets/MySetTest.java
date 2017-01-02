package mySets;

import java.util.*;

/**
 * Test cases for the Set implementations
 * (You must enbale assertions)
 *
 * @author Luepges
 */
public class MySetTest {
    public static void main(String[] args) throws Exception {

        boolean b = false;
        assert (b = true);
        if (!b) throw new Error("You must enable assertions!");

        MyMutableSet<String> set = new MyMutableSet<>();
        //Liste leer?
        assert set.size() == 0;

        //"Erster" hinzufuegen
        assert set.add("Erster");
        assert !set.add("Erster");
        assert set.size() == 1;
        assert set.contains("Erster");
        assert !set.contains("NichtVorhanden");

        //"2" hinzufuegen
        assert set.add("2");
        assert !set.add("2");
        assert set.size() == 2;
        assert set.contains("Erster");
        assert set.contains("2");
        assert !set.contains("NichtVorhanden");

        //"3" hinzufuegen
        assert set.add("3");
        assert !set.add("3");
        assert set.size() == 3;
        assert set.contains("Erster");
        assert set.contains("2");
        assert set.contains("3");
        assert !set.contains("NichtVorhanden");

        //null hinzufuegen
        assert set.add(null);
        assert !set.add(null);
        assert set.size() == 4;
        assert set.contains("Erster");
        assert set.contains("2");
        assert set.contains("3");
        assert set.contains(null);
        assert !set.contains("NichtVorhanden");

        //Entwas nicht vorhandenes loeschen
        assert !set.remove("NichtVorhanden");

        //"Erster" loeschen
        assert set.remove("Erster");
        assert set.size() == 3;
        assert !set.contains("Erster");
        assert set.contains("2");
        assert set.contains("3");
        assert set.contains(null);

        //"3" loeschen
        assert set.remove("3");
        assert set.size() == 2;
        assert !set.contains("Erster");
        assert set.contains("2");
        assert !set.contains("3");
        assert set.contains(null);

        //null loeschen
        assert set.remove(null);
        assert set.size() == 1;
        assert !set.contains("Erster");
        assert set.contains("2");
        assert !set.contains("3");
        assert !set.contains(null);

        //AddAll
        set.addAll(Arrays.asList("addall".split("|")));
        assert set.size() == 4;

        //Containsall
        assert set.containsAll(Arrays.asList("addall".split("|")));

        //FreezeAndClear
        MyMinmalSet<String> minmalSet = set.freezeAndClear();

        //Set gecleared
        assert set.isEmpty();
        assert set.size() == 0;

        //Addall von MinimalSet
        List<String> arrayList = new ArrayList<>();
        minmalSet.addAllTo(arrayList);
        assert arrayList.size() == 4;

        //AddAall von Set
        set.addAll(arrayList);
        arrayList.clear();
        assert set.size() == 4;
        assert arrayList.size() == 0;

        //UnmodifiableCollectionException test
        arrayList = Collections.unmodifiableList(arrayList);
        assert arrayList.size() == 0;
        try {
            minmalSet.addAllTo(arrayList);
            throw new AssertionError("Expected UnmodifiableCollectionException");
        } catch (UnmodifiableCollectionException ignored) {
        }

        System.out.println("Tests passed");
    }


}
