/**

 * 
 */


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
	calc(){
		this.input = "";
		this.outPut = " ";
	}
	
	/**
	 * dijkstra's two stack algorithm used to convert string and calculate then return string
	 * @param in
	 * @return outPut 
	 *
	 */
	public static String calculate(String in) {
		 input=in;
         String exp[] = input.split(" ");
         Stack<String> ops = new Stack<String>();
         Stack<Double> vals = new Stack<Double>();

         for(int i = exp.length-1; i >=0 ; i--) {
        	 	 //iterates through string and checks each token in the string math expression
        	 	 //Checks for operators to push into operator stack, and values to push into value stack.
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
         outPut = vals.pop().toString();
         // If the number is xx.0 remove the .0 for cleaner audio.
         if(outPut.charAt(outPut.length()-1)=='0' && outPut.charAt(outPut.length()-2)=='.')
        	 outPut = outPut.substring(0, outPut.length()-2);
		return outPut;
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
