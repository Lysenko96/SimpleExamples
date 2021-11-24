package net.gweep.servltomcat.beans;

public class FormulaBean {

	private String formula;

	public FormulaBean() {
		
	}
	
	public FormulaBean(String formula) {
		this.formula = formula;
	}	
	
	public int getResult() {
		//formula.split("[+-*/]"); don't work
		String[] numbers = formula.split("[+\\-*/]");
		int n = Integer.parseInt(numbers[0]);
		int n1 = Integer.parseInt(numbers[1]);
		int result = 0;
		if(formula.contains("+")) {
			result = n + n1;
		}
		return result;
	}
}