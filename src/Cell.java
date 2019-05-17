import javax.swing.*;

public class Cell extends JButton {
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
