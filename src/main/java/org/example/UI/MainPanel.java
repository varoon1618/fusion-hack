package org.example.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import org.example.Game.Game;

public class MainPanel extends JLayeredPane implements MouseListener, MouseMotionListener {

  public GamePanel gamePanel;
  public CodePanel codePanel;
  public JPanel commandPanel;
  public MainPanel(){
    intialise();
  }

  public void intialise(){
    setPreferredSize(new Dimension(1160,900));
    setLayout(null);
    setupCommandPanel();
  }

  public void setupCommandPanel(){
    commandPanel =  new JPanel();
    commandPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    commandPanel.setBounds(0,448,960,452);
    commandPanel.setPreferredSize(new Dimension(960,452));
    add(commandPanel,Integer.valueOf(0));

    JButton moveForwardButton = new JButton("Move Forward");
    moveForwardButton.addActionListener(e -> moveForwardClicked());
    add(moveForwardButton,JLayeredPane.MODAL_LAYER);
    moveForwardButton.setBounds(100,470,100,40);

    JButton turnRightButton = new JButton("Turn right");
    turnRightButton.addActionListener(e->turnRightClicked());
    add(turnRightButton,JLayeredPane.MODAL_LAYER);
    turnRightButton.setBounds(350,470,100,40);

    JButton turnLeftButton = new JButton("Turn left");
    turnLeftButton.addActionListener(e -> turnLeftClicked());
    add(turnLeftButton,JLayeredPane.MODAL_LAYER);
    turnLeftButton.setBounds(600,470,100,40);

    //startLoop button
    JButton startLoopButton = new JButton("Start loop");
    startLoopButton.addActionListener(e -> startLoopClicked());
    add(startLoopButton,JLayeredPane.MODAL_LAYER);
    startLoopButton.setBounds(100,570,100,40);

    //startLoop button
    JButton endLoopButton = new JButton("End loop");
    endLoopButton.addActionListener(e -> endLoopClicked());
    add(endLoopButton,JLayeredPane.MODAL_LAYER);
    endLoopButton.setBounds(350,570,100,40);
  }

  public void moveForwardClicked(){

  }
  public void turnRightClicked(){

  }
  public void turnLeftClicked(){

  }
  public void startLoopClicked(){

  }
  public void endLoopClicked(){

  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }
}
