package org.example.Game;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.example.UI.MainPanel;

public class GameWindow {
  JFrame jframe;

  public GameWindow(MainPanel mainPanel){
    jframe = new JFrame();
    //jframe.setSize(600,600);
    jframe.add(mainPanel);
    jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jframe.pack();
    jframe.setLocationRelativeTo(null);
    jframe.setResizable(false);
    jframe.setVisible(true);
  }
}
