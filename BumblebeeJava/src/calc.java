import java.util.Stack;
/**
 * @author Ian Zichko-Geithner
 *
 */
public class calc {
	static String words;
	static String numbers;
	/**
	 * Constructor
	 */
	calc(){
		this.words = "";
		this.numbers = " ";
	}
	
	/**
	 * dijkstra's two stack algorithm used to calculate string math equations
	 * @param in
	 * @return outPut 
	 *
	 */
	public static String calculate(String in) {
		 words=in;
         String exp[] = words.split(" ");
         Stack<String> ops = new Stack<String>();
         Stack<Double> vals = new Stack<Double>();

         for(int i = exp.length-1; i >=0 ; i--) {
        	 	 //Checks for operators to push into operator stack, and values to push into value stack.
        	 	 //iterates through string and checks each token in the string math expression
                 String current = exp[i];
                 if (current.equals(")") || current.equals("")) {
                 }
                 else if (current.equals("+") || current.equals("*") || current.equals("-") || current.equals("^") || current.equals("/")) {
                	 ops.push(current);
                 } 
                 else if (current.equals("(")) {
                	 getComp(ops, vals);
                 } 
                 else {
                	 vals.push(Double.parseDouble(current));
	    }
         }
         //iterates to calc each operation given
         for(int i =ops.size()-1;i>=0;i--) {
        	 getComp(ops, vals);
         }
         numbers = vals.pop().toString();
         // If the number is xx.0 remove the .0 for cleaner audio.
         if(numbers.charAt(numbers.length()-1)=='0' && numbers.charAt(numbers.length()-2)=='.')
        	 numbers = numbers.substring(0, numbers.length()-2);
		return numbers;
	}
	
	/**
	 * Pops the operation then uses it to calculate the 2 top values in the value stack
	 * @param in
	 * @return outPut 
	 *
	 */
	private static void getComp(Stack<String> ops, Stack<Double> vals) {
		String op = ops.pop();
		if (op.equals("+")) {
			vals.push(vals.pop() + vals.pop());
		} 
		else if (op.equals("*")) {
			vals.push(vals.pop() * vals.pop());
		} 
		else if (op.equals("-")) {
			vals.push(vals.pop() - vals.pop());
		}
		else if (op.equals("^")) {
			vals.push(Math.pow(vals.pop(), vals.pop()));
		}
		else if (op.equals("/")) {
			vals.push(vals.pop()/vals.pop());
		}
		
	}
	

 }
