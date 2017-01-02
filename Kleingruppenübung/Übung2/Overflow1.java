
public class Overflow1
{
    public Overflow1()
    {

    }

    public static void ausdruck2(String args[]){
        // Wertet zu true aus, da 2147483648 jetzt vorzeichenbehaftet ist und diese Zahl im Negativen die kleinste mögliche int-Zahl ist
        // und daher erlaubt bei der Verrechnung ist. Allerdings sorgt der danach auftretende Overflow dafür, dass
        //System.out.println(-2147483648 + (-2147483648));
        // zu 0 auswertet (s. Overflow in Vorlesung)

        // Dieser Teil erzeugt ebenfalls einen Overflow, aber im Positiven und die größte positive int-Zahl ist nicht groß genug, um durch
        // Overflow bei der Addition wieder bei 0 anzukommen, eben weil es im Negativen eine int-Zahl gibt, deren Betrag um 1 größer ist
        // und durch die Komplementbildung die 0 auf der Bit-Ebene zwei mal vorkommen, mit - und mit +.
        // Damit wertet der zweite Teil zu -2 aus und damit ist die gesamte Aussage erfüllt.
        //System.out.println(2147483647 + 2147483647);
        //System.out.println(-2147483648 + (-2147483648) > 2147483647 + 2147483647);
    }

    public static void ausdruck1(String args[]){
        // Führt zu Compiler-Fehler, da 2147483648 nicht als Zahl mit Vorzeichen, sondern als positive Zahl interpretiert wird
        // und das Minus als Rechenoperator, somit überschreitet 2147483648 den int-Wertebereich und darf gar nicht erst verrechnet werden.
        //System.out.println(-2147483648 - 2147483648);
        //System.out.println(2147483647 + 2147483647);
        //System.out.println(-2147483648 - 2147483648) > (2147483647 + 2147483647);
    }
}
