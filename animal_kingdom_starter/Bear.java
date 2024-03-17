import java.awt.*;

public class Bear extends Critter {
    private boolean polar; // this is to indicate whether its a polar bear or not
    private String move; // To alternate the current move of bear between "/" amd "\"

    //Bear class's constructor
    public Bear(boolean polar) {
        this.polar = polar;
        this.move = "/";
    }

   //This method override the Critter's default method
   // Bear will infect if an enemy is in front, otherwise hop if possible, otherwise turn left.

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
    // This method overrides the Critter's default method and returns the color of the bear.
    // Color - Color.WHITE if the bear is a polar bear, Color.BLACK otherwise

    public Color getColor() {
        return polar ? Color.WHITE : Color.BLACK;
    }

    // This method overrides the Critter's default method and returns the appearance of the bear.
    // The appearance alternates between "/" and "\" for each move.

    public String toString() {
        if (move.equals("\\")) {
            move = "/";
            return "/";
        } else {
            move = "\\";
            return "\\";
        }
    }
}
