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

    //bushes
    levelGrid[0][1] =5;
    levelGrid[1][1] = 5;
    levelGrid[2][1] = 5;
    levelGrid[3][1] = 5;
    levelGrid[0][5] = 5;
    levelGrid[1][5] = 5;
    levelGrid[2][5] = 5;
    levelGrid[3][5] = 5;

    //trees
    //levelGrid[11][3] = 4;// big
    levelGrid[12][1] = 6; // blossom 1
    levelGrid[11][0] = 8;
    levelGrid[13][3] = 4; // big
    levelGrid[12][5] = 7;
    levelGrid[14][0] = 8;
    levelGrid[14][2] = 4;
    levelGrid[14][4] = 7; //blossom2

    //levelGrid[8][3] = 4;// big
    levelGrid[9][1] = 6; // blossom 1
    levelGrid[10][3] = 8;
    levelGrid[8][0] = 8;
    //levelGrid[10][3] = 4; // big
    levelGrid[9][5] = 7;
    //levelGrid[11][0] = 8;
    levelGrid[11][2] = 4;
    levelGrid[11][4] = 8;//blossom2

    levelGrid[5][3] = 4;// big
    levelGrid[6][1] = 6; // blossom 1
    levelGrid[7][3] = 8;
    levelGrid[5][0] = 8;
    //levelGrid[10][3] = 4; // big
    levelGrid[6][5] = 7;
    //levelGrid[11][0] = 8;
    levelGrid[8][2] = 4;
    levelGrid[8][4] = 7;
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

    //bushes
    levelGrid[0][5] = 5;
    levelGrid[1][0] = 5;
    levelGrid[1][2] = 5;
    levelGrid[2][5] = 5;
    levelGrid[4][6] = 5;
    //trees
    levelGrid[12][1] = 6; // blossom 1
    levelGrid[11][0] = 8;
    levelGrid[13][3] = 4; // big
    levelGrid[12][5] = 7;
    levelGrid[14][0] = 8;
    levelGrid[14][2] = 4;
    levelGrid[14][4] = 7; //blossom2

    //levelGrid[8][3] = 4;// big
    levelGrid[9][1] = 6; // blossom 1
    levelGrid[10][3] = 8;
    levelGrid[8][0] = 8;
    //levelGrid[10][3] = 4; // big
    levelGrid[9][5] = 7;
    //levelGrid[11][0] = 8;
    levelGrid[11][2] = 4;
    levelGrid[11][4] = 8;//blossom2

    levelGrid[5][3] = 4;// big
    levelGrid[6][1] = 6; // blossom 1
    levelGrid[7][3] = 8;
    //levelGrid[10][3] = 4; // big
    levelGrid[6][5] = 7;
    //levelGrid[11][0] = 8;
    levelGrid[8][2] = 4;
    levelGrid[8][4] = 7;
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

    //bushes
    levelGrid[0][5] = 5;
    //levelGrid[1][5] = 0;
    levelGrid[2][5] = 5;
    //levelGrid[3][5] = 0;
    levelGrid[4][5] = 5;
    //levelGrid[5][5] = 0;
    levelGrid[6][5] = 5;
    levelGrid[0][1] = 5;
    //levelGrid[1][1] = 5;
    levelGrid[2][1] = 5;
   // levelGrid[3][1] = 5;
    levelGrid[4][1] = 5;
    //levelGrid[5][1] = 5;
    levelGrid[6][1] = 5;

    //trees
    levelGrid[12][1] = 6; // blossom 1
    levelGrid[11][0] = 8;
    levelGrid[13][3] = 4; // big
    levelGrid[12][5] = 7;
    levelGrid[14][0] = 8;
    levelGrid[14][2] = 4;
    levelGrid[14][4] = 7; //blossom2

    //levelGrid[8][3] = 4;// big
    levelGrid[9][1] = 6; // blossom 1
    levelGrid[10][3] = 8;
    levelGrid[8][0] = 8;
    //levelGrid[10][3] = 4; // big
    levelGrid[9][5] = 7;
    //levelGrid[11][0] = 8;
    levelGrid[11][2] = 4;
    levelGrid[11][4] = 8;//blossom2

   // levelGrid[5][3] = 4;// big
    levelGrid[6][1] = 6; // blossom 1
    levelGrid[7][3] = 8;
    //levelGrid[10][3] = 4; // big
    levelGrid[6][5] = 7;
    //levelGrid[11][0] = 8;
    levelGrid[8][2] = 4;
    levelGrid[8][4] = 7;

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

    //bushes
    levelGrid[1][5] = 5;
    levelGrid[1][1] = 5;
    levelGrid[3][5] = 5;

    //trees
    levelGrid[12][1] = 6; // blossom 1
    levelGrid[11][0] = 8;
    levelGrid[13][3] = 4; // big
    levelGrid[12][5] = 7;
    levelGrid[14][0] = 8;
    levelGrid[14][2] = 4;
    levelGrid[14][4] = 7; //blossom2

    //levelGrid[8][3] = 4;// big
    //levelGrid[9][3] = 5; // blossom 1
    levelGrid[8][3] = 8;
    levelGrid[8][0] = 8;
    //levelGrid[10][3] = 4; // big
    levelGrid[9][5] = 7;
    //levelGrid[11][0] = 8;
    levelGrid[11][2] = 4;
    levelGrid[10][4] = 8;//blossom2
    return levelGrid;
  }

}
