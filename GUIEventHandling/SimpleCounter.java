import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCounter extends JFrame implements ActionListener {
  private JLabel label;
  private JTextField textField;
  private JButton countButton;
  private int count = 0;

  public SimpleCounter() {
    // Create components
    label = new JLabel("Counter Value:");
    textField = new JTextField(10);
    textField.setText("0");
    textField.setEditable(false);
    countButton = new JButton("Count");

    // Register the button with ActionListener
    countButton.addActionListener(this);

    // Layout setup
    setLayout(new FlowLayout());
    add(label);
    add(textField);
    add(countButton);
  }

  // Handle button click
  public void actionPerformed(ActionEvent e) {
    count++;
    textField.setText(String.valueOf(count));
  }

  public static void main(String[] args) {
    SimpleCounter frame = new SimpleCounter();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("My Frame");
    frame.setSize(350, 120);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
