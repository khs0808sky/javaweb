package app.labs.servlet.basic;

public class CalcService {
	private int result = 0;
	
	public CalcService(int num1, int num2, String op) {
		if (op.equals("+")) {
			result = num1 + num2;
		} 
		else if (op.equals("-")) {
			result = num1 - num2;
		} 
		else if (op.equals("*")) {
			result = num1 * num2;
		} 
		else if (op.equals("/")) {
			result = num1 / num2;
		}
	}

	public int getResult() {
		return result;
	}
	
	
}
