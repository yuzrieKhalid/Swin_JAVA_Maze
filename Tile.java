package yuzrie.javamaze;

/**
 * Created by yuzrie on 10/7/15.
 * Class Type: Object Class
 */
public class Tile {

    private boolean isWalkable;
    private boolean hasObject;

    Tile () {
        isWalkable = true;
        hasObject = false;
    }

    /** Tile Checks
     * get and set isWalkable status
     * get and set hasObject status
     * can freeTile from an object
     * check if Tile isFree
     * */

    public void setIsWalkable(boolean isWalkable) { this.isWalkable = isWalkable; }

    public void setHasObject(boolean hasObject) { this.hasObject = hasObject; }

    public boolean isWalkable() { return isWalkable; }

    public boolean hasObject() { return hasObject; }

    public boolean isFree() { return (!hasObject && isWalkable); }

    public void freeTile() {
        isWalkable = true;
        hasObject = false;
    }
}
