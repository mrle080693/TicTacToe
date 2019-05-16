package gui;

import java.awt.*;

public class Move {
    Cell jButton;
    byte changePlayer = -1;



    public void fillCell(Cell jButton){

        if(jButton.isEmpty()) {
            if (changePlayer == -1) {
                jButton.setBackground(Color.CYAN);
                jButton.setX(true);
                jButton.setEmpty(false);
            }
            if (changePlayer == 1 ) {
                jButton.setBackground(Color.blue);
                jButton.setX(false);
                jButton.setEmpty(false);
            }
            changePlayer = (byte) (changePlayer * -1);
            this.jButton = jButton;
        }
    }
}
