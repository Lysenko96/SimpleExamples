package effectivejava.enums;

import java.util.function.DoubleBinaryOperator;

public enum Operation {

	PLUS("+", (x, y) -> x + y) {
//		public double apply(double x, double y) {
//			return x + y;
//		}
	},

	MINUS("-", (x, y) -> x - y) {
//		public double apply(double x, double y) {
//			return x - y;
//		}
	};

	private String symbol;
	private DoubleBinaryOperator op;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	Operation(String symbol, DoubleBinaryOperator op) {
		this.symbol = symbol;
		this.op = op;
	}

	@Override
	public String toString() {
		return symbol;
	}

//	public abstract double apply(double x, double y);

	public double apply(long x, long y) {
		return op.applyAsDouble(x, y);
	}

}
