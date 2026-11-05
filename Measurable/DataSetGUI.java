
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;

public class DataSetGUI extends JFrame {

    private JTable bankTable;
    private JTable coinTable;
    private JTable studentTable;

    private DefaultTableModel bankModel;
    private DefaultTableModel coinModel;
    private DefaultTableModel studentModel;

    private JTextArea outputArea;

    public DataSetGUI() {

        setTitle("Measurable Data Analysis System");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );

        add(mainPanel);

        JLabel title = new JLabel(
            "Measurable Data Analysis System",
            JLabel.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 23));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel dataPanel = new JPanel(
            new GridLayout(1, 3, 12, 0)
        );

        dataPanel.setBackground(Color.WHITE);

        bankModel = new DefaultTableModel(
            new String[]{"Account", "Balance"}, 0
        );

        bankTable = new JTable(bankModel);
        bankTable.setRowHeight(30);

        bankModel.addRow(new Object[]{"1001", "0.00"});
        bankModel.addRow(new Object[]{"1002", "10000.00"});
        bankModel.addRow(new Object[]{"1003", "2000.00"});

        dataPanel.add(createTablePanel(
            "Bank Account", bankTable
        ));

        coinModel = new DefaultTableModel(
            new String[]{"Coin", "Value"}, 0
        );

        coinTable = new JTable(coinModel);
        coinTable.setRowHeight(30);

        coinModel.addRow(new Object[]{"Quarter", "0.25"});
        coinModel.addRow(new Object[]{"Dime", "0.10"});
        coinModel.addRow(new Object[]{"Nickel", "0.05"});

        dataPanel.add(createTablePanel(
            "Coin", coinTable
        ));

        studentModel = new DefaultTableModel(
            new String[]{"Student", "Height"}, 0
        );

        studentTable = new JTable(studentModel);
        studentTable.setRowHeight(30);

        studentModel.addRow(new Object[]{"Ali", "157.00"});
        studentModel.addRow(new Object[]{"Alex", "165.00"});
        studentModel.addRow(new Object[]{"Maria", "147.50"});

        dataPanel.add(createTablePanel(
            "Student", studentTable
        ));

        mainPanel.add(dataPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBackground(Color.WHITE);

        JButton calculateButton = new JButton("Calculate Results");
        JButton clearButton = new JButton("Clear");

        calculateButton.addActionListener(e -> calculateResults());
        clearButton.addActionListener(e -> outputArea.setText(""));

        JPanel buttonPanel = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 10, 5)
        );

        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        outputArea = new JTextArea(9, 40);

        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        outputArea.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        JScrollPane outputScroll = new JScrollPane(outputArea);

        outputScroll.setBorder(
            BorderFactory.createTitledBorder("Results")
        );

        bottomPanel.add(outputScroll, BorderLayout.CENTER);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createTablePanel(String title, JTable table) {

        JPanel panel = new JPanel(new BorderLayout(5, 8));
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, 15));

        panel.add(label, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private String calculateData(
        DefaultTableModel model,
        String averageTitle,
        String highestTitle,
        String nameTitle,
        DecimalFormat df
    ) {

        double sum = 0;
        double highest = Double.NEGATIVE_INFINITY;
        String highestName = "";

        for (int i = 0; i < model.getRowCount(); i++) {

            String name = model.getValueAt(i, 0).toString();

            double value = Double.parseDouble(
                model.getValueAt(i, 1).toString()
            );

            sum += value;

            if (value > highest) {
                highest = value;
                highestName = name;
            }
        }

        double average = sum / model.getRowCount();

        String result = averageTitle + df.format(average) + "\n";
        result += highestTitle + df.format(highest) + "\n";

        if (nameTitle != null) {
            result += nameTitle + highestName + "\n";
        }

        return result;
    }

    private void calculateResults() {

        DecimalFormat bankFormat = new DecimalFormat("0.0");
        DecimalFormat otherFormat = new DecimalFormat("0.00");

        String result = "";

        result += calculateData(
            bankModel,
            "Bank Average Balance: ",
            "Bank Highest Balance: ",
            null,
            bankFormat
        );

        result += "\n";

        result += calculateData(
            coinModel,
            "Average Coin Value: ",
            "Highest Coin Balance: ",
            "Highest Coin's Name: ",
            otherFormat
        );

        result += "\n";

        result += calculateData(
            studentModel,
            "Average Student's Height: ",
            "Tallest Height: ",
            "Tallest Student's Name: ",
            otherFormat
        );

        outputArea.setText(result);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            DataSetGUI app = new DataSetGUI();
            app.setVisible(true);

        });
    }
}
