/**
 * Klasse zur Repraesentation einer Bohrmaschine.
 * Bohrmaschinen werden durch ihre Akku-Ladung und ihren Bohrer-Durchmesser und -Typ
 * charakterisiert. Die Klasse stellt Methoden zum Aufladen des Akkus und zum Bohren
 * in verschiedene Materialien zur Verfuegung. Beim Bohren wird auch die Geraeuschentwicklung
 * berechnet.
 * <ul>
 * <li><font style="color:red">public, damit aus anderen packages auch hierdrauf zugegriffen werden darf </font></li>
 * <li><font style="color:red">Nicht final, damit Vererbung erlaubt ist (falls wir z.B. einen super-duper eigenen Powerdrill ({@code class MySuperDrill extends Powerdrill}) der schwarze Loecher macht erstellen wollen) </font></li>
 * </ul>
 *
 * @author Alexander Bartolomey 369407
 * @author Alexander Luepges 368999
 * @version 1
 */
public class Powerdrill {

    /**
     * Maximale Ladung der Akkus aller Bohrer.
     * <ul>
     * <li><font style="color:red">protected, da nur diese Klasse (und evtl. Subklassen) die Information braucht. Da kein Getter fuer {@link Powerdrill#power} existiert, ist mit der max. Power nichts anzufangen</font></li>
     * <li><font style="color:red">final, da es eine Konstante ist </font></li>
     * <li><font style="color:red">static, da die Konstante fuer alle Powerdrill Instanzen gilt </font></li>
     * <li><font style="color:red">Nach den oracle code conventions waere die korrekte Benennuing {@code private final static double MAX_POWER} </font></li>
     * </ul>
     */
    protected final static double max_power = 5.0;

    /**
     * Ladung des Akkus
     * <ul>
     * <li><font style="color:red">protected, da nur diese Klasse (und evtl. abgeleitete Subklassen) die Information brauchen. Andere Klassen aber nicht </font></li>
     * <li><font style="color:red">nicht final, da es z.B. in {@link Powerdrill#charge(double)} modifiziert wird </font></li>
     * <li><font style="color:red">nicht static, da individuell fuer jeden Drill und Getter/Setter nicht static sind </font></li>
     * </ul>
     */
    protected double power;
    /**
     * Durchmesser des Bohrers
     * <ul>
     * <li><font style="color:red">private, da nur diese Klasse die Information braucht und Getter/Setter existieren </font></li>
     * <li><font style="color:red">nicht final, da es z.B. in {@link Powerdrill#setBitType(BitType)} modifiziert wird </font></li>
     * <li><font style="color:red">nicht static, da individuell fuer jeden Drill und Getter/Setter nicht static sind </font></li>
     * </ul>
     */
    private int bitSize;
    /**
     * Typ des Bohrers
     * <ul>
     * <li><font style="color:red">private, da nur diese Klasse die Information braucht und Getter/Setter existieren </font></li>
     * <li><font style="color:red">nicht final, da es z.B. in {@link Powerdrill#setBitSize(int)} modifiziert wird </font></li>
     * <li><font style="color:red">nicht static, da individuell fuer jeden Drill </font></li>
     * </ul>
     */
    private BitType bit;

    /**
     * Lese fuer den Bohrer-Typ.
     * <ul>
     * <li><font style="color:red">public, damit der Getter von ueberall verwendet werden kann </font></li>
     * <li><font style="color:red">nicht final, damit Subklassen dies ueberschreiben duerfen </font></li>
     * <li><font style="color:red">nicht static, da {@link Powerdrill#bit} individuell fuer jeden Drill </font></li>
     * </ul>
     *
     * @return der eingesetzte Bohrer-Typ
     */
    public BitType getBitType() {
        return this.bit;
    }

    /**
     * Schreibe den Bohrer-Typ.
     * <ul>
     * <li><font style="color:red">public, damit der Setter von ueberall verwendet werden kann</font></li>
     * <li><font style="color:red">nicht final, damit Subklassen dies ueberschreiben duerfen </font></li>
     * <li><font style="color:red">nicht static, da {@link Powerdrill#bit} individuell fuer jeden Drill </font></li>
     * </ul>
     *
     * @param bit zu setzender Typ
     */
    public void setBitType(BitType bit) {
        this.bit = bit;
    }

    /**
     * Lese Bohrer-Durchmesser
     * <ul>
     * <li><font style="color:red">public, damit der Getter von ueberall verwendet werden kann</font></li>
     * <li><font style="color:red">nicht final, damit Subklassen dies ueberschreiben duerfen </font></li>
     * <li><font style="color:red">nicht static, da {@link Powerdrill#bitSize} individuell fuer jeden Drill </font></li>
     * </ul>
     *
     * @return der eingesetzte Bohrer-Durchmesser
     */
    public int getBitSize() {
        return this.bitSize;
    }

    /**
     * Schreibe den Bohrer-Durchmesser
     * <ul>
     * <li><font style="color:red">public, damit der Setter von ueberall verwendet werden kann</font></li>
     * <li><font style="color:red">nicht final, damit Subklassen dies ueberschreiben duerfen </font></li>
     * <li><font style="color:red">nicht static, da {@link Powerdrill#bitSize} individuell fuer jeden Drill </font></li>
     * </ul>
     *
     * @param size neuer Bohrer-Durchmesser
     */
    public void setBitSize(int size) {
        this.bitSize = size;
    }

    /**
     * Erzeugt einen neuen Bohrer mit vollem Akku
     * <ul>
     * <li><font style="color:red">public, damit der Konstruktor von ueberall aufgerufen werden kann</font></li>
     * <li><font style="color:red">nicht static, da Konstruktor </font></li>
     * </ul>
     *
     * @param bit     eingesetzter Bohrer-Typ
     * @param bitSize eingesetzter Bohrer-Durchmesser
     */
    public Powerdrill(BitType bit, int bitSize) {
        this.bit = bit;
        this.bitSize = bitSize;
        this.power = Powerdrill.max_power;
    }

    /**
     * Erzeugt einen neuen Bohrer mit angegebener Ladung.
     * Uebersteigt die angegebene Ladung die maximale Ladung,
     * wird ein Bohrer mit vollem Akku erzeugt.
     * <ul>
     * <li><font style="color:red">public, damit der Konstruktor von ueberall aufgerufen werden kann</font></li>
     * <li><font style="color:red">nicht static, da Konstruktor </font></li>
     * </ul>
     *
     * @param bit     eingesetzter Bohrer-Typ
     * @param bitSize eingesetzter Bohrer-Durchmesser
     * @param power   Ladung
     * @see Powerdrill#Powerdrill(BitType, int)
     */
    public Powerdrill(BitType bit, int bitSize, double power) {
        this.bit = bit;
        this.bitSize = bitSize;
        if (power < Powerdrill.max_power) {
            this.power = power;
        } else {
            this.power = Powerdrill.max_power;
        }
    }

    /**
     * Laedt den Akku um den angegebenen Anteil auf, maximal jedoch voll.
     * <ul>
     * <li><font style="color:red">public, damit die Methode von ueberall verwendet werden kann</font></li>
     * <li><font style="color:red">nicht final, damit Subklassen dies ueberschreiben duerfen </font></li>
     * <li><font style="color:red">nicht static, da {@link Powerdrill#power} individuell fuer jeden Drill </font></li>
     * </ul>
     *
     * @param amount Anteil einer vollen Ladung, der aufgeladen werden soll.
     */
    public void charge(double amount) {
        this.power += Powerdrill.max_power * amount;
        if (this.power > Powerdrill.max_power) {
            this.power = Powerdrill.max_power;
        }
    }

    /**
     * Fuehrt eine Bohrung durch.
     * Eine Bohrung ist erfolgreich, wenn der eingesetzte Bohrer mit
     * material kompatibel ist und vor dem Aufruf der Methode
     * noch genug Akku-Ladung vorhanden war.
     * <ul>
     * <li><font style="color:red">public, damit die Methode von ueberall verwendet werden kann (z.B. in {@link ConstructionWork})</font></li>
     * <li><font style="color:red">nicht final, damit Subklassen dies ueberschreiben duerfen </font></li>
     * <li><font style="color:red">nicht static, da {@link Powerdrill#usePower(Material, boolean)} individuell fuer jeden Drill </font></li>
     * </ul>
     *
     * @param material Das gebohrte Material
     * @param noise    Das Geraeuschniveau in der Umgebung (wird aktualisiert)
     * @return Ob erfolgreich gebohrt wurde
     */
    public boolean drill(Material material, NoiseLevel noise) {
        boolean correctBit = false;
        for (Material mat : BitType.canHandle(this.bit)) {
            if (mat == material) {
                correctBit = true;
            }
        }

        boolean hasPower = this.usePower(material, correctBit);
        if (hasPower) {
            this.makeNoise(material, noise, correctBit);
        }

        return correctBit && hasPower;
    }

    /**
     * Reduziert die Akku-Ladung entsprechend der beim Bohren verbrauchten Energie.
     * <ul>
     * <li><font style="color:red">protected, damit nur diese und Subklassen es nutzen duerfen</font></li>
     * <li><font style="color:red">nicht final, damit Subklassen dies ueberschreiben duerfen </font></li>
     * <li><font style="color:red">nicht static, da z.B. {@link Powerdrill#power} individuell fuer jeden Drill (und this benoetigt wird) </font></li>
     * </ul>
     *
     * @param material   Material, in das gebohrt wird.
     * @param correctBit gibt an, ob der aktuelle Bohrer mit material kompatibel ist
     * @return ob noch genug Energie im Akku war.
     */
    protected boolean usePower(Material material, boolean correctBit) {
        if (correctBit && this.power > 0.5) {
            switch (material) {
                case Wood:
                case Plastic:
                    this.power *= 0.75;
                    break;
                case Metal:
                    this.power *= 0.6;
                    break;
                case ReinforcedConcrete:
                    this.power *= 0.4;
                default:
                    this.power *= 0.5;
            }
            return true;
        } else if (this.power > 0.5) {
            this.power -= 0.5;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Aktualisiert das Geraeuschniveau in der Umgebung beim Bohren.
     * Holz- und Kunststoff-Bohren erhoeht das aktuelle Geraeuschniveau um 5
     * Metall-Bohren mit einem kompatiblen Bohrer erhoeht das Geraeuschniveau um
     * 3 + Bohrer-Durchmesser, aber hoechstens um 10,
     * bei falschem Bohrer immer um 10.
     * Alles andere Bohren erhoeht bei kompatiblem Bohrer das aktuelle Geraeuschniveau um
     * 11, sonst um 8.
     * <ul>
     * <li><font style="color:red">protected, da nur diese (und evtl. Subklassen) hierdrauf zugreifen duerfen/muessen</font></li>
     * <li><font style="color:red">nicht final, damit Subklassen dies ueberschreiben duerfen </font></li>
     * <li><font style="color:red">nicht static, da individuell fuer jeden Drill und {@link Powerdrill#drill(Material, NoiseLevel)} {@code this.makeNoise(material, noise, correctBit);} nutzt </font></li>
     * </ul>
     *
     * @param material   Das zu bohrende Material
     * @param noise      Das aktuelle Geraeuschniveau der Umgebung (wird aktualisiert)
     * @param correctBit gibt an ob, der aktuelle Bohrer mit material kompatibel ist
     */
    protected void makeNoise(Material material, NoiseLevel noise, boolean correctBit) {
        switch (material) {
            case Wood:
            case Plastic:
                noise.add(5);
                break;
            case Metal:
                if (correctBit)
                    noise.add(Math.min(10, 3 + bitSize));
                else
                    noise.add(10);
                break;
            default:
                noise.add(correctBit ? 11 : 8);
        }
    }
}
