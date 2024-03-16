package org.example.UI.Button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;

public class RoundedButton extends JButton {
  private Color backgroundColor;
  private int cornerRadius;

  public RoundedButton(String text, Color backgroundColor, int cornerRadius) {
    super(text);
    this.backgroundColor = backgroundColor;
    this.cornerRadius = cornerRadius;
    setContentAreaFilled(false); // Make the button transparent
    setOpaque(true); // Make sure the button is opaque so the background color shows
    setForeground(Color.WHITE); // Set text color
    setBorderPainted(false); // Remove the border
    setFocusPainted(false); // Remove the focus border

    // Set a reasonable size to ensure the background color is visible
    Dimension size = getPreferredSize();
    size.width = Math.max(size.width, size.height); // Ensure a square button
    size.height = size.width;
    setPreferredSize(size);
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();

    // Draw background
    g2.setColor(backgroundColor);
    g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

    super.paintComponent(g2);
    g2.dispose();
  }

  @Override
  protected void paintBorder(Graphics g) {
    // Do not paint border
  }
}
