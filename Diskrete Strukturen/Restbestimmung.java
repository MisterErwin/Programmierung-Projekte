public class Restbestimmung {
  public static void main(String[] args){
    double b = 2271541;
    double a = 1649201;
    double gcd = 31117;
    for(int i = 0; i <= 78; i++){

      double out = (gcd-(a*i)) / b ;
      System.out.println(out);
    }
  }
}
