// Main class
public class Main {
    // Startup of our game
    public static void main(String[] args) {

        // I heard that graphical user interface mast be in new thread

        Thread threadForGUI = new Thread(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.startTheGame();
            }
        });

        // Thread start
        threadForGUI.start();
    }
}
