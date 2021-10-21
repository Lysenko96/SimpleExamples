package net.gweep.multithreading;

import java.util.function.DoubleUnaryOperator;

public class ThreadingIntegralCalc implements Runnable {

	private IntegralCalculator calculator;
	private Main main;

	public ThreadingIntegralCalc(double a, double b, int n, DoubleUnaryOperator f, Main main) {
		calculator = new IntegralCalculator(a, b, n, f);
		this.main = main;
	}

	@Override
	public void run() {
		double result = calculator.calculate();
		main.sendResult(result);
	}

}