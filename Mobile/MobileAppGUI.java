


import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MobileAppGUI extends JFrame {

    private JTextArea txtOutput;

    public MobileAppGUI() {

        setTitle("Mobile Device Application");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );
        mainPanel.setBackground(new Color(240, 248, 255));

        // Title
        JLabel lblTitle = new JLabel(
            "Mobile Device Application", JLabel.CENTER
        );
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(new Color(30, 41, 59));

        JLabel lblSubtitle = new JLabel(
            "Radio Tuner Information", JLabel.CENTER
        );
        lblSubtitle.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel titlePanel = new JPanel(new GridLayout(2, 1, 5, 5));
        titlePanel.setBackground(new Color(240, 248, 255));
        titlePanel.add(lblTitle);
        titlePanel.add(lblSubtitle);

        JPanel devicePanel = new JPanel(new GridLayout(2, 1, 10, 10));
        devicePanel.setBackground(new Color(240, 248, 255));
        devicePanel.setBorder(
            BorderFactory.createTitledBorder("Available Mobile Devices")
        );

        JPanel smartPhonePanel = new JPanel(new GridLayout(3, 1, 5, 5));
        smartPhonePanel.setBackground(Color.WHITE);
        smartPhonePanel.setBorder(
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        JLabel lblSmartPhone = new JLabel("1. Samsung S20");
        lblSmartPhone.setFont(new Font("Arial", Font.BOLD, 16));

        smartPhonePanel.add(lblSmartPhone);
        smartPhonePanel.add(new JLabel("Type: SmartPhone (Galaxy)"));
        smartPhonePanel.add(new JLabel("Radio: Hot FM - 97.60 MHz"));

        JPanel basicPhonePanel = new JPanel(new GridLayout(3, 1, 5, 5));
        basicPhonePanel.setBackground(Color.WHITE);
        basicPhonePanel.setBorder(
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        JLabel lblBasicPhone = new JLabel("2. Sonny Ericson Walkman");
        lblBasicPhone.setFont(new Font("Arial", Font.BOLD, 16));

        basicPhonePanel.add(lblBasicPhone);
        basicPhonePanel.add(new JLabel("Type: Basic Phone"));
        basicPhonePanel.add(new JLabel("Radio: Fly FM - 109.8 MHz"));

        devicePanel.add(smartPhonePanel);
        devicePanel.add(basicPhonePanel);

        txtOutput = new JTextArea();
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtOutput.setEditable(false);
        txtOutput.setMargin(new Insets(15, 15, 15, 15));
        txtOutput.setText(
            "Click 'Display Details' to view complete mobile device information."
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
        upperPanel.add(devicePanel, BorderLayout.CENTER);
        upperPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(upperPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        btnDisplay.addActionListener(e -> displayDetails());
        btnClear.addActionListener(e ->
            txtOutput.setText("")
        );
    }

    private void displayDetails() {

        //claude

        MobileDevice m1 = new SmartPhone(
            "Samsung", "S20", "Galaxy"
        );

        MobileDevice m2 = new BasicPhone(
            "Sonny Ericson", "Walkman"
        );

        // Set Radio Information
        m1.setStation("Hot FM");
        m1.setFrequency(97.60);

        m2.setStation("Fly FM");
        m2.setFrequency(109.8);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            m1.printDetails();
            System.out.println("Station:" + m1.station);
            System.out.println("Frequency:" + m1.frequency);

            System.out.println();

            m2.printDetails();
            System.out.println("Station:" + m2.station);
            System.out.println("Frequency:" + m2.frequency);

        } finally {
            System.setOut(originalOut);
        }

        txtOutput.setText(output.toString());
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new MobileAppGUI().setVisible(true);
        });
    }
}
