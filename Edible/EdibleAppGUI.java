
import java.awt.*;
import javax.swing.*;

public class EdibleAppGUI extends JFrame {

    private JComboBox<String> foodCombo;
    private JComboBox<String> personCombo;
    private JTextArea outputArea;

    private Color blue = new Color(49, 94, 134);
    private Color lightBlue = new Color(239, 245, 250);
    private Color darkText = new Color(45, 55, 65);

    public EdibleAppGUI() {

        setTitle("Edible Application");
        setSize(750, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        );

        setContentPane(mainPanel);

        JLabel title = new JLabel(
            "Edible Application",
            JLabel.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(blue);

        mainPanel.add(title, BorderLayout.NORTH);

        //claude
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(
            BorderFactory.createTitledBorder("Food Selection")
        );

        JLabel personLabel = new JLabel("Select Person:");
        personLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        personCombo = new JComboBox<>(
            new String[] {"Ali", "Sarah"}
        );

        personCombo.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 35)
        );

        JLabel foodLabel = new JLabel("Select Food:");
        foodLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        foodCombo = new JComboBox<>(
            new String[] {
                "Chicken",
                "Red Apple",
                "Navel Orange"
            }
        );

        foodCombo.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 35)
        );

        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(personLabel);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(personCombo);

        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(foodLabel);
        leftPanel.add(Box.createVerticalStrut(8));
        leftPanel.add(foodCombo);

        leftPanel.add(Box.createVerticalStrut(25));

        JButton showButton = new JButton("Show Result");
        JButton clearButton = new JButton("Clear");

        styleButton(showButton, blue, Color.WHITE);
        styleButton(clearButton, new Color(225, 230, 235), darkText);

        showButton.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 40)
        );

        clearButton.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 40)
        );

        showButton.addActionListener(e -> showResult());

        clearButton.addActionListener(e -> {
            outputArea.setText("");
        });

        leftPanel.add(showButton);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(clearButton);

        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(
            BorderFactory.createTitledBorder("Result")
        );

        outputArea = new JTextArea();

        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14));
        outputArea.setForeground(darkText);
        outputArea.setBackground(lightBlue);
        outputArea.setBorder(
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        );

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(
            BorderFactory.createLineBorder(
                new Color(220, 228, 235)
            )
        );

        rightPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        contentPanel.setBackground(Color.WHITE);

        contentPanel.add(leftPanel);
        contentPanel.add(rightPanel);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
    }

    private void styleButton(
        JButton button, Color background, Color foreground
    ) {

        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void showResult() {

        String personName =
            (String) personCombo.getSelectedItem();

        String foodName =
            (String) foodCombo.getSelectedItem();

        Person person = new Person(personName);

        Edible food;

        if (foodName.equals("Chicken")) {

            food = new Animal("Chicken");

        } else if (foodName.equals("Red Apple")) {

            food = new Apple("Red Apple");

        } else {

            food = new Orange("Navel Orange");
        }

        outputArea.append(
            person.eating(food) + "\n\n"
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            EdibleAppGUI frame = new EdibleAppGUI();
            frame.setVisible(true);
        });
    }
}
