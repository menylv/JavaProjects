import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddBookInfo extends JFrame {
   
    public static ArrayList<Book> bookList = new ArrayList<Book>();

    private JLabel lblTitle, lblAuthor, lblBooks;
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtArea;

    public AddBookInfo() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        lblTitle = new JLabel("Book Title:");
        lblAuthor = new JLabel("Author:");
        txtTitle = new JTextField();
        txtAuthor = new JTextField();
        p1.add(lblTitle);
        p1.add(txtTitle);
        p1.add(lblAuthor);
        p1.add(txtAuthor);

        JPanel p2 = new JPanel();
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        p2.add(btnAdd);
        p2.add(btnList);

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(p1);
        top.add(p2);

        JPanel p3 = new JPanel(new BorderLayout());
        lblBooks = new JLabel("Books:");
        txtArea = new JTextArea(5, 20);
        txtArea.setEditable(false);
        p3.add(lblBooks, BorderLayout.NORTH);
        p3.add(new JScrollPane(txtArea), BorderLayout.CENTER);

        pane.add(top, BorderLayout.NORTH);
        pane.add(p3, BorderLayout.CENTER);

        
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book b = new Book(txtTitle.getText(), txtAuthor.getText());
                bookList.add(b);

                txtTitle.setText("");
                txtAuthor.setText("");
            }
        });

        
        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = "";
                for (int i = 0; i < bookList.size(); i++) {
                    Book b = bookList.get(i);
                    result = result + "Book title : " + b.getTitle()
                            + " (Author : " + b.getAuthor() + ")\n";
                }
                txtArea.setText(result);
            }
        });
    }
}
