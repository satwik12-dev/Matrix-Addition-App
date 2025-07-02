package Arrays;

import javax.swing.*;
import java.awt.*;

class arrayadd {
    void add1dGUI(JFrame parent) {
        JDialog dialog = new JDialog(parent, "1D Array Addition", true);
        dialog.setSize(420, 370);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        JPanel inputPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        inputPanel.setBackground(new Color(255, 240, 245));

        JTextField size1Field = new JTextField();
        JTextField size2Field = new JTextField();
        JTextField arr1Field = new JTextField();
        JTextField arr2Field = new JTextField();

        inputPanel.add(styledLabel("Enter size of Array 1:"));
        inputPanel.add(size1Field);
        inputPanel.add(styledLabel("Enter size of Array 2:"));
        inputPanel.add(size2Field);
        inputPanel.add(styledLabel("Array 1 (space separated):"));
        inputPanel.add(arr1Field);
        inputPanel.add(styledLabel("Array 2 (space separated):"));
        inputPanel.add(arr2Field);

        JButton addButton = new JButton("Add Arrays");
        addButton.setBackground(new Color(255, 51, 153));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JTextArea resultArea = new JTextArea(2, 30);
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(255, 240, 245));
        resultArea.setFont(new Font("Consolas", Font.BOLD, 16));
        resultArea.setForeground(new Color(51, 51, 51));
        resultArea.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 153), 2));

        addButton.addActionListener(e -> {
            try {
                int n1 = Integer.parseInt(size1Field.getText().trim());
                int n2 = Integer.parseInt(size2Field.getText().trim());
                if (n1 != n2) {
                    resultArea.setText("Array sizes must be equal!");
                    return;
                }
                String[] arr1Str = arr1Field.getText().trim().split("\\s+");
                String[] arr2Str = arr2Field.getText().trim().split("\\s+");
                if (arr1Str.length != n1 || arr2Str.length != n2) {
                    resultArea.setText("Number of elements doesn't match the size!");
                    return;
                }
                int[] arr1 = new int[n1];
                int[] arr2 = new int[n2];
                int[] arr3 = new int[n1];
                for (int i = 0; i < n1; i++) arr1[i] = Integer.parseInt(arr1Str[i]);
                for (int i = 0; i < n2; i++) arr2[i] = Integer.parseInt(arr2Str[i]);
                for (int i = 0; i < n1; i++) arr3[i] = arr1[i] + arr2[i];
                StringBuilder sb = new StringBuilder("Result: ");
                for (int v : arr3) sb.append(v).append(" ");
                resultArea.setText(sb.toString());
            } catch (Exception ex) {
                resultArea.setText("Invalid input!");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 240, 245));
        buttonPanel.add(addButton);
        dialog.add(buttonPanel, BorderLayout.CENTER);

        dialog.add(inputPanel, BorderLayout.NORTH);
        dialog.add(resultArea, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    void add2dGUI(JFrame parent) {
        JDialog dialog = new JDialog(parent, "2D Matrix Addition", true);
        dialog.setSize(520, 520);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBackground(new Color(235, 255, 245));

        JTextField rowField = new JTextField();
        JTextField colField = new JTextField();
        JTextArea arr1Area = new JTextArea(3, 20);
        JTextArea arr2Area = new JTextArea(3, 20);

        inputPanel.add(styledLabel("Rows:"));
        inputPanel.add(rowField);
        inputPanel.add(styledLabel("Columns:"));
        inputPanel.add(colField);
        inputPanel.add(styledLabel("Matrix 1 (row-wise, space separated):"));
        inputPanel.add(new JScrollPane(arr1Area));
        inputPanel.add(styledLabel("Matrix 2 (row-wise, space separated):"));
        inputPanel.add(new JScrollPane(arr2Area));

        JButton addButton = new JButton("Add Matrices");
        addButton.setBackground(new Color(0, 204, 153));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JTextArea resultArea = new JTextArea(6, 30);
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(235, 255, 245));
        resultArea.setFont(new Font("Consolas", Font.BOLD, 16));
        resultArea.setForeground(new Color(51, 51, 51));
        resultArea.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 153), 2));

        addButton.addActionListener(e -> {
            try {
                int rows = Integer.parseInt(rowField.getText().trim());
                int cols = Integer.parseInt(colField.getText().trim());
                String[] arr1Str = arr1Area.getText().trim().split("\\s+");
                String[] arr2Str = arr2Area.getText().trim().split("\\s+");
                if (arr1Str.length != rows * cols || arr2Str.length != rows * cols) {
                    resultArea.setText("Number of elements doesn't match matrix size!");
                    return;
                }
                int[][] arr1 = new int[rows][cols];
                int[][] arr2 = new int[rows][cols];
                int[][] sum = new int[rows][cols];
                for (int i = 0; i < rows * cols; i++) {
                    arr1[i / cols][i % cols] = Integer.parseInt(arr1Str[i]);
                    arr2[i / cols][i % cols] = Integer.parseInt(arr2Str[i]);
                }
                StringBuilder sb = new StringBuilder("Result:\n");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        sum[i][j] = arr1[i][j] + arr2[i][j];
                        sb.append(String.format("%-5d", sum[i][j]));
                    }
                    sb.append("\n");
                }
                resultArea.setText(sb.toString());
            } catch (Exception ex) {
                resultArea.setText("Invalid input!");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(235, 255, 245));
        buttonPanel.add(addButton);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(235, 255, 245));
        centerPanel.add(inputPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(new JScrollPane(resultArea));

        dialog.add(centerPanel, BorderLayout.CENTER);

        dialog.setVisible(true);
    }

    private JLabel styledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label.setForeground(new Color(102, 0, 102));
        return label;
    }
}

public class MatrixAddition extends arrayadd {
    public static void main(String[] args) {
        // Stylish main frame
        JFrame frame = new JFrame("Matrix & Array Addition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430, 340);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 204));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Choose Addition Type");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(255, 51, 102));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btn1d = new JButton("1D Array Addition");
        btn1d.setBackground(new Color(255, 51, 153));
        btn1d.setForeground(Color.WHITE);
        btn1d.setFont(new Font("Segoe UI", Font.BOLD, 19));
        btn1d.setFocusPainted(false);
        btn1d.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1d.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btn2d = new JButton("2D Matrix Addition");
        btn2d.setBackground(new Color(0, 204, 153));
        btn2d.setForeground(Color.WHITE);
        btn2d.setFont(new Font("Segoe UI", Font.BOLD, 19));
        btn2d.setFocusPainted(false);
        btn2d.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2d.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel footer = new JLabel("by SATWIK");
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        footer.setForeground(new Color(102, 102, 255));
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(30));
        panel.add(title);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btn1d);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btn2d);
        panel.add(Box.createVerticalGlue());
        panel.add(footer);
        panel.add(Box.createVerticalStrut(10));

        frame.add(panel);
        frame.setVisible(true);

        MatrixAddition ad = new MatrixAddition();

        btn1d.addActionListener(e -> SwingUtilities.invokeLater(() -> ad.add1dGUI(frame)));
        btn2d.addActionListener(e -> SwingUtilities.invokeLater(() -> ad.add2dGUI(frame)));
    }
}