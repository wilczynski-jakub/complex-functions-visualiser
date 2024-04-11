//MainFrame.java
/** A class to generate the main GUI window, with: input plane on the left, functions to choose on the right.
 *@author Jakub Wilczyński
 *@since 13.11.2021
 */

package gui;
import maths.ComplexFunction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.GridLayout;
import java.io.File;
import java.util.Map;
import java.awt.image.BufferedImage;

public class MainFrame extends MyFrame {

    // Attributes - for easier code below
    private final ComplexPlane complexPlane;
    private final Map<String,ComplexFunction> functionsMap;

    // The constructor
    public MainFrame(String title, ComplexPlane complexPlane,
                     Map<String,ComplexFunction> functionsMap) {

        // Initializing
        super(title);
        this.centerize();
        this.exitButton();

        // Saving as attributes
        this.complexPlane = complexPlane;
        this.functionsMap = functionsMap;

        // Add panels
        this.addInputPanel("West");
        this.addInstructionPanel(
                "Please select which function you would like to apply to the input plane.",
                    "North");
        this.addFunctionsPanel("East");

        // Final adjustments
        super.windowSetup();
    }

    // The input plane panel
    private void addInputPanel(String toWhere) {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1));
        inputPanel.add(new JLabel(" input plane (x,y)", SwingConstants.RIGHT));
        inputPanel.add(new JLabel(new ImageIcon(this.complexPlane.image)));
        inputPanel.add(new JLabel("z = x + yi", SwingConstants.CENTER));
        this.add(inputPanel, toWhere);
    }

    // A panel with an instruction how to use
    private void addInstructionPanel(String message, String toWhere) {
        JPanel instructionPanel = new JPanel();
        JLabel howToUse = new JLabel(message, SwingConstants.CENTER);
        instructionPanel.add(howToUse);
        add(instructionPanel, toWhere);
    }

    // The function buttons panel
    private void addFunctionsPanel(String toWhere) {

        // Initialize the panel
        JPanel functionsPanel = new JPanel();
        functionsPanel.setLayout(new GridLayout(functionsMap.size()+1,1));
        functionsPanel.add(new JLabel("f(z) = ..."));

        // Iterating through each function in the functions map
        for (Map.Entry<String, ComplexFunction> functionMapEntry : functionsMap.entrySet()) {

            String functionName = functionMapEntry.getKey();

            // Add buttons with function labels
            JButton functionButton = new JButton(functionName);
            functionsPanel.add(functionButton);

            // Enable generating the output plane when clicked
            functionButton.addActionListener(event -> {
                ComplexFunction function = functionMapEntry.getValue();
                BufferedImage outputPlane = this.complexPlane.remap(function);
                new ImageFrame(outputPlane, "f(z) = "+functionName);
                try {
                    ImageIO.write(outputPlane, "png", new File("src/LastOutput.png"));
                } catch (java.io.IOException exception) {
                    System.err.println("There is an issue with the Output.png file");
                }
            });

        }//for

        this.add(functionsPanel,toWhere);
    }

}//MainFrame
