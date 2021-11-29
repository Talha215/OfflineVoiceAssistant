import java.util.Stack;

/**
 * @author Ian Zichko-Geithner
 *
 */
public class calc {
    static String input;
    static String outPut;

    /**
     * Constructor
     */
    calc() {
        input = "";
        outPut = " ";
    }

    /**
     * dijkstra's two stack algorithm used to convert string and calculate then return string
     * @param in input
     * @return outPut
     *
     */
    public static String calculate(String in) {
        input = in;
        String[] exp = input.split(" ");
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        for (int i = exp.length - 1; i >= 0; i--) {
            //iterates through string and checks each token in the string math expression
            //Checks for operators to push into operator stack, and values to push into value stack.
            String current = exp[i];
            switch (current) {
                case ")":
                case "":
                    break;
                case "+":
                case "*":
                case "-":
                case "^":
                case "/":
                    ops.push(current);
                    break;
                case "(":
                    getComp(ops, vals);
                    break;
                default:
                    vals.push(Double.parseDouble(current));
                    break;
            }
        }
        //iterates to calc each operation given
        for (int i = ops.size() - 1; i >= 0; i--) {
            getComp(ops, vals);
        }
        outPut = vals.pop().toString();
        return outPut;
    }

    /**
     * Pops the operation then uses it to calculate the 2 top values in the value stack
     * @param ops operations
     * @param vals values
     *
     */
    private static void getComp(Stack<String> ops, Stack<Double> vals) {
        String op = ops.pop();
        switch (op) {
            case "+" -> vals.push(vals.pop() + vals.pop());
            case "*" -> vals.push(vals.pop() * vals.pop());
            case "-" -> vals.push(vals.pop() - vals.pop());
            case "^" -> vals.push(Math.pow(vals.pop(), vals.pop()));
            case "/" -> vals.push(vals.pop() / vals.pop());
        }

    }


}
