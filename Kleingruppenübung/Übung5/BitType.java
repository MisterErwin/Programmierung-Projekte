
/**
 * Enumeration class BitType - Contains possible drill bits
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum BitType
{
    Twist, Dowelling, Masonry;
    /**
	*	Returns the set of materials the given drill can drill on
	*	@param the drill type of the drill tip
	*	@return Array of Materials the drill can drill on
	*/
    public static Material[] canHandle(BitType drillType){
        switch(drillType){
            case Twist : 
                return new Material[]{Material.Wood, Material.Plastic, Material.Metal};
            case Dowelling : 
                return new Material[]{Material.Wood, Material.Plastic};
            case Masonry : 
                return new Material[]{Material.Stone, Material.Concrete, Material.ReinforcedConcrete};
            default: return null;
        }
    }
}
