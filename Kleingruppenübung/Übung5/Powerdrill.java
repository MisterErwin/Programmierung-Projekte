/**
 * Klasse zur Repraesentation einer Bohrmaschine.
 *
 * Bohrmaschinen werden durch ihre Akku-Ladung und ihren Bohrer-Durchmesser und -Typ
 * charakterisiert. Die Klasse stellt Methoden zum Aufladen des Akkus und zum Bohren
 * in verschiedene Materialien zur Verfuegung. Beim Bohren wird auch die Geraeuschentwicklung
 * berechnet.
 */
public class Powerdrill {

  /**
   * Maximale Ladung der Akkus aller Bohrer.
   */
  public static final double max_power = 5.0;

  /**
   * Ladung des Akkus
   */
  private double power;
  /**
   * Durchmesser des Bohrers
   */
  private int bitSize;
  /**
   * Typ des Bohrers
   */
  private BitType bit;

  /**
   * Lese fuer den Bohrer-Typ.
   * @return der eingesetzte Bohrer-Typ
   */
  public BitType getBitType() {
    return this.bit;
  }
  /** 
   * Schreibe den Bohrer-Typ.
   * @param bit zu setzender Typ
   */
  public void setBitType(BitType bit) {
    this.bit = bit;
  }
  /**
   * Lese Bohrer-Durchmesser
   * @return der eingesetzte Bohrer-Durchmesser
   */
  public int getBitSize() {
    return this.bitSize;
  }
  /**
   * Schreibe den Bohrer-Durchmesser
   * @param size neuer Bohrer-Durchmesser
   */
  public void setBitSize(int size) {
    this.bitSize = size;
  }

  /**
   * Erzeugt einen neuen Bohrer mit vollem Akku
   * @param bit eingesetzter Bohrer-Typ
   * @param bitSize eingesetzter Bohrer-Durchmesser
   */
  public Powerdrill(BitType bit, int bitSize) {
    this.bit = bit;
    this.bitSize=bitSize;
    this.power = Powerdrill.max_power;
  }
  /**
   * Erzeugt einen neuen Bohrer mit angegebener Ladung.
   *
   * Uebersteigt die angegebene Ladung die maximale Ladung,
   * wird ein Bohrer mit vollem Akku erzeugt.
   *
   * @param power Ladung
   * @see Powerdrill(BitType, int)
   */
  public Powerdrill(BitType bit, int bitSize, double power) {
    this.bit = bit;
    this.bitSize = bitSize;
    if(power < Powerdrill.max_power) {
      this.power = power;
    } else {
      this.power = Powerdrill.max_power;
    }
  }
  /**
   * Laedt den Akku um den angegebenen Anteil auf, maximal jedoch voll.
   * @param ammount Anteil einer vollen Ladung, der aufgeladen werden soll.
   */
  public void charge(double amount) {
    this.power += Powerdrill.max_power * amount;
    if (this.power > Powerdrill.max_power) {
      this.power = Powerdrill.max_power;
    }
  }

  /**
   * Fuehrt eine Bohrung durch.
   *
   * Eine Bohrung ist erfolgreich, wenn der eingesetzte Bohrer mit
   * material kompatibel ist und vor dem Aufruf der Methode
   * noch genug Akku-Ladung vorhanden war.
   *
   * @param material Das gebohrte Material
   * @param noise Das Geraeuschniveau in der Umgebung (wird aktualisiert)
   *
   * @return Ob erfolgreich gebohrt wurde
   */
  public boolean drill(Material material, NoiseLevel noise) {
    boolean correctBit = false;
    for(Material mat : BitType.canHandle(this.bit)) {
      if(mat == material) {
        correctBit = true;
      }
    }
    
    boolean hasPower = this.usePower(material, correctBit);
    if(hasPower) {
      this.makeNoise(material, noise, correctBit);
    }

    return correctBit && hasPower;
  }
  
  /**
   * Reduziert die Akku-Ladung entsprechend der beim Bohren verbrauchten Energie.
   * @param material Material, in das gebohrt wird.
   * @param correctBit gibt an, ob der aktuelle Bohrer mit material kompatibel ist
   * @return ob noch genug Energie im Akku war.
   */
  private boolean usePower(Material material, boolean correctBit) {
    if(correctBit && this.power > 0.5) {
      switch(material) {
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
    } else if( this.power > 0.5) {
      this.power -= 0.5;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Aktualisiert das Geraeuschniveau in der Umgebung beim Bohren.
   *
   * Holz- und Kunststoff-Bohren erhoeht das aktuelle Geraeuschniveau um 5
   * Metall-Bohren mit einem kompatiblen Bohrer erhoeht das Geraeuschniveau um
   * 3 + Bohrer-Durchmesser, aber hoechstens um 10,
   * bei falschem Bohrer immer um 10.
   * Alles andere Bohren erhoeht bei kompatiblem Bohrer das aktuelle Geraeuschniveau um
   * 11, sonst um 8.
   *
   * @param material Das zu bohrende Material
   * @param noise Das aktuelle Geraeuschniveau der Umgebung (wird aktualisiert)
   * @param correctBit gibt an ob, der aktuelle Bohrer mit material kompatibel ist
   * 
   */
  private void makeNoise(Material material, NoiseLevel noise, boolean correctBit){
      switch(material){
          case Wood : case Plastic : 
            noise.add(5); 
            break;
          case Metal : 
            if(correctBit){
              int additionalNoise = this.getBitSize() + 3;
              if(additionalNoise > 10){
                  additionalNoise = 10;
              }
              noise.add(additionalNoise);
            } else {
                noise.add(10);
            } 
            break;
          case Concrete : case Stone : case ReinforcedConcrete : 
            if(correctBit){
                noise.add(11);
            } else {
                noise.add(8);
            }
      }
  }
}
