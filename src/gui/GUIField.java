package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIField  {
    private JPanel jPanel;
    Cell jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9;
    private Move move = new Move();

    public GUIField(){
        createJPanel();
        createCells();
    }

    public void createJPanel(){
        jPanel = new JPanel();
        jPanel.setBounds(0, 0, 190, 190);
        jPanel.setLayout(null);
        jPanel.setBackground(Color.black);
    }

    public void createCells(){

        ActionListenerForCell actionListenerForCell;

        jButton1 = new Cell();
        jButton1.setBounds(0, 0, 60, 60);
        jButton1.setBackground(Color.white);
        actionListenerForCell = new ActionListenerForCell(jButton1, (byte) 1);
        jButton1.addActionListener(actionListenerForCell);
        jPanel.add(jButton1);

        jButton2 = new Cell();
        jButton2.setBounds(65, 0, 60, 60);
        jButton2.setBackground(Color.white);
        actionListenerForCell = new ActionListenerForCell(jButton2, (byte) 2);
        jButton2.addActionListener(actionListenerForCell);
        jPanel.add(jButton2);

        jButton3 = new Cell();
        jButton3.setBounds(130, 0, 60, 60);
        jButton3.setBackground(Color.white);
        actionListenerForCell = new ActionListenerForCell(jButton3, (byte) 3);
        jButton3.addActionListener(actionListenerForCell);
        jPanel.add(jButton3);

        jButton4 = new Cell();
        jButton4.setBounds(0, 65, 60, 60);
        jButton4.setBackground(Color.white);
        actionListenerForCell = new ActionListenerForCell(jButton4, (byte) 4);
        jButton4.addActionListener(actionListenerForCell);
        jPanel.add(jButton4);

        jButton5 = new Cell();
        jButton5.setBounds(65, 65, 60, 60);
        jButton5.setBackground(Color.white);
        actionListenerForCell = new ActionListenerForCell(jButton5, (byte) 5);
        jButton5.addActionListener(actionListenerForCell);
        jPanel.add(jButton5);

        jButton6 = new Cell();
        jButton6.setBounds(130, 65, 60, 60);
        jButton6.setBackground(Color.white);
        actionListenerForCell = new ActionListenerForCell(jButton6, (byte) 6);
        jButton6.addActionListener(actionListenerForCell);
        jPanel.add(jButton6);

        jButton7 = new Cell();
        jButton7.setBounds(0, 130, 60, 60);
        jButton7.setBackground(Color.white);
        actionListenerForCell = new ActionListenerForCell(jButton7, (byte) 7);
        jButton7.addActionListener(actionListenerForCell);
        jPanel.add(jButton7);

        jButton8 = new Cell();
        jButton8.setBounds(65, 130, 60, 60);
        jButton8.setBackground(Color.white);
        actionListenerForCell = new ActionListenerForCell(jButton8, (byte) 8);
        jButton8.addActionListener(actionListenerForCell);
        jPanel.add(jButton8);

        jButton9 = new Cell();
        jButton9.setBounds(130, 130, 60, 60);
        jButton9.setBackground(Color.white);
        actionListenerForCell = new ActionListenerForCell(jButton9, (byte) 9);
        jButton9.addActionListener(actionListenerForCell);
        jPanel.add(jButton9);
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    // Create action listener for our cells
    class ActionListenerForCell implements ActionListener {
        Cell jButton;
        byte buttonNumber;

        public ActionListenerForCell(Cell jButton, byte buttonNumber){
            this.jButton = jButton;
            this.buttonNumber = buttonNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            move.fillCell(jButton);
            jButton = move.jButton;

            switch (buttonNumber){
                case (1):

                        jButton1 = jButton;
                        break;

                case (2):
                    jButton2 = jButton;
                    break;
                case (3):
                    jButton3 = jButton;
                    break;
                case (4):
                    jButton4 = jButton;
                    jButton4.setEmpty(false);
                    break;
                case (5):
                    jButton5 = jButton;
                    break;
                case (6):
                    jButton6 = jButton;
                    jButton6.setEmpty(false);
                    break;
                case (7):
                    jButton7 = jButton;
                    break;
                case (8):
                    jButton8 = jButton;
                    break;
                case (9):
                    jButton9 = jButton;
                    break;
                    default:
                        break;

            }
        }
    }
}
