import java.awt.*;

public class Giant extends Critter {
    private int moves = 0; //// Current step of the Giant's movement cycle

    // If there's an enemy in front, it infects; if the front is empty, it hops; otherwise, it turns right
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
//Color of the Giant which is gray
    public Color getColor() {
        return Color.GRAY;
    }

    // Returns the appearance of the Giant based on its movement cycle
    // The appearance changes every 6 steps, cycling through "fee", "fie", "foe", and "fum"
    //   String - "fee" for steps 0-5, "fie" for steps 6-11, "foe" for steps 12-17, "fum" for steps 18-22
    public String toString() {
        if (moves < 6) {
            moves++;
            return "fee";
        } else if (moves < 12) {
            moves++;
            return "fie";
        } else if (moves < 18) {
            moves++;
            return "foe";
        } else if (moves < 23) {
            moves++;
            return "fum";
        } else {
            moves = 0;
            return "fum";
        }
    }
}
