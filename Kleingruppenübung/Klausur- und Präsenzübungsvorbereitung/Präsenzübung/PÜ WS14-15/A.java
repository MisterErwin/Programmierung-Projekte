public class A {
  public int x = 2;
    public A() {
    this .x ++;
    }
    public A( int x) {
    this .x += x;
    }
    public void f( double x) {
    this .x = ( int ) (x + B.y);
  }
}
