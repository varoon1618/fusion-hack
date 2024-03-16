package org.example.UI;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CodePanel extends JPanel {

  public ArrayList<ArrayList<String>> codeBlocks = new ArrayList<>();

  public ArrayList<String> flatCodeBlocks = new ArrayList<>();
  private ArrayList<String> loopCode = new ArrayList<>();

  private ArrayList<String> nonLoopCode = new ArrayList<>();
  private boolean isCurrentlyLoop= false;
  public CodePanel(){

  }

  public void initialise(){

  }

  public void addCodeBlock(String string){
    JLabel label = new JLabel(string);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    add(label);
    updateCodeBlocks(label.getText());
    revalidate();
    repaint();
  }

  public void updateCodeBlocks(String command){
    if(command.equals("Start loop")){
      isCurrentlyLoop = true;
    }if(command.equals("End loop")) {
      isCurrentlyLoop = false;
      codeBlocks.add(loopCode);
      loopCode = new ArrayList<>();
    }else{
      if(isCurrentlyLoop){
        loopCode.add(command);
      }else{
        nonLoopCode.add(command);
        codeBlocks.add(nonLoopCode);
        nonLoopCode = new ArrayList<>();
      }
    }
  }
}
