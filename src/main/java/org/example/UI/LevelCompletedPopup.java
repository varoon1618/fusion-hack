package org.example.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LevelCompletedPopup extends JDialog {

  GamePanel gamePanel;
  CodePanel codePanel;
  public LevelCompletedPopup(JFrame parent, String message,GamePanel gamePanel,CodePanel codePanel) {
    super(parent, "Level Completed", true);
    this.gamePanel = gamePanel;
    this.codePanel = codePanel;
    setLayout(new BorderLayout());

    JLabel messageLabel = new JLabel(message);
    messageLabel.setHorizontalAlignment(JLabel.CENTER);
    add(messageLabel, BorderLayout.CENTER);

    JButton nextLevelButton = new JButton("Continue");
    nextLevelButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Code to load the next level
        JOptionPane.showMessageDialog(LevelCompletedPopup.this, "Level loaded");
        gamePanel.initialise(codePanel);
        dispose(); // Close the popup
      }
    });

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(nextLevelButton);
    add(buttonPanel, BorderLayout.SOUTH);

    setSize(300, 150);
    setLocationRelativeTo(parent);
    setResizable(false);
  }

}

