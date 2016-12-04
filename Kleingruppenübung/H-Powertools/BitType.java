/**
 * An enum holding all bit types.
 * Each BitType knows which {@link Material}s it can handle via {@link BitType#handling}
 */
public enum BitType {
    Twist(new Material[]{Material.Wood, Material.Plastic, Material.Metal}),
    Dowelling(new Material[]{Material.Wood, Material.Plastic}),
    Masonry(new Material[]{Material.Stone, Material.Concrete, Material.ReinforcedConcrete});

    /**
     * The {@link Material}s this type can handle
     */
    private final Material[] handling;

    BitType(Material[] handling) {
        this.handling = handling;
    }

    /**
     * A helper method returning which {@link Material}s a {@link BitType} can handle
     * @param type the BitType
     * @return an array of {@link Material}s a specific bit can handle
     */
    public static Material[] canHandle(BitType type) {
        return type.handling;
    }
}