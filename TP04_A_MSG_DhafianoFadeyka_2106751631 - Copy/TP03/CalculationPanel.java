import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CalculationPanel extends JPanel {
    private JTextField infixTextField;
    private JTextArea postfixTextArea;
    private JLabel resultLabel;
    private JLabel errorMessageLabel;

    // Constructor
    public CalculationPanel() { 
        setLayout(new BorderLayout());

        // Create labels
        JLabel infixInputLabel = new JLabel("Enter infix expression:");
        JLabel postfixLabel = new JLabel("Postfix expression:");
        resultLabel = new JLabel();
        JLabel errorLabel = new JLabel("Error message:");

        // Set font
        JPanel inputLabelPanel = new JPanel(new GridLayout(4, 1));
        inputLabelPanel.add(infixInputLabel);
        inputLabelPanel.add(postfixLabel);
        inputLabelPanel.add(resultLabel);
        inputLabelPanel.add(errorLabel);

        // Create text fields
        infixTextField = new JTextField();
        infixTextField.setPreferredSize(new Dimension(200, 25));

        // Create text area
        postfixTextArea = new JTextArea();
        postfixTextArea.setEditable(false);
        JScrollPane postfixScrollPane = new JScrollPane(postfixTextArea);

        // Create labels
        resultLabel = new JLabel();
        resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD, 14));
        resultLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Create error message label
        errorMessageLabel = new JLabel();
        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setFont(errorMessageLabel.getFont().deriveFont(Font.BOLD));
        errorMessageLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Set font
        JPanel inputValuePanel = new JPanel(new GridLayout(4, 1));
        inputValuePanel.add(infixTextField);
        inputValuePanel.add(postfixScrollPane);
        inputValuePanel.add(resultLabel);
        inputValuePanel.add(errorMessageLabel);

        // Add components
        add(inputLabelPanel, BorderLayout.WEST);
        add(inputValuePanel, BorderLayout.CENTER);

        // Create calculate button
        JButton calculateButton = new JButton("Calculate");
        PostFixCalculator calculateButtonListener = new PostFixCalculator(postfixTextArea, errorLabel, errorLabel);
        calculateButton.addActionListener(calculateButtonListener);

        // Add calculate button
        add(calculateButton, BorderLayout.EAST);
    }

    public class PostFixCalculator implements ActionListener {

        private JTextArea postfixTextArea;
        private JLabel resultLabel;
        private JLabel errorMessageLabel;
    
        // Constructor with dependencies (postfixTextArea, resultLabel, errorMessageLabel)
        public PostFixCalculator(JTextArea postfixTextArea, JLabel resultLabel, JLabel errorMessageLabel) {
            this.postfixTextArea = postfixTextArea;
            this.resultLabel = resultLabel;
            this.errorMessageLabel = errorMessageLabel;
        }
    
        // When button is clicked (actionPerformed method is called)
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Get text from postfixTextArea and parse it to List<String> tokens using space delimiter
                String[] tokens = postfixTextArea.getText().split(" ");
                // Calculate postfix expression using PostFixEvaluator class
                int result = PostFixCalculator.evaluate(tokens);
                // Set result label and error message label to empty
                resultLabel.setText(Integer.toString(result));
                errorMessageLabel.setText("");
    
            // Catch any IllegalArgumentException thrown by PostFixEvaluator
            } catch (IllegalArgumentException ex) {
                String errorMessage = ex.getMessage();
                // Set postfixTextArea, resultLabel to empty and set error message to errorMessageLabel
                postfixTextArea.setText("");
                resultLabel.setText("");
                errorMessageLabel.setText(String.format("[ %s ]", errorMessage));
    
            // Catch any ArithmeticException thrown by PostFixEvaluator
            } catch (ArithmeticException ex) {
                String errorMessage = ex.getMessage();
                // Set postfixTextArea, resultLabel to empty and set error message to errorMessageLabel
                postfixTextArea.setText("");
                resultLabel.setText("");
                errorMessageLabel.setText(String.format(" [ %s ]", errorMessage));
            }
        }

        private static int evaluate(String[] tokens) {
            return 0;
        }
    }
}