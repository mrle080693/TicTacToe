import javax.swing.*;
import java.util.ArrayList;

public class Move {

    // Variables we need to use object of this class

    // This cell will be set as field cell we need
    Cell cell;
    // If -1 set X. If 1 set O.
    byte changePlayer = -1;
    // For cross victory checking
    boolean crossVictory = false;
    // For zero victory checking
    boolean zeroVictory = false;
    // For draw checking
    boolean draw = false;

    // Check cell and set X or O

    public void fillCell(Cell cell, ArrayList<Cell> field) {
        // Cell empty or not checking
        if (cell.isEmpty()) {
            // if -1 set cell as X
            if (changePlayer == -1) {
                ImageIcon cross = new ImageIcon("cross.gif");
                cell.setIcon(cross);
                cell.setX(true);
                cell.setEmpty(false);
            }
            // if 1 set cell as O
            if (changePlayer == 1) {
                ImageIcon zero = new ImageIcon("zero.gif");
                cell.setIcon(zero);
                cell.setO(true);
                cell.setEmpty(false);
            }
            //
            checkEndOfGame(field);
            //If -1 set X. If 1 set O.
            changePlayer = (byte) (changePlayer * -1);
            this.cell = cell;
        }
    }

    // All combinations for game end

    public void checkEndOfGame(ArrayList<Cell> field) {
        // All combinations for X victory
        if (field.get(0).isX() && field.get(1).isX() && field.get(2).isX() ||
                field.get(3).isX() && field.get(4).isX() && field.get(5).isX() ||
                field.get(6).isX() && field.get(7).isX() && field.get(8).isX() ||
                field.get(0).isX() && field.get(3).isX() && field.get(6).isX() ||
                field.get(1).isX() && field.get(4).isX() && field.get(7).isX() ||
                field.get(2).isX() && field.get(5).isX() && field.get(8).isX() ||
                field.get(0).isX() && field.get(4).isX() && field.get(8).isX() ||
                field.get(2).isX() && field.get(4).isX() && field.get(6).isX()) {
            crossVictory = true;
        }
        // All combinations for O victory
        if (field.get(0).isO() && field.get(1).isO() && field.get(2).isO() ||
                field.get(3).isO() && field.get(4).isO() && field.get(5).isO() ||
                field.get(6).isO() && field.get(7).isO() && field.get(8).isO() ||
                field.get(0).isO() && field.get(3).isO() && field.get(6).isO() ||
                field.get(1).isO() && field.get(4).isO() && field.get(7).isO() ||
                field.get(2).isO() && field.get(5).isO() && field.get(8).isO() ||
                field.get(0).isO() && field.get(4).isO() && field.get(8).isO() ||
                field.get(2).isO() && field.get(4).isO() && field.get(6).isO()) {
            zeroVictory = true;
        }
        // All combinations for draw
        if(!crossVictory && !zeroVictory && !field.get(0).isEmpty() && !field.get(1).isEmpty()
                && !field.get(2).isEmpty() && !field.get(3).isEmpty() && !field.get(4).isEmpty()
                && !field.get(5).isEmpty() && !field.get(6).isEmpty() && !field.get(7).isEmpty()
                && !field.get(8).isEmpty()){
            draw = true;
        }
    }
}
