import java.awt.*;
import java.util.*;

public class Tiger extends Critter {
    Random random = new Random(); // Random number generator for color selection
    private int moves; // Current moves count
    private int color; // Current color index

    // Tiger class's constructor
    public Tiger() {
        this.moves = 0;
        this.color = random.nextInt(3); // Randomly select initial color index (0: RED, 1: GREEN, 2: BLUE)
    }

    // If there's an enemy in front, it infects; if there's a wall in front or to the right, it turns left;
    // if there's another Tiger in front, it turns right; otherwise, it hops
    public Action getMove(CritterInfo info) {
        moves++; // Increment step counter

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT; // Infect if there's an enemy in front
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT; // Turn left if there's a wall in front or to the right
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT; // Turn right if there's another Tiger in front
        } else {
            return Action.HOP; // Hop if none of the above conditions are met
        }
    }

    // Determines the Tiger's color based on its current step count
    // The color changes every 3 steps in a cycle of red, green, and blue
    public Color getColor() {
        if (moves % 3 == 0) { // Change color every 3 steps
            color = random.nextInt(3); // Randomly select a new color index (0: RED, 1: GREEN, 2: BLUE)
        }

        if (color == 0) {
            return Color.RED;
        } else if (color == 1) {
            return Color.GREEN;
        } else {
            return Color.BLUE;
        }
    }

    // The string is always "TGR", representing the Tiger's species
    public String toString() {
        return "TGR";
    }
}
