import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private JFrame jFrame;
    private JPanel jPanel;
    private JPanel jPanelEndOfGame;
    private JButton jButtonNew;
    private JButton jButtonExit;

    // For Panel
    Cell jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9;
    ArrayList<Cell> arrayList;
    private Move move = new Move();



    public GUI(){
        createJFrame();
        createComponents();
    }

    public void endOfGame() {
        if(move.crossVictory || move.zeroVictory || move.draw){
           jPanelEndOfGame = new JPanel();
           jPanelEndOfGame.setBounds(0, 0, 190, 190);
           jPanelEndOfGame.setLayout(null);
           if(move.crossVictory) {
               jPanelEndOfGame.setBackground(Color.red);
           }
           if (move.zeroVictory){
               jPanelEndOfGame.setBackground(Color.blue);
           }
           if (move.draw){
               jPanelEndOfGame.setBackground(Color.green);
           }
           jPanel.setVisible(false);
           jFrame.add(jPanelEndOfGame);


           System.out.println("END");

        }
    }

    public void createJFrame(){
        jFrame = new JFrame("TIC TAC TOE");
        jFrame.setSize(200, 270);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setLayout(null);


    }

    public void createComponents(){
        // Create JPanel (Field)
        jPanel = new JPanel();
        jPanel.setBounds(0, 0, 190, 190);
        jPanel.setLayout(null);
        jPanel.setBackground(Color.black);
        jFrame.add(jPanel);

        // Create Button for start and restart the game
        jButtonNew = new JButton("NEW");
        jButtonNew.setBounds(15, 210, 80, 30);
        GUI.ActionListenerForButtonNew actionListenerForButtonNew = new GUI.ActionListenerForButtonNew();
        jButtonNew.addActionListener(actionListenerForButtonNew);
        jFrame.add(jButtonNew);
        // Create Button for exit the game
        jButtonExit = new JButton("EXIT");
        jButtonExit.setBounds(100, 210, 80, 30);
        GUI.ActionListenerForButtonExit actionListenerForButtonExit = new GUI.ActionListenerForButtonExit();
        jButtonExit.addActionListener(actionListenerForButtonExit);
        jFrame.add(jButtonExit);

        // Panel components

        GUI.ActionListenerForCell actionListenerForCell;

        jButton1 = new Cell();
        jButton1.setBounds(0, 0, 60, 60);
        jButton1.setBackground(Color.white);
        actionListenerForCell = new GUI.ActionListenerForCell(jButton1, (byte) 1);
        jButton1.addActionListener(actionListenerForCell);
        jPanel.add(jButton1);

        jButton2 = new Cell();
        jButton2.setBounds(65, 0, 60, 60);
        jButton2.setBackground(Color.white);
        actionListenerForCell = new GUI.ActionListenerForCell(jButton2, (byte) 2);
        jButton2.addActionListener(actionListenerForCell);
        jPanel.add(jButton2);

        jButton3 = new Cell();
        jButton3.setBounds(130, 0, 60, 60);
        jButton3.setBackground(Color.white);
        actionListenerForCell = new GUI.ActionListenerForCell(jButton3, (byte) 3);
        jButton3.addActionListener(actionListenerForCell);
        jPanel.add(jButton3);

        jButton4 = new Cell();
        jButton4.setBounds(0, 65, 60, 60);
        jButton4.setBackground(Color.white);
        actionListenerForCell = new GUI.ActionListenerForCell(jButton4, (byte) 4);
        jButton4.addActionListener(actionListenerForCell);
        jPanel.add(jButton4);

        jButton5 = new Cell();
        jButton5.setBounds(65, 65, 60, 60);
        jButton5.setBackground(Color.white);
        actionListenerForCell = new GUI.ActionListenerForCell(jButton5, (byte) 5);
        jButton5.addActionListener(actionListenerForCell);
        jPanel.add(jButton5);

        jButton6 = new Cell();
        jButton6.setBounds(130, 65, 60, 60);
        jButton6.setBackground(Color.white);
        actionListenerForCell = new GUI.ActionListenerForCell(jButton6, (byte) 6);
        jButton6.addActionListener(actionListenerForCell);
        jPanel.add(jButton6);

        jButton7 = new Cell();
        jButton7.setBounds(0, 130, 60, 60);
        jButton7.setBackground(Color.white);
        actionListenerForCell = new GUI.ActionListenerForCell(jButton7, (byte) 7);
        jButton7.addActionListener(actionListenerForCell);
        jPanel.add(jButton7);

        jButton8 = new Cell();
        jButton8.setBounds(65, 130, 60, 60);
        jButton8.setBackground(Color.white);
        actionListenerForCell = new GUI.ActionListenerForCell(jButton8, (byte) 8);
        jButton8.addActionListener(actionListenerForCell);
        jPanel.add(jButton8);

        jButton9 = new Cell();
        jButton9.setBounds(130, 130, 60, 60);
        jButton9.setBackground(Color.white);
        actionListenerForCell = new GUI.ActionListenerForCell(jButton9, (byte) 9);
        jButton9.addActionListener(actionListenerForCell);
        jPanel.add(jButton9);

        // Add cells to array list to optimize working with object move()
        arrayList = new ArrayList<Cell>();
        arrayList.add(jButton1);
        arrayList.add(jButton2);
        arrayList.add(jButton3);
        arrayList.add(jButton4);
        arrayList.add(jButton5);
        arrayList.add(jButton6);
        arrayList.add(jButton7);
        arrayList.add(jButton8);
        arrayList.add(jButton9);
    }

    // Create action listeners for our buttons
    class ActionListenerForButtonNew implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.dispose();
            GUI gui = new GUI();
        }
    }

    class ActionListenerForButtonExit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.dispose();
        }
    }

    class ActionListenerForCell implements ActionListener {
        Cell jButton;
        byte buttonNumber;

        public ActionListenerForCell(Cell jButton, byte buttonNumber){
            this.jButton = jButton;
            this.buttonNumber = buttonNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            move.fillCell(jButton, arrayList);
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
                    break;
                case (5):
                    jButton5 = jButton;
                    break;
                case (6):
                    jButton6 = jButton;
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
            endOfGame();
        }
    }
}


