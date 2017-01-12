public class M {
  public void main ( String [] args ) {
    A a = new A(( int ) B.y);
    System . out . println (a.x); // OUT : [ ]
    B b = new B (2);
    System . out . println (b.x + " " + B.y); // OUT : [ ] [ ]
    A z = b;
    System . out . println (z.x); // OUT : [ ]
    z.f ( -5.0);
    System . out . println (b.x + " " + z.x); // OUT : [ ] [ ]
    z.f( -6);
    System . out . println (b.x + " " + B.y); // OUT : [ ] [ ]
  }
}
