package org.example.UI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CodePanel extends JPanel {

  public ArrayList<ArrayList<String>> codeBlocks = new ArrayList();

  public ArrayList<String> flatCodeBlocks = new ArrayList<>();
  private ArrayList<String> loopCode = new ArrayList<>();

  private ArrayList<String> nonLoopCode = new ArrayList<>();
  private boolean isCurrentlyLoop= false;

  public CodePanel(){
    initialise();
  }

  public void initialise(){
    JLabel topLabel = new JLabel("Code Panel");
    topLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    topLabel.setBounds(50,0,100,20);
    add(topLabel);

  }

  public void addCodeBlock(String string){
    JLabel label = new JLabel(string);
    //label.setAlignmentX(Component.CENTER_ALIGNMENT);
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

  public void printCodeBlocks(){
    for(int i = 0; i < codeBlocks.size();i++){
      for(int j = 0; j< codeBlocks.get(i).size();j++){
        System.out.print(codeBlocks.get(i).get(j)+ " ");
      }
      System.out.println();
    }
  }

  public ArrayList<String> getCodeBlocks(){
    return flattenCodeBlocks();
  }

  public ArrayList<String> flattenCodeBlocks(){
    for(int i = 0;i<codeBlocks.size();i++){
      if(codeBlocks.get(i).size() == 1){
        flatCodeBlocks.add(codeBlocks.get(i).get(0));
      }else{
        deconstructLoop(codeBlocks.get(i));
      }
    }
    return flatCodeBlocks;
  }

  public void deconstructLoop(ArrayList<String> arrayList){
    for(int l=0;l<3;l++){
      for(int k=1;k<arrayList.size();k++){
        flatCodeBlocks.add(arrayList.get(k));
      }
    }
  }

  public void printFlatCode(){
    for(int i=0;i<flatCodeBlocks.size();i++){
      System.out.println(flatCodeBlocks.get(i));
    }
  }

  public void clearAll(){
    codeBlocks.clear();
    flatCodeBlocks.clear();
    Component[] components = getComponents();
    for(Component component: components){
      if(component instanceof JLabel){
        if(!(((JLabel) component).getText().equals("Code Panel"))){
          remove(component);
        }
      }

    }
    revalidate();
    repaint();
  }
}

