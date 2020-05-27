package common;

/**
 *  Orientation
 */
public enum Orientation {
    /**
     * orientation east
     */
    EAST(1, "EAST"),

    /**
     * orientation west
     */
    WEST(2, "WEST"),

    /**
     * orientation south
     */
    SOUTH(3, "SOUTH"),

    /**
     * orientation north
     */
    NORTH(4, "NORTH");

    private int key;
    private String value;

    Orientation(int key, String value){
        this.key = key;
        this.value = value;
    }

    /**
     * get orientation by key
     * @param key
     * @return
     */
    public static Orientation getOrientationByKey(int key){
        if(key == 1){
            return EAST;
        }else if(key == 2){
            return WEST;
        }else if(key == 3){
            return SOUTH;
        }else if(key == 4){
            return NORTH;
        }else{
            return null;
        }
    }
}
