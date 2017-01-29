public class B extends A {
  public static double y = 3;
    public double x = 0;
    public B( double x) {
    y ++;
    }
    public void f( int y) {
    this .x = y * 2;
    B.y = 0;
    }
    public void f( double y) {
    this .x = 2 * y + B.y;
    }
}
