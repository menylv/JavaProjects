import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    private JLabel lblTitle;
    private JButton btnStudent, btnBook, btnBorrow;

    public MainMenu() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 10, 10));

        lblTitle = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
        btnStudent = new JButton("Add Student Info");
        btnBook = new JButton("Add Book Info");
        btnBorrow = new JButton("Borrow Book");

        pane.add(lblTitle);
        pane.add(btnStudent);
        pane.add(btnBook);
        pane.add(btnBorrow);

        //claude
        btnStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddStudentInfo f = new AddStudentInfo();
                f.setTitle("Add Student Info");
                f.setSize(450, 250);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
            }
        });

        //end claude

        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddBookInfo f = new AddBookInfo();
                f.setTitle("Add Book Info");
                f.setSize(450, 250);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
            }
        });

        btnBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BorrowBook f = new BorrowBook();
                f.setTitle("Borrow Book");
                f.setSize(550, 300);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setTitle("Main Menu");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}