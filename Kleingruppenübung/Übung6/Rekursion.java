public class Rekursion {
    /** 
     * Iteratives Summieren eines Arrays 
     *  @param an integer array to be summed up
     *  @return sum of integers in array
    */
    public static int arraySum(int[] a){
        int res = 0;
        for(int i = 0; i < a.length; i++){
            res += a[i];
        }
        return res;
    }
    
    /**
     * Recursive sumamation of an integer array
     * @param an integer array to be summed up
     * @return sum of integers in array
     */
    public static int arraySumRecursive(int[] a){
        return arraySumHelp(a,0);
    }
    
    /**
     * Helper method for recursive summation
     * @param an integer array
     * @param current state
     * @return current sum of integers from i to end of sequence
     */
    private static int arraySumHelp(int[] a, int i){
        if(i < a.length){
            return a[i] + arraySumHelp(a,i+1);
        } else {
            return 0;
        }
    }
    
    public static int alternativeArraySum(int[] a){
        if(a.length <= 0){
            return 0;
        } else if(a.length == 1){
            return a[0];
        } else {
            return a[0] + alternativeArraySum(java.util.Arrays.copyOfRange(a,1,a.length-1));
        }
    }
}