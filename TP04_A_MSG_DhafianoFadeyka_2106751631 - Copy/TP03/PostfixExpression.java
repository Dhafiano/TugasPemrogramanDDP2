import java.util.Stack;
import java.util.StringTokenizer;

public class PostfixExpression {
    public static String convertToPostfix(String infixExpression) {

        // Remove all spaces
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        // Tokenize infix expression
        StringTokenizer tokenizer = new StringTokenizer(infixExpression, "+-*/^()", true);

        // Convert infix expression to postfix expression
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            // Check if token is empty
            if (!token.isEmpty()) {

                // Check if token is operand or operator
                if (isOperand(token)) {
                    postfixExpression.append(token).append(" ");
                } else if (isOperator(token)) {
                    char operator = token.charAt(0);

                    // Check if operator is parenthesis
                    if (operator == '(') {
                        operatorStack.push(operator);

                    // Check if operator is closing parenthesis
                    } else if (operator == ')') {
                        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                            postfixExpression.append(operatorStack.pop()).append(" ");
                        }

                        // Check if operator stack is empty
                        if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                            operatorStack.pop();

                        // Check if operator stack is empty
                        } else {
                            throw new IllegalArgumentException("Invalid expression: Unbalanced parentheses");
                        }

                    // Check if operator is exponentiation
                    } else {
                        while (!operatorStack.isEmpty() && getPrecedence(operator) <= getPrecedence(operatorStack.peek())) {
                            postfixExpression.append(operatorStack.pop()).append(" ");
                        }

                        operatorStack.push(operator);
                    }
                
                } else {
                    throw new IllegalArgumentException("Invalid expression: Unknown token '" + token + "'");
                }
            }
        }

        // Check if operator stack is empty
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(' || operatorStack.peek() == ')') {
                throw new IllegalArgumentException("Invalid expression: Unbalanced parentheses");
            }

            // Append operator to postfix expression
            postfixExpression.append(operatorStack.pop()).append(" ");
        }

        return postfixExpression.toString().trim();
    }

    private static int getPrecedence(char operator) {
        return 0;
    }

    // Evaluate postfix expression
    public static long evaluatePostfix(String postfixExpression) {
        // Create stack to hold operands
        Stack<Long> operandStack = new Stack<>();
    
        // Tokenize postfix expression
        StringTokenizer tokenizer = new StringTokenizer(postfixExpression);
    
        // Evaluate postfix expression token by token
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
    
            // If token is an operand, push it onto operand stack
            if (isOperand(token)) {
                long operand = Long.parseLong(token);
                operandStack.push(operand);
    
            // If token is an operator, pop operands from stack and apply operator, then push result onto operand stack
            } else if (isOperator(token)) {
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: Insufficient operands");
                }
                long operand2 = operandStack.pop();
                long operand1 = operandStack.pop();
                long result = evaluateOperation(operand1, operand2, token.charAt(0));
                operandStack.push(result);
    
            // Otherwise, throw an exception
            } else {
                throw new IllegalArgumentException("Invalid expression: Unknown token '" + token + "'");
            }
        }
    
        // The last remaining item on the operand stack is the final result
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: Too many operands");
        }
        return operandStack.pop();
    }
    
    /**
     * Checks whether a token is a valid operand (a single-digit integer).
     * 
     * @param token the token to check
     * @return true if the token is a valid operand, false otherwise
     */
    private static boolean isOperand(String token) {
        return token.matches("\b") && token.length() == 1;
    }
    
    /**
     * Checks whether a token is a valid operator (+,-,*,/).
     * 
     * @param token the token to check
     * @return true if the token is a valid operator, false otherwise
     */
    private static boolean isOperator(String token) {
        return token.matches("[+-*/]") && token.length() == 1;
    }
    
    /**
     * Returns the result of applying an operator to two operands.
     * 
     * @param operand1 the first operand
     * @param operand2 the second operand
     * @param operator the operator (+,-,*,/)
     * @return the result of the operation
     * @throws ArithmeticException if dividing by zero
     * @throws IllegalArgumentException if operator is not one of the valid operators
     */
    private static long evaluateOperation(long operand1, long operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Invalid expression: Division by zero");
                } else {
                    return operand1 / operand2;
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}