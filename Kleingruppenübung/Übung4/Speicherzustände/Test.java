public class Test 
{
    public static boolean test(int[] a){
        int[] b = a;
        
        b[0] = -1;
        System.out.println(a.toString());
        System.out.println(b.toString());
        return a == b;
    }
}