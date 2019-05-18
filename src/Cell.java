import javax.swing.*;

// We extend this class from button to create not a standard buttons.
// We need buttons with some new parameters to work with it as we need.

public class Cell extends JButton {
    // Variables for checking cells
    private boolean isEmpty = true;
    private boolean isX;
    private boolean isO;

    // We provide access to encapsulated variables

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public boolean isX() {
        return isX;
    }

    public void setX(boolean x) {
        isX = x;
    }

    public boolean isO() {
        return isO;
    }

    public void setO(boolean o) {
        isO = o;
    }
}
