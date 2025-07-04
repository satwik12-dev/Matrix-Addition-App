package Arrays;
import javax.swing.*;
import java.awt.*;
import java.util.*;
class arrayadd {
    @SuppressWarnings("unused")
    void add1dGUI(JFrame parent) {
        JDialog dialog = new JDialog(parent, "1D Array Addition", true);
        dialog.setSize(520, 520);
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

    @SuppressWarnings("unused")
    void add2dGUI(JFrame parent) {
        JDialog dialog = new JDialog(parent, "2D Matrix Addition", true);
        dialog.setSize(520, 520);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        JPanel inputPanel = new JPanel(new GridLayout(6, 1, 10, 10));
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

    @SuppressWarnings("unused")
    void subarr1dGUI(JFrame parent) {
        JDialog dialog = new JDialog(parent, "1D Array Subtraction", true);
        dialog.setSize(520, 520);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        JPanel inputPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        inputPanel.setBackground(new Color(240, 255, 255));

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

        JButton subButton = new JButton("Subtract Arrays");
        subButton.setBackground(new Color(51, 153, 255));
        subButton.setForeground(Color.WHITE);
        subButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        subButton.setFocusPainted(false);
        subButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JTextArea resultArea = new JTextArea(2, 30);
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(240, 255, 255));
        resultArea.setFont(new Font("Consolas", Font.BOLD, 16));
        resultArea.setForeground(new Color(51, 51, 51));
        resultArea.setBorder(BorderFactory.createLineBorder(new Color(51, 153, 255), 2));

        subButton.addActionListener(e -> {
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
                for (int i = 0; i < n1; i++) arr3[i] = arr1[i] - arr2[i];
                StringBuilder sb = new StringBuilder("Result: ");
                for (int v : arr3) sb.append(v).append(" ");
                resultArea.setText(sb.toString());
            } catch (Exception ex) {
                resultArea.setText("Invalid input!");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 255, 255));
        buttonPanel.add(subButton);
        dialog.add(buttonPanel, BorderLayout.CENTER);

        dialog.add(inputPanel, BorderLayout.NORTH);
        dialog.add(resultArea, BorderLayout.SOUTH);

        dialog.setVisible(true);
    } 

    @SuppressWarnings("unused")
    void sub2dGUI(JFrame parent) {
        JDialog dialog = new JDialog(parent, "2D Matrix Subtraction", true);
        dialog.setSize(520, 620);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        JPanel inputPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        inputPanel.setBackground(new Color(255, 245, 235));

        JTextField rowField = new JTextField();
        JTextField colField = new JTextField();
        JTextArea arr1Area = new JTextArea(10, 20);
        JTextArea arr2Area = new JTextArea(10, 20);

        inputPanel.add(styledLabel("Rows:"));
        inputPanel.add(rowField);
        inputPanel.add(styledLabel("Columns:"));
        inputPanel.add(colField);
        inputPanel.add(styledLabel("Matrix 1 (row-wise, space separated):"));
        inputPanel.add(new JScrollPane(arr1Area));
        inputPanel.add(styledLabel("Matrix 2 (row-wise, space separated):"));
        inputPanel.add(new JScrollPane(arr2Area));

        JButton subButton = new JButton("Subtract Matrices");
        subButton.setBackground(new Color(255, 102, 51));
        subButton.setForeground(Color.WHITE);
        subButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        subButton.setFocusPainted(false);
        subButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JTextArea resultArea = new JTextArea(10, 30);
         resultArea.setPreferredSize(new Dimension(400, 180));
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(255, 245, 235));
        resultArea.setFont(new Font("Consolas", Font.BOLD, 16));
        resultArea.setForeground(new Color(51, 51, 51));
        resultArea.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 51), 2));

        subButton.addActionListener(e -> {
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
                int[][] diff = new int[rows][cols];
                for (int i = 0; i < rows * cols; i++) {
                    arr1[i / cols][i % cols] = Integer.parseInt(arr1Str[i]);
                    arr2[i / cols][i % cols] = Integer.parseInt(arr2Str[i]);
                }
                StringBuilder sb = new StringBuilder("Result:\n");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        diff[i][j] = arr1[i][j] - arr2[i][j];
                        sb.append(String.format("%-5d", diff[i][j]));
                    }
                    sb.append("\n");
                }
                resultArea.setText(sb.toString());
            } catch (Exception ex) {
                resultArea.setText("Invalid input!");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 245, 235));
        buttonPanel.add(subButton);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(255, 245, 235));
        centerPanel.add(inputPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(new JScrollPane(resultArea));

        dialog.add(centerPanel, BorderLayout.CENTER);

        dialog.setVisible(true);
    }


    @SuppressWarnings("unused")
    void mul1dGUI(JFrame parent) {
        JDialog dialog = new JDialog(parent, "1D Array Multiplication", true);
        dialog.setSize(520, 520);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        JPanel inputPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        inputPanel.setBackground(new Color(240, 255, 240));

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

        JButton mulButton = new JButton("Multiply Arrays");
        mulButton.setBackground(new Color(51, 204, 51));
        mulButton.setForeground(Color.WHITE);
        mulButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        mulButton.setFocusPainted(false);
        mulButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JTextArea resultArea = new JTextArea(2, 30);
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(240, 255, 240));
        resultArea.setFont(new Font("Consolas", Font.BOLD, 16));
        resultArea.setForeground(new Color(51, 51, 51));
        resultArea.setBorder(BorderFactory.createLineBorder(new Color(51, 204, 51), 2));

        mulButton.addActionListener(e -> {
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
                for (int i = 0; i < n1; i++) arr3[i] = arr1[i] * arr2[i];
                StringBuilder sb = new StringBuilder("Result: ");
                for (int v : arr3) sb.append(v).append(" ");
                resultArea.setText(sb.toString());
            } catch (Exception ex) {
                resultArea.setText("Invalid input!");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 255, 240));
        buttonPanel.add(mulButton);
        dialog.add(buttonPanel, BorderLayout.CENTER);

        dialog.add(inputPanel, BorderLayout.NORTH);
        dialog.add(resultArea, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    @SuppressWarnings("unused")
    void mul2dGUI(JFrame parent) {
        JDialog dialog = new JDialog(parent, "2D Matrix Multiplication", true);
        dialog.setSize(540, 600);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        JPanel inputPanel = new JPanel(new GridLayout(8, 1, 10, 10));
        inputPanel.setBackground(new Color(240, 245, 255));

        JTextField row1Field = new JTextField();
        JTextField col1Field = new JTextField();
        JTextField row2Field = new JTextField();
        JTextField col2Field = new JTextField();
        JTextArea arr1Area = new JTextArea(4, 20);
        JTextArea arr2Area = new JTextArea(4, 20);

        inputPanel.add(styledLabel("Matrix 1 Rows:"));
        inputPanel.add(row1Field);
        inputPanel.add(styledLabel("Matrix 1 Columns:"));
        inputPanel.add(col1Field);
        inputPanel.add(styledLabel("Matrix 2 Rows:"));
        inputPanel.add(row2Field);
        inputPanel.add(styledLabel("Matrix 2 Columns:"));
        inputPanel.add(col2Field);
        inputPanel.add(styledLabel("Matrix 1 (row-wise, space separated):"));
        inputPanel.add(new JScrollPane(arr1Area));
        inputPanel.add(styledLabel("Matrix 2 (row-wise, space separated):"));
        inputPanel.add(new JScrollPane(arr2Area));

        JButton mulButton = new JButton("Multiply Matrices");
        mulButton.setBackground(new Color(102, 51, 204));
        mulButton.setForeground(Color.WHITE);
        mulButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
        mulButton.setFocusPainted(false);
        mulButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JTextArea resultArea = new JTextArea(8, 30);
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(240, 245, 255));
        resultArea.setFont(new Font("Consolas", Font.BOLD, 16));
        resultArea.setForeground(new Color(51, 51, 51));
        resultArea.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 204), 2));

        mulButton.addActionListener(e -> {
            try {
                int r1 = Integer.parseInt(row1Field.getText().trim());
                int c1 = Integer.parseInt(col1Field.getText().trim());
                int r2 = Integer.parseInt(row2Field.getText().trim());
                int c2 = Integer.parseInt(col2Field.getText().trim());

                if (c1 != r2) {
                    resultArea.setText("Matrix multiplication not possible. Columns of first != Rows of second.");
                    return;
                }

                String[] arr1Str = arr1Area.getText().trim().split("\\s+");
                String[] arr2Str = arr2Area.getText().trim().split("\\s+");
                if (arr1Str.length != r1 * c1 || arr2Str.length != r2 * c2) {
                    resultArea.setText("Number of elements doesn't match matrix size!");
                    return;
                }

                int[][] arr1 = new int[r1][c1];
                int[][] arr2 = new int[r2][c2];
                int[][] arr3 = new int[r1][c2];

                for (int i = 0; i < r1 * c1; i++) {
                    arr1[i / c1][i % c1] = Integer.parseInt(arr1Str[i]);
                }
                for (int i = 0; i < r2 * c2; i++) {
                    arr2[i / c2][i % c2] = Integer.parseInt(arr2Str[i]);
                }

                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c2; j++) {
                        arr3[i][j] = 0;
                        for (int k = 0; k < c1; k++) {
                            arr3[i][j] += arr1[i][k] * arr2[k][j];
                        }
                    }
                }

                StringBuilder sb = new StringBuilder("2d matrix after multiplication is:\n");
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c2; j++) {
                        sb.append(arr3[i][j]).append(" ");
                    }
                    sb.append("\n");
                }
                resultArea.setText(sb.toString());
            } catch (Exception ex) {
                resultArea.setText("Invalid input!");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 245, 255));
        buttonPanel.add(mulButton);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(240, 245, 255));
        centerPanel.add(inputPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(new JScrollPane(resultArea));

        dialog.add(centerPanel, BorderLayout.CENTER);

        dialog.setVisible(true);
    }
}

public class MatrixAddition extends arrayadd {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // // Stylish main frame
        JFrame frame = new JFrame("Matrix & Array Operations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 204));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Choose Operation");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(255, 51, 102));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btn1dAdd = new JButton("1D Array Addition");
        btn1dAdd.setBackground(new Color(255, 51, 153));
        btn1dAdd.setForeground(Color.WHITE);
        btn1dAdd.setFont(new Font("Segoe UI", Font.BOLD, 19));
        btn1dAdd.setFocusPainted(false);
        btn1dAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1dAdd.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btn2dAdd = new JButton("2D Matrix Addition");
        btn2dAdd.setBackground(new Color(0, 204, 153));
        btn2dAdd.setForeground(Color.WHITE);
        btn2dAdd.setFont(new Font("Segoe UI", Font.BOLD, 19));
        btn2dAdd.setFocusPainted(false);
        btn2dAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2dAdd.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btn1dSub = new JButton("1D Array Subtraction");
        btn1dSub.setBackground(new Color(51, 153, 255));
        btn1dSub.setForeground(Color.WHITE);
        btn1dSub.setFont(new Font("Segoe UI", Font.BOLD, 19));
        btn1dSub.setFocusPainted(false);
        btn1dSub.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1dSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btn2dSub = new JButton("2D Matrix Subtraction");
        btn2dSub.setBackground(new Color(255, 102, 51));
        btn2dSub.setForeground(Color.WHITE);
        btn2dSub.setFont(new Font("Segoe UI", Font.BOLD, 19));
        btn2dSub.setFocusPainted(false);
        btn2dSub.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2dSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btn1dMul = new JButton("1D Array Multiplication");
        btn1dMul.setBackground(new Color(51, 204, 51));
        btn1dMul.setForeground(Color.WHITE);
        btn1dMul.setFont(new Font("Segoe UI", Font.BOLD, 19));
        btn1dMul.setFocusPainted(false);
        btn1dMul.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1dMul.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btn2dMul = new JButton("2D Matrix Multiplication");
        btn2dMul.setBackground(new Color(102, 51, 204));
        btn2dMul.setForeground(Color.WHITE);
        btn2dMul.setFont(new Font("Segoe UI", Font.BOLD, 19));
        btn2dMul.setFocusPainted(false);
        btn2dMul.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2dMul.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Keep frame centered on maximize
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
            frame.setLocationRelativeTo(null);
            }
        });

        JLabel footer = new JLabel("by SATWIK");
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        footer.setForeground(new Color(102, 102, 255));
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(30));
        panel.add(title);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btn1dAdd);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btn2dAdd);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btn1dSub);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btn2dSub);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btn1dMul);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btn2dMul);
        panel.add(Box.createVerticalGlue());
        panel.add(footer);
        panel.add(Box.createVerticalStrut(10));

        frame.add(panel);
        frame.setVisible(true);

        MatrixAddition ad = new MatrixAddition();

        btn1dAdd.addActionListener(e -> SwingUtilities.invokeLater(() -> ad.add1dGUI(frame)));
        btn2dAdd.addActionListener(e -> SwingUtilities.invokeLater(() -> ad.add2dGUI(frame)));
        btn1dSub.addActionListener(e -> SwingUtilities.invokeLater(() -> ad.subarr1dGUI(frame)));
        btn2dSub.addActionListener(e -> SwingUtilities.invokeLater(() -> ad.sub2dGUI(frame)));
        btn1dMul.addActionListener(e -> SwingUtilities.invokeLater(() -> ad.mul1dGUI(frame)));
        btn2dMul.addActionListener(e -> SwingUtilities.invokeLater(() -> ad.mul2dGUI(frame)));}
}