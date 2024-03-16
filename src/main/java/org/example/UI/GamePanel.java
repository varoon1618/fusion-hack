package org.example.UI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

  private float xDelta;
  private float yDelta;

  private BufferedImage image;
  private BufferedImage passableBlock;
  private BufferedImage impassableBlock;

  private BufferedImage destinationBlock;
  private BufferedImage[][] walkingAnimations;
  private BufferedImage[][] idleAnimations;
  private JButton testCat;
  //private Cat cat;
  private int animationTick;

  Timer timer;
  Timer timer1;
  int counter1;
  private int animationIndex;
  private final int animationSpeed = 100;

  private boolean isCancelled;
  private ArrayList<String> codeBlocks;

  //private LevelManager levelManager;
  private int[][] currentGrid;

  private int currentLevel = 1;
  CodePanel codePanel;

  public GamePanel(CodePanel codePanel) {
    initialise(codePanel);
  }

  public void initialise(CodePanel codePanel){
    this.codePanel = codePanel;
    setFocusable(true);
    //cat = new Cat(this);
    xDelta = 0;
    yDelta = 60*3;
    animationTick = 0;
    counter1 = 0;
    //levelManager = new LevelManager();
    //addKeyListener(new KeyboardInputs(this, cat));
    //setPanelSize();
    //loadImages();
    //setUpGrid();
  }

}
