public class HSeiteneffekte
{
    public static void main(String args[]){
        Wrapper w1 = new Wrapper();
        Wrapper w2 = new Wrapper();
        
        w1.i = 1;
        w2.i = 2;
        
        int x = 3;
        
        int[] a = { 4, 5 };
        
        f(w2,w1,a);
        f(w1,w2,a[0],x);
        w1 = new Wrapper();
        w1.i = 6;
        f(w1,w2, new int[] {a[0], a[1]});
    }
    public static void f(Wrapper x, Wrapper y, int... a){
        a[0] = y.i;
        y = x;
        y.i = a[1];
        // Speicherzustand hier zeichen
        int k = 0;
    }
}
