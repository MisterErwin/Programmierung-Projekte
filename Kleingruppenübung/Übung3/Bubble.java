
/**
 * Write a description of class Bubblesort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bubble
{
    /**
     * Bubblesort - stable sorting algorithm with time consumtion in O(n^2) and in-place operation due to array limitations
     * @param integer array, unclear if sorted or not
     * @return integer array, sorted in ascending order
     */
    public static int[] bubble(int[] a){
        // Outer loop, iterates from right to left. After each loop, it is guaranteed to have shifted the biggest element to the end of the array
        for(int i = a.length; i > 0; i--){
            // Inner loop, iterates from left to right over the remaining elements to be sorted
            for(int j = 0; j < i - 1; j++){
                // main sorting structure. if a[j] is greater than a[j+1], switch them up.
                if(a[j] > a[j+1]){
                    // save a[j]
                    int a1 = a[j];
                    //override a[j]
                    a[j] = a[j+1];
                    // replace a[j+1] with saved a[j]
                    a[j+1] = a1;
                }
            }
        }
        // return sorted array
        return a;
    }
}
