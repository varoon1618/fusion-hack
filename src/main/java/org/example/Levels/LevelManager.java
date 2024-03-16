package org.example.Levels;

public class LevelManager {
  //0- can pass , 1 - cannot pass
  private int gridWidth = 15;
  private int gridHeight = 7;
  private int[][] grid = new int[gridWidth][gridHeight];

  public int[][] setupGrid(){
    for(int i=0;i<gridHeight;i++){
      for(int j=0;j<gridWidth;j++){
        grid[j][i] = 1;
      }
    }
    return grid;
  }
  public int[][] setupLevel(int level){
    int[][] levelGrid = new int[15][7];
    if(level==1){
      levelGrid = setupLevel1(setupGrid());
    }if(level==2){
      levelGrid = setupLevel2(setupGrid());
    }if(level==3){
      levelGrid = setupLevel3(setupGrid());
    }if(level==4){
      levelGrid = setupLevel4(setupGrid());
    }if(level>4){
      levelGrid = setupGrid();
    }
    return levelGrid;
  }

  public int[][] setupLevel1(int[][] levelGrid){
    levelGrid[0][3] = 0;
    levelGrid[1][3] = 0;
    levelGrid[2][3] = 0;
    levelGrid[3][3] = -1;
    return levelGrid;
  }

  public int[][] setupLevel2(int[][] levelGrid){
    levelGrid[0][3] = 0;
    levelGrid[1][3] = 0;
    levelGrid[2][3] = 0;
    levelGrid[3][3] = 0;
    levelGrid[3][2] = 0;
    levelGrid[3][1] = 0;
    levelGrid[4][1] = 0;
    levelGrid[5][1] = -1;
    return levelGrid;
  }

  public int[][] setupLevel3(int[][] levelGrid){
    levelGrid[0][3] = 0;
    levelGrid[1][3] = 0;
    levelGrid[2][3] = 0;
    levelGrid[3][3] = 0;
    levelGrid[4][3] = 0;
    levelGrid[5][3] = 0;
    levelGrid[6][3] = -1;
    return levelGrid;
  }

  public int[][] setupLevel4(int[][] levelGrid){
    levelGrid[0][3] = 0;
    levelGrid[1][3] = 0;
    levelGrid[2][3] = 0;
    levelGrid[3][3] = 0;
    levelGrid[3][2] = 0;
    levelGrid[3][1] = 0;
    levelGrid[4][1] = 0;
    levelGrid[5][1] = 0;
    levelGrid[5][2] = 0;
    levelGrid[5][3] = 0;
    levelGrid[5][4] = 0;
    levelGrid[5][5] = 0;
    levelGrid[6][5] = 0;
    levelGrid[7][5] =0;
    levelGrid[7][4] =0;
    levelGrid[7][3] =0;
    levelGrid[7][2]= 0;
    levelGrid[8][2]= 0;
    levelGrid[9][2]= 0;
    levelGrid[10][2]= -1;
    return levelGrid;
  }

}
