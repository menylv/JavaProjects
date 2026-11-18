import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddStudentInfo extends JFrame {
    
    public static ArrayList<Student> studentList = new ArrayList<Student>();

    private JLabel lblName, lblMatric, lblStudents;
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtArea;

    public AddStudentInfo() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        
        JPanel p1 = new JPanel(new GridLayout(2, 2));
        lblName = new JLabel("Name:");
        lblMatric = new JLabel("Matric:");
        txtName = new JTextField();
        txtMatric = new JTextField();
        p1.add(lblName);
        p1.add(txtName);
        p1.add(lblMatric);
        p1.add(txtMatric);

       
        JPanel p2 = new JPanel();
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        p2.add(btnAdd);
        p2.add(btnList);

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(p1);
        top.add(p2);

        
        JPanel p3 = new JPanel(new BorderLayout());
        lblStudents = new JLabel("Students:");
        txtArea = new JTextArea(5, 20);
        txtArea.setEditable(false);
        p3.add(lblStudents, BorderLayout.NORTH);
        p3.add(new JScrollPane(txtArea), BorderLayout.CENTER);

        pane.add(top, BorderLayout.NORTH);
        pane.add(p3, BorderLayout.CENTER);

        
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = new Student(txtName.getText(), txtMatric.getText());
                studentList.add(s);

                txtName.setText("");
                txtMatric.setText("");
            }
        });

      //claude
        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = "";
                for (int i = 0; i < studentList.size(); i++) {
                    result = result + "Name : " + studentList.get(i).toString() + "\n";
                }
                txtArea.setText(result);
            }
        });

        //end claude
    }
}
