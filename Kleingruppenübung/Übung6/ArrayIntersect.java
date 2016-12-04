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
    return _sortedArrayIntersection(a, b, new int[0], 0);
  }
  
  private static int[] _sortedArrayIntersection(int[] a, int[] b, int[] result, int state){
     if(state >= a.length){
         return result;
     }
     if(findInSortedArray(a[state], b) && a[state] != a[state + 1]){
         result = Arrays.copyOf(result, result.length + 1);
         result[result.length - 1] = a[state];
         recursiveCallsSorted++;
         return _sortedArrayIntersection(a,b,result, state + 1);
     } else {
         recursiveCallsSorted++;
         return _sortedArrayIntersection(a,b,result, state + 2);
     }
  }
  
  private static boolean findInSortedArray(int needle, int[] haystack){
      recursiveCallsSorted++;
      return _findInSortedArray(needle, haystack, 0);
  }
  private static boolean _findInSortedArray(int needle, int[] haystack, int state){
      if(haystack[state] > needle){
          return false;
      } else {
          if(haystack[state] == needle){
              return true;
          } else {
              recursiveCallsSorted++;
              return _findInSortedArray(needle, haystack, state + 1);
          }
      }
  }

}
