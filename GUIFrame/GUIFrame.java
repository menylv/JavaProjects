import javax.swing.*; 
import java.awt.*; 
 
class MyGUIFrame extends JFrame { 
 private JLabel label1; 
  
 public MyGUIFrame() { 
  Container pane = getContentPane(); 
  label1 = new JLabel("Hello"); 
  pane.add(label1); 
 } 
  
 public static void main(String[] args) { 
  MyGUIFrame frame = new MyGUIFrame(); 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  frame.setTitle("My Frame"); 
  frame.setSize(300, 200); 
  frame.setVisible(true); 
 } 
}