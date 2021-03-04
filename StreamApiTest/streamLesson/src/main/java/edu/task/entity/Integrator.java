package edu.task.entity;

public class Integrator {

	private Double a;
	private Double b;

	public Integrator() {

	}

	public Integrator(Double a, Double b) {
		this.a = a;
		this.b = b;
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public Double calculate(double a, double b, int v) {
		double c = 0;
		if (v == 0) {
			c = a + b;
			return 1 / 2d * ((a + c) + (b + c)) * (b - a);
		} else if (v == 1) {
			c = a - b;
			return  1 / 2d * ((a - c) + (b - c)) * (b + a);
		}
		return 1d;
	}
}
