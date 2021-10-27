package net.gweep.multithreading.executors;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class IntegralCalculator {

	private double a;
	private double b;
	private int n;
	private double h;
	private DoubleUnaryOperator f;

	public IntegralCalculator(double a, double b, int n, DoubleUnaryOperator f) {
		this.a = a;
		this.b = b;
		this.n = n;
		this.f = f;
		h = (b - a) / n;
	}

	// �?умма результатов �?ину�?ов от чи�?ла умножена на h
	// map(f) -> func get double return double
	public double calculate() {
		return IntStream.range(0, n).mapToDouble(i -> a + i * h).map(f).map(y -> y * h).sum();
	}

}
