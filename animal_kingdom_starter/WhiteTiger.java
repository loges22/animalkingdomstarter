import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean hasInfected;//To track if WhiteTiger is infected

    public WhiteTiger() {
        hasInfected = false; // Initially, the WhiteTiger hasn't infected anyone.
    }

    public Action getMove(CritterInfo info) {
        // If there is an enemy in front, infect it
        if (info.getFront() == Neighbor.OTHER) {
            hasInfected = true; // Set the flag to true if infection occurs
            return Action.INFECT;
            // If there is a wall in front or to the right, turn left
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
            // If there is a fellow WhiteTiger in front, turn right
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
            // Otherwise, hop
        } else {
            return Action.HOP;
        }
    }

    public Color getColor() {
        return Color.WHITE; // WhiteTigers are always white
    }

    public String toString() {
        // Return "tgr" if the WhiteTiger hasn't infected yet, "TGR" if it has
        return hasInfected ? "TGR" : "tgr";
    }
}

