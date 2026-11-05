
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PriceAppGUI extends JFrame {

    private JTextArea txtOutput;

    public PriceAppGUI() {

        setTitle("Product Price Application");
        setSize(650, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );
        mainPanel.setBackground(new Color(240, 248, 255));

        JLabel lblTitle = new JLabel(
            "Product Price Application", JLabel.CENTER
        );
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(new Color(30, 41, 59));

        JLabel lblSubtitle = new JLabel(
            "Customer Purchase Eligibility", JLabel.CENTER
        );
        lblSubtitle.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel titlePanel = new JPanel(new GridLayout(2, 1, 5, 5));
        titlePanel.setBackground(new Color(240, 248, 255));
        titlePanel.add(lblTitle);
        titlePanel.add(lblSubtitle);

        JPanel productPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        productPanel.setBackground(new Color(240, 248, 255));
        productPanel.setBorder(
            BorderFactory.createTitledBorder("Available Products")
        );

        JPanel phonePanel = createProductPanel(
            "1. iPhone 14 ProMax",
            "Type: SmartPhone | Price: RM5,500.00",
            "Customer: Sally | Salary: RM3,000.00"
        );

        JPanel laptopPanel = createProductPanel(
            "2. Lenovo Yoga",
            "Type: Laptop | Price: RM6,000.00",
            "Customer: Aaron | Salary: RM8,000.00"
        );

        JPanel carPanel = createProductPanel(
            "3. BMW",
            "Type: Car | Price: RM200,000.00",
            "Customer: Simon | Salary: RM10,000.00"
        );

        productPanel.add(phonePanel);
        productPanel.add(laptopPanel);
        productPanel.add(carPanel);

        txtOutput = new JTextArea();
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtOutput.setEditable(false);
        txtOutput.setMargin(new Insets(15, 15, 15, 15));
        txtOutput.setText(
            "Click 'Display Details' to view purchase eligibility results."
        );

        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBorder(
            BorderFactory.createTitledBorder("Output")
        );

        JButton btnDisplay = new JButton("Display Details");
        JButton btnClear = new JButton("Clear");

        btnDisplay.setBackground(new Color(37, 99, 235));
        btnDisplay.setForeground(Color.WHITE);
        btnDisplay.setFocusPainted(false);

        btnClear.setFocusPainted(false);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.add(btnDisplay);
        buttonPanel.add(btnClear);

        JPanel upperPanel = new JPanel(new BorderLayout(10, 10));
        upperPanel.setBackground(new Color(240, 248, 255));

        upperPanel.add(titlePanel, BorderLayout.NORTH);
        upperPanel.add(productPanel, BorderLayout.CENTER);
        upperPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(upperPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        btnDisplay.addActionListener(e -> displayDetails());
        btnClear.addActionListener(e -> txtOutput.setText(""));
    }

    private JPanel createProductPanel(
        String name, String details, String customer
    ) {

        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.setBackground(Color.WHITE);
        panel.setBorder(
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        JLabel lblName = new JLabel(name);
        lblName.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(lblName);
        panel.add(new JLabel(details));
        panel.add(new JLabel(customer));

        return panel;
    }

    private void displayDetails() {

        SmartPhone sp = new SmartPhone(
            "SmartPhone", "Iphone 14 ProMax", 5500.00
        );

        Laptop lp = new Laptop(
            "Laptop", "Lenovo Yoga", 6000.00
        );

        Car c = new Car("BMW", 200000);

        Customer c1 = new Customer("Sally", 3000.00);
        Customer c2 = new Customer("Aaron", 8000.00);
        Customer c3 = new Customer("Simon", 10000.00);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            sp.getPrice(c1);
            System.out.println();

            lp.getPrice(c2);
            System.out.println();

            c.getPrice(c3);

        } finally {
            System.setOut(originalOut);
        }

        txtOutput.setText(output.toString());
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new PriceAppGUI().setVisible(true);
        });
    }
}
