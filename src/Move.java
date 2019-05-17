import javax.swing.*;
import java.util.ArrayList;

public class Move {
    Cell jButton;
    byte changePlayer = -1;
    boolean crossVictory = false;
    boolean zeroVictory = false;
    boolean draw = false;

    public void fillCell(Cell jButton, ArrayList<Cell> arrayList) {

        if (jButton.isEmpty()) {
            if (changePlayer == -1) {
                ImageIcon cross = new ImageIcon("cross.gif");
                jButton.setIcon(cross);
                jButton.setX(true);
                jButton.setEmpty(false);
            }
            if (changePlayer == 1) {
                ImageIcon zero = new ImageIcon("zero.gif");
                jButton.setIcon(zero);
                jButton.setO(true);
                jButton.setEmpty(false);
            }
            checkVictory(arrayList);
            changePlayer = (byte) (changePlayer * -1);
            this.jButton = jButton;
        }
    }

    public void checkVictory(ArrayList<Cell> arrayList) {
        if (arrayList.get(0).isO() && arrayList.get(1).isO() && arrayList.get(2).isO() ||
                arrayList.get(3).isO() && arrayList.get(4).isO() && arrayList.get(5).isO() ||
                arrayList.get(6).isO() && arrayList.get(7).isO() && arrayList.get(8).isO() ||
                arrayList.get(0).isO() && arrayList.get(3).isO() && arrayList.get(6).isO() ||
                arrayList.get(1).isO() && arrayList.get(4).isO() && arrayList.get(7).isO() ||
                arrayList.get(2).isO() && arrayList.get(5).isO() && arrayList.get(8).isO() ||
                arrayList.get(0).isO() && arrayList.get(4).isO() && arrayList.get(8).isO() ||
                arrayList.get(2).isO() && arrayList.get(4).isO() && arrayList.get(6).isO()) {
            zeroVictory = true;
            System.out.println("O Win");
        }
        if (arrayList.get(0).isX() && arrayList.get(1).isX() && arrayList.get(2).isX() ||
                arrayList.get(3).isX() && arrayList.get(4).isX() && arrayList.get(5).isX() ||
                arrayList.get(6).isX() && arrayList.get(7).isX() && arrayList.get(8).isX() ||
                arrayList.get(0).isX() && arrayList.get(3).isX() && arrayList.get(6).isX() ||
                arrayList.get(1).isX() && arrayList.get(4).isX() && arrayList.get(7).isX() ||
                arrayList.get(2).isX() && arrayList.get(5).isX() && arrayList.get(8).isX() ||
                arrayList.get(0).isX() && arrayList.get(4).isX() && arrayList.get(8).isX() ||
                arrayList.get(2).isX() && arrayList.get(4).isX() && arrayList.get(6).isX()) {
            crossVictory = true;
            System.out.println("X Win");
        }
        if(!crossVictory && !zeroVictory && !arrayList.get(0).isEmpty() && !arrayList.get(1).isEmpty()
                && !arrayList.get(2).isEmpty() && !arrayList.get(3).isEmpty() && !arrayList.get(4).isEmpty()
                && !arrayList.get(5).isEmpty() && !arrayList.get(6).isEmpty() && !arrayList.get(7).isEmpty()
                && !arrayList.get(8).isEmpty()){
            draw = true;
            System.out.println("Draw");
        }
    }


}
