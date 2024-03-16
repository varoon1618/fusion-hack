package org.example.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import org.example.Game.Game;
import org.example.UI.Button.RoundedButton;

public class MainPanel extends JLayeredPane implements MouseListener, MouseMotionListener {

  public GamePanel gamePanel;
  public CodePanel codePanel;
  public JPanel commandPanel;
  private JLabel label;
  private Point startPoint;
  private JPanel rightPanel;

  private JPanel buttonPanel;
  public MainPanel(){
    initialise();
  }

  public void initialise(){
    setPreferredSize(new Dimension(1160,900));
    setLayout(null);
    setupCommandPanel();

    //panel on the right side that includes command panel
    //and button panel
    setupRightPanel();
    setupGamePanel();
  }

  public void setupGamePanel(){
    gamePanel = new GamePanel(codePanel);
    gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
    add(gamePanel,Integer.valueOf(0));
    gamePanel.setBounds(0,0,960,448);
  }

  public void setupCommandPanel(){
    commandPanel =  new JPanel();
    commandPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    commandPanel.setBounds(0,448,960,452);
    commandPanel.setPreferredSize(new Dimension(960,452));
    commandPanel.setBackground(new Color (249, 236, 217));
    add(commandPanel,Integer.valueOf(0));

    ImageIcon moveForwardIcon = new ImageIcon("/move-forward.png");
    JButton moveForwardButton = new JButton("Move forward");
    moveForwardButton.setBackground(new Color(204, 202, 240));
    moveForwardButton.addActionListener(e -> moveForwardClicked());
    add(moveForwardButton,JLayeredPane.MODAL_LAYER);
    moveForwardButton.setBounds(100,470,120,40);

    /*RoundedButton moveForwardButton = new RoundedButton("Move forward",Color.GREEN,20);
    moveForwardButton.addActionListener(e -> moveForwardClicked());
    add(moveForwardButton,JLayeredPane.MODAL_LAYER);
    moveForwardButton.setBounds(100,470,100,40);*/

    JButton turnRightButton = new JButton("Turn right");
    turnRightButton.addActionListener(e->turnRightClicked());
    add(turnRightButton,JLayeredPane.MODAL_LAYER);
    turnRightButton.setBackground(new Color(255, 223, 0));
    turnRightButton.setBounds(370,470,120,40);

    JButton turnLeftButton = new JButton("Turn left");
    turnLeftButton.addActionListener(e -> turnLeftClicked());
    add(turnLeftButton,JLayeredPane.MODAL_LAYER);
    turnLeftButton.setBackground(new Color(247, 206, 226));
    turnLeftButton.setBounds(620,470,120,40);

    //startLoop button
    JButton startLoopButton = new JButton("Start loop (4)");
    startLoopButton.setBackground(new Color(235,45,58));
    startLoopButton.addActionListener(e -> startLoopClicked());
    add(startLoopButton,JLayeredPane.MODAL_LAYER);
    startLoopButton.setBounds(100,570,120,40);

    //startLoop button
    JButton endLoopButton = new JButton("End loop");
    endLoopButton.setBackground(new Color(235,45,58));
    endLoopButton.addActionListener(e -> endLoopClicked());
    add(endLoopButton,JLayeredPane.MODAL_LAYER);
    endLoopButton.setBounds(370,570,120,40);
  }

  public void setupRightPanel(){
    rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
    rightPanel.setBounds(960,0,200,900);
    rightPanel.setPreferredSize(new Dimension(200,900));
    rightPanel.setMinimumSize(new Dimension(200,900));
    rightPanel.setMaximumSize(new Dimension(200,900));
    rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    codePanel = new CodePanel();
    codePanel.setLayout(new BoxLayout(codePanel,BoxLayout.Y_AXIS));
    //codePanel.setBounds(960,0,200,480);
    codePanel.setPreferredSize(new Dimension(200,480));
    codePanel.setMinimumSize(new Dimension(200,480));
    codePanel.setMaximumSize(new Dimension(200,480));
    //codePanel.setBorder(BorderFactory.createLineBorder(Color.black));

    buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
    //buttonPanel.setBounds(960,480,200,420);
    buttonPanel.setPreferredSize(new Dimension(200,420));
    buttonPanel.setMinimumSize(new Dimension(200,420));
    buttonPanel.setMaximumSize(new Dimension(200,420));
    setupButtonPanel();
    //buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    rightPanel.add(Box.createVerticalGlue()); // Add glue to center horizontally
    rightPanel.add(codePanel);
    rightPanel.add(Box.createVerticalGlue()); // Add glue to center horizontally
    rightPanel.add(buttonPanel);

    add(rightPanel,Integer.valueOf(0));
  }

  public void setupButtonPanel(){

    buttonPanel.add(Box.createRigidArea(new Dimension(0, 30)));

    JButton runCodeButton = new JButton("Run Code");
    runCodeButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, runCodeButton.getMinimumSize().height));
    runCodeButton.setHorizontalAlignment(SwingConstants.CENTER);
    runCodeButton.addActionListener(e ->runCodeClicked() );
    buttonPanel.add(runCodeButton);

    buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));

    JButton clearAllButton = new JButton("Clear All");
    clearAllButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, clearAllButton.getMinimumSize().height));
    clearAllButton.setHorizontalAlignment(SwingConstants.CENTER);
    clearAllButton.addActionListener(e -> clearAllClicked());
    buttonPanel.add(clearAllButton);

    buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));

    JButton showSolutionButton = new JButton("Show Solution");
    showSolutionButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, showSolutionButton.getMinimumSize().height));
    showSolutionButton.setHorizontalAlignment(SwingConstants.CENTER);
    showSolutionButton.addActionListener(e -> clearAllClicked());
    buttonPanel.add(showSolutionButton);
  }

  public void runCodeClicked(){
    gamePanel.setCodeBlocks(codePanel.getCodeBlocks());
    //codePanel.printFlatCode();
    gamePanel.runCommands();
  }

  public void clearAllClicked(){
    codePanel.clearAll();
  }
  public void moveForwardClicked(){
    label = new JLabel("Move forward");
    //label.setBackground(Color.CYAN);
    label.addMouseListener(this);
    label.addMouseMotionListener(this);
    add(label,JLayeredPane.DRAG_LAYER);
    label.setBounds(100,470,100,40);
    label.setVisible(true);
  }
  public void turnRightClicked(){
    label = new JLabel("Turn right");
    label.addMouseListener(this);
    label.addMouseMotionListener(this);
    add(label,JLayeredPane.DRAG_LAYER);
    label.setBounds(350,470,100,40);
  }
  public void turnLeftClicked(){
    label = new JLabel("Turn left");
    //label.setBackground(Color.GREEN);
    label.addMouseListener(this);
    label.addMouseMotionListener(this);
    add(label,JLayeredPane.DRAG_LAYER);
    label.setBounds(600,470,100,40);
  }
  public void startLoopClicked(){
    label = new JLabel("Start loop (4)");
    //label.setBackground(Color.red);
    label.addMouseListener(this);
    label.addMouseMotionListener(this);
    add(label,JLayeredPane.DRAG_LAYER);
    label.setBounds(100,570,100,40);
  }
  public void endLoopClicked(){
    label = new JLabel("End loop");
    //label.setBackground(Color.red);
    label.addMouseListener(this);
    label.addMouseMotionListener(this);
    add(label,JLayeredPane.DRAG_LAYER);
    label.setBounds(350,570,100,40);
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    startPoint = SwingUtilities.convertPoint(label,e.getPoint(),label.getParent());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    codePanel.addCodeBlock(label.getText());
    System.out.println(label.getText());
    remove(label);
    repaint();
  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public void mouseDragged(MouseEvent e) {
    Point location = SwingUtilities.convertPoint(label,e.getPoint(),label.getParent());
    if(label.getParent().getParent().getBounds().contains(location)){
      Point newLocation = label.getLocation();
      newLocation.translate(location.x-startPoint.x,location.y-startPoint.y);
      newLocation.x = Math.max(newLocation.x, 0);
      newLocation.y = Math.max(newLocation.y,0);
      newLocation.x = Math.min(newLocation.x,label.getParent().getWidth()-label.getWidth());
      newLocation.y = Math.min(newLocation.y,label.getParent().getHeight()-label.getHeight());
      label.setLocation(newLocation);
      startPoint = location;
    }
  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }
}
