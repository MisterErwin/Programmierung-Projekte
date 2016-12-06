
/**
 * Write a description of class List here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class List
{
    private static final List EMPTY = new List(null, 0);
    
    private final List next;
    
    private static int value;
    
    public List(List next, int value)
    {
        this.next = next;
        this.value = value;
    }
}
