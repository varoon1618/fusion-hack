package org.example.Game;

import java.util.MissingFormatArgumentException;
import org.example.Main;
import org.example.UI.GamePanel;
import org.example.UI.MainPanel;

public class Game implements Runnable{
  private GameWindow gameWindow;
  private GamePanel gamePanel;
  private final int fps = 120;
  private MainPanel mainPanel;
  private Thread gameThread;

  public final static int tileSize = 64;
  //public final static float scale = 2.0f;
  public final static int tiles_in_width = 15;
  private final static int Tiles_in_height = 7;
  public final static int game_width = tileSize*tiles_in_width;
  public final static int game_height = tileSize*Tiles_in_height;
  public Game(){
    //gamePanel = new GamePanel();
    mainPanel = new MainPanel();
    gameWindow = new GameWindow(mainPanel);
    startGameLoop();

  }

  private void startGameLoop(){
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {
    double timePerFrame = 1000000000.0/fps;
    long lastFrame = System.nanoTime();
    long now = System.nanoTime();
    while(true){
      now = System.nanoTime();
      if(System.nanoTime() - lastFrame >= timePerFrame){
        mainPanel.repaint();
        lastFrame = now;
      }
    }
  }
}

