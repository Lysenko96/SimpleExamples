package net.gweep.multithreading.executors;

import java.util.concurrent.Callable;
import java.util.function.DoubleUnaryOperator;

public class CallableIntegralCalc implements Callable<Double> {

	private IntegralCalculator calculator;
	private Main main;

	public CallableIntegralCalc(double a, double b, int n, DoubleUnaryOperator f, Main main) {
		calculator = new IntegralCalculator(a, b, n, f);
		this.main = main;
	}

	@Override
	public Double call() {
		// double result = calculator.calculate();
		// main.sendResult(result);
		return calculator.calculate();
	}

}