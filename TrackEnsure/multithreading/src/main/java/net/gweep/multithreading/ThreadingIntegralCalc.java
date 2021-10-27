package net.gweep.multithreading;

import java.util.function.DoubleUnaryOperator;

public class ThreadingIntegralCalc implements Runnable {

	private IntegralCalculator calculator;
	private Main main;

	public ThreadingIntegralCalc(double a, double b, int n, DoubleUnaryOperator f, Main main2) {
		calculator = new IntegralCalculator(a, b, n, f);
		this.main = main2;
	}

	@Override
	public void run() {
		double result = calculator.calculate();
		// main.sendResult(result);
		main.sendResult1(result);
	}

}