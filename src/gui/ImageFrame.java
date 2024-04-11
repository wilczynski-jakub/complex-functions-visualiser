//ImageFrame.java
/** A class to generate a full-screen window with an image.
 *@author Jakub Wilczyński
 *@since 13.11.2021
 */

package gui;

import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ImageFrame extends MyFrame {

    // The constructor
    public ImageFrame(BufferedImage image, String title) {
        super(title);
        add(new JLabel(new ImageIcon(image)));
        super.windowSetup();
    }

}//ImageFrame