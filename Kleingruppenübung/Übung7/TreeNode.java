/**
 * Ein Konten in einem binaeren Baum.
 *
 * Der gespeicherte Wert ist unveraenderlich,
 * die Referenzen auf die Nachfolger koennen aber
 * geaendert werden.
 *
 * Die Klasse bietet Methoden, um Werte aus einem Baum
 * zu suchen, einzufuegen und zu loeschen. Diese gibt
 * es jeweils noch in optimierten Varianten, um
 * rotate-to-root Baeume zu verwalten.
 *
 * uh huh. Da hat jemand das loeschen vergessen?
 */
public class TreeNode {
  /**
   * Linker Nachfolger
   */
  private TreeNode left;
  /**
   * Rechter Nachfolger
   */
  private TreeNode right;
  /**
   * Wert, der in diesem Knoten gespeichert ist
   */
  private final int value;

  /**
   * Erzeugt einen neuen Knoten ohne Nachfolger
   */
  public TreeNode(int val) {
    this.value = val;
    this.left = null;
    this.right = null;
  }

  /**
   * Erzeugt einen neuen Knoten mit den gegebenen Nachfolgern
   */
  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.value = val;
    this.left = left;
    this.right = right;
  }

  public int getValue() {
    return this.value;
  }

  /**
   * Der gespeicherte Wert, umgewandelt in einen String
   */
  public String getValueString() {
    return Integer.toString(this.value);
  }

  public boolean hasLeft() {
    return this.left != null;
  }

  public boolean hasRight() {
    return this.right != null;
  }

  public TreeNode getLeft() {
    return this.left;
  }

  public TreeNode getRight() {
    return this.right;
  }

  /**
   * Sucht in diesem Teilbaum nach x, ohne den Baum zu veraendern.
   * @return true, falls x enthalten ist, sonst false
   */
  public boolean simpleSearch(int x) {
    if (this.value == x) return true; //Falls value x ist, wurde x gefunden
    if (x < this.value) { //Falls x links zu suchen ist
      return left == null ? false : left.simpleSearch(x); //true, wenn links ein Teilbaum ist und der linke Teilbaum x enthaelt
    } else //Falls x rechts zu suchen ist
      return right == null ? false : right.simpleSearch(x);//true, wenn rechts ein Teilbaum ist und der rechte Teilbaum x enthaelt
  }

  /**
   * Fuegt x in diesen Teilbaum ein.
   */
  public void insert(int x) {
    //Eigentlich unnoetige Rekursion, da fuer jeden Knoten aufgerufen
    //Es wuerde reichen zu schauen, ob this.value == x ist, da insert und simpleSearch (fast) gleich den Baum durchlaufen
    //Da aber die Aufgabe "In der Klasse <b>TreeNode</b> wird zunaechst nach der einzufuegenden Zahl gesucht" lautet,
    //wird dieser Weg hier benutzt
    if (this.simpleSearch(x))return;

    if (x < this.value){ //Ist x auf der linken Seite (< this.value) anzutreffen
      if (left==null) //Falls links nichts ist, x hinzufuegen
        left = new TreeNode(x);
      else left.insert(x); //x im linken Teilbaum einfuegen
    }else { //Ist x auf der rechten Seite (> this.value) anzutreffen
      if (right==null)//Falls rechts  nichts ist, x hinzufuegen
          right = new TreeNode(x);
      else right.insert(x); //x im rechten Teilbaum einfuegen
    }
  }

  /**
   * Sucht in diesem Teilbaum nach x und rotiert den Endpunkt der Suche in die
   * Wurzel.
   * @param x der gesuchte Wert
   * @return die neue Wurzel des Teilbaums oder null
   */
  public TreeNode rotationSearch(int x) {
    if (this.value == x) return this; //Dieser Knoten ist der gesuchte Knoten. Diesen Teilbaum (this) zurueckgeben
    if (this.left != null && x < this.value) { //Links ist noch ein Teilbaum und der ges. Teilbaum ist links
      TreeNode newRoot = this.left.rotationSearch(x); //Im linken Teilbaum nach x suchen und rotieren
      if (newRoot == null) return null; //Nicht gefunden => null zureckgeben
      //newroot mit this rotieren
      this.left = newRoot.right;
      newRoot.right = this;
      return newRoot;
    } else if (this.right != null && x > this.value) {//Rechts ist noch ein Teilbaum und der ges. Teilbaum ist rechts
      TreeNode newRoot = this.right.rotationSearch(x); //Im rechten Teilbaum nach x suchen und rotieren
      if (newRoot == null) return null; //Nicht gefunden => null zureckgeben
      //newroot mit this rotieren
      this.right = newRoot.left;
      newRoot.left = this;
      return newRoot;
    } else {
      //Nichts gefunden => null zurueck geben
      return null;
    }
  }

  /**
   * Geordnete Liste aller Zahlen, die in diesem Teilbaum gespeichert sind.
   */
  @Override
  public String toString() {
    //Falls links ein Teilbaum ist, mit dem und ", " Anfangen. Ansonsten ein leerer String
    String ret = left==null?"":left.toString() + ", ";
    ret += this.value; //Diesen Wert hinzufuegen
    if (right != null) //Falls rechts noch ein Teilbaum ist
      ret += ", " + right.toString(); //Den rechten Teilbaum plus ", " anhaengen
    return ret; //Den String zurueckgeben
  }

  /**
   * Erzeugt eine dot Repraesentation in str
   */
  public int toDot(StringBuilder str, int nullNodes) {
    //Wieso wird hier String concatenation bei den Paremetern fuer StringBuilder#append angewendet?
    //Das macht den Einsatz eines StringBuilder irgendwie sinnlos
    if(this.hasLeft()) {
      str.append(this.getValueString() + " -> " + this.left.getValueString() + ";"
        + System.lineSeparator());
      nullNodes = this.left.toDot(str, nullNodes);
    } else {
      str.append("null" + nullNodes + "[shape=point]" + System.lineSeparator()
        + this.getValueString() + " -> null" + nullNodes + ";" + System.lineSeparator());
      nullNodes += 1;
    }
    if(this.hasRight()) {
      str.append(this.getValueString() + " -> " + this.right.getValueString() + ";"
        + System.lineSeparator());
      nullNodes = this.right.toDot(str, nullNodes);
    } else {
      str.append("null" + nullNodes + "[shape=point]" + System.lineSeparator()
        + this.getValueString() + " -> null" + nullNodes + ";" + System.lineSeparator());
      nullNodes += 1;
    }
    return nullNodes;
  }
}
