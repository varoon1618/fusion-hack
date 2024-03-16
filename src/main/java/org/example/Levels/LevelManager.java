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

  public int[][] setupLevel1(int[][] level1Grid){
    level1Grid[0][3] = 0;
    level1Grid[1][3] = 0;
    level1Grid[2][3] = 0;
    level1Grid[3][3] = -1;
    return level1Grid;
  }

  public int[][] setupLevel(int level){
    int[][] levelGrid = new int[15][7];
    if(level==1){
      levelGrid = setupLevel1(setupGrid());
    }if(level==2){
      levelGrid = setupGrid();
    }
    return levelGrid;
  }

}
