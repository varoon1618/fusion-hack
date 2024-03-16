package org.example.Player;

import org.example.UI.GamePanel;

public class Cat {

  // 0 - left ; 1 - up; 2- right; 3- down
  private int directionFacing = 2;
  private boolean idle = true;
  private final GamePanel gamePanel;
  private int currentX ;
  private int currentY ;

  public Cat(GamePanel gamePanel){
    this.gamePanel = gamePanel;
    currentX = 0;
    currentY = 3;
  }

  public void setCurrentDirection(String direction){
    if(direction.equals("left")){
      directionFacing = 0;
    }if(direction.equals("up")){
      directionFacing = 1;
    }if(direction.equals("right")){
      directionFacing = 2;
    }if(direction.equals("down")){
      directionFacing = 3;
    }
  }
  public int getDirection(){
    return directionFacing;
  }

  public boolean isIdle(){
    return idle;
  }
  public void setIdle(Boolean bool){
    idle = bool;
  }

  public int getCurrentX(){
    return currentX;
  }

  public void setCurrentX(int x){
    currentX = x;
  }

  public int getCurrentY(){
    return currentY;
  }

  public void setCurrentY(int y){
    currentY = y;
  }

  public void moveForward(int currentDirection){
    setIdle(false);
    if(currentDirection == 0){
      gamePanel.changeXDelta(-4);
    }if(currentDirection==1){
      gamePanel.changeYDelta(-4);
    }if(currentDirection==2){
      gamePanel.changeXDelta(+4);
    }if(currentDirection==3){
      gamePanel.changeYDelta(+4);
    }
  }

  public void turnRight(int currentDirection){
    setIdle(true);
    if(currentDirection==0){//facing left currently
      setCurrentDirection("up");
    }if(currentDirection==1){//facing up (north)
      setCurrentDirection("right");
    }if(currentDirection==2){// facing right
      setCurrentDirection("down");
    }if(currentDirection==3){ // facing down (Staring at you)
      setCurrentDirection("left");
    }
  }

  public void turnLeft(int currentDirection){
    setIdle(true);
    if(currentDirection==0){ //cat is facing left
      setCurrentDirection("down");
    }if(currentDirection==1){ // cat is facing up(back of the cat is seen)
      setCurrentDirection("left");
    }if(currentDirection==2){ // cat is facing right
      setCurrentDirection("up");
    }if(currentDirection==3){//cat is facing down(Staring at you)
      setCurrentDirection("right");
    }
  }
}
