import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Class for graphical user interface and listeners for it buttons

public class GUI {

    // Window and main components
    private JFrame jFrame;
    private JPanel jPanel;
    // It may be local but I want to see all graphical components there
    private JButton jButtonNew;
    private JButton jButtonExit;

    // Components for field
    private Cell cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9;
    private ArrayList<Cell> field;

    // Create object move to use methods of it
    private Move move = new Move();

    // Panel for showing game end result
    // It may be local but I want to see all graphical components there
    private JPanel jPanelEndOfGame;
    private JLabel jLabelForJPanelEndOfGame;

    // Method for game starting

    void startTheGame(){
        createJFrame();
        addMainComponentsToJFrame();
        addFieldComponentsToField();
        cellsToArrayList();
    }

    // Initialize window

    private void createJFrame(){
        jFrame = new JFrame("TIC TAC TOE");
        jFrame.setSize(200, 270);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Creating at the center of the screen
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        // Get chance to put components we need
        jFrame.setLayout(null);
    }

    // Initialize main components
    private void addMainComponentsToJFrame() {
        // Initialize panel for field
        jPanel = new JPanel();
        jPanel.setBounds(0, 0, 190, 190);
        jPanel.setLayout(null);
        jPanel.setBackground(Color.black);
        jFrame.add(jPanel);

        // Create Button for start and restart the game
        jButtonNew = new JButton("NEW");
        jButtonNew.setBounds(15, 210, 80, 30);
        ActionListenerForButtonNew actionListenerForButtonNew = new ActionListenerForButtonNew();
        jButtonNew.addActionListener(actionListenerForButtonNew);
        jFrame.add(jButtonNew);
        // Create Button for exit the game
        jButtonExit = new JButton("EXIT");
        jButtonExit.setBounds(100, 210, 80, 30);
        ActionListenerForButtonExit actionListenerForButtonExit = new ActionListenerForButtonExit();
        jButtonExit.addActionListener(actionListenerForButtonExit);
        jFrame.add(jButtonExit);
    }

    // Initialize field components and add to jPanel

     private void addFieldComponentsToField() {
         // It is for click cells
         ActionListenerForCell actionListenerForCell;
         // Cells initializing and adding to field
         cell1 = new Cell();
         cell1.setBounds(0, 0, 60, 60);
         cell1.setBackground(Color.white);
         // Chois cell for our listener
         actionListenerForCell = new ActionListenerForCell(cell1, (byte) 1);
         cell1.addActionListener(actionListenerForCell);
         jPanel.add(cell1);

         cell2 = new Cell();
         cell2.setBounds(65, 0, 60, 60);
         cell2.setBackground(Color.white);
         actionListenerForCell = new ActionListenerForCell(cell2, (byte) 2);
         cell2.addActionListener(actionListenerForCell);
         jPanel.add(cell2);

         cell3 = new Cell();
         cell3.setBounds(130, 0, 60, 60);
         cell3.setBackground(Color.white);
         actionListenerForCell = new ActionListenerForCell(cell3, (byte) 3);
         cell3.addActionListener(actionListenerForCell);
         jPanel.add(cell3);

         cell4 = new Cell();
         cell4.setBounds(0, 65, 60, 60);
         cell4.setBackground(Color.white);
         actionListenerForCell = new ActionListenerForCell(cell4, (byte) 4);
         cell4.addActionListener(actionListenerForCell);
         jPanel.add(cell4);

         cell5 = new Cell();
         cell5.setBounds(65, 65, 60, 60);
         cell5.setBackground(Color.white);
         actionListenerForCell = new ActionListenerForCell(cell5, (byte) 5);
         cell5.addActionListener(actionListenerForCell);
         jPanel.add(cell5);

         cell6 = new Cell();
         cell6.setBounds(130, 65, 60, 60);
         cell6.setBackground(Color.white);
         actionListenerForCell = new ActionListenerForCell(cell6, (byte) 6);
         cell6.addActionListener(actionListenerForCell);
         jPanel.add(cell6);

         cell7 = new Cell();
         cell7.setBounds(0, 130, 60, 60);
         cell7.setBackground(Color.white);
         actionListenerForCell = new ActionListenerForCell(cell7, (byte) 7);
         cell7.addActionListener(actionListenerForCell);
         jPanel.add(cell7);

         cell8 = new Cell();
         cell8.setBounds(65, 130, 60, 60);
         cell8.setBackground(Color.white);
         actionListenerForCell = new ActionListenerForCell(cell8, (byte) 8);
         cell8.addActionListener(actionListenerForCell);
         jPanel.add(cell8);

         cell9 = new Cell();
         cell9.setBounds(130, 130, 60, 60);
         cell9.setBackground(Color.white);
         actionListenerForCell = new ActionListenerForCell(cell9, (byte) 9);
         cell9.addActionListener(actionListenerForCell);
         jPanel.add(cell9);
     }

     // Add cells to array list to optimize working with object move()

    private void cellsToArrayList(){
        field = new ArrayList<>();
        field.add(cell1);
        field.add(cell2);
        field.add(cell3);
        field.add(cell4);
        field.add(cell5);
        field.add(cell6);
        field.add(cell7);
        field.add(cell8);
        field.add(cell9);
    }

    // Variants of game ending

    private void endOfGame() {
        if(move.crossVictory || move.zeroVictory || move.draw){
            jPanelEndOfGame = new JPanel();
            jPanelEndOfGame.setBounds(0, 0, 190, 190);
            jPanelEndOfGame.setLayout(null);


            jLabelForJPanelEndOfGame = new JLabel();
            jLabelForJPanelEndOfGame.setBounds(0, 0, 190, 190);
            jPanelEndOfGame.add(jLabelForJPanelEndOfGame);

            if(move.crossVictory) {
                ImageIcon imageIconCrossWin = new ImageIcon("crossVictory.gif");
                jLabelForJPanelEndOfGame.setIcon(imageIconCrossWin);
            }
            if (move.zeroVictory){
                ImageIcon imageIconZeroWin = new ImageIcon("zeroVictory.gif");
                jLabelForJPanelEndOfGame.setIcon(imageIconZeroWin);
            }
            if (move.draw){
                ImageIcon imageIconDraw = new ImageIcon("draw.gif");
                jLabelForJPanelEndOfGame.setIcon(imageIconDraw);
            }
            jPanel.setVisible(false);
            jFrame.add(jPanelEndOfGame);

            System.out.println("END");

        }
    }

    // Create action listener for button "NEW"
    class ActionListenerForButtonNew implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Close window
            jFrame.dispose();
            // New window
            GUI gui = new GUI();
            gui.startTheGame();
        }
    }

    // For button "EXIT"
    class ActionListenerForButtonExit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.dispose();
        }
    }

    // Universal listener for all cells
    class ActionListenerForCell implements ActionListener {
        Cell cell;
        byte cellNumber;

        // Constructor for listener to chose cell we need
        ActionListenerForCell(Cell cell, byte buttonNumber){
            this.cell = cell;
            this.cellNumber = buttonNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            move.fillCell(cell, field);
            cell = move.cell;

            // Cell choice
            switch (cellNumber){
                case (1):
                    cell1 = cell;
                    break;
                case (2):
                    cell2 = cell;
                    break;
                case (3):
                    cell3 = cell;
                    break;
                case (4):
                    cell4 = cell;
                    break;
                case (5):
                    cell5 = cell;
                    break;
                case (6):
                    cell6 = cell;
                    break;
                case (7):
                    cell7 = cell;
                    break;
                case (8):
                    cell8 = cell;
                    break;
                case (9):
                    cell9 = cell;
                    break;
                default:
                    break;
            }
            // Make a check on the end of the game
            endOfGame();
        }
    }
}


