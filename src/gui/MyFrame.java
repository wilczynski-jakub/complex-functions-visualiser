//MyFrame.java
/** An abstract class, parent to ImageFrame and MainFrame.
 *@author Jakub Wilczyński
 *@since 13.11.2021
 */

package gui;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public abstract class MyFrame extends JFrame {

    // The constructor
    public MyFrame(String title) {
        super(title);
    }

    // Adjust the window's size, make it visible
    protected void windowSetup() {
        super.pack();
        super.setVisible(true);
        this.centerize();
    }

    // Move it to the center of the screen
    protected void centerize() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - this.getWidth()) / 2;
        int y = (screen.height - this.getHeight()) / 2;
        setLocation(x, y);
    }

    // Make the "x" button work
    protected void exitButton() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}//MyFrame