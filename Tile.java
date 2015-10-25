package yuzrie.javamaze;

/**
 * Created by yuzrie on 10/7/15.
 * Class Type: Object Class
 */
public class Tile {

    private boolean isWalkable;
    private boolean hasObstacle;
    private String tileName;

    Tile () {
        isWalkable = true;
        hasObstacle = false;
        tileName = "Empty Lot";
    }

    /** Tile Checks
     * get and set isWalkable status
     * get and set hasObstacle status
     * can freeTile from an object
     * check if Tile isFree
     * */


    public void setTileName(String tileName) { this.tileName = tileName; }

    public void setIsWalkable(boolean isWalkable) { this.isWalkable = isWalkable; }

    public void setHasObstacle(boolean hasObstacle) { this.hasObstacle = hasObstacle; }

    public String getTileName() { return tileName; }

    public boolean isWalkable() { return isWalkable; }

    public boolean hasObstacle() { return hasObstacle; }

}
