/**
 * 
 */


/**
 * @author No This is Patrick
 *
 */
public class StringToMath {
	private static String outPut = "";
	
	/**
	 * Takes a string that is the words of a math expression then converts it into a string of numbers and operators to represent that expression.
	 * @param words
	 *@return outPut
	 */
	public static String convert(String words) {
		
		String[] singleWords = words.split(" ");
		for(int i=0;i<singleWords.length;i++) {
			System.out.println(singleWords[i]);
			if(singleWords[i].equals("one")) {
				outPut = outPut + "1";
			}
			if(singleWords[i].equals("two") || singleWords[i].equals("to") || singleWords[i].equals("too")) {
				outPut = outPut + "2";
			}
			if(singleWords[i].equals("three")) {
				outPut = outPut + "3";
			}
			if(singleWords[i].equals("four") || singleWords[i].equals("for")) {
				outPut = outPut + "4";
			}
			if(singleWords[i].equals("five")) {
				outPut = outPut + "5";
			}
			if(singleWords[i].equals("six")) {
				outPut = outPut + "6";
			}
			if(singleWords[i].equals("seven")) {
				outPut = outPut + "7";
			}
			if(singleWords[i].equals("eight")) {
				outPut = outPut + "8";
			}
			if(singleWords[i].equals("nine")) {
				outPut = outPut + "9";
			}
			if(singleWords[i].equals("zero")) {
				outPut = outPut + "0";
			}
			if(singleWords[i].equals("ten")) {
				outPut = outPut + "10";
			}
			if(singleWords[i].equals("eleven")) {
				outPut = outPut + "11";
			}
			if(singleWords[i].equals("twelve")) {
				outPut = outPut + "12";
			}
			if(singleWords[i].equals("thirteen")) {
				outPut = outPut + "13";
			}
			if(singleWords[i].equals("fourteen")) {
				outPut = outPut + "14";
			}
			if(singleWords[i].equals("fifteen")) {
				outPut = outPut + "15";
			}
			if(singleWords[i].equals("sixteen")) {
				outPut = outPut + "16";
			}
			if(singleWords[i].equals("seventeen")) {
				outPut = outPut + "17";
			}
			if(singleWords[i].equals("eighteen")) {
				outPut = outPut + "18";
			}
			if(singleWords[i].equals("nineteen")) {
				outPut = outPut + "19";
			}
			//If the word "Twenty" is used, check next word to see intended number
			if(singleWords[i].equals("twenty")) {
				outPut = outPut + "2";
				if(i+1<singleWords.length) {
					i++;
					if(singleWords[i].equals("one")) {
						outPut = outPut + "1";
					}
					else if(singleWords[i].equals("two") || singleWords[i].equals("to") || singleWords[i].equals("too")) {
						outPut = outPut + "2";
					}
					else if(singleWords[i].equals("three")) {
						outPut = outPut + "3";
					}
					else if(singleWords[i].equals("four") || singleWords[i].equals("for")) {
						outPut = outPut + "4";
					}
					else if(singleWords[i].equals("five")) {
						outPut = outPut + "5";
					}
					else if(singleWords[i].equals("six")) {
						outPut = outPut + "6";
					}
					else if(singleWords[i].equals("seven")) {
						outPut = outPut + "7";
					}
					else if(singleWords[i].equals("eight")) {
						outPut = outPut + "8";
					}
					else if(singleWords[i].equals("nine")) {
						outPut = outPut + "9";
					}
					else {
						outPut = outPut + "0";
					}
					
				}
				else if(i+1==singleWords.length){
					outPut = outPut + "0";
				}
			
			}
			//If the word "Thirty" is used, check next word to see intended number
			if(singleWords[i].equals("thirty")) {
				outPut = outPut + "3";
				if(i+1<singleWords.length) {
					i++;
					if(singleWords[i].equals("one")) {
						outPut = outPut + "1";
					}
					else if(singleWords[i].equals("two") || singleWords[i].equals("to") || singleWords[i].equals("too")) {
						outPut = outPut + "2";
					}
					else if(singleWords[i].equals("three")) {
						outPut = outPut + "3";
					}
					else if(singleWords[i].equals("four") || singleWords[i].equals("for")) {
						outPut = outPut + "4";
					}
					else if(singleWords[i].equals("five")) {
						outPut = outPut + "5";
					}
					else if(singleWords[i].equals("six")) {
						outPut = outPut + "6";
					}
					else if(singleWords[i].equals("seven")) {
						outPut = outPut + "7";
					}
					else if(singleWords[i].equals("eight")) {
						outPut = outPut + "8";
					}
					else if(singleWords[i].equals("nine")) {
						outPut = outPut + "9";
					}
					else {
						outPut = outPut + "0";
					}
					
				}
				else if(i+1==singleWords.length){
					outPut = outPut + "0";
				}
			
			}
			//If the word "forty" is used, check next word to see intended number
			if(singleWords[i].equals("forty")) {
				outPut = outPut + "4";
				if(i+1<singleWords.length) {
					i++;
					if(singleWords[i].equals("one")) {
						outPut = outPut + "1";
					}
					else if(singleWords[i].equals("two") || singleWords[i].equals("to") || singleWords[i].equals("too")) {
						outPut = outPut + "2";
					}
					else if(singleWords[i].equals("three")) {
						outPut = outPut + "3";
					}
					else if(singleWords[i].equals("four") || singleWords[i].equals("for")) {
						outPut = outPut + "4";
					}
					else if(singleWords[i].equals("five")) {
						outPut = outPut + "5";
					}
					else if(singleWords[i].equals("six")) {
						outPut = outPut + "6";
					}
					else if(singleWords[i].equals("seven")) {
						outPut = outPut + "7";
					}
					else if(singleWords[i].equals("eight")) {
						outPut = outPut + "8";
					}
					else if(singleWords[i].equals("nine")) {
						outPut = outPut + "9";
					}
					else {
						outPut = outPut + "0";
					}
					
				}
				else if(i+1==singleWords.length){
					outPut = outPut + "0";
				}
			
			}
			//If the word "fifty" is used, check next word to see intended number
			if(singleWords[i].equals("fifty")) {
				outPut = outPut + "5";
				if(i+1<singleWords.length) {
					i++;
					if(singleWords[i].equals("one")) {
						outPut = outPut + "1";
					}
					else if(singleWords[i].equals("two") || singleWords[i].equals("to") || singleWords[i].equals("too")) {
						outPut = outPut + "2";
					}
					else if(singleWords[i].equals("three")) {
						outPut = outPut + "3";
					}
					else if(singleWords[i].equals("four") || singleWords[i].equals("for")) {
						outPut = outPut + "4";
					}
					else if(singleWords[i].equals("five")) {
						outPut = outPut + "5";
					}
					else if(singleWords[i].equals("six")) {
						outPut = outPut + "6";
					}
					else if(singleWords[i].equals("seven")) {
						outPut = outPut + "7";
					}
					else if(singleWords[i].equals("eight")) {
						outPut = outPut + "8";
					}
					else if(singleWords[i].equals("nine")) {
						outPut = outPut + "9";
					}
					else {
						outPut = outPut + "0";
					}
					
				}
				else if(i+1==singleWords.length){
					outPut = outPut + "0";
				}
			
			}
			//If the word "sixty" is used, check next word to see intended number
			if(singleWords[i].equals("sixty")) {
				outPut = outPut + "6";
				if(i+1<singleWords.length) {
					i++;
					if(singleWords[i].equals("one")) {
						outPut = outPut + "1";
					}
					else if(singleWords[i].equals("two") || singleWords[i].equals("to") || singleWords[i].equals("too")) {
						outPut = outPut + "2";
					}
					else if(singleWords[i].equals("three")) {
						outPut = outPut + "3";
					}
					else if(singleWords[i].equals("four") || singleWords[i].equals("for")) {
						outPut = outPut + "4";
					}
					else if(singleWords[i].equals("five")) {
						outPut = outPut + "5";
					}
					else if(singleWords[i].equals("six")) {
						outPut = outPut + "6";
					}
					else if(singleWords[i].equals("seven")) {
						outPut = outPut + "7";
					}
					else if(singleWords[i].equals("eight")) {
						outPut = outPut + "8";
					}
					else if(singleWords[i].equals("nine")) {
						outPut = outPut + "9";
					}
					else {
						outPut = outPut + "0";
					}
					
				}
				else if(i+1==singleWords.length){
					outPut = outPut + "0";
				}
			
			}
			//If the word "seventy" is used, check next word to see intended number
			if(singleWords[i].equals("seventy")) {
				outPut = outPut + "7";
				if(i+1<singleWords.length) {
					i++;
					if(singleWords[i].equals("one")) {
						outPut = outPut + "1";
					}
					else if(singleWords[i].equals("two") || singleWords[i].equals("to") || singleWords[i].equals("too")) {
						outPut = outPut + "2";
					}
					else if(singleWords[i].equals("three")) {
						outPut = outPut + "3";
					}
					else if(singleWords[i].equals("four") || singleWords[i].equals("for")) {
						outPut = outPut + "4";
					}
					else if(singleWords[i].equals("five")) {
						outPut = outPut + "5";
					}
					else if(singleWords[i].equals("six")) {
						outPut = outPut + "6";
					}
					else if(singleWords[i].equals("seven")) {
						outPut = outPut + "7";
					}
					else if(singleWords[i].equals("eight")) {
						outPut = outPut + "8";
					}
					else if(singleWords[i].equals("nine")) {
						outPut = outPut + "9";
					}
					else {
						outPut = outPut + "0";
					}
					
				}
				else if(i+1==singleWords.length){
					outPut = outPut + "0";
				}
			
			}
			//If the word "eighty" is used, check next word to see intended number
			if(singleWords[i].equals("eighty")) {
				outPut = outPut + "8";
				if(i+1<singleWords.length) {
					i++;
					if(singleWords[i].equals("one")) {
						outPut = outPut + "1";
					}
					else if(singleWords[i].equals("two") || singleWords[i].equals("to") || singleWords[i].equals("too")) {
						outPut = outPut + "2";
					}
					else if(singleWords[i].equals("three")) {
						outPut = outPut + "3";
					}
					else if(singleWords[i].equals("four") || singleWords[i].equals("for")) {
						outPut = outPut + "4";
					}
					else if(singleWords[i].equals("five")) {
						outPut = outPut + "5";
					}
					else if(singleWords[i].equals("six")) {
						outPut = outPut + "6";
					}
					else if(singleWords[i].equals("seven")) {
						outPut = outPut + "7";
					}
					else if(singleWords[i].equals("eight")) {
						outPut = outPut + "8";
					}
					else if(singleWords[i].equals("nine")) {
						outPut = outPut + "9";
					}
					else {
						outPut = outPut + "0";
					}
					
				}
				else if(i+1==singleWords.length){
					outPut = outPut + "0";
				}
			
			}
			//If the word "ninety" is used, check next word to see intended number
			if(singleWords[i].equals("ninety")) {
				outPut = outPut + "9";
				if(i+1<singleWords.length) {
					i++;
					if(singleWords[i].equals("one")) {
						outPut = outPut + "1";
					}
					else if(singleWords[i].equals("two") || singleWords[i].equals("to") || singleWords[i].equals("too")) {
						outPut = outPut + "2";
					}
					else if(singleWords[i].equals("three")) {
						outPut = outPut + "3";
					}
					else if(singleWords[i].equals("four") || singleWords[i].equals("for")) {
						outPut = outPut + "4";
					}
					else if(singleWords[i].equals("five")) {
						outPut = outPut + "5";
					}
					else if(singleWords[i].equals("six")) {
						outPut = outPut + "6";
					}
					else if(singleWords[i].equals("seven")) {
						outPut = outPut + "7";
					}
					else if(singleWords[i].equals("eight")) {
						outPut = outPut + "8";
					}
					else if(singleWords[i].equals("nine")) {
						outPut = outPut + "9";
					}
					else {
						outPut = outPut + "0";
					}
					
				}
				else if(i+1==singleWords.length){
					outPut = outPut + "0";
				}
			
			}
			//Handles use of the word "hundred"
			if(singleWords[i].equals("hundred")) {
				if(singleWords[i+1].equals("and")) {
					i++;
				}
				if(i+1<singleWords.length) {
					if(singleWords[i+1].equals("plus") || singleWords[i+1].equals("minus") || singleWords[i+1].equals("times")
							|| singleWords[i+1].equals("multiply") || singleWords[i+1].equals("multiplied") || singleWords[i+1].equals("divided")
							|| singleWords[i+1].equals("divide") || singleWords[i+1].equals("")) {
						System.out.println("HUNDRED");
						outPut = outPut + "00";
					}
					else if(singleWords[i+1].equals("one") || singleWords[i+1].equals("two") || singleWords[i+1].equals("three") || singleWords[i+1].equals("four")
							|| singleWords[i+1].equals("five") || singleWords[i+1].equals("six") || singleWords[i+1].equals("seven") || singleWords[i+1].equals("eight")
							|| singleWords[i+1].equals("nine") || singleWords[i+1].equals("too") || singleWords[i+1].equals("to") || singleWords[i+1].equals("for")){
						outPut = outPut + "0";
					}
				}
				else {
					outPut = outPut + "00";
				}
			}
			//Handles use of the word "thousand"
			if(singleWords[i].equals("thousand")) {
				if(singleWords[i+1].equals("and")) {
					i++;
				}
				if(i+1<singleWords.length) {
					if(singleWords[i+1].equals("plus") || singleWords[i+1].equals("minus") || singleWords[i+1].equals("times")
							|| singleWords[i+1].equals("multiply") || singleWords[i+1].equals("multiplied") || singleWords[i+1].equals("divided")
							|| singleWords[i+1].equals("divide") || singleWords[i+1].equals("")) {
						System.out.println("HUNDRED");
						outPut = outPut + "00";
					}
					else if(singleWords[i+1].equals("one") || singleWords[i+1].equals("two") || singleWords[i+1].equals("three") || singleWords[i+1].equals("four")
							|| singleWords[i+1].equals("five") || singleWords[i+1].equals("six") || singleWords[i+1].equals("seven") || singleWords[i+1].equals("eight")
							|| singleWords[i+1].equals("nine")){
						outPut = outPut + "0";
					}
				}
				else {
					outPut = outPut + "00";
				}
			}
			if(singleWords[i].equals("million")) {
				outPut = outPut + "000000";
			}
			//If the word intends a negative number
			if(singleWords[i].equals("negative")) {
				outPut = outPut + " -";
			}
			//If the word intends addition
			if(singleWords[i].equals("plus")) {
				outPut = outPut + " + ";
			}
			//If the word intends subtraction
			if(singleWords[i].equals("minus")) {
				outPut = outPut + " - ";
			}
			//If the word intends multiplication
			if(singleWords[i].equals("multiply")) {
				outPut = outPut + " * ";
			}
			if(singleWords[i].equals("multiplied")) {
				outPut = outPut + " * ";
			}
			if(singleWords[i].equals("times")) {
				outPut = outPut + " * ";
			}
			//If the word intends division
			if(singleWords[i].equals("division")) {
				outPut = outPut + " / ";
			}
			if(singleWords[i].equals("divided")) {
				outPut = outPut + " / ";
			}
			//If the word intends exponents
			if(singleWords[i].equals("exponent")) {
				outPut = outPut + " ^ ";
			}
			//If the word intends open parenthesis
			if(singleWords[i].equals("open")) {
				outPut = outPut + " ( ";
			}
			//If the word intends close parenthesis
			if(singleWords[i].equals("close")) {
				outPut = outPut + " ) ";
			}
			
		}
		return outPut;
		
	}
	public static void clear() {
		outPut = "";
	}

}
