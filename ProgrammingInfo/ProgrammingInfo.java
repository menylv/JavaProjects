import javax.swing.*; 
import java.awt.*; 
public class ProgrammingInfo extends JFrame { 
 private JLabel label1, label2; 
 private JRadioButton year1,year2; 
 private JCheckBox java, c; 
  
 public ProgrammingInfo(){ 
  Container pane = getContentPane(); 
  pane.setLayout(new FlowLayout()); 
  label1 = new JLabel("Years Of Study :"); 
  year1 = new JRadioButton("Year 1"); 
  year2 = new JRadioButton("Year 2"); 
   
  ButtonGroup bg = new ButtonGroup(); 
  bg.add(year1); 
  bg.add(year2); 
   
  label2 = new JLabel("Programming Language :"); 
  java = new JCheckBox("Java"); 
  c = new JCheckBox("C++"); 
   
  pane.add(label1); 
  pane.add(year1); 
  pane.add(year2); 
  pane.add(label2); 
  pane.add(java); 
  pane.add(c); 
 } 
  
 public static void main(String [] args) { 
  ProgrammingInfo frame = new ProgrammingInfo(); 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  frame.setTitle("Programming Info"); 
  frame.setSize(400, 100); 
  frame.setVisible(true); 
 } 
} 