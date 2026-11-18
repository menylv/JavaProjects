import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBook extends JFrame {
    private JLabel lblStudent, lblBook, lblInfo, lblMessage;
    private JComboBox<Student> cbStudent;
    private JComboBox<Book> cbBook;
    private JButton btnBorrow;

    public BorrowBook() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        
        JPanel p1 = new JPanel(new GridLayout(2, 2));
        lblStudent = new JLabel("Student Name & Matric:");
        lblBook = new JLabel("Book Title & Author:");
        cbStudent = new JComboBox<Student>();
        cbBook = new JComboBox<Book>();

        //claude
        for (int i = 0; i < AddStudentInfo.studentList.size(); i++) {
            cbStudent.addItem(AddStudentInfo.studentList.get(i));
        }
        for (int i = 0; i < AddBookInfo.bookList.size(); i++) {
            cbBook.addItem(AddBookInfo.bookList.get(i));
        }

        p1.add(lblStudent);
        p1.add(cbStudent);
        p1.add(lblBook);
        p1.add(cbBook);

        
        JPanel p2 = new JPanel();
        btnBorrow = new JButton("Borrow");
        p2.add(btnBorrow);

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(p1);
        top.add(p2);

       
        JPanel p3 = new JPanel(new GridLayout(2, 1));
        lblInfo = new JLabel("Borrow Information :");
        lblMessage = new JLabel("");
        p3.add(lblInfo);
        p3.add(lblMessage);

        pane.add(top, BorderLayout.NORTH);
        pane.add(p3, BorderLayout.SOUTH);

        // end claude

        btnBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = (Student) cbStudent.getSelectedItem();
                Book b = (Book) cbBook.getSelectedItem();

                
                if (s == null || b == null) {
                    lblMessage.setText("Please add student and book first.");
                } else {
                    lblMessage.setText(b.borrowBy(s));
                }
            }
        });
    }
}
