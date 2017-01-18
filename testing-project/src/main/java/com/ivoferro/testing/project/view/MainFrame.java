/*
 * Package location for user interface components.
 */
package com.ivoferro.testing.project.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * Represents the application main frame.
 *
 * @author Ivo Ferro
 */
public class MainFrame extends JFrame {

    /**
     * The resource bundle.
     */
    private ResourceBundle resourceBundle;

    /**
     * The presentation label.
     */
    private JLabel presentationLabel;

    /**
     * The empty border.
     */
    private static final EmptyBorder EMPTY_BORDER = new EmptyBorder(20, 20, 20, 20);

    /**
     * The minimum window size.
     */
    private static final Dimension MINIMUM_WINDOW_SIZE = new Dimension(320, 200);

    /**
     * Creates an instance of main frame.
     */
    public MainFrame() {

        resourceBundle = ResourceBundle.getBundle("languages.MessagesBundle");
        setTitle(resourceBundle.getString("window_title"));

        createComponents();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(MINIMUM_WINDOW_SIZE);
        setLocationRelativeTo(null);
        pack();
    }

    /**
     * Creates the GUI components.
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout(10, 10));

        componentsPanel.add(createPresentationLabel(), BorderLayout.NORTH);
        componentsPanel.add(createButtonsLabel(), BorderLayout.CENTER);

        componentsPanel.setBorder(EMPTY_BORDER);
        add(componentsPanel);
    }

    /**
     * Creates the presentation label.
     *
     * @return presentation label
     */
    private JLabel createPresentationLabel() {
        presentationLabel = new JLabel(resourceBundle.getString("presentation"), SwingConstants.CENTER);
        Font font = new Font("Courier New", Font.BOLD, 16);
        presentationLabel.setFont(font);
        return presentationLabel;
    }

    /**
     * Creates the buttons label.
     *
     * @return buttons label
     */
    private JPanel createButtonsLabel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton enButton = new JButton("EN");
        enButton.addActionListener((ActionEvent ae) -> {
            Locale locale = new Locale("en", "GB");
            resourceBundle = ResourceBundle.getBundle("languages.MessagesBundle", locale);
            refreshText();
        });

        JButton ptButton = new JButton("PT");
        ptButton.addActionListener((ActionEvent ae) -> {
            Locale locale = new Locale("pt", "PT");
            resourceBundle = ResourceBundle.getBundle("languages.MessagesBundle", locale);
            refreshText();
        });

        JButton plButton = new JButton("PL");
        plButton.addActionListener((ActionEvent ae) -> {
            Locale locale = new Locale("pl", "PL");
            resourceBundle = ResourceBundle.getBundle("languages.MessagesBundle", locale);
            refreshText();
        });

        buttonsPanel.add(enButton);
        buttonsPanel.add(ptButton);
        buttonsPanel.add(plButton);

        return buttonsPanel;
    }

    /**
     * Refresh the text.
     */
    private void refreshText() {
        setTitle(resourceBundle.getString("window_title"));
        presentationLabel.setText(resourceBundle.getString("presentation"));
    }
}
