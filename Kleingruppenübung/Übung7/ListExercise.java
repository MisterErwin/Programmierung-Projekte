public class ListExercise {

    public static List mergesort(List list) {
        // IMPLEMENT ME
        if (list.length() < 2) return list;

        List[] lalalala = divide(list);

        return merge(mergesort(lalalala[0]), mergesort(lalalala[1]));
    }

    private static List merge(List first, List second) {
        // IMPLEMENT ME
        if (first.isEmpty())return second;
        if (second.isEmpty())return first;
        
        if (first.getValue() < second.getValue() )
            return new List(merge(first.getNext(), second), first.getValue());
        else  
            return new List(merge(first, second.getNext()), second.getValue());
    }

    /**
     * Divides a list of at least two elements into two lists of the same 
     * length (up to rounding).
     */
    private static List[] divide(List list) {
        List[] res = new List[2];
        int length = list.length() / 2;
        res[0] = list.getSublist(length);
        for (int i = 0; i < length; i++) {
            list = list.getNext();
        }
        res[1] = list;
        return res;
    }
    
    /**
     * Creates a list from the given inputs and outputs the sorted list and 
     * the original list thereafter.
     */
    public static void main(String[] args) {
        System.out.println(merge(buildList(0, new String[]{"1", "3", "5"}),
            buildList(0, new String[]{"2", "3", "4"})));

        System.out.println(mergesort(buildList( "1,15,41,63,14,23")));

        if (args != null && args.length > 0) {
            List list = buildList(0,args);
            System.out.println(mergesort(list));
            System.out.println(list);
        }
    }

    /**
     * Builds a list from the given input array.
     */
    private static List buildList(int i, String[] args) {
        if (i < args.length) {
            return new List(buildList(i + 1,args), Integer.parseInt(args[i]));
        } else {
            return List.EMPTY;
        }
    }
    
    private static List buildList(int i, int[] args) {
        if (i < args.length) {
            return new List(buildList(i + 1,args), args[i]);
        } else {
            return List.EMPTY;
        }
    }
    private static List buildList(String args){
        String[] a = args.split(",");
        return buildList(0,a);
    }
}
