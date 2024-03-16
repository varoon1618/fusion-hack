package org.example.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
    topLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, topLabel.getMinimumSize().height));
    topLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(topLabel);

  }

  public void addCodeBlock(String string){
    JLabel label = new JLabel(string);
    label.setBorder(BorderFactory.createLineBorder(Color.black));
    if(string.equals("Move forward")){
      label.setBackground(new Color(204, 202, 240));
    }if(string.equals("Turn right")){
      label.setBackground(new Color(255, 223, 0));
    }if(string.equals("Turn left")){
      label.setBackground(new Color(247, 206, 226));
    }if(string.equals("Start loop (4)")){
      label.setBackground(new Color(235,45,58));
    }if(string.equals("End loop")){
      label.setBackground(new Color(235,45,58));
    }
    label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getMinimumSize().height));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    add(label);
    label.setOpaque(true);
    updateCodeBlocks(label.getText());
    revalidate();
    repaint();
  }

  public void updateCodeBlocks(String command){
    if(command.equals("Start loop (4)")){
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

