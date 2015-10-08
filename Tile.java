package yuzrie.javamaze;

/**
 * Created by yuzrie on 10/7/15.
 * Class Type: Object Class
 */
public class Tile {

    private boolean isWalkable;
    private boolean hasObject;
    private String tileName;

    Tile () {
        isWalkable = true;
        hasObject = false;
        tileName = "Empty Lot";
    }

    /** Tile Checks
     * get and set isWalkable status
     * get and set hasObject status
     * can freeTile from an object
     * check if Tile isFree
     * */


    public void setTileName(String tileName) { this.tileName = tileName; }

    public void setIsWalkable(boolean isWalkable) { this.isWalkable = isWalkable; }

    public void setHasObject(boolean hasObject) { this.hasObject = hasObject; }

    public String getTileName() { return tileName; }

    public boolean isWalkable() { return isWalkable; }

    public boolean hasObject() { return hasObject; }

    public boolean isFree() { return (!hasObject && isWalkable); }

    public void freeTile() {
        isWalkable = true;
        hasObject = false;
    }
}
