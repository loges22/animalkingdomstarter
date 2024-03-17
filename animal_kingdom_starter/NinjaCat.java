import java.awt.*;

public class NinjaCat extends Critter {
    private boolean hasInfectedLastTurn = false;

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            hasInfectedLastTurn = true; //Infect if there is enemy in front
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL) {
            return Action.RIGHT;   // Turn right if there's a wall in front
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.LEFT;    // Perform a U-turn by turning left twice if there's another NinjaCat
        } else {
            return Action.HOP;     // Hop forward if no one
        }
    }

    public Color getColor() {
        // Change color to black if it infected last turn, otherwise yellow
        if (hasInfectedLastTurn) {
            hasInfectedLastTurn = false;
            return Color.BLACK;
        }
        return Color.YELLOW;
    }

    public String toString() {
        // Return "!" if it infected last turn, "N" otherwise
        return hasInfectedLastTurn ? "!" : "NJC";
    }
}
