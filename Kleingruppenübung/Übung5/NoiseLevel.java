
/**
 * A class holding the current noise level on the construction side with visualisation of the noise level for human ears and ability to increase the noise level
 */
public class NoiseLevel
{
	/**
	*	holds the current noise level
	*/
    private int noiseLevel;

    /**
     * Constructor for objects of class NoiseLevel.
	 * Initialises noise level to 0
     */
    public NoiseLevel()
    {
        this.noiseLevel = 0;
    }
    /**
	*	Setter for the current noise level
	*	@param value of noise to be set 
	*/
    public void setNoiseLevel(int noiseLevel){
        this.noiseLevel = noiseLevel;
    }
    /**
	* 	Getter for the current noise level
	* 	@return current noise level
	*/
    public int getNoiseLevel(){
        return this.noiseLevel;
    }
    /**
	*	Adds noise from new drillings to the current noise level by determining which noise is louder. When a certain threshold is reached, the noise level will be simply increased by 1
	*	@param volume of the noise to be added
	*/
    public void add(int noise){
        if(noise >= 10 && this.getNoiseLevel() >= 10){
            this.setNoiseLevel(java.lang.Math.max(noise, this.getNoiseLevel()) + 1);
        } else {
            this.setNoiseLevel(java.lang.Math.max(noise, this.getNoiseLevel()));
        }
    }
    /**
     * toString method that returns a textual visualisation of the current noise volume.
     * @return a String containing the noise level understandable for human ears
     */
    public String toString(){
		int noise = this.getNoiseLevel();
        if(noise < 0){
            return "Negative Lautstärken existieren nicht";
        }
        if(noise < 2){
            return "leise";
        } else if(noise < 5){
            return "normal";
		} else if (noise >= 10 && noise <= 12){
			return "laut";
        } else if(noise < 12){
            return "LAUT";
        } else {
            return "furchtbar laut";
        }
    }
}
