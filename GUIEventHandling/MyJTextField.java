import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyJTextField extends JFrame implements ActionListener {
  JTextField my_text1 = new JTextField();
  JTextField my_text2 = new JTextField();

  public MyJTextField() {
    Container pane = getContentPane();
    pane.setBackground(Color.white);
    pane.setLayout(new BorderLayout());

    pane.add(new JLabel("Type something in the 1st text field:"), BorderLayout.NORTH);
    pane.add(my_text1, BorderLayout.CENTER);
    pane.add(my_text2, BorderLayout.SOUTH);

    // Register this frame as listener for the first text field
    my_text1.addActionListener(this);

    // Make the second text field not editable
    my_text2.setEditable(false);
  }

  public void actionPerformed(ActionEvent e) {
    String input = my_text1.getText();

    if (input.equals(""))
      my_text2.setText("You didn't type anything");
    else
      my_text2.setText(input);
  }

  public static void main(String[] args) {
    MyJTextField frame = new MyJTextField();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("My Frame");
    frame.setSize(350, 100);
    frame.setVisible(true);
  }
}
