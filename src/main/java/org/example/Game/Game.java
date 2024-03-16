package org.example.Game;

import java.util.MissingFormatArgumentException;
import org.example.Main;
import org.example.UI.MainPanel;

public class Game implements Runnable{
  private MainPanel mainPanel;

  public Game(){
    mainPanel = new MainPanel();
    GameWindow gameWindow = new GameWindow(mainPanel);
  }
  @Override
  public void run() {

  }
}
