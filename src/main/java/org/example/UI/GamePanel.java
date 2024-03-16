package org.example.UI;

import static org.example.Game.Game.game_height;
import static org.example.Game.Game.game_width;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.example.Images.ImageLoader;
import org.example.Levels.LevelManager;
import org.example.Player.Cat;

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
  private Cat cat;
  private int animationTick;

  Timer timer;
  Timer timer1;
  int counter1;
  private int animationIndex;
  private final int animationSpeed = 100;

  private boolean isCancelled;
  private ArrayList<String> codeBlocks;

  private LevelManager levelManager;
  private int[][] currentGrid;

  public static int currentLevel = 1;
  CodePanel codePanel;

  public GamePanel(CodePanel codePanel) {

    initialise(codePanel);
  }

  public void initialise(CodePanel codePanel){
    this.codePanel = codePanel;
    setFocusable(true);
    cat = new Cat(this);
    xDelta = 0;
    yDelta = 60*3;
    animationTick = 0;
    counter1 = 0;
    levelManager = new LevelManager();
    setPanelSize();
    loadImages();
    setUpGrid();
  }

  public void setPanelSize(){
    setPreferredSize(new Dimension(game_width,game_height));
  }

  private void loadImages(){
    ImageLoader imageLoader = new ImageLoader();
    passableBlock = imageLoader.getStonePath();
    impassableBlock = imageLoader.getGrassPath();
    destinationBlock = imageLoader.getDestination();
    walkingAnimations = imageLoader.getWalkingAnimations();
    idleAnimations = imageLoader.getIdleAnimations();
  }

  private void setUpGrid(){
    currentGrid = levelManager.setupLevel(currentLevel);
  }

  public void changeXDelta(double value) {
    this.xDelta += value;
  }

  public void changeYDelta(double value) {
    this.yDelta += value;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for(int i=0;i<7;i++){
      for(int j=0;j<15;j++){
        if(currentGrid[j][i] == 0){
          g.drawImage(passableBlock,j*64,i*64,64,64,null);
        }if(currentGrid[j][i] == 1){
          g.drawImage(impassableBlock,j*64,i*64,64,64,null);
        }if(currentGrid[j][i] == -1){
          g.drawImage(destinationBlock,j*64,i*64,64,64,null);
        }
      }
    }

    updateAnimationTick();

    if (cat.isIdle()) {
      g.drawImage(idleAnimations[cat.getDirection()][animationIndex],(int)xDelta,(int)yDelta,64,64,null);
    } else {
      g.drawImage(walkingAnimations[cat.getDirection()][animationIndex], (int) xDelta, (int) yDelta,
          64, 64, null);
    }


  }
  private void updateAnimationTick() {
    animationTick++;
    if (animationTick >= animationSpeed) {
      animationTick = 0;
      animationIndex++;
      if (animationIndex >= 4) {
        animationIndex = 0;
      }
    }
  }

  public void setCodeBlocks(ArrayList<String> codeBlocks) {
    this.codeBlocks = codeBlocks;
  }

  public void runCommands() {
    startCallingMethod(codeBlocks.size());
    //startExecution(codeBlocks);

  }

  public void move2seconds() {
    if (timer != null) {
      timer.cancel();
    }

    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        cat.moveForward(cat.getDirection());// Move the player forward
        System.out.println("current deltaX: "+ xDelta);

      }
    }, 0, 100); // Delay of 150 milliseconds between each movement
    // Schedule the timer task to run repeatedly with a fixed delay
    // Start the timer immediately and repeat every 150 milliseconds
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        timer.cancel();// Stop the movement after 2 seconds
        cat.setIdle(true);
      }
    }, 1500); // Duration of 2 seconds
  }

  public void controlCat(String command) {
    if (command.equals("Move forward")) {
      //System.out.println("carx: "+cat.getCurrentX()+" cary: "+cat.getCurrentY()+" car direction: "+cat.getDirection());
      if(cat.getDirection()==0 && cat.getCurrentX()>0){
        if(currentGrid[cat.getCurrentX()-1][cat.getCurrentY()] <= 0){
          cat.setCurrentX(cat.getCurrentX()-1);
          move2seconds();
        }
      }if(cat.getDirection()==1 && cat.getCurrentY()>0){
        if(currentGrid[cat.getCurrentX()][cat.getCurrentY()-1] <= 0){
          cat.setCurrentY(cat.getCurrentY()-1);
          move2seconds();
        }
      }if(cat.getDirection()==2 && cat.getCurrentX()<14){
        if(currentGrid[cat.getCurrentX()+1][cat.getCurrentY()] <= 0){
          cat.setCurrentX(cat.getCurrentX()+1);
          move2seconds();
        }
      }if(cat.getDirection()==3 && cat.getCurrentY()<6){
        if(currentGrid[cat.getCurrentX()][cat.getCurrentY()+1]<=0){
          cat.setCurrentY(cat.getCurrentY()+1);
          move2seconds();
        }
      }

    }
    if (command.equals("Turn right")) {
      System.out.println("turned right, delta x: "+ xDelta);
      cat.turnRight(cat.getDirection());
    }
    if (command.equals("Turn left")) {
      System.out.println("turned left, delta x: "+ xDelta);
      cat.turnLeft(cat.getDirection());
    }
  }

  /**
   * Repeatedly calls a codeblock to be executed on each "line"
   * for example
   * ->Turn right
   * ->Start loop(2) -> Move forward,turn right -> End loop
   * ->Move forward
   *
   * so this should execute turn right first , then the loop part twice
   * and the final move forward.
   * @param totalTimes
   */
  public void startCallingMethod(int totalTimes) {
    if (timer1 != null) {
      timer1.cancel();
    }
    timer1 = new Timer();
    timer1.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (counter1 < totalTimes) {
          controlCat(codeBlocks.get(counter1));
          counter1++;
        }
        if (counter1 == totalTimes) {
          timer1.cancel(); // Stop the timer when it reaches the total number of times
          checkGameWin();
        }
      }
    }, 0, 2000); // Call every 2 seconds
  }

  public void checkGameWin(){
    if(currentGrid[cat.getCurrentX()][cat.getCurrentY()] == -1){
      currentLevel++;
      LevelCompletedPopup popup = new LevelCompletedPopup(null,"LEVEL "+(currentLevel-1)+" COMPLETE :)",this,codePanel);
      popup.setVisible(true);
      codePanel.clearAll();
    }else{
      LevelCompletedPopup popup = new LevelCompletedPopup(null,"CAT ISN'T ON THE FLOWER :( RETRY ?",this,codePanel);
      popup.setVisible(true);
      codePanel.clearAll();
    }
  }

  public String getInfo(int currentLevel){
    String message = null;
    if(currentLevel == 1){
      message = "Your objective is to get the cat on top of the flower"+"\\n"+
          "Drag and drop Move forward into the code panel to move the cat forward"+"\\n"+
          "Ignore the other blocks for now";
    }
    return message;
  }
}

