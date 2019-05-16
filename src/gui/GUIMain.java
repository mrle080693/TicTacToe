package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain {
    private JFrame jFrame;
    private GUIField guiField;
    private JPanel jPanel;
    private JButton jButtonNew;
    private JButton jButtonExit;

    public GUIMain(){
        createJFrame();
        createComponents();
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
        guiField = new GUIField();
        jPanel = guiField.getjPanel();
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

    // Create action listeners for our buttons
    class ActionListenerForButtonNew implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.dispose();
            GUIMain guiMain = new GUIMain();
        }
    }

    class ActionListenerForButtonExit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.dispose();
        }
    }
}
