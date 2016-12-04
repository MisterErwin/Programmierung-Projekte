import java.util.Arrays;
/**
 * Klasse, welche die Schnittmenge der Einträge von zwei Arrays berechnet.
 */
public class ArrayIntersect {

  public static int recursiveCallsNonSorted = 0;
  public static int recursiveCallsSorted = 0;

  public static int[] arrayIntersection(int[] a, int[] b) {
    recursiveCallsNonSorted++;
    return _arrayIntersection(a,b, new int[0], 0);
  }
  private static int[] _arrayIntersection(int[] a , int[] b, int[] result, int state) {
    if(state >= a.length){
        return result;
    }
    if(findInArray(a[state], b)){
       result = Arrays.copyOf(result, result.length + 1);
       result[result.length - 1] = a[state];
    }
    recursiveCallsNonSorted++;
    return _arrayIntersection(a, b, result, state + 1);
  }
  private static boolean findInArray(int needle, int[] haystack){
    recursiveCallsNonSorted++;
    return _findInArray(needle, haystack, 0);
  }
  private static boolean _findInArray(int needle, int[] haystack, int state){
    if(state >= haystack.length)
        return false;
    else
        if(haystack[state] == needle)
            return true;
        else {
            recursiveCallsNonSorted++;
            return _findInArray(needle, haystack, state+1);
        }
  }

  public static int[] sortedArrayIntersection(int[] a, int[] b) {
    recursiveCallsSorted++;
    return _sortedArrayIntersection(a, b, new int[0], 0, 0);
  }

  private static int[] _sortedArrayIntersection(int[] a, int[] b, int[] result, int lastBIndex, int state){
     if(state >= a.length){
         return result;
     }
     int foundAt = findInSortedArray(a[state], b, lastBIndex);
     if(foundAt >= 0){
         result = Arrays.copyOf(result, result.length + 1);
         result[result.length - 1] = a[state];
     }
     recursiveCallsSorted++;
     return _sortedArrayIntersection(a,b,result,foundAt >= 0 ? foundAt : lastBIndex, state + 1);
  }

  private static int findInSortedArray(int needle, int[] haystack, int lastIndex){
      recursiveCallsSorted++;
      return _findInSortedArray(needle, haystack, lastIndex);
  }
  private static int _findInSortedArray(int needle, int[] haystack, int state){
      if(haystack[state] > needle){
          return -1;
      } else {
          if(haystack[state] == needle){
              return state;
          } else {
              recursiveCallsSorted++;
              return _findInSortedArray(needle, haystack, state + 1);
          }
      }
  }

}
