/**
 * Package for testing concepts.
 */
package com.ivoferro.testing.project;

import com.ivoferro.testing.project.view.MainFrame;

/**
 * The boot class.
 *
 * @author Ivo Ferro
 */
public class Main {

    /**
     * Empty private constructor prevents from instantiating this class.
     */
    private Main() {

    }

    /**
     * The main method to run the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

}
