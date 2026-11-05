
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;

public class DataSetGUI extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private DecimalFormat df = new DecimalFormat("0.00");

    private Color darkBlue = new Color(30, 41, 59);
    private Color lightBlue = new Color(239, 246, 255);
    private Color blue = new Color(37, 99, 235);
    private Color white = Color.WHITE;

    public DataSetGUI() {

        setTitle("Measurable Data Analysis System");
        setSize(1050, 680);
        setMinimumSize(new Dimension(900, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();
        sidebar.setBackground(darkBlue);
        sidebar.setPreferredSize(new Dimension(260, 0));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // ================= LOGO =================

        JPanel logoPanel = new JPanel(new BorderLayout());
        logoPanel.setBackground(darkBlue);

        logoPanel.setPreferredSize(new Dimension(260, 140));
        logoPanel.setMinimumSize(new Dimension(260, 140));
        logoPanel.setMaximumSize(new Dimension(260, 140));
        logoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        logoPanel.setBorder(
            BorderFactory.createEmptyBorder(35, 20, 35, 10)
        );

        JPanel logoContent = new JPanel();
        logoContent.setBackground(darkBlue);
        logoContent.setLayout(
            new BoxLayout(logoContent, BoxLayout.Y_AXIS)
        );

        JLabel logo = new JLabel("MEASURABLE");
        logo.setFont(new Font("Arial", Font.BOLD, 25));
        logo.setForeground(Color.WHITE);
        logo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel logoSubtitle = new JLabel("DATA ANALYSIS SYSTEM");
        logoSubtitle.setFont(new Font("Arial", Font.BOLD, 10));
        logoSubtitle.setForeground(new Color(148, 163, 184));
        logoSubtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        logoContent.add(logo);
        logoContent.add(Box.createVerticalStrut(8));
        logoContent.add(logoSubtitle);

        logoPanel.add(logoContent, BorderLayout.WEST);

        sidebar.add(logoPanel);

        // ================= MENU =================

        addMenuButton(sidebar, "Dashboard", "Dashboard");
        addMenuButton(sidebar, "Bank Account", "Bank");
        addMenuButton(sidebar, "Coin", "Coin");
        addMenuButton(sidebar, "Student", "Student");

        sidebar.add(Box.createVerticalGlue());

        JLabel footer = new JLabel("Java Swing Application");
        footer.setFont(new Font("Arial", Font.PLAIN, 12));
        footer.setForeground(Color.LIGHT_GRAY);
        footer.setBorder(
            BorderFactory.createEmptyBorder(15, 20, 25, 10)
        );

        sidebar.add(footer);

        add(sidebar, BorderLayout.WEST);

        // ================= MAIN CONTENT =================

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(lightBlue);

        mainPanel.add(createDashboard(), "Dashboard");
        mainPanel.add(createDataPanel("Bank Account"), "Bank");
        mainPanel.add(createDataPanel("Coin"), "Coin");
        mainPanel.add(createDataPanel("Student"), "Student");

        add(mainPanel, BorderLayout.CENTER);

        cardLayout.show(mainPanel, "Dashboard");
    }

    // ================= MENU BUTTON =================

    private void addMenuButton(
        JPanel sidebar, String text, String page
    ) {

        JButton button = new JButton(text);

        button.setMaximumSize(new Dimension(230, 48));
        button.setPreferredSize(new Dimension(230, 48));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setForeground(Color.WHITE);
        button.setBackground(darkBlue);
        button.setFont(new Font("Arial", Font.BOLD, 15));

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.setBorder(
            BorderFactory.createEmptyBorder(10, 25, 10, 10)
        );

        button.addActionListener(
            e -> cardLayout.show(mainPanel, page)
        );

        sidebar.add(button);
        sidebar.add(Box.createVerticalStrut(10));
    }

    // ================= DASHBOARD =================

    private JPanel createDashboard() {

        JPanel panel = new JPanel(new BorderLayout(20, 20));
        panel.setBackground(lightBlue);

        panel.setBorder(
            BorderFactory.createEmptyBorder(40, 40, 40, 40)
        );

        JLabel title = new JLabel("Dashboard");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(darkBlue);

        JLabel subtitle = new JLabel(
            "Welcome to Measurable Data Analysis System"
        );

        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setForeground(new Color(100, 116, 139));

        JPanel header = new JPanel();
        header.setBackground(lightBlue);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        header.add(title);
        header.add(Box.createVerticalStrut(12));
        header.add(subtitle);

        panel.add(header, BorderLayout.NORTH);

        JPanel cards = new JPanel(
            new GridLayout(1, 3, 20, 20)
        );

        cards.setBackground(lightBlue);

        cards.add(createCard(
            "BANK ACCOUNT",
            "3 Records",
            "Analyse account balances"
        ));

        cards.add(createCard(
            "COIN",
            "3 Records",
            "Analyse coin values"
        ));

        cards.add(createCard(
            "STUDENT",
            "3 Records",
            "Analyse student heights"
        ));

        panel.add(cards, BorderLayout.CENTER);

        return panel;
    }

    // ================= DASHBOARD CARDS =================

    private JPanel createCard(
        String title, String value, String desc
    ) {

        JPanel card = new JPanel();

        card.setBackground(white);
        card.setLayout(
            new BoxLayout(card, BoxLayout.Y_AXIS)
        );

        card.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    new Color(220, 226, 235)
                ),
                BorderFactory.createEmptyBorder(
                    25, 20, 25, 20
                )
            )
        );

        JLabel heading = new JLabel(title);
        heading.setFont(new Font("Arial", Font.BOLD, 15));
        heading.setForeground(blue);

        JLabel number = new JLabel(value);
        number.setFont(new Font("Arial", Font.BOLD, 28));
        number.setForeground(darkBlue);

        JLabel description = new JLabel(desc);
        description.setFont(new Font("Arial", Font.PLAIN, 13));
        description.setForeground(new Color(100, 116, 139));

        card.add(heading);
        card.add(Box.createVerticalStrut(25));
        card.add(number);
        card.add(Box.createVerticalStrut(12));
        card.add(description);

        return card;
    }

    // ================= DATA PANEL =================

    private JPanel createDataPanel(String type) {

        JPanel panel = new JPanel(
            new BorderLayout(15, 20)
        );

        panel.setBackground(lightBlue);

        panel.setBorder(
            BorderFactory.createEmptyBorder(
                35, 35, 35, 35
            )
        );

        JLabel title = new JLabel(type + " Analysis");

        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(darkBlue);

        JLabel subtitle = new JLabel(
            "View records and analyse measurable values."
        );

        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));

        JPanel header = new JPanel();

        header.setBackground(lightBlue);
        header.setLayout(
            new BoxLayout(header, BoxLayout.Y_AXIS)
        );

        header.add(title);
        header.add(Box.createVerticalStrut(10));
        header.add(subtitle);

        panel.add(header, BorderLayout.NORTH);

        // Table columns
        String[] columns;

        if (type.equals("Bank Account")) {

            columns = new String[]{
                "Account Number", "Balance"
            };

        } else if (type.equals("Coin")) {

            columns = new String[]{
                "Coin Name", "Value"
            };

        } else {

            columns = new String[]{
                "Student Name", "Height (cm)"
            };
        }

        DefaultTableModel model =
            new DefaultTableModel(columns, 0) {

                @Override
                public boolean isCellEditable(
                    int row, int column
                ) {
                    return false;
                }
            };

        JTable table = new JTable(model);

        table.setRowHeight(42);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setForeground(darkBlue);
        table.setSelectionBackground(
            new Color(219, 234, 254)
        );

        table.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        table.getTableHeader().setBackground(
            new Color(226, 232, 240)
        );

        table.getTableHeader().setForeground(darkBlue);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBorder(
            BorderFactory.createLineBorder(
                new Color(220, 226, 235)
            )
        );

        // ================= SAMPLE DATA =================

        if (type.equals("Bank Account")) {

            model.addRow(new Object[]{"1001", "0.00"});
            model.addRow(new Object[]{"1002", "10000.00"});
            model.addRow(new Object[]{"1003", "2000.00"});

        } else if (type.equals("Coin")) {

            model.addRow(new Object[]{"Quarter", "0.25"});
            model.addRow(new Object[]{"Dime", "0.10"});
            model.addRow(new Object[]{"Nickel", "0.05"});

        } else {

            model.addRow(new Object[]{"Ali", "157.50"});
            model.addRow(new Object[]{"Alex", "165.00"});
            model.addRow(new Object[]{"Maria", "147.00"});
        }

        // ================= RESULT PANEL =================

        JPanel resultPanel = new JPanel(
            new GridLayout(1, 2, 15, 15)
        );

        resultPanel.setBackground(lightBlue);

        JLabel averageLabel = new JLabel("Average: -");
        JLabel highestLabel = new JLabel("Highest: -");

        styleResultLabel(averageLabel);
        styleResultLabel(highestLabel);

        resultPanel.add(averageLabel);
        resultPanel.add(highestLabel);

        // Calculate button
        JButton calculateButton =
            new JButton("Calculate Results");

        calculateButton.setBackground(blue);
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);

        calculateButton.setFont(
            new Font("Arial", Font.BOLD, 15)
        );

        calculateButton.setPreferredSize(
            new Dimension(200, 45)
        );

        calculateButton.addActionListener(e -> {

            double sum = 0;
            double highest = Double.NEGATIVE_INFINITY;
            String highestName = "";

            for (int i = 0; i < model.getRowCount(); i++) {

                String name =
                    model.getValueAt(i, 0).toString();

                double value = Double.parseDouble(
                    model.getValueAt(i, 1).toString()
                );

                sum += value;

                if (value > highest) {

                    highest = value;
                    highestName = name;
                }
            }

            if (model.getRowCount() == 0) {

                averageLabel.setText("Average: -");
                highestLabel.setText("Highest: -");
                return;
            }

            double average =
                sum / model.getRowCount();

            averageLabel.setText(
                "Average: " + df.format(average)
            );

            highestLabel.setText(
                "<html>Highest: " + highestName +
                "<br>" + df.format(highest) + "</html>"
            );
        });

        // Bottom panel
        JPanel bottom = new JPanel(
            new BorderLayout(10, 15)
        );

        bottom.setBackground(lightBlue);

        bottom.add(resultPanel, BorderLayout.CENTER);
        bottom.add(calculateButton, BorderLayout.SOUTH);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    // ================= RESULT LABEL STYLE =================

    private void styleResultLabel(JLabel label) {

        label.setOpaque(true);
        label.setBackground(white);
        label.setForeground(darkBlue);

        label.setFont(
            new Font("Arial", Font.BOLD, 15)
        );

        label.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                    new Color(220, 226, 235)
                ),
                BorderFactory.createEmptyBorder(
                    18, 15, 18, 15
                )
            )
        );
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            DataSetGUI app = new DataSetGUI();
            app.setVisible(true);

        });
    }
}
