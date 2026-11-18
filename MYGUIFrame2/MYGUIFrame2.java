import javax.swing.*; 
import java.awt.*; 
 
class MyGUIFrame2 extends JFrame { 
 private JLabel label1; 
 private JTextField textField1; 
 private JButton btnSubmit; 
 private JButton btnHelp; 
  
 public MyGUIFrame2() { 
  Container pane = getContentPane(); 
pane.setLayout(new BorderLayout(0,0)); 
  
JPanel p1 = new JPanel(); 
JPanel p2 = new JPanel(); 
 
pane.add(p1, BorderLayout.CENTER); 
pane.add(p2, BorderLayout.SOUTH); 
 
label1 = new JLabel("Search For:"); 
label1.setFont(new Font("Tahoma", Font.PLAIN, 13)); 
  
textField1 = new JTextField(); 
textField1.setColumns(10); 
   
p1.add(label1); 
p1.add(textField1); 
   
btnSubmit = new JButton("Submit"); 
btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13)); 
 
btnHelp = new JButton("Help"); 
btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 13)); 
 
p2.add(btnSubmit); 
p2.add(btnHelp);  
 } 
  
   public static void main(String[] args) { 
    MyGUIFrame2 frame = new MyGUIFrame2(); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.setTitle("My Frame"); 
    frame.setBounds(100, 100, 400,  200); 
    frame.setVisible(true); 
   } 
}